package ru.courses.algebra;

import java.util.List;

public class SumFraction {
    List<Double> numlist;

    public SumFraction(List<Double> numlist){
        this.numlist = numlist;
    }
    public double sumNumbers() {
        double sum = 0;
        for (int i=0;i<numlist.size();i++){
            System.out.print(numlist.get(i)+"|");
            sum=sum+numlist.get(i);
        }
        System.out.println();
        return sum;
    }
}