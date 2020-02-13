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
            actualMovieList.append(movie.getDetails());
        }
        return actualMovieList.toString();
    }
    public void checkOut(Movie movie) {
        moviesList.remove(movie);

    }

}

//
//1. Fix all compilation errors.
//2. Make a commit
//3. Run Test (if passed you are good)
//4. if failed (ignore all test, ungnore one by one fix test one by one each)