package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Arrays;


public class BibliotecaApp {


    private Library library;
    private ApplicationState applicationState;
    private ArrayList<Book> booksList;
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();


    private Menu menu;

    public BibliotecaApp() {

        this.booksList = new ArrayList<>(Arrays.asList(new Book("Calculus Made Easy", "Silvanus P.", 2003), new Book("Problem Solving Strategies", "Arthur Engel", 2005)));

        library=new Library();
        applicationState = ApplicationState.RUNNING;
        menu = new Menu();


    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.showWelcomeMessage());
        System.out.println(bibliotecaApp.showMenu());

        System.out.println(bibliotecaApp.getBooksDetails());


    }


    public String showWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore";
    }


    public ArrayList<MenuOptions> showMenu() {
        return menu.getMenu();
    }

    public String getBooksDetails() {

        return this.booksList.get(0).getDetails() + this.booksList.get(1).getDetails();

    }


    public ArrayList<MenuOptions> getMenu() {
        return menu.getMenu();
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
