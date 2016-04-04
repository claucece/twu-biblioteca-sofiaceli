package com.twu.biblioteca.models;

import com.twu.biblioteca.models.BookModel.BookSpec;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookSpecTest {

    private BookSpec specOfBook;
    private String title;
    private String author;
    private String publishedYear;
    private BookSpec.Genre.Type type;
    private BookSpec.Genre genre;

    @Before
    public void setUp() {
        title = "From Whom The Bells Toll";
        type = BookSpec.Genre.Type.FICTION;
        genre = BookSpec.Genre.NOVEL;
        specOfBook = new BookSpec(title, author, publishedYear, type, genre);
    }

    @Test
    public void shouldGetTitle() {
        String expected = specOfBook.getTitle();
        String actual = title.toLowerCase();
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

    @Test
    public void shouldGetType() {
        String expected = specOfBook.getType();
        String actual = type.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetGenre() {
        String expected = specOfBook.getGenre();
        String actual = genre.toString();
        assertEquals(expected, actual);
    }

}