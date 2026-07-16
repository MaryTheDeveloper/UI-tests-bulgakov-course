package ru.bulgakov.junit;

import org.junit.jupiter.api.*;

public class JunitTest {

    @Nested
    public class PositiveTest {
        @Test
        @Disabled("Баг 123")
        void junitTest1() {
            System.out.println("Test 1");
        }

        @Test
        void junitTest2() {
            System.out.println("Test 2");
        }
    }

    @Nested
    public class NegativeTest {
        @Test
        @Disabled("Баг 123")
        void junitTest1() {
            System.out.println("Test 1");
        }

        @Test
        void junitTest2() {
            System.out.println("Test 2");
        }
    }
}
