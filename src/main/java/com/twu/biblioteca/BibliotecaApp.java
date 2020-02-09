package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Arrays;


public class BibliotecaApp {

    private ArrayList<Book> booksList;
    private ApplicationState applicationState;
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();

    private Menu menu;

    public BibliotecaApp() {

        applicationState = ApplicationState.RUNNING;
        menu = new Menu();
        this.booksList = new ArrayList<>(Arrays.asList(new Book("Calculus Made Easy", "Silvanus P.", 2003), new Book("Problem Solving Strategies", "Arthur Engel", 2005)));


    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.getWelcomeMessage());
        System.out.println(bibliotecaApp.getBookList());
        System.out.println(bibliotecaApp.getBooksDetails());

    }


    public String getWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore";
    }


    public String getBookList() {
        StringBuilder actualBookList = new StringBuilder();
        for (Book book : booksList) {
            actualBookList.append(book.getName());
        }
        return actualBookList.toString();
    }

    public String getBooksDetails() {

        return this.booksList.get(0).getDetails() + this.booksList.get(1).getDetails();

    }


    public ArrayList<MenuOptions> getMenu() {
        return menu.getOptions();
    }

    public String getInvalidChoiceNotification() {
        return "Please Select a Valid Option!";
    }

    public void quit() {
        this.applicationState = ApplicationState.CLOSED;
    }

    public String returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            booksList.add(book);
            checkedOutBooks.remove(book);
        }
        return null;
    }

    public String checkout(Book book) {
        if (booksList.contains(book)) {
            checkedOutBooks.add(book);
            booksList.remove(book);
            return "Thank you! Enjoy the book";
        } else
            return "Sorry,that book is not available";

    }

    public ApplicationState getState() {
        return this.applicationState;
    }
}
