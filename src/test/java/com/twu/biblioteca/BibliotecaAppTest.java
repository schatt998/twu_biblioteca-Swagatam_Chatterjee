package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BibliotecaAppTest {


    @Test
    public void shouldShowWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMessage = "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore\n";

        String actualMessage = bibliotecaApp.showWelcomeMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void shouldGetOptionInTheMenu() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMenu = "1.LIST_OF_BOOKS\n2.CHECKOUT\n3.RETURN\n4.QUIT\n5.LIST_OF_MOVIES\n6.CHECK_OUT_MOVIES\n";

        String actualMenu = bibliotecaApp.showMenu();

        Assertions.assertEquals(expectedMenu, actualMenu);
    }

    @Test
    void shouldGetListOfMovies() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMenu = "Phir Hera Pheri|Priyadarshan|2006|10\nHera Pheri|Priyadarshan|2000|10\n";

        String actualMenu = bibliotecaApp.getMovieList();

        Assertions.assertEquals(expectedMenu, actualMenu);
    }

    @Test
    void shouldNotBeInMovieListIfAMovieIsCheckedOut() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedMovieList = "Hera Pheri|Priyadarshan|2000|10\n";

        bibliotecaApp.checkOut(new Movie("Phir Hera Pheri", "Priyadarshan", "2006", "10"));
        String actualMovieList = bibliotecaApp.getMovieList();

        Assertions.assertEquals(expectedMovieList, actualMovieList);

    }


}