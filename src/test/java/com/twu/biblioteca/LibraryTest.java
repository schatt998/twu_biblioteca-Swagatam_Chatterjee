package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class LibraryTest {
    User user;
    @BeforeEach
    void setUser(){
        user = new User("222-3333", "233");
    }
    @Test
    void shouldReturnAvailableBooks() {
        Library library = new Library();
        Book mathsBook = mock(Book.class);
        Book calculusBook = mock(Book.class);
        when(mathsBook.getName()).thenReturn("Calculus Made Easy");
        when(calculusBook.getName()).thenReturn("Problem Solving Strategies");
        String expectedBookList = mathsBook.getName() + "\n" + calculusBook.getName() + "\n";
        String actualBookList = library.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
    }

    @Test
    void shouldGiveBookDetailsOfTheBookList() {
        Library library = new Library();
        Book mathsBook = mock(Book.class);
        Book calculusBook = mock(Book.class);
        when(calculusBook.getDetails()).thenReturn("Calculus Made Easy|Silvanus P.|2003");
        when(mathsBook.getDetails()).thenReturn("Problem Solving Strategies|Arthur Engel|2005");
        String expectedBookList = calculusBook.getDetails() + "\n" + mathsBook.getDetails() + "\n";
        String actualBookList = library.getBookDetails();

        Assertions.assertEquals(expectedBookList, actualBookList);
    }

    @Test
    void shouldNotBeInTheBookListIfABookIsCheckedOutFromLibrary() {
        Library library = new Library();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        String expectedBookList = new Book("Problem Solving Strategies", "Arthur Engel", 2005).getName();
        library.checkoutBook(calculusBook,user);
        String actualBookList = library.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
    }

    @Test
    void shouldReceiveSuccessfulNotificationIfBookIsSuccessfullyCheckedOut() {
        Library library = new Library();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Thank you! Enjoy the book\n";
        String expectedBookList = mathsBook.getName();

        String actualNotificationMessage = library.checkoutBook(calculusBook,user);
        String actualBookList = library.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReceiveUnSuccessfulNotificationIfBookIsUnSuccessfullyCheckedOut() {
        Library library = new Library();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Sorry,that book is not available\n";
        String expectedBookList = calculusBook.getName() + mathsBook.getName();

        String actualNotificationMessage = library.checkoutBook(new Book("book", "author", 1233),user);
        String actualBookList = library.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldBeInBookListIfABookIsReturned() {
        Library library = new Library();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedBookList = mathsBook.getName() + calculusBook.getName();

        library.checkoutBook(calculusBook,user);
        library.returnBook(calculusBook,user);


        String actualBookList = library.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);

    }

    @Test
    void shouldReceiveSuccessfulNotificationIfBookIsSuccessfullyReturned() {
        Library library = new Library();

        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Thank you for returning the book\n";


        library.checkoutBook(calculusBook,user);
        String actualNotificationMessage = library.returnBook(calculusBook,user);


        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReceiveUnSuccessfulNotificationIfBookIsSuccessfullyReturned() {
        Library library = new Library();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "That is not a valid book to return\n";


        library.checkoutBook(calculusBook,user);
        String actualNotificationMessage = library.returnBook(new Book("book", "author", 1233),user);


        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReturnTrueIfAUserIsAValidUser() {

        Library library=new Library();

        Assertions.assertTrue(library.logIn(user));
    }
    @Test
    void shouldBeInMovieListIfAMovieIsReturned() {
        Library library = new Library();
        Movie movieNumberOne=new Movie("Hera Pheri", "Priyadarshan", "2000","10");
        Movie movieNumberTwo=new Movie("Phir Hera Pheri", "Priyadarshan", "2006","10");
       String expectedMovieList=library.getMovieList();
        library.checkoutMovie(movieNumberTwo);
        library.returnMovie(movieNumberTwo);


        String actualMovieList = library.getMovieList();

        Assertions.assertEquals(expectedMovieList,actualMovieList);

    }

    @Test
    void shouldBeInTheUserBorrowedListOfUserIfABookIsCheckedOutByTheUser() {
        Library library = new Library();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        String expectedBookList = new Book("Problem Solving Strategies", "Arthur Engel", 2005).getName();

        library.checkoutBook(calculusBook,user);
        String actualBookList = library.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
    }
}