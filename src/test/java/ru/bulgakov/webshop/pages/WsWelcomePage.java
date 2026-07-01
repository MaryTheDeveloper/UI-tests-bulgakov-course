package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WsWelcomePage {

    private final SelenideElement registrationButton = $("a.ico-register");
    public WsRegistrationPage openRegistration() {
        registrationButton.click();
        return new WsRegistrationPage();
    }
}
