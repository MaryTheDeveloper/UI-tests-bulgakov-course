package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DemoQaRegistrationPage {

    public final SelenideElement registrationForm = $("#userForm");
    public final SelenideElement submitButton = $("#submit");
    public final SelenideElement calendarForm = $(".react-datepicker-popper");
    public final SelenideElement calendarMonthSelector = $(".react-datepicker__month-select");
    public final SelenideElement calendarYearSelector = $(".react-datepicker__year-select");
    public final ElementsCollection calendarMonthSelectorElements = $$(".react-datepicker__month-select option");
    public final ElementsCollection calendarYearSelectorElements = $$(".react-datepicker__year-select option");
    public final ElementsCollection calendarDaySelectorElements = $$(".react-datepicker__day");

    public final SelenideElement registrationSuccessModal = $(".modal-content");
    public final SelenideElement registrationInformationTable = $(".table-dark");
    public final SelenideElement studentNameField = $(".table-dark > tbody > tr:first-child > td:nth-child(2)");

    public DemoQaRegistrationPage registrationFormIsVisible() {
        registrationForm.shouldBe(visible);
        return this;
    }

    private DemoQaRegistrationPage setFieldById(String fieldName, String fieldValue) {
        $("#" + fieldName).setValue(fieldValue);
        return this;
    }
    public DemoQaRegistrationPage setFirstName(String firstName) {
        return setFieldById("firstName", firstName);
    }

    public DemoQaRegistrationPage setLastName(String lastName) {
        return setFieldById("lastName", lastName);
    }

    public DemoQaRegistrationPage setPhoneNumber(String phoneNumber) {
        return setFieldById("phoneNumber", phoneNumber);
    }

    private DemoQaRegistrationPage setRadioButtonByValue(String value) {
        $(String.format("[value=%s]", value)).click();
        return this;
    }

    public DemoQaRegistrationPage setGenderMale() {
        return setRadioButtonByValue("Male");
    }

    public DemoQaRegistrationPage submit() {
        submitButton.scrollTo().click();
        return this;
    }

    public DemoQaRegistrationPage dateOfBirth() {
        $("#dateOfBirthInput").click();
        $(".react-datepicker-popper").shouldBe(visible);
        return this;
    }

    public DemoQaRegistrationPage chooseDate(String day, String month, String year) {
        calendarMonthSelector.click();
        calendarMonthSelectorElements.findBy(text(month)).click();
        calendarYearSelector.click();
        calendarYearSelectorElements.findBy(text(year)).click();
        calendarDaySelectorElements.findBy(text(day)).click();
        calendarForm.shouldNotBe(visible);
        return this;
    }

    public DemoQaRegistrationPage verifyInformationTableApeared() {
        registrationSuccessModal.shouldBe(visible);
        return this;
    }

    public DemoQaRegistrationPage checkFullNameSavedCorrecly(String firstName, String lastName) {
        studentNameField.shouldHave(exactText(firstName + " " + lastName));
        return this;
    }
}
