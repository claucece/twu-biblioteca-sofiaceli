package com.twu.biblioteca.views;

import com.twu.biblioteca.models.book.BookInventory;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class Catalogue {

    private MenuCatalogue menuCatalogue;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BookInventory bookInventory = new BookInventory();

    @Before
    public void setUp() {
        menuCatalogue = new MenuCatalogue();
    }

    @Test
    public void shouldPrintMenuItems() {
        String actual = "--> Checkout book --> Return book --> Return To Main   \n";
        assertEquals(menuCatalogue.toLineColumn(bookInventory), actual);
    }

}