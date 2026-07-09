package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class WsCategoryPage {
    private final ElementsCollection productsGrid = $$("div.product-grid div");

    public WsProductCartPage selectItemByIndex(Integer index) {
        productsGrid.get(index).click();
        return new WsProductCartPage();
    }
}