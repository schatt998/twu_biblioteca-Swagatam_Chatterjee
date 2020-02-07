package com.twu.biblioteca;

public class BibliotecaApp {


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
}
