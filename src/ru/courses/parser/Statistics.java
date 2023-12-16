package ru.courses.parser;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Statistics {
    static int totalTrafic;
    static LocalDateTime minTime;
    static LocalDateTime maxTime;
    static Duration duration;
    static  HashSet<String> saitList;
    static  HashSet<String> notExistSaitList;
    static HashMap<String, Integer> staOS;
    static int totalVisits; // общее число визитов не ботов
    static int totalErrors; // общее число ошибочных запросов
    static Map<String, Integer> visitsByUser; // словарь для подсчета визитов по IP-адресам
    DateTime firstLogTime; // время первого лога
    DateTime lastLogTime; // время последнего лога
    static HashMap<String, Integer> staBrowser;
    public Statistics(){
        this.totalTrafic = 0;
        this.minTime = LocalDateTime.now();
        this.maxTime = LocalDateTime.of(1900, 1, 1, 0, 0, 0);
    }

    public static void addEntry(ParserLog log){

        totalTrafic += log.getDataByteSize()/1024;

        if (minTime.isAfter(log.getDateTime())){
            minTime = log.getDateTime();
        }

        if (maxTime.isBefore(log.getDateTime())){
            maxTime = log.getDateTime();
        }

        if(log.getHttpResponseCode()==200){
            saitList.add(log.getResourcePath());
        }

        if(log.getHttpResponseCode()==404) {
            notExistSaitList.add(log.getResourcePath());
        }

        if (!log.getUserAgent().contains("bot")) { // Проверяем, что это не бот
            totalVisits++; // Увеличиваем счетчик визитов
            // Добавляем посещение для данного IP
            visitsByUser.put(log.getClientIpAddress(), visitsByUser.getOrDefault(log.getClientIpAddress(), 0) + 1);
        }

        if (log.getHttpResponseCode() >= 400 && log.getHttpResponseCode() < 600) { // Проверяем на ошибочный код ответа
            totalErrors++; // Увеличиваем счетчик ошибок
        }

        UserAgent os = new UserAgent(log.getUserAgent());



        if(staOS.containsKey(os.getOperatingSystem())){
            staOS.put(os.getOperatingSystem(),staOS.get(os.getOperatingSystem())+1);
        }else {
            staOS.put(os.getOperatingSystem(),1);
        }



        if(staBrowser.containsKey(os.getBrowser())){
            staBrowser.put(os.getOperatingSystem(),staBrowser.get(os.getOperatingSystem())+1);
        }else {
            staBrowser.put(os.getOperatingSystem(),1);
        }
    }

    public static HashMap<String, Double> calcStatOS(){
        HashMap<String, Double> allstatOS = new HashMap<>();
        int totalOS = staOS.values().stream().mapToInt(Integer::intValue).sum();

        for (Map.Entry<String, Integer> entry : staOS.entrySet()){
            double calc = (double) entry.getValue()/totalOS;
            allstatOS.put(entry.getKey(), calc);
        }
        return allstatOS;
    }

    public static double averageVisitsPerHour(){
        double hours = Duration.between(minTime, maxTime).toHours();
        return totalVisits / hours; // Возвращаем среднее количество посещений за час
    }

    public static double averageErrorsPerHour() {
        double hours = Duration.between(minTime, maxTime).toHours();
        return totalErrors / hours; // Возвращаем среднее количество ошибок за час
    }

    double averageVisitsPerUser() {
        return (double) totalVisits / visitsByUser.size(); // Возвращаем среднее число посещений на одного пользователя
    }


    public static HashMap<String, Double> calcStatBrowser(){
        HashMap<String, Double> allstatBrowser = new HashMap<>();
        int totalBrowser = staBrowser.values().stream().mapToInt(Integer::intValue).sum();

        for (Map.Entry<String, Integer> entry : staBrowser.entrySet()){
            double calc = (double) entry.getValue()/totalBrowser;
            allstatBrowser.put(entry.getKey(), calc);
        }
        return allstatBrowser;
    }


    public static int getTrafficRate(){
        duration = Duration.between(minTime, maxTime);
        return totalTrafic/(int) duration.toHours();
    }

    public static HashSet<String> getSaitList(){
        return saitList;
    }

    public static HashSet<String> getNotExistSaitList(){
        return notExistSaitList;
    }



    public String toString(){
        String res = "";
        res = "минимальная дата: "+this.minTime.toString()+"\nмаксимальная дата: "+this.maxTime.toString()+"\ntotalTrafic = "+totalTrafic;
        return res;
    }
}
