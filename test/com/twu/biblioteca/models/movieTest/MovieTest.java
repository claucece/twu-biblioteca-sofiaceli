package com.twu.biblioteca.models.movieTest;

import com.twu.biblioteca.models.movie.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    private Movie movie;
    private String title;
    private String author;
    private String publishedYear;
    private String type;
    private String genre;
    private String rating;

    @Before
    public void setUp() {
        title = "American History X";
        type = "independant";
        genre = "drama";
        movie = new Movie(title, author, publishedYear, rating, type, genre);
    }

    @Test
    public void shouldGetRating() {
        String expected = movie.getRating();
        String actual = rating;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTitle() {
        String expected = movie.getTitle();
        String actual = title.toLowerCase();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAuthor() {
        String expected = movie.getAuthor();
        String actual = author;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPublishedYear() {
        String expected = movie.getPublishedYear();
        String actual = publishedYear;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetType() {
        String expected = movie.getType();
        String actual = type;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetGenre() {
        String expected = movie.getGenre();
        String actual = genre;
        assertEquals(expected, actual);
    }

}