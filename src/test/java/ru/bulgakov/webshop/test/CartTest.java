package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.pages.WsProductCartPage;
import ru.bulgakov.webshop.pages.WsWelcomePage;
import ru.bulgakov.webshop.steps.AuthSteps;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        String itemQuantity = "2";
        int processorIndex = 0;
        WsProductCartPage cartPage = new WsProductCartPage();

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .selectComputers()
                .selectDesktops()
                .selectItemByIndex(0)
                .selectProcessor(processorIndex)
                .setQuantity(itemQuantity)
                .addToCart()
                .successNotificationAppeared()
                .cartQuantityIsCorrect(itemQuantity);

        String itemName = cartPage.getItemName();
        String expectedTotal = cartPage.getSubtotal();

        assertAll(
                () -> assertEquals(itemName, cartPage.getItemName()),
                () -> assertEquals(expectedTotal, cartPage.getSubtotal()),
                () -> assertEquals(itemQuantity, cartPage.getQuantity())
        );

        cartPage
                .openShoppingCart()
                .correctItemName(itemName)
                .correctQuantity(itemQuantity)
                .correctSubtotal(String.format(Locale.US, "%.2f",
                        Float.parseFloat(expectedTotal) * Float.parseFloat(itemQuantity)));
    }
}
