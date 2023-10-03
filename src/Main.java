import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("fraction: " + fraction(5.3));
        System.out.println("sumLastNums: " + sumLastNums(4568));
        System.out.println("charToNum: " + charToNum('9'));
        System.out.println("isPositive: " + isPositive(3));
        System.out.println("isPositive: " + isPositive(-5));
        System.out.println("is2Digits: " + is2Digits(-32));
        System.out.println("is2Digits: " + is2Digits(-516));
        System.out.println("is2Digits: " + is2Digits(32));
        System.out.println("is2Digits: " + is2Digits(516));

    }

    public static double fraction(double x){
        int y=(int)x;
        return  x-y;
    }

    public static int sumLastNums(int x){
        int y = (x%10);
        int z = (x%100)/10;
        return  y+z;
    };

    public static int charToNum(char x){
        int y = (int)x-48;
        return y;
    };

    public static boolean isPositive(int x){
        boolean y = x > 0;
        return y;
    };

    public static boolean is2Digits(int x){
        boolean y = (x>0 && x<=99)||(x<0 && x>=-99);
        return y;
    };
}