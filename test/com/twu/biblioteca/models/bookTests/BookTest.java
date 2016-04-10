package com.twu.biblioteca.models.bookTests;

import com.twu.biblioteca.models.book.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book specOfBook;
    private String title;
    private String author;
    private String publishedYear;
    private Book.Genre.Type type;
    private Book.Genre genre;
    private String rating;

    @Before
    public void setUp() {
        title = "From Whom The Bells Toll";
        type = Book.Genre.Type.FICTION;
        genre = Book.Genre.NOVEL;
        specOfBook = new Book(title, author, publishedYear, type, genre, rating);
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

    @Test
    public void shouldGetRating() {
        String expected = specOfBook.getRating();
        String actual = rating;
        assertEquals(expected, actual);
    }

}
