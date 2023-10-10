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
        System.out.println("abs: " + abs(5));
        System.out.println("abs: " + abs(-5));
        System.out.println("safeDiv: " + safeDiv(5, 0));
        System.out.println("safeDiv: " + safeDiv(8, 2));
        System.out.println("max: " + max(5, 7));
        System.out.println("max: " + max(8, -1));
        System.out.println("makeDecision: " + makeDecision(5, 7));
        System.out.println("makeDecision: " + makeDecision(8, -1));
        System.out.println("makeDecision: " + makeDecision(4, 4));
        System.out.println("max3: " + max3(5, 7, 7));
        System.out.println("max3: " + max3(8, -1, 4));
        System.out.println("sum3: " + sum3(5, 7, 2));
        System.out.println("sum3: " + sum3(8, -1, 4));
        System.out.println("sum2: " + sum2(5, 7));
        System.out.println("sum2: " + sum2(8, -1));
        System.out.println("is35: " + is35(5));
        System.out.println("is35: " + is35(8));
        System.out.println("is35: " + is35(15));
        System.out.println("magic6: " + magic6(5,7));
        System.out.println("magic6: " + magic6(8,2));
        System.out.println("magic6: " + magic6(1,6));
        System.out.println("age: " + age(5));
        System.out.println("age: " + age(31));
        System.out.println("age: " + age(44));
        System.out.println("age: " + age(44411));
        System.out.println("age: " + age(0));
        System.out.println("day: " + day(1));
        System.out.println("day: " + day(2));
        System.out.println("day: " + day(4));
        System.out.println("day: " + day(17));
        System.out.println("printDays:");
        printDays("четверг");


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
    };

    public static int abs(int x){
        if(x<0)return Math.abs(x);
        return x;
    };

    public static int safeDiv(int x, int y){
        if(y!=0) return x/y;
        return 0;
    };

    public static int max(int x, int y){
        if(x>y) return x;
        return y;
    };

    public static String makeDecision(int x, int y){
        if(x>y)return x + " > " + y;
        else if(x<y) return x + " < " + y;
        return x + " = " + y;
    };

    public static int max3(int x, int y, int z){
        int res=x;
        if(res<y) res = y;
        if(res<z) res = z;
        return res;
    };

    public static boolean sum3(int x, int y, int z){
        boolean res = false;
        if((x+y==z)||(x+y==y)||(x+y==x)) res = true;
        if((x+z==z)||(x+z==y)||(x+z==x)) res = true;
        if((z+y==z)||(z+y==y)||(z+y==x)) res = true;
        return res;
    };

    public static int sum2(int x, int y){
        int sum = x+y;
        if(sum>10 && sum<19) return 20;
        return sum;
    };

    public static boolean is35(int x){
        boolean res = false;
        if((x%3==0)||(x%5==0)) res = true;
        if((x%3==0)&&(x%5==0)) res = false;
        return res;
    };

    public static boolean magic6(int x, int y){
        boolean res = false;
        if(x==6||y==6||(x+y==6)||(x-y==6)||(y-x==6)) res = true;
        return res;
    };

    public static String age(int x){
        boolean res = false;
        String str = "лет";

        switch (x%10) {
            case 1:
                str = "год";
                break;
            case 2:
                str = "года";
                break;
            case 3:
                str = "года";
                break;
            case 4:
                str = "года";
                break;
        };

        switch (x%100) {
            case 11:
                str = "лет";
                break;
            case 12:
                str = "лет";
                break;
            case 13:
                str = "лет";
                break;

        };
        return x + " "+str;
    };

    public static String day(int x){
        String str = "это не день недели";
        switch (x){
            case 1: str= "Понедельник"; break;
            case 2: str= "Вторник"; break;
            case 3: str= "Среда"; break;
            case 4: str= "Четверг"; break;
            case 5: str= "Пятница"; break;
            case 6: str= "Суббота"; break;
            case 7: str= "Воскресенье"; break;
        }
        return str;
    };

    public static void printDays(String x){
        switch (x){
            case "понедельник": x=x+"\nвторник";
            case "вторник": x=x+"\nсреда";
            case "среда": x=x+"\nчетверг";
            case "четверг": x=x+"\nпятница";
            case "пятница": x=x+"\nсуббота";
            case "суббота": x=x+"\nвоскресенье";
            case "воскресенье": System.out.println(x);break;
            default:x = "это не день недели";System.out.println(x);break;
        };
    };

}