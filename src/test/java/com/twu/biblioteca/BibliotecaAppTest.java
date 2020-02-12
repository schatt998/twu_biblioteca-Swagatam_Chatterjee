package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BibliotecaAppTest {


    @Test
    public void shouldShowWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMessage = "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore";

        String actualMessage = bibliotecaApp.showWelcomeMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void shouldGetOptionInTheMenu() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMenu = "1.LIST_OF_BOOKS\n2.CHECKOUT\n3.RETURN\n4.QUIT\n";

        String actualMenu = bibliotecaApp.showMenu();

        Assertions.assertEquals(expectedMenu, actualMenu);
    }

}