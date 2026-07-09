package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LavaTopPayingPage {
    private final SelenideElement price = $(".styles-module-scss-module__kWKzya__price");

    public LavaTopPayingPage checkPrice(String expectedPrice) {
        switchTo().window(2);
        price.shouldHave(text(expectedPrice));
        return this;
    }
}
