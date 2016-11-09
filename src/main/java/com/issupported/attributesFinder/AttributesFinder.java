package com.issupported.attributesFinder;

import com.issupported.model.Attribute;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class AttributesFinder {

    private List<Attribute> attributes;
    private Map<Attribute, List<Position>> result = new HashMap<>();

    public AttributesFinder(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public  Map<Attribute, List<Position>> findAttributes(String input) {
        List<Callable<Object[]>> tasks = new ArrayList<>();

        IntStream.range(0, attributes.size()).forEach(i -> tasks.add(new Parser(input, i)));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            Object[] futureResult;
            for (Future<Object[]> f: executorService.invokeAll(tasks)) {
                futureResult = f.get();
                result.put((Attribute) futureResult[0], (List<Position>) futureResult[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        executorService.shutdown();
        return result;
    }

    private class Parser implements Callable<Object[]> {
        private String input;
        private int attributeIndex;

        Parser(String input, int attributeIndex) {
            this.input = input;
            this.attributeIndex = attributeIndex;
        }

        @Override
        public Object[] call() throws Exception {
            List<Position> positions = new ArrayList<>();
            Object[] result = new Object[2];

            for (int j = 0; j < input.length(); j++) {
                int firstIndex = input.indexOf(attributes.get(attributeIndex).getName(), j);

                if (firstIndex != -1) {
                    int lastIndex = firstIndex + attributes.get(attributeIndex).getName().length();
                    j = lastIndex;
                    positions.add(new Position(firstIndex, lastIndex));
                } else {
                    break;
                }
            }
            if (positions.size() != 0) {
                result[0] = attributes.get(attributeIndex);
                result[1] = positions;
            }

            return result;
        }
    }
}
