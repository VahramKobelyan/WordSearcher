package com.koko;

import com.koko.utils.Assert;
import com.koko.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.koko.utils.Constants.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final List<String> arguments = Arrays.asList(args);

        Assert.isTrue(arguments.size() > 1, WRONG_ARGUEMNTS_COUNT_ERROR);

        final String keyword = arguments.get(0);
        Assert.isTrue(keyword.matches(ALPHA_NEMERIC), INCORRECT_KEYWORD);

        final String filename = arguments.get(1);
        final File f1 = new File(filename);
        Assert.isTrue(f1.exists(), FILE_NOT_EXISTS);
        Assert.isTrue(f1.isFile(), MessageFormat.format("{0} {1}", f1.getAbsolutePath(), IS_DIRECTORY));
        final Pattern pattern = Utils.getFinderPattern(keyword, arguments.contains("part"), arguments.contains("ci"));
        final MutableLong lineNumber = new MutableLong(1);
        Files.lines(f1.toPath())
                .map(s -> new Line(s, lineNumber.getAndIncrement()))
                .peek(line -> {
                    Matcher matcher = pattern.matcher(line.getText());
                    while (matcher.find()) {
                        line.addIndex(matcher.start());
                        line.addIndex(matcher.end());
                    }
                })
                .filter(Line::found)
                .forEach(System.out::println);

    }
}
