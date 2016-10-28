package com.issupported.attributesFinder;

import com.issupported.model.Attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class AttributesFinder {

    private List<Attribute> attributes;
    private ConcurrentHashMap<Attribute, List<Position>>  result;

    public AttributesFinder(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public  Map<Attribute, List<Position>> findAttributes(String input) { //TODO: refactor
        result = new ConcurrentHashMap<>();
        List<Callable<String>> tasks = new ArrayList<>();

        IntStream.range(0, attributes.size()).forEach(i -> tasks.add(() -> {
            List<Position> positions = new ArrayList<>();

            for (int j = 0; j < input.length(); j++) {
                int firstIndex = input.indexOf(attributes.get(i).getName(), j);

                if (firstIndex != -1) {
                    int lastIndex = firstIndex + attributes.get(i).getName().length();
                    j = lastIndex;
                    positions.add(new Position(firstIndex, lastIndex));
                } else {
                    break;
                }
            }
            result.put(attributes.get(i), positions);
            //System.out.println(Thread.currentThread().getName() + ": " + attributes.get(i) + " with positions:" + positions.toString());
            return null;
        }));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            executorService.invokeAll(tasks);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        executorService.shutdown();
        return result;
    }
}
