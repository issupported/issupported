package com.issupported.attributesFinder;

import com.issupported.model.Attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttributesFinder {

    private List<Attribute> attributes;

    public AttributesFinder(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public  Map<Attribute, List<Position>> findAttributes(String input) { //TODO: add multithreading
        Map<Attribute, List<Position>> result = new HashMap<>();

        for (Attribute attribute: attributes) {
            List<Position> positions = new ArrayList<>();

            for (int i = 0; i < input.length(); i++) {
                int firstIndex = input.indexOf(attribute.getName(), i);

                if (firstIndex != -1) {
                    int lastIndex = firstIndex + attribute.getName().length();
                    i = lastIndex;
                    positions.add(new Position(firstIndex, lastIndex));
                } else {
                    break;
                }
            }
            result.put(attribute, positions);
        }
        return result;
    }
}
