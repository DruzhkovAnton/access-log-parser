package ru.courses.main;
import ru.courses.food.Sauce;
import static ru.courses.algebra.Sum.sum;

public class Main {
    public static void main(String[] args) {
        if(args.length>0){
            sum(args);
        }else {
            String[] num = {"10","3qq4","1"};
            sum(num);
        }

    }
}