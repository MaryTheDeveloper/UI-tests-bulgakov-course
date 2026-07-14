package homework.lesson1;

import java.util.*;

public class Math {
    public static void main(String[] args) {
        List<Double> prices = new ArrayList<>(Arrays.asList(120.23, 200.03, 1009.98, 2.90, 375.00));
        double budget = 5000;
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
        List<Double> sortedPrices = new ArrayList<>(priceList);
        Collections.sort(sortedPrices);

        for (double price : sortedPrices) {
            if (budget - price >= 0) {
                total += price;
                count++;
            } else {
                break;
            }
        }

        System.out.println("Куплено: " + count + " товара на сумму " + total);
        System.out.println("Остаток бюджета: " + (budget - total));
        System.out.println("Не куплено: " + (priceList.size() - count));
    }

    // этот метод, как по мне, более читаемый, но for мне больше нравится, так как там просто идет перебор всех итемов сразу
    public static void canBuyVersionWhile(List<Double> priceList, double budget) {
        double total = 0;
        int count = 0;
        int notBuyedCount = 0;
        double balance = budget;

        while (count < priceList.size()) {
            if (balance - priceList.get(count) > 0) {
                total += priceList.get(count);
                balance -= priceList.get(count);
            } else {
                notBuyedCount++;
            }
            count++;
        }
        System.out.println("Куплено: " + (count - notBuyedCount) + " товара на сумму " + total);
        System.out.println("Остаток бюджета: " + (budget - total));
        System.out.println("Не куплено: " + (notBuyedCount));
    }
}
