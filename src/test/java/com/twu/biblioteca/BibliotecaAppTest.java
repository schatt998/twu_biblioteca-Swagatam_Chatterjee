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


}