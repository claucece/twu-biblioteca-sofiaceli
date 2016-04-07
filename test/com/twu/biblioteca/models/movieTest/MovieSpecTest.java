package com.twu.biblioteca.models.movieTest;

import com.twu.biblioteca.models.movie.MovieSpec;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieSpecTest {

    private MovieSpec movieSpec;
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
        movieSpec = new MovieSpec(title, author, publishedYear, rating, type, genre);
    }

    @Test
    public void shouldGetRating() {
        String expected = movieSpec.getRating();
        String actual = rating;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTitle() {
        String expected = movieSpec.getTitle();
        String actual = title.toLowerCase();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAuthor() {
        String expected = movieSpec.getAuthor();
        String actual = author;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPublishedYear() {
        String expected = movieSpec.getPublishedYear();
        String actual = publishedYear;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetType() {
        String expected = movieSpec.getType();
        String actual = type;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetGenre() {
        String expected = movieSpec.getGenre();
        String actual = genre;
        assertEquals(expected, actual);
    }

}