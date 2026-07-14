package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.pages.WsProductCartPage;
import ru.bulgakov.webshop.pages.WsWelcomePage;
import ru.bulgakov.webshop.steps.AuthSteps;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class CartTest {
    private static final Faker faker = new Faker();
    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    void addToCardTest() {
        String itemQty = "2";
        int processorIndex = 0;
        WsProductCartPage wsProductCartPage = new WsProductCartPage();

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .selectComputers()
                .selectDesktops()
                .selectItemByIndex(0)
                .selectProcessor(processorIndex)
                .inputQtyValue(itemQty)
                .addToCart()
                .successNotificationAppeared()
                .cartQtyIsCorrect(itemQty);

        String itemName = wsProductCartPage.getItemName();
        String itemPrice = wsProductCartPage.getItemPrice();

        wsProductCartPage
                .openShoppingCart()
                .correctItemName(itemName)
                .correctQty(itemQty)
                .correctSubtotal(String.format(Locale.US, "%.2f",
                        Float.parseFloat(itemPrice) * Float.parseFloat(itemQty)));
    }
}
