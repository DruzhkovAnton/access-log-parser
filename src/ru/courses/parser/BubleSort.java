package ru.courses.parser;

import java.util.ArrayList;

public class BubleSort {

    public static void bubbleSort(ArrayList<Integer> intList) {
        for (int i = 0; i < intList.size() - 1; i++) {
            for (int j = 0; j < intList.size() - i - 1; j++) {
                if (intList.get(j) > intList.get(j + 1)) {
                    int temp = intList.get(j);
                    intList.set(j, intList.get(j + 1));
                    intList.set(j + 1, temp);
                }
            }
        }
    }

    public static void bubbleSort(int[] intArray) {
        int n = intArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
            }
        }
    }
}
