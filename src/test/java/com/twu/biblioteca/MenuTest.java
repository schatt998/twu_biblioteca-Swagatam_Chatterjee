package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MenuTest {

    @Test
    void shouldContainAllOptions() {
        Menu menu = new Menu();
        MenuOptions expectedMenuOptions = MenuOptions.LIST_OF_BOOKS;

        Assertions.assertEquals(expectedMenuOptions, menu.getOptions());
    }
}