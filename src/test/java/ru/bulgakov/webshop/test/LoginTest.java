package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.bulgakov.webshop.BaseTest;
import ru.bulgakov.webshop.pages.BasePage;
import ru.bulgakov.webshop.pages.WsRegistrationPage;
import ru.bulgakov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class LoginTest extends BaseTest {
    private static final Faker faker = new Faker();
    private String email;
    private String password;

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

    @Nested
    class PositiveTest{
        @Test
        @DisplayName("Пользователь успешно вошел на сайт")
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

    @Nested
    class NegativeTest{
        @ParameterizedTest
        @DisplayName("Пользователь не может зайти на сайт с некорректным email")
        @CsvFileSource(resources = "/email.csv")
        @Tag("smoke")
        @Tag("NEGATIVE")
        @Tag("login")
        void invalidEmailLoginTest(String email) {
            open(WEB_SHOP_URL, WsWelcomePage.class)
                    .openLogin()
                    .checkLoginPageOpened()
                    .enterEmail(email)
                    .verifyEmailValidationErrorAppear()
                    .submitLogin();
        }
    }
}
