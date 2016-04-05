package com.twu.biblioteca.models.movieModelTest;

import com.twu.biblioteca.helpers.ElementSpec;
import com.twu.biblioteca.models.bookModel.Book;
import com.twu.biblioteca.models.bookModel.BookSpec;
import com.twu.biblioteca.models.movieModel.Movie;
import com.twu.biblioteca.models.movieModel.MovieSpec;
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