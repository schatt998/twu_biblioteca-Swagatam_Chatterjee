package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class LibraryTest {
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
        library.checkout(calculusBook);
        String actualBookList = library.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
    }

    @Test
    void shouldReceiveSuccessfulNotificationIfBookIsSuccessfullyCheckedOut() {
        Library library = new Library();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Thank you! Enjoy the book";
        String expectedBookList = mathsBook.getName();

        String actualNotificationMessage = library.checkout(calculusBook);
        String actualBookList = library.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }

    @Test
    void shouldReceiveUnSuccessfulNotificationIfBookIsUnSuccessfullyCheckedOut() {
        Library library = new Library();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
        String expectedNotificationMessage = "Sorry,that book is not available";
        String expectedBookList = calculusBook.getName() + mathsBook.getName();

        String actualNotificationMessage = library.checkout(new Book("book", "author", 1233));
        String actualBookList = library.getBookList();

        Assertions.assertEquals(expectedBookList, actualBookList);
        Assertions.assertEquals(expectedNotificationMessage, actualNotificationMessage);

    }
}