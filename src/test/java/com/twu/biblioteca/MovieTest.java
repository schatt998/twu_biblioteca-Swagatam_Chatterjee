package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieTest {

    @Test
    void shouldGetMovieInformation() {
        Movie movie = new Movie("Phir Hera Pheri", "Priyadarshan", "2006", "10");
        String expectedMovieInformation = "Phir Hera Pheri|Priyadarshan|2006|10";

        String actualMovieIformation = movie.getMovieInformation();

        Assertions.assertEquals(expectedMovieInformation, actualMovieIformation);
    }
}