package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
    private static final Faker faker = new Faker();

    @Test
    void registrationTest() {
        String password = faker.harryPotter().character() + faker.number().positive();
        String email = faker.internet().emailAddress();

        open("https://demowebshop.tricentis.com/register", WsWelcomePage.class)
                .openRegistration()
                .verifyRegistrationOpen()
                .selectMaleGender()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .submitRegistration()
                .checkRegistrationCompleted()
                .checkEmailIsShown(email);
    }
}
