package ru.courses.algebra;

public class RaiseToPow {
    public static void toPow(String b, String y){
        int a =Integer.parseInt(b);
        int x = Integer.parseInt(y);
        double res = 0;
        res =  Math.pow(a,x);
        System.out.println(res);
    }
}
