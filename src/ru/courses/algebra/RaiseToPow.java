package ru.courses.algebra;

public class RaiseToPow {
    public static String toPow(String b, String y){
        int a =Integer.parseInt(b);
        int x = Integer.parseInt(y);
        int res = 0;
        res = (int) Math.pow(a,x);
        System.out.println(res);
    }
}
