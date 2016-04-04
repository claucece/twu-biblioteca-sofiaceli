package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.ElementSpec;

public class MovieSpec implements ElementSpec {

    private String name;
    private String director;
    private String year;
    private String rating;

    public MovieSpec(String name, String director, String year, String rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
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
        return null;
    }

    @Override
    public String getGenre() {
        return null;
    }

    public String getRating() {
        return rating;
    }
}
