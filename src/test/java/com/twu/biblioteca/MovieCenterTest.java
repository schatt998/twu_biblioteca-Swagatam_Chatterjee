package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieCenterTest {

    @Test
    void shouldGetMoviesList() {
        MovieCenter movieCenter = new MovieCenter();
        String expectedMovieList = "Phir Hera Pheri|Priyadarshan|2006|10\nHera Pheri|Priyadarshan|2000|10\n";

        String actualMovieList = movieCenter.getMovieList();

        Assertions.assertEquals(expectedMovieList, actualMovieList);

    }

    @Test
    void shouldNotBeInMovieListIfAMovieIsCheckedOut() {
        MovieCenter movieCenter = new MovieCenter();
        String expectedMovieList = "Hera Pheri|Priyadarshan|2000|10\n";

        movieCenter.checkOut(new Movie("Phir Hera Pheri", "Priyadarshan", "2006", "10"));
        String actualMovieList = movieCenter.getMovieList();

        Assertions.assertEquals(expectedMovieList, actualMovieList);

    }

}