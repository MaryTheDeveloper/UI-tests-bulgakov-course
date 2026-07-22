package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class WsCategoryPage {
    private final ElementsCollection productsGrid = $$("div.product-grid div");

    @Step("Перейти на карточку товара из списка товаров")
    public WsProductCartPage selectItemByIndex(Integer index) {
        productsGrid.get(index).click();
        return new WsProductCartPage();
    }
}