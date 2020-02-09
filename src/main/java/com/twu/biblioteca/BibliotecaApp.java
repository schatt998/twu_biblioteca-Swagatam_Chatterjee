package com.twu.biblioteca;


import java.util.ArrayList;


public class BibliotecaApp {

    ArrayList<Books> booksList = new ArrayList<>();

    public BibliotecaApp() {

        Books calculusBook = new Books("Calculus Made Easy", "Silvanus P.", 2003);
        Books mathsBook = new Books("Problem Solving Strategies", "Arthur Engel", 2005);
        booksList.add(calculusBook);
        booksList.add(mathsBook);

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
        return booksList.get(0).getName() + booksList.get(1).getName();
    }

    public String getBooksDetails() {

        return booksList.get(0).getDetails() + booksList.get(1).getDetails();

    }


    public MenuOptions getMenu() {
        return MenuOptions.LIST_OF_BOOKS;
    }

    public String getInvalidChoiceNotification() {
        return "Please Select a Valid Option!";
    }
}
