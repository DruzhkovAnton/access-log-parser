package ru.courses.parser;

import java.time.Duration;
import java.time.LocalDateTime;

public class Statistics {
    static int totalTrafic;
    static LocalDateTime minTime;
    static LocalDateTime maxTime;
    static Duration duration;
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
    }

    public static int getTrafficRate(){
        duration = Duration.between(minTime, maxTime);
        return totalTrafic/(int) duration.toHours();
    }



    public String toString(){
        String res = "";
        res = "минимальная дата: "+this.minTime.toString()+"\nмаксимальная дата: "+this.maxTime.toString()+"\ntotalTrafic = "+totalTrafic;
        return res;
    }
}
