package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsProductCartPage extends BasePage {

    private final ElementsCollection optionList = $$("dl dd ul li");
    private final SelenideElement quantityInput = $("input.qty-input");
    private final SelenideElement addToCartButton = $("input.add-to-cart-button");
    private final SelenideElement successNotification = $("div.bar-notification.success");
    private final SelenideElement productName = $("[itemprop=name]");
    private final SelenideElement productPrice = $("[itemprop=price]");

    @Step("Получить название товара")
    public String getItemName() {
        return productName.getText();
    }

    @Step("Получить стоимость товара")
    public String getProductPrice() {
        return productPrice.getText();
    }

    @Step("Выбрать процессор")
    public WsProductCartPage selectProcessor(int processorIndex) {
        optionList.get(0).$$("li input").get(processorIndex).click();
        return this;
    }

    @Step("Ввести количество товаров")
    public WsProductCartPage setQuantity(String quantity) {
        quantityInput.setValue(quantity);
        return this;
    }

    @Step("Добавить товар в корзину")
    public WsProductCartPage addToCart() {
        addToCartButton.click();
        return this;
    }

    @Step("Уведомление об успешном добавлении товара в корзину")
    public WsProductCartPage successNotificationAppeared() {
        successNotification.shouldBe(visible);
        return this;
    }

    public float getProcessorPrice(int processorIndex) {
        return switch (processorIndex) {
            case 0 -> 0f;
            case 1 -> 15f;
            case 2 -> 100f;
            default -> throw new IllegalArgumentException("Unknown processor index: " + processorIndex);
        };
    }
}