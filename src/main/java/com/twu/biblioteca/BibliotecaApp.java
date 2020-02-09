package com.twu.biblioteca;


import java.util.ArrayList;


public class BibliotecaApp {

    ArrayList<Book> booksList = new ArrayList<>();
    ApplicationState applicationState;
    Menu menu;

    public BibliotecaApp() {

        applicationState = ApplicationState.RUNNING;
        menu= new Menu();
        Book calculusBook = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        Book mathsBook = new Book("Problem Solving Strategies", "Arthur Engel", 2005);
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


    public ArrayList<MenuOptions> getMenu() {
        return menu.getOptions();
    }

    public String getInvalidChoiceNotification() {
        return "Please Select a Valid Option!";
    }

    public void quit() {
        this.applicationState = ApplicationState.CLOSED;
    }

    public ApplicationState getState() {
        return this.applicationState;
    }
}
