package ru.courses.algebra;

public class Sum {
    public static void sum(String[] num){
        double sum = 0;
        for (String x:num){
                if(isParsableAsDouble(x)){
                sum+=Double.parseDouble(x);
            }
        }
        System.out.println("Сумма = " + sum);
    }
    public static boolean isParsableAsDouble(String str) {
        try {
            double value = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
