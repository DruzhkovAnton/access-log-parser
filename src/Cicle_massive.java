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
}
