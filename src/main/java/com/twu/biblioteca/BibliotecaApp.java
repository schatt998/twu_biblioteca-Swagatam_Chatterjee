package com.twu.biblioteca;

public class BibliotecaApp {


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.showWelcomeMessage());
        System.out.println(bibliotecaApp.displayBookList());
    }

    public String showWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore";
    }
    public String displayBookList(){
        return "1.Calculus Made Easy.2.Problem Solving Strategies";
    }
}
