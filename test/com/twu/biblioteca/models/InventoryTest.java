package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = Inventory.valueOf();
    }

//    @Test
//    public void shouldAddBook() {
//        Book expectedBook = inventory.addBook().get(0);
//        String expected = expectedBook.getSpec().getAuthor();
//        String actual = inventory.returnInventoryOfBooks().get(0).getSpec().getAuthor();
//        assertEquals(expected, actual);
//    }

}