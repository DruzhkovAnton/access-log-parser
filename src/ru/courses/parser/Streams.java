package ru.courses.parser;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static String getStringFromStream(Stream stringStream) {
        String result = (String) stringStream.collect(Collectors.joining(" "));
        return result;
    }
}
