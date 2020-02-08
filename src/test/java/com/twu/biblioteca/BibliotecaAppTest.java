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
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMessage = "1.Calculus Made Easy.\n2.Problem Solving Strategies\n";
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


}