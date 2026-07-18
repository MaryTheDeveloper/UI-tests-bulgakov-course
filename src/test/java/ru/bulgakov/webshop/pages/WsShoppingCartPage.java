package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class WsShoppingCartPage {

    private final SelenideElement productName = $("a.product-name");
    private final SelenideElement quantityInput = $("input.qty-input");
    private final SelenideElement subtotal = $("span.product-subtotal");

    public String getItemName() {
        return productName.getText();
    }

    public String getQuantity() {
        return quantityInput.getValue();
    }

    public String getSubtotal() {
        return subtotal.getText();
    }
}
