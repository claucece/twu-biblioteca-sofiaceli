package com.twu.biblioteca.models.bookModelTests;

import com.twu.biblioteca.helpers.ElementSpec;
import com.twu.biblioteca.models.bookModel.Book;
import com.twu.biblioteca.models.bookModel.BookSpec;
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
        ElementSpec expected = book.getSpec();
        BookSpec actual = bookspec;
        assertEquals(expected, actual);
    }
}