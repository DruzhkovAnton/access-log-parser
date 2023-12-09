package ru.courses.parser;

import ru.courses.parser.Statistics;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ParserLog {
    private final String clientIpAddress;
    private final String dateTimeString;
    private LocalDateTime dateTime;
    private enum HttpMethod {
        GET,
        POST,
        PUT,
        PATCH,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT
    }
    private HttpMethod method;
    private final String resourcePath;
    private final int httpResponseCode;
    private final int dataByteSize;
    private final String referer;
    private String userAgent;

    public ParserLog(String logEntry) throws ParseException {
        String[] parts = logEntry.split(" ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);

        this.clientIpAddress = parts[0];
        this.dateTimeString = parts[3].substring(1);//+ " " + parts[4];
        this.dateTime = LocalDateTime.parse(this.dateTimeString, formatter);
        this.method = HttpMethod.GET;
        switch (parts[5].substring(1)){
            case "GET":
                this.method = HttpMethod.GET;
                break;
            case "POST":
                this.method = HttpMethod.POST;
                break;
            case "PUT":
                this.method = HttpMethod.PUT;
                break;
            case "PATCH":
                this.method = HttpMethod.PATCH;
                break;
            case "HEAD":
                this.method = HttpMethod.HEAD;
                break;
            case "OPTIONS":
                this.method = HttpMethod.OPTIONS;
                break;
            case "DELETE":
                this.method = HttpMethod.DELETE;
                break;
            case "TRACE":
                this.method = HttpMethod.TRACE;
                break;

        }

        this.resourcePath = parts[6];
        this.httpResponseCode = Integer.parseInt(parts[8]);
        this.dataByteSize = parts[9].equals("-") ? 0 : Integer.parseInt(parts[9]);
        this.referer = parts[10].substring(1, parts[10].length() - 1);
        this.userAgent = parts[11].substring(1);

        for (int i = 12; i < parts.length; i++) {
            this.userAgent += " " + parts[i];
        }
        this.userAgent = this.userAgent.substring(0, this.userAgent.length() - 1);


    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public String getDateTimeString() {
        return dateTimeString;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public int getHttpResponseCode() {
        return httpResponseCode;
    }

    public int getDataByteSize() {
        return dataByteSize;
    }

    public String getReferer() {
        return referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String toString() {
        return String.format("IP: %s, Date: %s, Method: %s, Resource: %s, Response: %d, Size: %d, Referer: %s, User-Agent: %s",
                clientIpAddress, dateTimeString, method, resourcePath, httpResponseCode, dataByteSize, referer, userAgent);
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
        Statistics statistics = new Statistics();


        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                ParserLog entry = new ParserLog(line);
                UserAgent userAgent1 = new UserAgent(entry.userAgent);
                statistics.addEntry(entry);
                System.out.println(entry.toString());
                //System.out.println(entry.dateTime+" "+entry.method+" "+entry.userAgent+" "+userAgent1.getOperatingSystem()+" "+userAgent1.getBrowser());
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
        System.out.println(statistics.toString());
        System.out.println("колличество трафика за час - "+statistics.getTrafficRate()+" kb");


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


