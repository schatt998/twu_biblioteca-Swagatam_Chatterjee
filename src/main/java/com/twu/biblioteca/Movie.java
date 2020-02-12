package com.twu.biblioteca;

public class Movie {
    private String movieName;
    private String movieDirector;
    private String movieReleaseYear;
    private String movieRating;

    public Movie(String movieName, String movieDirector, String movieReleaseYear, String movieRating) {
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.movieReleaseYear = movieReleaseYear;
        this.movieRating = movieRating;
    }

    public String getMovieInformation() {
        return movieName + "|" + movieDirector + "|" + movieReleaseYear + "|" + movieRating;
    }
}
