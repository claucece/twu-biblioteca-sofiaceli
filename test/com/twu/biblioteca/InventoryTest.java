package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;
    private BookSpec bookSpec;
    private Book book;
    private List<Book> expected = new ArrayList<Book>();

    @Before
    public void setUp() {
        inventory = new Inventory();
        bookSpec = new BookSpec("Hemingway", "Killers", 1960);
        book = new Book("1", bookSpec);
    }

    @Test
    public void shouldAddBook() {
        expected = inventory.addBook(book);
        assertTrue(expected.get(0) instanceof Book);
    }

    @Test
    public void shouldGetAllBooks() {
        inventory.getAllBooks();
        inventory.addBook(book);
        System.out.println(inventory.getAllBooks());
        //assertEquals(inventory.getBook("1"), book);
    }
}