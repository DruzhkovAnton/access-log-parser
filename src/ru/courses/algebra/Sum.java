package ru.courses.algebra;

public class Sum {
    public static void sum(String[] num){
        double sum = 0;
        for (String x:num){
            try{
                double a = Double.parseDouble(x);
                sum+=a;
            }catch (NumberFormatException ex){
                System.out.println(x + " не является числом и будет пропущено");
            }
        }
        System.out.println("Сумма = " + sum);
    }
}
