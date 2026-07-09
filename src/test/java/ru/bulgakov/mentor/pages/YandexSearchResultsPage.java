package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YandexSearchResultsPage {

    private final SelenideElement closeWindow = $(".DistributionButtonClose");

    public YandexSearchResultsPage closeDefaultBrowserSelectionPage() {
        closeWindow.shouldBe(visible); //тест флакал с впн, потом я его вырубила, но решила оставить на всякий случай проверки
        closeWindow.click();
        closeWindow.shouldNotBe(visible);
        return this;
    }

    public WelcomePage openLink(String webSiteName) {
        $(byText(webSiteName)).click();
        switchTo().window(1);
        return new WelcomePage();
    }
}
