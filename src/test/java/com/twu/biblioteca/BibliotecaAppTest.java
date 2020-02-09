package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        Books calculusBook = mock(Books.class);
        Books mathematicsBook = mock(Books.class);
        when(calculusBook.getName()).thenReturn("Calculus Made Easy\n");
        when(mathematicsBook.getName()).thenReturn("Problem Solving Strategies\n");
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMessage = calculusBook.getName() + mathematicsBook.getName();
        String actualMessage = bibliotecaApp.getBookList();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void shouldDisplayAuthorsAndPublicationYearsOfBooks() {
        Books calculusBook = mock(Books.class);
        Books mathematicsBook = mock(Books.class);
        when(calculusBook.getDetails()).thenReturn("Calculus Made Easy|Silvanus P.|2003\n");
        when(mathematicsBook.getDetails()).thenReturn("Problem Solving Strategies|Arthur Engel|2005\n");
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedBookList = calculusBook.getDetails() + mathematicsBook.getDetails();
        String actualBookList = bibliotecaApp.getBooksDetails();

        Assertions.assertEquals(expectedBookList, actualBookList);

    }

    @Test
    void shouldGetListOfBooksAsOptionInTheMenu() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        MenuOptions expectedMenu = MenuOptions.LIST_OF_BOOKS;
        MenuOptions actualMenu = bibliotecaApp.getMenu();
        Assertions.assertEquals(expectedMenu, actualMenu);
    }

    @Test
    void shouldGetInvalidChoiceNotification() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedInvalidChoiceNotification = "Please Select a Valid Option!";
        String actualInvalidChoiceNotification = bibliotecaApp.getInvalidChoiceNotification();
        Assertions.assertEquals(expectedInvalidChoiceNotification, actualInvalidChoiceNotification);
    }
}