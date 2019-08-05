package com.koko.utils;

import com.koko.Line;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class Utils {

    private static final String REGEX_PART_WORD = "[^ ]*%s[^ ]*";
    private static final String REGEX_FULL_WORD = "\\b%s\\b";

    public static Pattern getFinderPattern(final String keyword, final boolean isPart, final boolean isKeyInsensitive) {

        final String regex = isPart ? REGEX_PART_WORD : REGEX_FULL_WORD;
        final int flag = isKeyInsensitive ? CASE_INSENSITIVE : 0;
        return Pattern.compile(String.format(regex, keyword), flag);
    }


    public static void addMatchedIndexes(final Pattern pattern, final Line line) {
        Matcher matcher = pattern.matcher(line.getText());
        while (matcher.find()) {
            line.addIndex(matcher.start());
            line.addIndex(matcher.end());
        }
    }

    public static String repeat(final String s, final int count) {
        return new String(new char[count]).replace("\0", s);
    }

}
