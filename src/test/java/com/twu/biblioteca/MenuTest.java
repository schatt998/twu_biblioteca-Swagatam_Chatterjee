package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;


class MenuTest {

    User user;

    @BeforeEach
    void setUser(){
        user = new User("222-3333","233");
    }
    @Test
    void shouldShowAppropriateMessageWhenInvalidInputIsEntered() throws IOException {
        Console mockConsole = mock(Console.class);
        Menu menu = new Menu(mockConsole);
        when(mockConsole.readLine()).thenReturn("8").thenReturn("4");

        menu.action(null, null,mock(User.class));

        verify(mockConsole).print("Please Select a Valid Option!");
    }

    @Test
    void shouldShowListOfBooksWhenFirstOptionIsEntered() throws IOException {
        Console mockConsole = mock(Console.class);
        Library library = new Library();
        Menu menu = new Menu(mockConsole);
        when(mockConsole.readLine()).thenReturn("1").thenReturn("4");

        menu.action(null, null,mock(User.class));

        verify(mockConsole).print(library.getBookList());
    }


    @Test
    void shouldContainAllOptions() {
        Menu menu = new Menu(new Console(System.out));

        String expectedMenu = "1.LIST_OF_BOOKS\n2.CHECKOUT\n3.RETURN\n4.QUIT\n5.LIST_OF_MOVIES\n6.CHECK_OUT_MOVIES\n7.RETURN_MOVIES\n8.SEE_YOUR_PROFILE\n";

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
        menu.checkoutBook(calculusBook,user);
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

        String actualNotificationMessage = menu.checkoutBook(calculusBook,user);
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

        String actualNotificationMessage = menu.checkoutBook(new Book("book", "author", 1233),user);
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

        menu.checkoutBook(calculusBook,user);
        menu.returnItem(calculusBook,user);


        String actualBookList = menu.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);

    }

    @Test
    void shouldReceiveSuccessfulNotificationIfBookIsSuccessfullyReturned() {
        Menu menu = new Menu(new Console(System.out));
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Thank you for returning the book\n";


        menu.checkoutBook(calculusBook,user);
        String actualNotificationMessage = menu.returnItem(calculusBook,user);


        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReceiveUnSuccessfulNotificationIfBookIsSuccessfullyReturned() {
        Menu menu = new Menu(new Console(System.out));
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "That is not a valid book to return\n";


        menu.checkoutBook(calculusBook,user);
        String actualNotificationMessage = menu.returnItem(new Book("book", "author", 1233),user);


        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldShowLogInPageWhenCheckOutBookOptionIsEntered() throws IOException {
        Console mockConsole = mock(Console.class);
        Menu menu = new Menu(mockConsole);
        when(mockConsole.readLine()).thenReturn("2").thenReturn("4");

        menu.action(null, null,mock(User.class));

        verify(mockConsole, times(1)).print("Enter Your Log-In ID and Password \n");


    }
    @Test
    void shouldBeNotBeAbleToReturnABookIfItIsNotCheckedOutByThatUser(){

    }

//    @Test
//    void shouldAllowToEnterLibraryIdAndPassword() throws IOException {
//        Console mockConsole = mock(Console.class);
//        Menu menu = new Menu(mockConsole);
//        when(mockConsole.readLine()).thenReturn("2").thenReturn("4");
//
//        menu.action(null, null,mock(User.class));
//
//        verify(mockConsole, times(1)).print("Enter Your Log-In ID and Password \n");
//        verify(mockConsole, times(3)).readLine();
//    }
//
//    @Test
//    void shouldNotAllowToCheckOutABookIfLibraryIdAndPasswordIsNotValid() throws IOException {
//        Console mockConsole = mock(Console.class);
//        Menu menu = new Menu(mockConsole);
//        when(mockConsole.readLine()).thenReturn("2").thenReturn("xxx-xxxx|214", "4");
//
//        menu.action(null, null,mock(User.class));
//
//        verify(mockConsole, times(1)).print("Enter Your Log-In ID and Password \n");
//        verify(mockConsole, times(3)).readLine();
//    }


}
