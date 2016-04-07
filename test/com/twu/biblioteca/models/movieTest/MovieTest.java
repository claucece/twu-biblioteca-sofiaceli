package com.twu.biblioteca.models.movieTest;

import com.twu.biblioteca.helpers.ElementSpec;
import com.twu.biblioteca.models.movie.Movie;
import com.twu.biblioteca.models.movie.MovieSpec;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie;
    private String id;
    private MovieSpec movieSpec;

    @Before
    public void setUp() {
        movie = new Movie(movieSpec);
    }

    @Test
    public void shouldHaveBookId() {
        String expected = movie.getId();
        String actual = id;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveBookSpec() {
        ElementSpec expected = movie.getSpec();
        MovieSpec actual = movieSpec;
        assertEquals(expected, actual);
    }

}