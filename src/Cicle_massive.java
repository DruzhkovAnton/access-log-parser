import java.util.Arrays;

public class Cicle_massive {

    public static String listNums(int x){
       String str = "0";
        for(int i=1; i<=x; i++){
            str = str+" "+i;
        }
        return str;
    }

    public static String reverseListNums(int x) {
        String str = Integer.toString(x);
        for(int i=x-1; i>=0; i--){
            str = str+" "+i;
        }
        return str;
    }

    public static String chet(int x) {
        String str = "0";
        for(int i=2; i<=x; i+=2){
            str = str+" "+i;
        }
        return str;
    }

    public static int pow(int x, int y){
        int res = 1;
        for(int i=1; i<=y; i++){
            res = res * x;
        }
        return res;
    }

    public static int numLen(long x){
        int res = 0;
        for(long i=x; i>=1; i/=10){
            res++;
        }
        return res;
    }

    public static boolean equalNum(int x) {
        boolean res = true;
        int y = x%10;
        int z = x;
        for (long i = x; i >= 1; i /= 10) {

            if(y != z%10){
                res = false;
            }
            z = z/10;
        }
        return res;
    }

    public static void square(int x){
        for (int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void leftTriangle(int x){
        for (int i=1; i<=x; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void guessGame() {
        int randomNum = 3;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int x;
        do {
            System.out.println("What number am I thinking (0 to 9)? :");
            x = sc.nextInt();
            if (x != randomNum) {
                System.out.println("No, try again");
            } else
                System.out.println("Yes, it`s " + randomNum);
        } while (x!=randomNum);
    }

    public static int findFirst(int[] arr, int x){
        for(int i=0;i<arr.length;i++)
            if(arr[i]==x)return i;
        return -1;
    }

    public static int findLast(int[] arr, int x){
        int index = -1;
        for(int i=0;i<arr.length;i++)
            if(arr[i]==x)index = i;
        return index;
    }

    public static int maxAbs(int[] arr){
        int res = 0;
        for(int i=0;i<arr.length;i++)
            if (Math.abs(res)<=Math.abs(arr[i]))res=arr[i];
        return res;
    }

    public static int countPositive(int[] arr){
        int res = 0;
        for(int i=0;i<arr.length;i++)
            if (arr[i]>0)res++;
        return res;
    }

    public static boolean palindrom(int[] arr){
        int x = 0;
        int y = arr.length-1;
        while (x < y) {
            if (arr[x] != arr[y]) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }

    public static void reverse(int[] arr){
        int x = 0;
        int y = arr.length;
        int[] res = new int[y];
        while (x < arr.length) {
            res[x]=arr[y-1 ];
            x++;
            y--;
        }

        System.out.println(Arrays.toString(res));
    }

    public static int[] reverseBack(int[] arr){
        int x = 0;
        int y = arr.length;
        int[] res = new int[y];
        while (x < arr.length) {
            res[x]=arr[y-1 ];
            x++;
            y--;
        }
        return res;
    }

    public static int[] concat(int[] arr1, int[] arr2){
        int x = arr1.length + arr2.length;
        int[] res = new int[x];
        for(int i=0; i<x; i++){
            if(i<arr1.length)
                res[i]=arr1[i];
            else res[i]=arr2[i-arr1.length];
        }
        return res;
    }

    public static int[] findAll(int[] arr, int x){

        int y = 0;
        int z = 0;
        for (int i=0; i<arr.length; i++)
            if(arr[i]==x)y++;
        int[] res = new int[y];

        for (int i=0; i<arr.length; i++)
            if(arr[i]==x){
                res[z] = i;
                z++;
            }
        return res;
    }

    public static int[] deleteNegative(int[] arr){
        int x = 0;
        for (int i=0; i<arr.length; i++)
            if(arr[i]>0)x++;
        int[] res = new int[x];
        x = 0;

        for (int i=0; i<arr.length; i++)
            if(arr[i]>0){
                res[x] = arr[i];
                x++;
            }
        return res;
    }

    public static int[] add(int[] arr, int x, int pos){
        int[] res = new int[arr.length+1];
        int y = 0;
        for (int i=0; i<res.length; i++){
            if(i==pos)res[i]=x;
            else {
                res[i]=arr[y];
                y++;
            }

        }
        return res;
    }

    public static int[] addArr(int[] arr, int[] ins, int pos){
        int[] res = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            res[i] = arr[i];
        }

        for (int i = 0; i < ins.length; i++) {
            res[pos + i] = ins[i];
        }

        for (int i = pos; i < arr.length; i++) {
            res[ins.length + i] = arr[i];
        }
        return res;
    }

}
