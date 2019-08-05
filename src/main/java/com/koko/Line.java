package com.koko;

import java.util.ArrayList;
import java.util.List;

import static com.koko.utils.Utils.*;

public class Line {


    private final String text;
    private final long lineNumber;
    private final List<Integer> matchedIndexes = new ArrayList<>();

    public Line(final String text, final long lineNumber) {
        this.text = text;
        this.lineNumber = lineNumber;
    }

    public void addIndex(final int i) {
        matchedIndexes.add(i);
    }

    public boolean found() {
        return !matchedIndexes.isEmpty();
    }

    public String getText() {
        return text;
    }

    public long getLineNumber() {
        return lineNumber;
    }

    public List<Integer> getMatchedIndexes() {
        return matchedIndexes;
    }

    private String getLabel() {
        final StringBuilder stringBuilder = new StringBuilder(matchedIndexes.get(matchedIndexes.size() - 1));
        stringBuilder.append(repeat("-", matchedIndexes.get(0)));
        for (int i = 1; i < matchedIndexes.size(); i++) {
            final String character = i % 2 < 1 ? "-" : "^";
            int count = matchedIndexes.get(i) - matchedIndexes.get(i - 1);
            stringBuilder.append(repeat(character, count));
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return String.format("%-10d%s\n%s%s", lineNumber, text, repeat(" ", 10), getLabel());

    }


}
