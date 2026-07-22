package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class WsShoppingCartPage {

    private final SelenideElement productName = $("a.product-name");
    private final SelenideElement quantityInput = $("input.qty-input");
    private final SelenideElement subtotal = $("span.product-subtotal");

    @Step("Получить название товара")
    public String getItemName() {
        return productName.getText();
    }

    @Step("Получить количество товара")
    public String getQuantity() {
        return quantityInput.getValue();
    }

    @Step("Получить стоимость товара")
    public String getSubtotal() {
        return subtotal.getText();
    }
}
