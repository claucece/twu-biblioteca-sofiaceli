package com.twu.biblioteca.models.MovieModel;

import com.twu.biblioteca.helpers.ElementSpec;

public class MovieSpec implements ElementSpec {

    private String name;
    private String director;
    private String year;
    private String rating;
    private String type;
    private String genre;

    public MovieSpec(String name, String director, String year, String rating, String type, String genre) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.type = type;
        this.genre = genre;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getAuthor() {
        return director;
    }

    @Override
    public String getPublishedYear() {
        return year;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }
}
