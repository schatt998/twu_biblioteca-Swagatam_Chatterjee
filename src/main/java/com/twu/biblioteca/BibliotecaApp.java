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

    }


    public String getWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore";
    }


    public String getBookList() {
        return "1.Calculus Made Easy.\n2.Problem Solving Strategies\n";
    }

    public String getBooksDetails() {

        return booksList.get(0).getDetails() + booksList.get(1).getDetails();

    }


}
