package com.company;

import java.util.*;

class Newspaper {
    String name;
    double[] prices;

    public Newspaper(String name, double[] prices) {
        this.name = name;
        this.prices = prices;
    }
}

public class WeeklyExpenses {
    // A class to represent a newspaper
    static List<List<Double>> paperCombination = new ArrayList<>();
    static List<List<Double>> finalCombination = new ArrayList<>();
    static List<List<String>> result = new ArrayList<>();
    private static void findWeeklySum(List<Newspaper>newspapers, Map<Double,String>Expense,List<Double>weeklyPrice){
        double sum = 0;
        for (int i =0;i<newspapers.size();i++) {
            Newspaper n = newspapers.get(i);
            double[] price = n.prices;
            for (int j = 0; j <price.length ; j++) {
                sum+=price[j];
            }
            weeklyPrice.add(sum);
            Expense.put(sum,n.name);
            sum=0;
        }
    }

    static  void possibleCombination(int index, Double budget,List<Double>weeklyExpense,List<Double>temp){
        if (index == weeklyExpense.size()) {
            paperCombination.add(new ArrayList<>(temp));
            return;
        }
        if (weeklyExpense.get(index) <= budget) {
            temp.add(weeklyExpense.get(index));
            possibleCombination(index + 1, budget - weeklyExpense.get(index),weeklyExpense, temp);
            temp.remove(temp.size() - 1);
        }
        possibleCombination(index + 1,budget, weeklyExpense, temp);
    }

    public static void main(String[] args) {
        // Create a list of newspapers
        List<Newspaper> newspapers = new ArrayList<>();
        newspapers.add(new Newspaper("TOI", new double[]{3, 3, 3, 3, 3, 5, 6}));
        newspapers.add(new Newspaper("Hindu", new double[]{2.5, 2.5, 2.5, 2.5, 2.5, 4, 4}));
        newspapers.add(new Newspaper("ET", new double[]{4, 4, 4, 4, 4, 4, 10}));
        newspapers.add(new Newspaper("BM", new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5}));
        newspapers.add(new Newspaper("HT", new double[]{2, 2, 2, 2, 2, 4, 4}));
        Map<Double,String> Expense = new HashMap<>();// To store weekly expense and newspaper in pair class
        List<Double>weeklyExpense = new ArrayList<>();
        findWeeklySum(newspapers,Expense,weeklyExpense);


        possibleCombination(0,40.0,weeklyExpense,new ArrayList<Double>());

        //... Finding pair with maximum length....
        int len = 0;
        for (int i =0;i<paperCombination.size();i++) {
            if (len < paperCombination.get(i).size())
                len = paperCombination.get(i).size();
        }
        for (int i = 0; i <paperCombination.size() ; i++) {
            if (paperCombination.get(i).size()==len)
                finalCombination.add(paperCombination.get(i));
        }

        for (List<Double>e1: finalCombination) {
            List<String>getCombination = new ArrayList<>();
            for (Double e2: e1) {
                getCombination.add(Expense.get(e2));
            }
            result.add(new ArrayList<>(getCombination));
        }
        System.out.println("All possible Combinations : " + result);

        }

    }


       
