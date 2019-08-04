package com.koko.utils;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class Utils {

    private static final String REGEX_PART_WORD = "[^ ]*%s[^ ]*";
    private static final String REGEX_FULL_WORD = "\\b%s\\b";

    public static Pattern getFinderPattern(String keyword, boolean isPart, boolean isKeyInsensitive) {

        final String regex = isPart ? REGEX_PART_WORD : REGEX_FULL_WORD;
        final int flag = isKeyInsensitive ? CASE_INSENSITIVE : 0;
        return Pattern.compile(String.format(regex, keyword), flag);
    }

    public static String repeat(String s, int count) {
        return new String(new char[count]).replace("\0", s);
    }

}
