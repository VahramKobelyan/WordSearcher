package com.koko;

import com.koko.utils.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static com.koko.utils.Constants.*;
import static com.koko.utils.Utils.addMatchedIndexes;
import static com.koko.utils.Utils.getFinderPattern;

public class Main {

    public static void main(String[] args) throws IOException {
        final List<String> arguments = Arrays.asList(args);

        Assert.isTrue(arguments.size() > 1, WRONG_ARGUEMNTS_COUNT_ERROR);
        long startTime = System.nanoTime();

        final String keyword = arguments.get(0);
        Assert.isTrue(keyword.matches(ALPHA_NEMERIC), INCORRECT_KEYWORD);

        final String filename = arguments.get(1);
        final File f1 = new File(filename);
        Assert.isTrue(f1.exists(), FILE_NOT_EXISTS);
        Assert.isTrue(f1.isFile(), MessageFormat.format("{0} {1}", f1.getAbsolutePath(), IS_DIRECTORY));
        final Pattern pattern = getFinderPattern(keyword, arguments.contains("part"), arguments.contains("ci"));
        final MutableLong lineNumber = new MutableLong(1);
        Files.lines(f1.toPath())
                .map(s -> new Line(s, lineNumber.getAndIncrement()))
                .peek(line -> addMatchedIndexes(pattern, line))
                .filter(Line::found)
                .forEach(System.out::println);
        long endTime = System.nanoTime();
        if (arguments.contains("log"))
            System.out.println("Execution time in milliseconds:  " + (endTime - startTime));
    }

}
