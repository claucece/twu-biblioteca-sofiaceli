package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book book;
    private String id;
    private BookSpec bookspec;

    @Before
    public void setUp() {
        book = new Book(bookspec);
    }

    @Test
    public void shouldHaveBookId() {
        String expected = book.getId();
        String actual = id;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveBookSpec() {
        BookSpec expected = book.getSpec();
        BookSpec actual = bookspec;
        assertEquals(expected, actual);
    }
}