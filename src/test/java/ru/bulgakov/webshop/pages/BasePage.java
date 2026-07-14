package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePage {

    private final ElementsCollection topMenu = $$("ul.top-menu li a");
    private final SelenideElement submenuDesktops = $(byText("Desktops"));
    private final SelenideElement cartQuantity = $("span.cart-qty");
    private final SelenideElement cartHeaderLink = $("a.ico-cart");

    public BasePage selectComputers() {
        topMenu.get(1).hover();
        return this;
    }

    public WsCategoryPage selectDesktops() {
        submenuDesktops.click();
        return new WsCategoryPage();
    }

    public void cartQuantityIsCorrect(String itemQuantity) {
        cartQuantity.shouldHave(text("(" + itemQuantity + ")"));
    }

    public WsShoppingCartPage openShoppingCart() {
        cartHeaderLink.click();
        return new WsShoppingCartPage();
    }
}
