package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class MenuTest {

    @Test
    void shouldContainAllOptions() {
        Menu menu = new Menu();

        String expectedMenu = "1.LIST_OF_BOOKS\n2.CHECKOUT\n3.RETURN\n4.QUIT\n";

        String actualMenu = menu.getMenu();


        Assertions.assertEquals(expectedMenu, actualMenu);
    }
}