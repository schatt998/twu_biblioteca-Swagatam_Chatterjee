package com.twu.biblioteca;


import java.io.IOException;
import java.util.Scanner;


public class BibliotecaApp {



    private Library library;
    Movie movie = new Movie("Phir Hera Pheri", "Priyadarshan", "2006", "10");
    Console console = new Console(System.out);

    private Menu menu;
    Scanner stringScanner = new Scanner(System.in);
    Scanner integerScanner = new Scanner(System.in);


    public BibliotecaApp() {
        this.library = new Library();
        this.menu = new Menu(console);

    }

    public void start() throws IOException {
        console.print(showWelcomeMessage());
        console.print(showMenu());
        menu.action(stringScanner, integerScanner);
    }

    public String showWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore\n";
    }

    public String getMovieList(){

        return movie.getMovieInformation();
    }


    public String showMenu() {
        return menu.getMenu();
    }


}
