import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        ArrayList<Integer> list = new ArrayList<>();
        int n = 10;

        for (int i=0;i<n;i++){
            list.add(i+1);
        }
        System.out.println(list);
        System.out.println("  ");

        for (int i=0;i<n;i+=2){
            int temp = list.get(i);
            list.set(i,list.get(i+1));
            list.set(i+1, temp);
        }
        System.out.println(list);

    }

}