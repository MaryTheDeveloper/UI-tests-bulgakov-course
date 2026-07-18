package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.pages.WsProductCartPage;
import ru.bulgakov.webshop.pages.WsShoppingCartPage;
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
        WsProductCartPage productCartPage = new WsProductCartPage();
        WsShoppingCartPage shoppingCartPage = new WsShoppingCartPage();

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .selectComputers()
                .selectDesktops()
                .selectItemByIndex(0)
                .selectProcessor(processorIndex)
                .setQuantity(itemQuantity)
                .addToCart()
                .successNotificationAppeared()
                .verifyCartQuantity(itemQuantity);

        String itemName = productCartPage.getItemName();
        String itemPrice = productCartPage.getProductPrice();
        float processorPrice = productCartPage.getProcessorPrice(processorIndex);
        String expectedTotal = String.format(Locale.US, "%.2f",
                (Float.parseFloat(itemPrice) + processorPrice) * Float.parseFloat(itemQuantity));

        productCartPage.openShoppingCart();

        assertAll(
                () -> assertEquals(itemName, shoppingCartPage.getItemName()),
                () -> assertEquals(expectedTotal, shoppingCartPage.getSubtotal()),
                () -> assertEquals(itemQuantity, shoppingCartPage.getQuantity())
        );
    }
}
