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
}
