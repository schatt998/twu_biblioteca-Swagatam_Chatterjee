package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class MenuTest {

    @Test
    void shouldContainAllOptions() {
        Menu menu = new Menu();
        ArrayList<MenuOptions> expectedMenuOptions = new ArrayList<>();
        expectedMenuOptions.add(MenuOptions.LIST_OF_BOOKS);
        expectedMenuOptions.add(MenuOptions.CHECKOUT);


        Assertions.assertEquals(expectedMenuOptions, menu.getMenu());
    }
}