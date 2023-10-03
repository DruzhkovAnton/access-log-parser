import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x = 5.3;
        System.out.println("fraction: " + fraction(x));
    }

    public static double fraction(double x){
        int y=(int)x;
        return  x-y;
    }
}