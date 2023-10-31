import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pointe pointe1 = new Pointe(1,3);
        Pointe pointe2 = new Pointe(1,5);
        Pointe pointe3 = new Pointe(5,8);

        System.out.print(pointe1.toSring());
        System.out.print(pointe2.toSring());
        System.out.print(pointe3.toSring());
        Pointe.poitEquals(pointe1,pointe2,pointe3);

        Line line1 = new Line(1,3,5,8);
        Line line2 = new Line(10,11,15,19);
        Line line3 = new Line(line1.p2, line2.p1);

        System.out.println(line1.fromPointToPoint());
        System.out.println("Длина линии 1 = " + line1.lengthLine());

        System.out.println(line2.fromPointToPoint());
        System.out.println("Длина линии 2 = " + line2.lengthLine());

        System.out.println(line3.fromPointToPoint());
        System.out.println("Длина линии 3 = " + line3.lengthLine());

        line1.p2.x = line1.p2.x + 1;
        line2.p1.y = line2.p1.y +1;

        System.out.println("произошло изменени линий");

        System.out.println(line1.fromPointToPoint());
        System.out.println("Длина линии 1 = " + line1.lengthLine());
        System.out.println(line2.fromPointToPoint());
        System.out.println("Длина линии 2 = " + line2.lengthLine());
        System.out.println(line3.fromPointToPoint());
        System.out.println("Длина линии 3 = " + line3.lengthLine());

        System.out.println("сумма длин всех линий = "+(line1.lengthLine() + line2.lengthLine() + line3.lengthLine()));




    }
}