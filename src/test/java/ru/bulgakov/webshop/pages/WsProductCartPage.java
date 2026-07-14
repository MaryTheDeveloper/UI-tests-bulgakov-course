package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsProductCartPage extends BasePage{

    private final ElementsCollection optionList = $$("dl dd ul li");
    private final SelenideElement quantityInput = $("input.qty-input");
    private final SelenideElement addToCartButton = $("input.add-to-cart-button");
    private final SelenideElement successNotification = $("div.bar-notification.success");
    private final SelenideElement productName = $("[itemprop=name]");
    private final SelenideElement subtotal = $("[itemprop=price]");

    public String getItemName() { return productName.getText(); }
    public String getQuantity() { return quantityInput.getValue(); }
    public String getSubtotal() { return subtotal.getText(); }

    public WsProductCartPage selectProcessor(int processorIndex) {
        optionList.get(0).$$("li input").get(processorIndex).click();
        return this;
    }

    public WsProductCartPage setQuantity(String quantity) {
        quantityInput.setValue(quantity);
        return this;
    }

    public WsProductCartPage addToCart() {
        addToCartButton.click();
        successNotification.shouldBe(visible);
        return this;
    }

    public WsProductCartPage successNotificationAppeared() {
        successNotification.shouldBe(visible);
        return this;
    }
}