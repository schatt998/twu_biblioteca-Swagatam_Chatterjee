package com.twu.biblioteca;


import java.util.Scanner;


public class BibliotecaApp {


    private Library library;
    private ApplicationState applicationState;
    private Menu menu;

    public BibliotecaApp() {

        this.library = new Library();
        this.applicationState = ApplicationState.RUNNING;
        this.menu = new Menu();
    }

    public static void main(String[] args) {

        }



    public String showWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore";
    }


    public String showMenu() {
        return menu.getMenu();
    }

    public String getBooksDetails() {

        return library.getBookDetails();

    }


    public String getInvalidChoiceNotification() {
        return "Please Select a Valid Option!";
    }

    public void quit() {
        this.applicationState = ApplicationState.CLOSED;

    }

    public String returnBook(Book book) {
        return library.returnBook(book);
    }

    public String checkout(Book book) {
        return library.checkout(book);


    }

    public String getBookList() {
        return library.getBookList();
    }

    public ApplicationState getState() {
        return this.applicationState;
    }
}
