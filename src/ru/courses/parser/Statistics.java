package ru.courses.parser;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
    private static Map<Integer, Integer> visitsPerSecond = new HashMap<>();
    private HashSet<String> refererDomains = new HashSet<>();
    static long timeStampMin;
    static long timeStampMax;
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
            int second = (int)(localDateTimeToLong(log.getDateTime())/1000);
            // Обновляем количество посещений в эту секунду
            visitsPerSecond.put(second, visitsPerSecond.getOrDefault(second, 0) + 1);
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

    public void logReferer(String referer) {//Метод для возврата списка сайтов, со страниц которых есть ссылки на текущий сайт:
        // Отсекаем протокол и путь, оставляя только домен
        String domain = referer.replaceFirst("^https?://", "") // Удалить протокол
                .replaceFirst("/.*$", "");      // Удалить путь
        // Добавляем домен в HashSet
        refererDomains.add(domain);
    }

    public int calculateMaxVisitsBySingleUser() {//Метод расчёта максимальной посещаемости одним пользователем
        int maxVisits = 0;
        for (int visits : visitsByUser.values()) {
            if (visits > maxVisits) {
                maxVisits = visits;
            }
        }
        return maxVisits;
    }

    public int calculatePeakVisitsPerSecond() {//Метод для расчёта пиковой посещаемости сайта (в секунду)
        int maxVisits = 0;
        for (int visits : visitsPerSecond.values()) {
            if (visits > maxVisits) {
                maxVisits = visits;
            }
        }
        return maxVisits;
    }

    public static long localDateTimeToLong(LocalDateTime localDateTime) {
        // Получение количества миллисекунд с начала эпохи для UTC
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
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
