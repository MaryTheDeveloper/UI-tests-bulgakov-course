package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class WsShoppingCartPage {

    private final SelenideElement productName = $("a.product-name");
    private final SelenideElement qtyInput = $("input.qty-input");
    private final SelenideElement subtotal = $("span.product-subtotal");

    public WsShoppingCartPage correctItemName(String itemName) {
        productName.shouldHave(text(itemName));
        return this;
    }

    public WsShoppingCartPage correctQty(String itemQty) {
        qtyInput.shouldHave(value(itemQty));
        return this;
    }

    public void correctSubtotal(String itemSubtotal) {
        subtotal.shouldHave(text(itemSubtotal));
    }
}
