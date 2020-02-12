package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieCenter {

    private ArrayList<Movie> moviesList;
    public MovieCenter() {
        moviesList=new ArrayList<>(Arrays.asList(new Movie("Phir Hera Pheri", "Priyadarshan", "2006", "10"),new Movie("Hera Pheri", "Priyadarshan", "2000", "10")));
    }

    public String getMovieList() {
        StringBuilder actualMovieList = new StringBuilder();
        for (Movie movie : moviesList) {
            actualMovieList.append(movie.getMovieInformation());
        }
        return actualMovieList.toString();
    }

}
