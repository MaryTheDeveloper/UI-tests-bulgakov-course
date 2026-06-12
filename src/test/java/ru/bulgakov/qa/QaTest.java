package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    void mentoringPriceShouldBe4700Test() {

        open("https://ya.ru/");
        $("#text").setValue("bulgakov qa");
        $("[type=submit]").click();
        $(".DistributionButtonClose").click();
        $(byText("ivanbulgakovqa.ru")).click();
        sleep(5000);
        switchTo().window(1);

        $$(".t-menu__list li").last().click();
        $(byText("Хочу вкатиться в QA")).click();
        $(byText("Бегу оплачивать")).click();
        sleep(5000);

        switchTo().window(2);
        $(".styles-module-scss-module__kWKzya__price").shouldBe(text("47 000.00"));
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
