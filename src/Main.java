//import java.util.Scanner;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("listNums:\n" + Cicle_massive.listNums(5));
        System.out.println("reverseListNums:\n" + Cicle_massive.reverseListNums(5));
        System.out.println("chet:\n" + Cicle_massive.chet(9));
        System.out.println("pow:\n" + Cicle_massive.pow(2, 5));
        System.out.println("numLen:\n" + Cicle_massive.numLen(123456789));
        System.out.println("equalNum:\n" + Cicle_massive.equalNum(12));
        System.out.println("equalNum:\n" + Cicle_massive.equalNum(22));
        System.out.println("square");
        Cicle_massive.square(2);
        System.out.println("square");
        Cicle_massive.square(4);
        System.out.println("leftTriangle");
        Cicle_massive.leftTriangle(3);
        System.out.println("rightTriangle");
        Cicle_massive.rightTriangle(3);
        System.out.println("rightTriangle");
        Cicle_massive.rightTriangle(4);
       // System.out.println("guessGame");
        //Cicle_massive.guessGame();

        int arr[] = {1,2,3,4,5,6,7,8,9};
        System.out.println("findFirst: " + Cicle_massive.findFirst(arr,0));

        int arr1[] = {1,2,3,3,5,6,3,3,9};
        System.out.println("findLast: " + Cicle_massive.findLast(arr1,3));

        int arr2[] = {1,-2,-7,4,2,2,-25};
        System.out.println("maxAbs: " + Cicle_massive.maxAbs(arr2));

        int arr3[] = {1,-2,7,-4,-2,2,5};
        System.out.println("countPositive: " + Cicle_massive.countPositive(arr3));

        int arr4[] = {1,-2,-7,4,2,2,5};
        System.out.println("palindrom: " + Cicle_massive.palindrom(arr4));
        int arr5[] = {1,-2,-7,4,-7,-2,1};
        System.out.println("palindrom: " + Cicle_massive.palindrom(arr5));

        int arr6[] = {1,2,3,4,5};
        System.out.println("reverse: " );
        Cicle_massive.reverse(arr6);

        int arr7[] = {1,2,3,4,5};
        System.out.println("reverseBack:\n" + Arrays.toString(Cicle_massive.reverseBack(arr7)));


    }
}