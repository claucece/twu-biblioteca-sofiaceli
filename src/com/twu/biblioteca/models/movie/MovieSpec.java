package com.twu.biblioteca.models.movie;

import com.twu.biblioteca.helpers.ElementSpec;

public class MovieSpec implements ElementSpec {

    private String title;
    private String director;
    private String year;
    private String rating;
    private String type;
    private String genre;

    public MovieSpec(String title, String director, String year, String rating, String type, String genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.type = type;
        this.genre = genre;
    }

    @Override
    public String getRating() {
        return rating;
    }

    @Override
    public String getTitle() {
        return title.toLowerCase();
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

}
