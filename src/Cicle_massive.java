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
}
