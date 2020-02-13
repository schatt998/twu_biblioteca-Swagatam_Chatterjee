package com.twu.biblioteca;


import java.io.IOException;
import java.util.Scanner;


public class BibliotecaApp {


    private Library library;
    private MovieCenter movieCenter;
    private User user;


    Console console = new Console(System.out);

    private Menu menu;
    Scanner stringScanner = new Scanner(System.in);
    Scanner integerScanner = new Scanner(System.in);


    public BibliotecaApp(User user) {
        this.user=user;
        this.menu = new Menu(console);
      this.movieCenter = new MovieCenter();

    }

    public void start() throws IOException {
        console.print(showWelcomeMessage());
        console.print(showMenu());
        menu.action(stringScanner, integerScanner,user);
    }

    public String showWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore\n";
    }

    public String getMovieList() {
        return movieCenter.getMovieList();
    }


    public String showMenu() {
        return menu.getMenu();
    }


    public void checkOut(Movie movie) {
        movieCenter.checkOut(movie);

    }
    public  boolean isValid(String userCredentials) {

        if (userCredentials.equals("xxx-xxxx|234"))
            return true;
        else
            return false;
    }

}
