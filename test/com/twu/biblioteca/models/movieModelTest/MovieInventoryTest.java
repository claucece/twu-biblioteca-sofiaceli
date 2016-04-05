package com.twu.biblioteca.models.movieModelTest;

import com.twu.biblioteca.models.movieModel.Movie;
import com.twu.biblioteca.models.movieModel.MovieInventory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieInventoryTest {

    private MovieInventory movieInventory;

    @Before
    public void setUp() {
        movieInventory = new MovieInventory();
    }

    @Test
    public void shouldReturnProperBookList() {
        assertTrue(movieInventory.getList().get(0) instanceof Movie);
        assertTrue(movieInventory.getList().get(2) instanceof Movie);
    }

    @Test
    public void shouldPrintApropiateError() {
        String expected = new StringBuilder("No available movies!").toString();
        String actual = movieInventory.printError().toString();
        assertEquals(expected, actual);
    }

}