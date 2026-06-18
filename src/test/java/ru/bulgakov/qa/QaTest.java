package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.LavaTopPayingPage;
import ru.bulgakov.pages.YandexSearchPage;
import ru.bulgakov.pages.YandexSearchResultsPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
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

        open("https://demoqa.com/automation-practice-form");
        sleep(3000);
        $("#userForm").shouldBe(visible);

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("[value=\"Male\"]").click();
        $("[placeholder=\"Mobile Number\"]").setValue(phoneNumber);
        $("#submit").scrollTo().click();
        sleep(3000);

        $(".modal-content").shouldBe(visible);
        $(".table-dark").shouldBe(visible);
        $(".table-dark > tbody > tr:first-child > td:nth-child(2)").shouldHave(exactText(firstName + " " + lastName));
    }
}
