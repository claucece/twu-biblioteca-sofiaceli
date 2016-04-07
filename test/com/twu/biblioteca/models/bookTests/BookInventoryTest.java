package com.twu.biblioteca.models.bookTests;

import com.twu.biblioteca.models.book.Book;
import com.twu.biblioteca.models.book.BookInventory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookInventoryTest {

    private BookInventory bookInventory;

    @Before
    public void setUp() {
        bookInventory = new BookInventory();
    }

    @Test
    public void shouldReturnProperBookList() {
        assertTrue(bookInventory.getList().get(0) instanceof Book);
        assertTrue(bookInventory.getList().get(2) instanceof Book);
    }

    @Test
    public void shouldPrintApropiateError() {
        String expected = new StringBuilder("No available books!").toString();
        String actual = bookInventory.printError().toString();
        assertEquals(expected, actual);
    }
}