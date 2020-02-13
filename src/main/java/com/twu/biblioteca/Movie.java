package com.twu.biblioteca;

import java.util.Objects;

public class Movie implements Item {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieName.equals(movie.movieName) &&
                movieDirector.equals(movie.movieDirector) &&
                movieReleaseYear.equals(movie.movieReleaseYear) &&
                movieRating.equals(movie.movieRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, movieDirector, movieReleaseYear, movieRating);
    }

    @Override
    public String getName() {
        return movieName+"\n";
    }

    @Override
    public String getDetails() {
        return movieName+"|"+movieDirector+"|"+movieReleaseYear+"|"+movieRating+"\n";
    }
}
