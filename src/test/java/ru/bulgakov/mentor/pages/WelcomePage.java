package ru.bulgakov.mentor.pages;

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

    public WelcomePage wannaBeQA() {
        return clickButton("Хочу вкатиться в QA");
    }

    public LavaTopPayingPage readyToPay() {
        clickButton("Бегу оплачивать");
        return new LavaTopPayingPage();
    }

    private WelcomePage clickButton(String buttonText) {
        $(byText(buttonText)).click();
        return this;
    }
}
