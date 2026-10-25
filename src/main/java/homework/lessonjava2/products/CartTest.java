package homework.lessonjava2.products;

public class CartTest {

    public static void main(String[] args) {
        Product product1 = new Product("Сыр", 200);
        Product product2 = new Product("Масло", 201.11);
        Product product3 = new Product("Лимон", 0.59);
        Product product4 = new Product("Яблоко", 1.59);

        Cart cart = new Cart();
        cart.addProduct(product1, 1);
        cart.addProduct(product2, 2);
        cart.addProduct(product3, 5);
        cart.addProduct(product4, 10);

        System.out.println("Стоимость продуктов в корзине: " + cart.getTotalPrice());
        System.out.println("Количество продуктов в корзине: " + cart.getProductCount());
    }
}
