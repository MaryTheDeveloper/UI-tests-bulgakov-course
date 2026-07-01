package ru.bulgakov.mentor.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.mentor.pages.DemoQaRegistrationPage;
import ru.bulgakov.mentor.pages.LavaTopPayingPage;
import ru.bulgakov.mentor.pages.YandexSearchPage;

import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    private static final String PRACTICE_FORM_URL = "https://demoqa.com/automation-practice-form";
    private static final String YANDEX_URL = "https://ya.ru/";

    @Test
    @DisplayName("Проверить, что цена обучения 47000.00 рублей")
    @Tag("POSITIVE")
    void mentoringPriceShouldBe47000Test() {
        LavaTopPayingPage lavaTopPayingPage = new LavaTopPayingPage();

        open(YANDEX_URL, YandexSearchPage.class)
                .search("bulgakov qa")
                .submit()
                .closeDefaultBrowserSelectionPage()
                .openLink("ivanbulgakovqa.ru")
                .clickPrice()
                .wannaBeQA()
                .readyToPay()
                .checkPrice("47 000.00");
    }

    @Test
    void userShouldBeRegistredAsMale() {

        String firstName = "Jane";
        String lastName = "Doe";
        String phoneNumber = "8800555353";

        open(PRACTICE_FORM_URL, DemoQaRegistrationPage.class)
                .registrationFormIsVisible()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setGenderMale()
                .dateOfBirth()
                .chooseDate("12","February", "1980")
                .submit()
                .verifyInformationTableApeared()
                .checkFullNameSavedCorrecly(firstName, lastName);
    }
}
