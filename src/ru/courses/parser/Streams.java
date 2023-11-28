package ru.courses.parser;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static String getStringFromStream(Stream stringStream) {
        String result = (String) stringStream.collect(Collectors.joining(" "));
        return result;
    }

    public static void printList1(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void printList(ArrayList list) {
       list.forEach(i-> System.out.println(i));
    }
}
