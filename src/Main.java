import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x = 5.3;
        int x1 = 4568;
        System.out.println("fraction: " + fraction(x));
        System.out.println("sumLastNums: " + sumLastNums(x1));

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
}