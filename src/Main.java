import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pointe pointe1 = new Pointe();
        Pointe pointe2 = new Pointe();
        Pointe pointe3 = new Pointe();
        Pointe pointe4 = new Pointe();

        BrokenLine lst = new BrokenLine(pointe1);
        lst.pLst.add(pointe2);
        lst.pLst.add(pointe3);
        lst.pLst.add(pointe4);
        lst.getLineLst();

        Line l1 = new Line(pointe1, pointe2);
        Line l2 = new Line(pointe2, pointe3);
        Line l3 = new Line(pointe3, pointe4);

        double sumLine = l1.lengthLine()+l2.lengthLine()+l3.lengthLine();
        double sumMassLine = lst.lengthBrokenLine();


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

        Pointe3D p1 = new Pointe3D();
        p1.x = 12;
        p1.y = 15;
        p1.z = 20;

        System.out.println(p1);
















    }
}