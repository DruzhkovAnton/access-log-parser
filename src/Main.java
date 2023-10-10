import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        System.out.println("fraction: " + fraction(5.3));
        System.out.println("sumLastNums: " + sumLastNums(4568));
        System.out.println("charToNum: " + charToNum('9'));
        System.out.println("isPositive: " + isPositive(3));
        System.out.println("isPositive: " + isPositive(-5));
        System.out.println("is2Digits: " + is2Digits(-3));
        System.out.println("is2Digits: " + is2Digits(3));
        System.out.println("is2Digits: " + is2Digits(32));
        System.out.println("is2Digits: " + is2Digits(516));
        System.out.println("isUpperCase: " + isUpperCase('A'));
        System.out.println("isUpperCase: " + isUpperCase('q'));
        System.out.println("isInRange: " + isInRange(5, 1, 3));
        System.out.println("isInRange: " + isInRange(2, 15, 33));
        System.out.println("isDivisor: " + isDivisor(3, 6));
        System.out.println("isDivisor: " + isDivisor(0, 0));
        System.out.println("isEqual: " + isEqual(3, 3,3));
        System.out.println("isEqual: " + isEqual(2, 15,2));
        a =  lastNumSum(a, 11);
        a =  lastNumSum(a, 123);
        a =  lastNumSum(a, 14);
        System.out.println("lastNumSum: " + lastNumSum(a, 1));
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
        boolean y = (x>9 && x<=99)||(x<-9 && x>=-99);
        return y;
    };

    public static boolean isUpperCase(char x){
        boolean y = (int)x > 64 && (int)x < 91;
        return y;
    };

    public static boolean isInRange(int a, int b, int num){
        boolean y = (num>=a && num <=b)||(num>=b && num <=a);
        return y;
    };

    public static boolean isDivisor (int a, int b){
        boolean y=(b!=0 && a%b==0) || (a!=0 && b%a==0);
        return y;
    };

    public static boolean isEqual (int a, int b, int c){
        boolean y = a==b && b==c;
        return y;
    };

    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }
}