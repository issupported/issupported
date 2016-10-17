package com.issupported.parser;

import com.issupported.model.Attribute;

import java.util.HashMap;
import java.util.Map;

public class Parser {
/*
    private Attribute borderRadius;
    private Attribute margin;

    public Parser() {
        borderRadius = new Attribute();
        margin = new Attribute();
        borderRadius.setName("border-radius");
        borderRadius.setChromeSupport(true);
        borderRadius.setIeSupport(false);
        margin.setName("margin");
        margin.setChromeSupport(true);
        margin.setIeSupport(true);
    }


    public String parse(String input) {
        Map<Attribute, Position> result = new HashMap<Attribute, Position>();
        //Map<Attribute, List<Position>> result = new HashMap<Attribute, List<Position>>();

        int firstIndex = input.indexOf(borderRadius.getName());
        int lastIndex = firstIndex + borderRadius.getName().length();

        result.put(borderRadius, new Position(firstIndex, lastIndex));
        return result.toString();
    }

    private class Position {
        private int start;
        private int end;

        Position(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }*/
}
