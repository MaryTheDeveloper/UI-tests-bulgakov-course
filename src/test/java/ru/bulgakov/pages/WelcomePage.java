package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WelcomePage {

    private final SelenideElement priceButton = $$(".t-menu__list li").last();

    public WelcomePage clickPrice() {
        priceButton.click();
        return this;
    }

    public WelcomePage clickButton(String buttonText) {
        $(byText(buttonText)).click();
        return this;
    }
}
