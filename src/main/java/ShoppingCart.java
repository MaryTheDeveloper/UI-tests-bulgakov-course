public class ShoppingCart {

    public static void main(String[] args) {
        String[] items = {"Кроссовки", "Футболка", "Рюкзак", "Джинсы", "Носки"};
        double[] prices = {1900.0, 450.0, 3200.0, 890.0, 150.0};
        double budget = 5000.0;

        // 1. Вывести список товаров с ценами
        System.out.println("Корзина:");
        for (int i = 0; i < items.length; i++) {
            System.out.println("Продукт: " + items[i] + ", цена - " + prices[i]);
        }

        // 2. Вывести сумму корзины
        double total = 0;
        for (double price : prices) {
            total += price;
        }

        System.out.println("Общая сумма корзины: " + total);

        // 3. Хватает ли у клиента денег
        System.out.println("Бюджет: " + budget);

        if (budget > total) {
            System.out.println("Бюджета хватает! Остаток: " + (budget - total));
        } else {
            System.out.println("Бюджета не хватает! Недостаток: " + (total - budget));
        }

    }
}
