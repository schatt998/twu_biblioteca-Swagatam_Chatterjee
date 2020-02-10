package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;



class LibraryTest {
    @Test
    void shouldReturnAvailableBooks()
    {
        Library library=new Library();
        ArrayList expectedBookList= new ArrayList<>(Arrays.asList(new Book("Calculus Made Easy", "Silvanus P.", 2003), new Book("Problem Solving Strategies", "Arthur Engel", 2005)));
        ArrayList<Book> actualBookList = library.getBookList();
        Assertions.assertEquals(expectedBookList,actualBookList);
    }

}