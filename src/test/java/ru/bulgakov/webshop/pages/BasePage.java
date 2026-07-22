package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePage {

    private final ElementsCollection topMenu = $$("ul.top-menu li a");
    private final SelenideElement submenuDesktops = $(byText("Desktops"));
    private final SelenideElement cartQuantity = $("span.cart-qty");
    private final SelenideElement cartHeaderLink = $("a.ico-cart");

    @Step("Выбрать из списка Computers")
    public BasePage selectComputers() {
        topMenu.get(1).hover();
        return this;
    }

    @Step("Выбрать категорию Desktops")
    public WsCategoryPage selectDesktops() {
        submenuDesktops.click();
        return new WsCategoryPage();
    }

    @Step("Подтвердить количество товаров в корзине")
    public BasePage verifyCartQuantity(String itemQuantity) {
        cartQuantity.shouldHave(text("(" + itemQuantity + ")"));
        return this;
    }

    @Step("Открыть корзину")
    public WsShoppingCartPage openShoppingCart() {
        cartHeaderLink.click();
        return new WsShoppingCartPage();
    }
}
