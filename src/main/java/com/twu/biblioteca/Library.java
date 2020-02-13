package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {


    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private ArrayList<Item> checkedOutItems = new ArrayList<>();

    public Library() {

        this.bookList = new ArrayList<>(Arrays.asList(new Book("Calculus Made Easy", "Silvanus P.", 2003), new Book("Problem Solving Strategies", "Arthur Engel", 2005)));
        this.movieList = new ArrayList<>(Arrays.asList(new Movie("Hera Pheri", "Priyadarshan", "2000","10"), new Movie("Phir Hera Pheri", "Priyadarshan", "2006","10")));




    }

    public String getBookList() {
        StringBuilder actualBookList = new StringBuilder();
        for (Book book : bookList) {
            actualBookList.append (book.getName());
        }
        return actualBookList.toString();
    }
    public String getMovieList() {
        StringBuilder actualBookList = new StringBuilder();
        for (Movie movie : movieList) {
            actualBookList.append (movie.getDetails());
        }
        return actualBookList.toString();
    }


    public String getBookDetails() {
        StringBuilder actualBookDetails = new StringBuilder();
        for (Book item : bookList) {
            actualBookDetails.append(item.getDetails());
        }
        return actualBookDetails.toString();
    }


    public String checkoutBook(Book item) {
        if (bookList.contains(item)) {
            checkedOutItems.add( item);
            bookList.remove(item);
            return "Thank you! Enjoy the book\n";
        } else
            return "Sorry,that book is not available\n";
    }
    public String checkoutMovie(Movie item) {
        if (movieList.contains(item)) {
            checkedOutItems.add( item);
            movieList.remove(item);
            return "Thank you! Enjoy the Movie\n";
        } else
            return "Sorry,that Movie is not available\n";
    }

    public String returnBook(Book item) {
        if (checkedOutItems.contains(item)) {
            bookList.add(item);
            checkedOutItems.remove(item);
            return "Thank you for returning the book\n";
        }
        return "That is not a valid book to return\n";

    }
}
