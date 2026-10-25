package homework.lessonjava2.products;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public Double getTotalPrice() {
        return products.entrySet().stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
    }

    public int getProductCount() {
        return products.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
