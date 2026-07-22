package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WsLoginPage {

    private final SelenideElement loginPageTitle = $("div.page-title h1");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement rememberMeCheckbox = $("input#RememberMe");
    private final SelenideElement loginButton = $("input.login-button");

    @Step("Страница входа открыта")
    public WsLoginPage checkLoginPageOpened() {
        loginPageTitle.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

    @Step("Ввести электронную почту {email}")
    public WsLoginPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввести пароль {password}")
    public WsLoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Поставить галочку 'Запомнить меня'")
    public  WsLoginPage checkRememberMe() {
        rememberMeCheckbox.click();
        return this;
    }

    @Step("Подтвердить авторизацию")
    public WsWelcomePage submitLogin() {
        loginButton.click();
        return new WsWelcomePage();
    }

    @Step("Проверить, что появилась ошибка валидации почты")
    public WsLoginPage verifyEmailValidationErrorAppear() {
        $("span.field-validation-error").shouldBe(visible);
        return this;
    }
}
