package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {

    private Book book;
    private ArrayList<Book> bookList;

    public Library() {

        this.bookList = new ArrayList<>(Arrays.asList(new Book("Calculus Made Easy", "Silvanus P.", 2003), new Book("Problem Solving Strategies", "Arthur Engel", 2005)));
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}
