package ru.bulgakov.webshop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.bulgakov.webshop.config.Config;
import ru.bulgakov.webshop.config.WebDriverConfig;
import ru.bulgakov.webshop.util.AttachManager;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.webshop.config.Config.getSelenoidChromeOptions;

public class BaseTest {

    private static final WebDriverConfig config = Config.getWebDriverConfig();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = config.browserSize();
        Configuration.browser = config.browser();

        if ("remote".equals(System.getProperty("run"))) {
            Configuration.remote = "https://"
                    + config.selenoidUser()
                    + ":"
                    + config.selenoidPassword()
                    + "@"
                    + config.selenoidUrl();
            Configuration.browserCapabilities = getSelenoidChromeOptions();
        }
    }

    @AfterEach
    void after() {
        clearBrowserCookies();
        clearBrowserLocalStorage();

        AttachManager.takeScreenshot();
        AttachManager.getBrowserConsoleLogs();
        AttachManager.getPageSource();

        if ("remote".equals(config.run())) {
            AttachManager.addVideo();
        }
    }
}
