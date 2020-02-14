package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Library {


    private ArrayList<Book> bookList;
    private ArrayList<Movie> movieList;
    private ArrayList<Item> checkedOutMovies = new ArrayList<>();
    private HashMap<Book,User> checkoutBookLog=new HashMap<>();
    private ArrayList<User> validUserList=new ArrayList<>();

    public Library() {

        this.validUserList.add(new User("222-3333","233"));
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

    public boolean logIn(User user){
        if(validUserList.contains(user)){
            user.logIn();
            return true;
        }
        else
            return false;
    }
    public String checkoutBook(Book item,User user) {
        if (bookList.contains(item)) {
            checkoutBookLog.put(item,user);
            bookList.remove(item);
            return "Thank you! Enjoy the book\n";
        } else
            return "Sorry,that book is not available\n";
    }
    public String checkoutMovie(Movie item) {
        if (movieList.contains(item)) {
            checkedOutMovies.add( item);
            movieList.remove(item);
            return "Thank you! Enjoy the Movie\n";
        } else
            return "Sorry,that Movie is not available\n";
    }

    public String returnBook(Book item,User user) {
        if (checkoutBookLog.containsKey(item)&&checkoutBookLog.containsValue(user)) {
            bookList.add(item);
            checkoutBookLog.remove(item);
            return "Thank you for returning the book\n";
        }
        return "That is not a valid book to return\n";

    }
    public String returnMovie(Movie item) {
        if (checkedOutMovies.contains(item)) {
            checkedOutMovies.remove(item);
            movieList.add(item);
            return "Thank you for returning the book\n";
        }
        return "That is not a valid book to return\n";

    }

}
