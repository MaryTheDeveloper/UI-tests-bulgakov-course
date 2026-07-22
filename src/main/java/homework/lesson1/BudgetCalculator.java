package homework.lesson1;

import java.util.*;

public class BudgetCalculator {
    public static void main(String[] args) {
        List<Double> prices = new ArrayList<>(Arrays.asList(120.23, 200.03, 1009.98, 2.90, 375.00));
        double budget = 200.03;
        double sum = sumOfPriceList(prices);

        System.out.println(sum);
        System.out.println(compareBudget(budget, sum));
        canBuyVersionFor(prices, budget);
        canBuyVersionWhile(prices, budget);
    }

    public static double sumOfPriceList(List<Double> priceList) {
        double total = 0;
        for (double price : priceList) {
            total += price;
        }
        return total;
    }

    public static String compareBudget(double budget, double sum) {
        if (budget >= sum) {
            return "Бюджета хватает! Остаток: " + (budget - sum);
        }

        return "Бюджета не хватает! Не хватает: " + (sum - budget);
    }

    public static void canBuyVersionFor(List<Double> priceList, double budget) { //
        double total = 0;
        int count = 0;
        int index = 0;

        for (double price : priceList) {
            if (total + price <= budget) {
                total += price;
                count++;
            }
        }

        System.out.println("Куплено: " + count + " товара на сумму " + total);
        System.out.println("Остаток бюджета: " + (budget - total));
        System.out.println("Не куплено: " + (priceList.size() - count));
    }

    public static void canBuyVersionWhile(List<Double> priceList, double budget) {
        double total = 0;
        int index = 0;
        int boughtCount = 0;
        int notBoughtCount = 0;
        double balance = budget;

        while (boughtCount < priceList.size()) {
            if (balance - priceList.get(boughtCount) >= 0) {
                total += priceList.get(boughtCount);
                balance -= priceList.get(boughtCount);
                index++;
            } else {
                notBoughtCount++;
            }
            boughtCount++;
        }
        System.out.println("Куплено: " + index + " товара на сумму " + total);
        System.out.println("Остаток бюджета: " + (budget - total));
        System.out.println("Не куплено: " + (notBoughtCount));
    }
}
