package ru.bulgakov.webshop.test;

import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.bulgakov.webshop.BaseTest;
import ru.bulgakov.webshop.pages.BasePage;
import ru.bulgakov.webshop.pages.WsLoginPage;
import ru.bulgakov.webshop.pages.WsRegistrationPage;
import ru.bulgakov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static ru.bulgakov.webshop.config.Config.*;

@Epic("Авторизация")
@Feature("Вход в аккаунт")
public class LoginTest extends BaseTest {
    private static final Faker faker = new Faker();
    private String email;
    private String password;

    @Nested
    class PositiveTests{
        @BeforeEach
        void beforeEach() {
            password = faker.harryPotter().character() + faker.number().positive();
            email = faker.internet().emailAddress();

            open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                    .register(
                            faker.name().firstName(),
                            faker.name().lastName(),
                            email,
                            password)
                    .checkUserLoggedIn(email);

            clearBrowserCookies();
            clearBrowserLocalStorage();
        }

        @Test
        @DisplayName("Успешная авторизация пользователя")
        @Severity(CRITICAL)
        @Owner("Maria S")
        @Link(name = "TASK-220", url = "https://jira/ticket/TASK-220")
        @Tag("POSITIVE")
        @Tag("smoke")
        @Tag("login")
        void successLoginTest() {
            open(WEB_SHOP_URL, WsWelcomePage.class)
                    .openLogin()
                    .checkLoginPageOpened()
                    .enterEmail(email)
                    .enterPassword(password)
                    .checkRememberMe()
                    .submitLogin()
                    .checkUserLoggedIn(email);
        }
    }

    @ParameterizedTest(name = "Авторизация с некорректным email: {0}")
    @Severity(CRITICAL)
    @Owner("Maria S")
    @Link(name = "TASK-86", url = "https://jira/ticket/TASK-86")
    @CsvFileSource(resources = "/email.csv")
    @Tag("smoke")
    @Tag("NEGATIVE")
    @Tag("login")
    void invalidEmailLoginTest(String email) {
        open(WEB_SHOP_LOGIN_URL, WsLoginPage.class)
                .enterEmail(email)
                .enterPassword("password")
                .verifyEmailValidationErrorAppear()
                .submitLogin();
    }
}
