package com.twu.biblioteca.views;

import com.twu.biblioteca.models.book.BookInventory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CatalogueTest {

    private Catalogue catalogue;
    private BookInventory bookInventory = new BookInventory();

    @Before
    public void setUp() {
        catalogue = new Catalogue();
    }

    @Test
    public void shouldPrintMenuItems() {
        String actual = "--> Checkout book --> Return book --> Return To Main   \n";
        assertEquals(catalogue.toLineColumn(bookInventory), actual);
    }

}