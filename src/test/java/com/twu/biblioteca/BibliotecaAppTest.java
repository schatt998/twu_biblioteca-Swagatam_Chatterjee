package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

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
        Book calculusBook = mock(Book.class);
        Book mathematicsBook = mock(Book.class);
        when(calculusBook.getName()).thenReturn("Calculus Made Easy\n");
        when(mathematicsBook.getName()).thenReturn("Problem Solving Strategies\n");
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMessage = calculusBook.getName() + mathematicsBook.getName();

        String actualMessage = bibliotecaApp.getBookList();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void shouldDisplayAuthorsAndPublicationYearsOfBooks() {
        Book calculusBook = mock(Book.class);
        Book mathematicsBook = mock(Book.class);
        when(calculusBook.getDetails()).thenReturn("Calculus Made Easy|Silvanus P.|2003\n");
        when(mathematicsBook.getDetails()).thenReturn("Problem Solving Strategies|Arthur Engel|2005\n");
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        String expectedBookList = calculusBook.getDetails() + mathematicsBook.getDetails();
        String actualBookList = bibliotecaApp.getBooksDetails();

        Assertions.assertEquals(expectedBookList, actualBookList);

    }

    @Test
    void shouldGetOptionInTheMenu() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        ArrayList<MenuOptions> expectedMenu = new ArrayList<>();
        expectedMenu.add(MenuOptions.LIST_OF_BOOKS);
        expectedMenu.add(MenuOptions.CHECKOUT);


        ArrayList<MenuOptions> actualMenu = bibliotecaApp.getMenu();

        Assertions.assertEquals(expectedMenu, actualMenu);
    }

    @Test
    void shouldGetInvalidChoiceNotification() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedInvalidChoiceNotification = "Please Select a Valid Option!";

        String actualInvalidChoiceNotification = bibliotecaApp.getInvalidChoiceNotification();

        Assertions.assertEquals(expectedInvalidChoiceNotification, actualInvalidChoiceNotification);
    }

    @Test
    void shouldQuitTheApplication() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();


        bibliotecaApp.quit();
        ApplicationState actualApplicationState = bibliotecaApp.getState();

        Assertions.assertEquals(ApplicationState.CLOSED, actualApplicationState);

    }

    @Test
    void shouldBeInRunningStateUntilQuitOptionIsChosen() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        ApplicationState applicationState = bibliotecaApp.getState();

        Assertions.assertEquals(ApplicationState.RUNNING, applicationState);
    }

    @Test
    void shouldNotBeInBookListIfABookIsCheckedOut() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        bibliotecaApp.checkout(calculusBook);
        String expectedBookList = mathsBook.getName();

        String actualBookList = bibliotecaApp.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);

    }

    @Test
    void shouldReceiveSuccessfulNotificationIfBookIsSuccessfullyCheckedOut() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Thank you! Enjoy the book";
        String expectedBookList = mathsBook.getName();

        String actualNotificationMessage = bibliotecaApp.checkout(calculusBook);
        String actualBookList = bibliotecaApp.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReceiveUnSuccessfulNotificationIfBookIsSuccessfullyCheckedOut() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Sorry,that book is not available";
        String expectedBookList = calculusBook.getName() + mathsBook.getName();

        String actualNotificationMessage = bibliotecaApp.checkout(new Book("book", "author", 1233));
        String actualBookList = bibliotecaApp.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

}