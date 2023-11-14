package ru.courses.algebra;

public class RaiseToPow {
    int a,x;
    public RaiseToPow(String a, String x){
        this.a = Integer.parseInt(a);
        this.x = Integer.parseInt(x);
    }


    public void toPow(){
        int res = 0;
        res = (int) Math.pow(a,x);
        System.out.println(res);
    }
}
