package com.twu.biblioteca.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Column {

    private List<List<String>> lines;
    private List<Integer> maxLength;
    private int numColumns;

    public Column() {
        lines = new ArrayList<List<String>>();
        maxLength = new ArrayList<Integer>();
        numColumns = -1;
    }

    public List<List<String>> addLine(String ... line) {
        if (numColumns == -1) {
            numColumns = line.length;
            for (int i = 0; i < numColumns; i++) {
                maxLength.add(0);
            }
        }
        if (numColumns != line.length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < numColumns; i++) {
            maxLength.set(i, Math.max(maxLength.get(i), line[i].length()));
        }
        lines.add(Arrays.asList(line));
        return lines;
    }

    public String toString() {
        String result = "";
        for (List<String> line : lines) {
            for (int i = 0; i < numColumns; i++) {
                result += pad(line.get(i), maxLength.get(i) + 1);
            }
            result += System.getProperty("line.separator");
        }
        lines.clear();
        return result;
    }

    private String pad(String word, int newLength) {
        while (word.length() < newLength) {
             word += " ";
        }
        return word;
    }
}