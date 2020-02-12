package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.mockito.Mockito.*;


class MenuTest {
    @Test
    void shouldShowAppropriateMessageWhenInvalidInputIsEntered() throws IOException {
        Console mockConsole = mock(Console.class);
        Menu menu = new Menu(mockConsole);
        when(mockConsole.readLine()).thenReturn("5", "4");

        menu.action(null, null);

        verify(mockConsole).print("Please Select a Valid Option!");
    }



    @Test
    void shouldContainAllOptions() {
        Menu menu = new Menu(new Console(System.out));

        String expectedMenu = "1.LIST_OF_BOOKS\n2.CHECKOUT\n3.RETURN\n4.QUIT\n";

        String actualMenu = menu.getMenu();


        Assertions.assertEquals(expectedMenu, actualMenu);
    }

    @Test
    void shouldGetInvalidChoiceNotification() {
        Menu menu = new Menu(new Console(System.out));
        String expectedInvalidChoiceNotification = "Please Select a Valid Option!";

        String actualInvalidChoiceNotification = menu.getInvalidChoiceNotification();

        Assertions.assertEquals(expectedInvalidChoiceNotification, actualInvalidChoiceNotification);
    }

    @Test
    void shouldQuitTheApplication() {
        Menu menu = new Menu(new Console(System.out));
        boolean actualFlag = menu.exitApplication();
        Assertions.assertEquals(false, actualFlag);
    }

    @Test
    void shouldNotBeInBookListIfABookIsCheckedOut() {
        Menu menu = new Menu(new Console(System.out));
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        menu.checkout(calculusBook);
        String expectedBookList = mathsBook.getName();

        String actualBookList = menu.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);

    }

    @Test
    void shouldReceiveSuccessfulNotificationIfBookIsSuccessfullyCheckedOut() {
        Menu menu = new Menu(new Console(System.out));
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Thank you! Enjoy the book\n";
        String expectedBookList = mathsBook.getName();

        String actualNotificationMessage = menu.checkout(calculusBook);
        String actualBookList = menu.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReceiveUnSuccessfulNotificationIfBookIsSuccessfullyCheckedOut() {
        Menu menu = new Menu(new Console(System.out));
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Sorry,that book is not available\n";
        String expectedBookList = calculusBook.getName() + mathsBook.getName();

        String actualNotificationMessage = menu.checkout(new Book("book", "author", 1233));
        String actualBookList = menu.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldBeInBookListIfABookIsReturned() {
        Menu menu = new Menu(new Console(System.out));
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
        Menu menu = new Menu(new Console(System.out));
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Thank you for returning the book\n";


        menu.checkout(calculusBook);
        String actualNotificationMessage = menu.returnBook(calculusBook);


        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReceiveUnSuccessfulNotificationIfBookIsSuccessfullyReturned() {
        Menu menu = new Menu(new Console(System.out));
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "That is not a valid book to return\n";


        menu.checkout(calculusBook);
        String actualNotificationMessage = menu.returnBook(new Book("book", "author", 1233));


        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }
}
