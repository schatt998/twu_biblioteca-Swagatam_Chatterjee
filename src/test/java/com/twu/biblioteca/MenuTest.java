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
    @Test
    void shouldGetInvalidChoiceNotification() {
        Menu menu = new Menu();
        String expectedInvalidChoiceNotification = "Please Select a Valid Option!";

        String actualInvalidChoiceNotification = menu.getInvalidChoiceNotification();

        Assertions.assertEquals(expectedInvalidChoiceNotification, actualInvalidChoiceNotification);
    }
    @Test
    void shouldQuitTheApplication() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
    }


    @Test
    void shouldNotBeInBookListIfABookIsCheckedOut() {
        Menu menu = new Menu();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        menu.checkout(calculusBook);
        String expectedBookList = mathsBook.getName();

        String actualBookList = menu.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);

    }

    @Test
    void shouldReceiveSuccessfulNotificationIfBookIsSuccessfullyCheckedOut() {
        Menu menu = new Menu();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Thank you! Enjoy the book";
        String expectedBookList = mathsBook.getName();

        String actualNotificationMessage = menu.checkout(calculusBook);
        String actualBookList = menu.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReceiveUnSuccessfulNotificationIfBookIsSuccessfullyCheckedOut() {
        Menu menu = new Menu();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Sorry,that book is not available";
        String expectedBookList = calculusBook.getName() + mathsBook.getName();

        String actualNotificationMessage = menu.checkout(new Book("book", "author", 1233));
        String actualBookList = menu.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldBeInBookListIfABookIsReturned() {
        Menu menu = new Menu();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedBookList = mathsBook.getName() + calculusBook.getName();

        menu.checkout(calculusBook);
        menu.returnBook(calculusBook);


        String actualBookList = menu.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);

    }

    @Test
    void shouldReceiveSuccessfulNotificationIfBookIsSuccessfullyReturned() {
        Menu menu = new Menu();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Thank you for returning the book";


        menu.checkout(calculusBook);
        String actualNotificationMessage = menu.returnBook(calculusBook);


        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReceiveUnSuccessfulNotificationIfBookIsSuccessfullyReturned() {
        Menu menu = new Menu();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "That is not a valid book to return";


        menu.checkout(calculusBook);
        String actualNotificationMessage = menu.returnBook(new Book("book", "author", 1233));


        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }




}