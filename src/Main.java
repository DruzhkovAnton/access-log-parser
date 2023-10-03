import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("fraction: " + fraction(5.3));
        System.out.println("sumLastNums: " + sumLastNums(4568));
        System.out.println("charToNum: " + charToNum('9'));

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
}