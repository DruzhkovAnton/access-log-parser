package ru.courses.parser;

import java.io.*;
import java.util.Scanner;

public class ParserLog {

    public static void parse (String path) {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        int i = 0;
        int j = 0;
        int k = 1024;

        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int length = line.length();
            if(length>1024)throw new RuntimeException("В строке " +i+"больше 1024 символов");
            if(j<length)j=length;
            if(k>length)k=length;
            i++;
        }

        System.out.println("строк в файле - "+ i);
        System.out.println("наибольшая длина строки - "+ j);
        System.out.println("наименьшая длина строки - "+ k);
    }

}
