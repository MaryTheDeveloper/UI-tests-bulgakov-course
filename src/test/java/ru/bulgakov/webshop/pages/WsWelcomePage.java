package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsWelcomePage extends BasePage {

    private final SelenideElement registrationButton = $("a.ico-register");
    private final SelenideElement logInButton = $("a.ico-login");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");

    @Step("Открыть страницу регистрации")
    public WsRegistrationPage openRegistration() {
        registrationButton.click();
        return new WsRegistrationPage();
    }

    @Step("Открыть страницу входа")
    public WsLoginPage openLogin() {
        logInButton.click();
        return new WsLoginPage();
    }

    @Step("Проверить, что пользователь вошел в профиль")
    public WsWelcomePage checkUserLoggedIn(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }
}
