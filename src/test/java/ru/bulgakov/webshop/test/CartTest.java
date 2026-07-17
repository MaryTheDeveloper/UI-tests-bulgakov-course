package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.BaseTest;
import ru.bulgakov.webshop.pages.BasePage;
import ru.bulgakov.webshop.pages.WsProductCartPage;
import ru.bulgakov.webshop.pages.WsShoppingCartPage;
import ru.bulgakov.webshop.pages.WsWelcomePage;
import ru.bulgakov.webshop.steps.AuthSteps;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class CartTest extends BaseTest {
    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    @DisplayName("Добавить 2 компьютера с процессором Slow в корзину и проверить стоимость и количество")
    @Tag("POSITIVE")
    @Tag("cart")
    @Tag("smoke")
    void addToCartTest() {
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
