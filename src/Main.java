public class Main {
    public static void main(String[] args) {
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












    }
}