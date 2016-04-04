package com.twu.biblioteca.models;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.models.BookModel.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;
    private Catalogue catalogue;

    @Before
    public void setUp() {
        inventory = Inventory.valueOf();
        catalogue = new Catalogue(inventory);
    }

//    @Test
//    public void shouldAddBook() {
//        Book expectedBook = inventory.getListOfBooks().get(0);
//        String expected = expectedBook.getSpec().getAuthor();
//        String actual = inventory.returnInventoryOfBooks().get(0).getSpec().getAuthor();
//        assertEquals(expected, actual);
//    }

}