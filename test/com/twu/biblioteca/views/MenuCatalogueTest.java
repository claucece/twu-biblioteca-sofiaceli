package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.bookModel.BookInventory;
import com.twu.biblioteca.models.movieModel.MovieInventory;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MenuCatalogueTest {

    private MenuCatalogue menuCatalogue;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BookInventory bookInventory = new BookInventory();

    @Before
    public void setUp() {
        menuCatalogue = new MenuCatalogue();
    }

    ///not passing
    @Test
    public void shouldPrintMenuItems() {
        String actual = "--> Checkout Book   --> Return Book   --> Return To Main Menu   \n";
        assertEquals(menuCatalogue.toLineColumn(bookInventory), actual);
    }

}