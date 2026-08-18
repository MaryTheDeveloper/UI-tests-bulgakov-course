package ru.bulgakov.webshop.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class APITest {

    @Test
    @Tags({@Tag("API"), @Tag("positive1")})
    void apiTest1() {
        System.out.println("API positive test");
    }

    @Test
    @Tags({@Tag("API"), @Tag("negative1")})
    void apiTest2() {
        System.out.println("API negative test");
    }
}
