package com.twu.biblioteca;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BibliotecaApp {


    private Library library;
    Movie movieNoOne = new Movie("Phir Hera Pheri", "Priyadarshan", "2006", "10");
    Movie movieNoTwo = new Movie("Hera Pheri", "Priyadarshan", "2000", "10");
    private ArrayList<Movie> moviesList = new ArrayList<>();

    Console console = new Console(System.out);

    private Menu menu;
    Scanner stringScanner = new Scanner(System.in);
    Scanner integerScanner = new Scanner(System.in);


    public BibliotecaApp() {
        this.library = new Library();
        this.menu = new Menu(console);
        moviesList.add(movieNoOne);
        moviesList.add(movieNoTwo);

    }

    public void start() throws IOException {
        console.print(showWelcomeMessage());
        console.print(showMenu());
        menu.action(stringScanner, integerScanner);
    }

    public String showWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore\n";
    }

    public String getMovieList() {
        StringBuilder actualMovieList = new StringBuilder();
        for (Movie movie : moviesList) {
            actualMovieList.append(movie.getMovieInformation());
        }
        return actualMovieList.toString();
    }


    public String showMenu() {
        return menu.getMenu();
    }


    public void checkOut(Movie movie) {
        moviesList.remove(movie);

    }
}
