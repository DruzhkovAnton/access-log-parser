package ru.courses.main;
import ru.courses.algebra.*;
import ru.courses.geometry.*;
import ru.courses.student.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        String number = scanner.nextLine();
        System.out.println("Введите степень:");
        String x = scanner.nextLine();
        RaiseToPow pow = new RaiseToPow(number,x);
        pow.toPow();




        Pointe pointe1 = new Pointe(1,5);
        Pointe pointe2 = new Pointe(2,8);
        Pointe pointe3 = new Pointe(5,3);
        Pointe pointe4 = new Pointe(8,9);

        BrokenLine lst = new BrokenLine(pointe1);
        lst.pLst.add(pointe2);
        lst.pLst.add(pointe3);
        lst.pLst.add(pointe4);
        lst.getLineLst();

        Line l1 = new Line(pointe1, pointe2);
        Line l2 = new Line(pointe2, pointe3);
        Line l3 = new Line(pointe3, pointe4);

        double sumLine = l1.lengthLine()+l2.lengthLine()+l3.lengthLine();
        double sumMassLine = lst.length();


        System.out.println("массив точек:\n" + lst.pointListToString());

        System.out.println("Длина линий ломаной - " + sumLine);

        System.out.println("массив линий:" + lst.lineListToString());

        System.out.println("Длина массива линий ломаной - " + sumMassLine);
         assert sumLine==sumMassLine:"длина линий ломаной не совпадает с длиной линий из массива";
        System.out.println("длина ломаной " + sumLine + " равна длине линий из массива " + sumMassLine);

        pointe2.x = 12;
        System.out.println("--------------------");
        System.out.println("массив точек:\n" + lst.pointListToString());
        System.out.println("Длина линий ломаной - " + sumLine);
        System.out.println("массив линий:" + lst.lineListToString());
        System.out.println("Длина массива линий ломаной - " + sumMassLine);
        if(sumLine==sumMassLine)System.out.println("длина ломаной " + sumLine + " равна длине линий из массива " + sumMassLine);
        else System.out.println("длина линий ломаной не совпадает с длиной линий из массива");


        Fraction a = new Fraction(1,3);
        Fraction b = new Fraction(2,5);
        Fraction с = new Fraction(7,8);

        Fraction sum = a.plus(b);
        Fraction minus = b.minus(a);
        Fraction sum1 = a.plus(5);
        Fraction minus1 = b.minus(5);

        Fraction sum2 = a.plus(b).plus(с).minus(5);

        System.out.println(sum.toString());
        System.out.println(minus.toString());
        System.out.println(sum1.toString());
        System.out.println(minus1.toString());
        System.out.println(sum2.toString());




        Student alex = new Student("Alex", List.of(5,4,5,2,3,1));
        System.out.println(alex);

        Pointe3D p1 = new Pointe3D(12,15,20);

        System.out.println(p1);

        Polygon polygon = new Polygon();
        polygon.pLst.add(pointe1);
        polygon.pLst.add(pointe2);
        polygon.pLst.add(pointe3);
        polygon.pLst.add(pointe4);
        polygon.getLineLst();
        System.out.println(polygon.lineListToString());
        System.out.println(polygon.length());
        System.out.println();

        Lineble li1 = new Polygon(List.of(pointe1,pointe2,pointe3,pointe4));
        Lineble li2 = new BrokenLine(List.of(pointe1,pointe2,pointe3,pointe4));

        li1.getLineLst();
        li2.getLineLst();

        System.out.println(li1.length());
        System.out.println(li2.length());

        double num1 = 2;
        double num2 = 3.0/5.0;
        double num3 = 2.3;
        SumFraction result = new SumFraction(List.of(num1,num2,num3));
        System.out.println(result.sumNumbers());

        double num11 = 3.6;
        double num21 = 49.0/12.0;
        double num31 = 3;
        double num4 = 3.0/2.0;
        SumFraction result1 = new SumFraction(List.of(num11,num21,num31,num4));
        System.out.println(result1.sumNumbers());

        double num12 = 1.0/3.0;
        double num22 = 1;
        SumFraction result3 = new SumFraction(List.of(num12,num22));
        System.out.println(result3.sumNumbers());








    }
}