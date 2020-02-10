package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {

    private Book book;
    private ArrayList<Book> bookList;
    private ArrayList<Book> checkedOutBooks=new ArrayList<>();

    public Library() {

        this.bookList = new ArrayList<>(Arrays.asList(new Book("Calculus Made Easy", "Silvanus P.", 2003), new Book("Problem Solving Strategies", "Arthur Engel", 2005)));
    }

    public String getBookList() {
        StringBuilder actualBookList = new StringBuilder();
        for (Book book : bookList) {
            actualBookList.append(book.getName());
        }
        return actualBookList.toString();
    }

    public String getBookDetails() {
        StringBuilder actualBookDetails = new StringBuilder();
        for (Book book : bookList) {
            actualBookDetails.append(book.getDetails());
        }
        return actualBookDetails.toString();
    }


    public String checkout(Book book) {
        if (bookList.contains(book)) {
            checkedOutBooks.add(book);
            bookList.remove(book);
            return "Thank you! Enjoy the book";
        } else
            return "Sorry,that book is not available";
    }

    public String returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            bookList.add(book);
            checkedOutBooks.remove(book);
            return null;
        }
        return null;

    }
}
