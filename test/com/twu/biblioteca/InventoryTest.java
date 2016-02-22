package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;
    private BookSpec bookSpec;
    private Book book;
    private List<Book> expected = new ArrayList<Book>();

    @Before
    public void setUp() {
        inventory = new Inventory();
        bookSpec = new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980");
        book = new Book("1", bookSpec);
    }

    @Test
    public void shouldAddBook() {
        expected = inventory.addBook(book);
        assertTrue(expected.get(0) instanceof Book);
    }

    @Test
    public void shouldGetAllBooks() {
        inventory.addBook(book);
        String expected = inventory.getBookInformation(book);
        String actual = "For whom the bells toll Ernest Hemingway 1980 " +
                "\n";
        assertEquals(expected, actual);
    }
}