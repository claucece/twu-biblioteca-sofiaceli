package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListOfBooksTest {

    private ListOfBooks listOfBooks;

    @Before
    public void setUp() {
    listOfBooks = new ListOfBooks();
    }

    @Test
    public void shouldExistanceOfBookInList() {
        List<Book> books = listOfBooks.VALUES;
        String expected = books.get(0).getSpec().getTitle();
        String actual = "for whom the bells toll";
        assertEquals(expected, actual);
    }

}