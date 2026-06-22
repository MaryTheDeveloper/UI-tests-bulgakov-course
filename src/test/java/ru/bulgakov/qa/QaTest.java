package ru.bulgakov.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.DemoQaRegistrationPage;
import ru.bulgakov.pages.LavaTopPayingPage;
import ru.bulgakov.pages.YandexSearchPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    @DisplayName("Проверить, что цена обучения 47000.00 рублей")
    @Tag("POSITIVE")
    void mentoringPriceShouldBe47000Test() {
        LavaTopPayingPage lavaTopPayingPage = new LavaTopPayingPage();

        open("https://ya.ru/", YandexSearchPage.class)
                .search("bulgakov qa")
                .submit()
                .closeDefaultBrowserSelectionPage()
                .openLink("ivanbulgakovqa.ru")
                .clickPrice()
                .clickButton("Хочу вкатиться в QA")
                .clickButton("Бегу оплачивать");

        lavaTopPayingPage.checkPrice("47 000.00");
    }

    @Test
    void userShouldBeRegistredAsMale() {

        String firstName = "Jane";
        String lastName = "Doe";
        String phoneNumber = "8800555353";

        open("https://demoqa.com/automation-practice-form", DemoQaRegistrationPage.class)
                .registrationFormIsVisible()
                .setFieldById("firstName", firstName)
                .setFieldById("lastName", lastName)
                .setFieldById("userNumber", phoneNumber)
                .setRadioButtonByValue("Male")
                .clickDateOfBirthField()
                .chooseDateOnTheTable("12","February", "1980")
                .clickSubmitButton()
                .checkRegistrationSuccessModalTableVisible()
                .checkFullNameSavedCorrecly(firstName, lastName);
    }
}
