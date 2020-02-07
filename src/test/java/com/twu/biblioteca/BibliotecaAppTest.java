package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BibliotecaAppTest {

    @Test
    public void shouldShowWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMessage = "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore";
        String actualMessage = bibliotecaApp.getWelcomeMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void shouldDisplayAListOfBooks() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMessage = "1.Calculus Made Easy.\n2.Problem Solving Strategies\n";
        String actualMessage = bibliotecaApp.getBookList();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }


}