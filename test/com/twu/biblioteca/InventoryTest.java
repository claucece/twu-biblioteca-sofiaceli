package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;
    private BookSpec bookSpec;

    @Before
    public void setUp() {
        inventory = new Inventory();
        bookSpec = new BookSpec("Hemingway", "Killers", 1960);
    }

    @Test
    public void shouldAddBook() {
        Book expected = inventory.addBook(bookSpec);
        BookSpec newbookspec = new BookSpec("Hemingway", "Killers", 1960);
        Book actual = new Book(newbookspec);
    }
}