package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Inventory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CatalogueTest {

    private Catalogue catalogue;
    private Inventory inventory;

    @Before
    public void setUp() {
        catalogue = new Catalogue();
        inventory = new Inventory();
    }

    @Test
    public void shouldReturnBookInformation() {
        String expected = "For whom the bells toll Ernest Hemingway 1980 FICTION \n" +
                "Demian                  Herman Hesse     1980 FICTION \n" +
                "Moby Dick               Herman Melville  1980 FICTION \n";
        String actual = catalogue.getBookInformation(inventory);
        assertEquals(expected, actual);
    }

}