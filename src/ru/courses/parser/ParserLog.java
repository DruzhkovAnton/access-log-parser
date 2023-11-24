package ru.courses.parser;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ParserLog {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]");

    private String clientIpAddress;
    private String dateTimeString;
    //private String dateTime;
    private String method;
    private String resourcePath;
    private int httpResponseCode;
    private int dataByteSize;
    private String referer;
    private String userAgent;
    private String bot;

    public ParserLog(String logEntry) throws ParseException {
        // Разбиваем запись лога по пространству
        String[] parts = logEntry.split(" ");

        this.clientIpAddress = parts[0];
        // Пропущенные свойства не назначаются, так как они не используются
        this.dateTimeString = parts[3] + " " + parts[4]; // склеиваем дату и время, [13/Dec/2018:17:00:00 -0500] формата
        //this.dateTime = dateFormat.parse(this.dateTimeString); // преобразуем в объект Date
        this.method = parts[5].substring(1); // убираем первую кавычку перед методом
        this.resourcePath = parts[6];
        this.httpResponseCode = Integer.parseInt(parts[8]);
        this.dataByteSize = parts[9].equals("-") ? 0 : Integer.parseInt(parts[9]); // если прочерк, считаем размер данных 0
        this.referer = parts[10].substring(1, parts[10].length() - 1); // убираем кавычки вокруг referer
        this.userAgent = parts[11].substring(1); // начинаем с 1, чтобы убрать кавычку

        for (int i = 12; i < parts.length; i++) { // user-agent может содержать пробелы
            this.userAgent += " " + parts[i];
        }
        this.userAgent = this.userAgent.substring(0, this.userAgent.length() - 1); // убираем последнюю кавычку

        for (int i = 12; i < this.userAgent.length(); i++) {
            this.bot += extractFragment(this.userAgent);
        }

    }

    public String toString() {
        return String.format("IP: %s, Date: %s, Method: %s, Resource: %s, Response: %d, Size: %d, Referer: %s, User-Agent: %s",
                clientIpAddress, dateTimeString, method, resourcePath, httpResponseCode, dataByteSize, referer, userAgent);
    }

    public String getUserAgent() {
        return userAgent;
    }

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
        int z = 0;
        int x = 0;
        int z1 = 0;
        int x1 = 0;

        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                ParserLog entry = new ParserLog(line);
                System.out.println(entry.userAgent);
                if(line.contains("YandexBot"))z++;
                if(line.contains("Googlebot"))x++;
                String bot = extractFragment(line);
                if(bot.equals("YandexBot"))z1++;
                if(bot.equals("Googlebot"))x1++;
                int length = line.length();
                if(length>1024)throw new RuntimeException("В строке " +i+"больше 1024 символов");

            } catch (ParseException e) {
                System.out.println("Ошибка при разборе даты: " + e.getMessage());
            }

            i++;
        }
        System.out.println("строк в файле - "+ i);
        System.out.println("YandexBot встречается в логе(contains) "+z);
        System.out.println("Googlebot встречается в логе(contains) "+x);
        System.out.println("YandexBot встречается в логе(extractFragment) "+z1);
        System.out.println("Googlebot встречается в логе(extractFragment) "+x1);


    }

    private static int yndexBot(ParserLog entry){
        int x=0;

        return x;
    }

    private static String extractFragment(String userAgent) {
        int start = userAgent.indexOf("(");
        int end = userAgent.indexOf(")");
        String fragment="";
        if (start != -1 && end != -1 && start < end) {
            String firstBrackets = userAgent.substring(start + 1, end);

            String[] parts = firstBrackets.split(";");
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }

            if (parts.length >= 2) {
                 fragment = parts[1];

                int slashIndex = fragment.indexOf("/");
                if (slashIndex != -1) {
                    return fragment.substring(0, slashIndex);
                } else {
                    return fragment;
                }
            }
        }
        return fragment;
    }

}
