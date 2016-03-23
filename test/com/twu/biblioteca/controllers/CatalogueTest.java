package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookSpec;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatalogueTest {

    private Catalogue catalogue;
    private Inventory inventory;
    private BookSpec bookSpec;
    private Book book;
    private BookSpec.Genre genre;

    @Before
    public void setUp() {
        catalogue = new Catalogue();
        inventory = new Inventory();
        bookSpec = new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980", BookSpec.Genre.Type.FICTION);
        book = new Book("1", bookSpec);
    }

    @Test
    public void shouldReturnBookInformation() {
        String expected = "For whom the bells toll Ernest Hemingway 1980 \n" +
                "Demian                  Herman Hesse     1980 \n" +
                "Moby Dick               Herman Melville  1980 \n";
        String actual = catalogue.getBookInformation(inventory);
        assertEquals(expected, actual);
    }

}