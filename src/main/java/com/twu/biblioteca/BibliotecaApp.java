package com.twu.biblioteca;


import java.util.Scanner;


public class BibliotecaApp {


    private Library library;

    private Menu menu;
    Scanner stringScanner = new Scanner(System.in);
    Scanner integerScanner = new Scanner(System.in);


    public BibliotecaApp() {
        this.library = new Library();
        this.menu = new Menu();
    }

    public void start() {
        System.out.println(showWelcomeMessage());
        System.out.println(showMenu());
        menu.action(stringScanner, integerScanner);
    }

    public String showWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore";
    }


    public String showMenu() {
        return menu.getMenu();
    }


}
