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
    static HashMap<String, Integer> staOS;
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

        UserAgent os = new UserAgent(log.getUserAgent());

        if(staOS.containsKey(os.getOperatingSystem())){
            staOS.put(os.getOperatingSystem(),staOS.get(os.getOperatingSystem())+1);
        }else {
            staOS.put(os.getOperatingSystem(),1);
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


    public static int getTrafficRate(){
        duration = Duration.between(minTime, maxTime);
        return totalTrafic/(int) duration.toHours();
    }

    public static HashSet<String> getSaitList(){
        return saitList;
    }



    public String toString(){
        String res = "";
        res = "минимальная дата: "+this.minTime.toString()+"\nмаксимальная дата: "+this.maxTime.toString()+"\ntotalTrafic = "+totalTrafic;
        return res;
    }
}
