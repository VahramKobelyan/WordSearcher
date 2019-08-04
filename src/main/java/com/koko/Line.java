package com.koko;

import java.util.ArrayList;
import java.util.List;

import static com.koko.utils.Utils.*;

public class Line {


    private final String text;
    private final long lineNumber;
    private final List<Integer> machedIndexes = new ArrayList<>();

    public Line(final String text, final long lineNumber) {
        this.text = text;
        this.lineNumber = lineNumber;
    }

    public void addIndex(int i) {
        machedIndexes.add(i);
    }

    public boolean found() {
        return !machedIndexes.isEmpty();
    }

    public String getText() {
        return text;
    }

    public long getLineNumber() {
        return lineNumber;
    }

    public List<Integer> getMachedIndexes() {
        return machedIndexes;
    }

    private String getLabel() {
        final StringBuilder stringBuilder = new StringBuilder(machedIndexes.get(machedIndexes.size() - 1));
        stringBuilder.append(repeat("-", machedIndexes.get(0)));
        for (int i = 1; i < machedIndexes.size(); i++) {
            final String character = i % 2 < 1 ? "-" : "^";
            int count = machedIndexes.get(i) - machedIndexes.get(i - 1);
            stringBuilder.append(repeat(character, count));
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return String.format("%-10d%s\n%s%s", lineNumber, text, repeat(" ", 10), getLabel());

    }


}
