package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookSpecTest {

    private String title;
    private BookSpec specOfBook;
    private String author;
    private String publishedYear;

    @Before
    public void setUp() {
        specOfBook = new BookSpec(title, author, publishedYear);
    }

    @Test
    public void shouldGetTitle() {
        String expected = specOfBook.getTitle();
        String actual = title;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAuthor() {
        String expected = specOfBook.getAuthor();
        String actual = author;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPublishedYear() {
        String expected = specOfBook.getPublishedYear();
        String actual = publishedYear;
        assertEquals(expected, actual);
    }
}