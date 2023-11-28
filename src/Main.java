import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static ru.courses.parser.BubleSort.bubbleSort;
import static ru.courses.parser.BubleSort.reverse;
import static ru.courses.parser.Streams.getStringFromStream;
import static ru.courses.parser.Streams.printList;

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

        int[] list1 = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
        System.out.println(list);
        bubbleSort(list);
        bubbleSort(list1);
        System.out.println(list);
        System.out.println(Arrays.toString(list1));

        reverse(list1);
        System.out.println(Arrays.toString(list1));

        reverse(list);
        System.out.println(list);

        Stream<String> words = Stream.of("a", "b", "c", "d", "e", "f");
        String result = getStringFromStream(words);
        System.out.println(result);

        ArrayList<Integer> num = new ArrayList<>(List.of(1,2,3,4));
        printList(num);





    }

}