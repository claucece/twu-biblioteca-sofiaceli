package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.InputAsker;
import com.twu.biblioteca.models.Inventory;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookCatalogueTest {

    private Catalogue catalogue;
    private BookCatalogue bookCatalogue;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        bookCatalogue = new BookCatalogue(catalogue);

    }

    @Test
    public void shouldReturnBookInformation() {
        String expected = "For whom the bells toll Ernest Hemingway 1980 FICTION \n" +
                "Demian                  Herman Hesse     1980 FICTION \n" +
                "Moby Dick               Herman Melville  1980 FICTION \n";
        String actual = bookCatalogue.returnCatalogue();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintMenuItems() {
        System.setOut(new PrintStream(outContent));
        String actual = "--> Checkout Book   --> Return Book   --> Return To Main Menu   \n";
        assertEquals(bookCatalogue.printBookCatalogueMenu(), actual);
    }

    @Test
    public void shouldQuitWhenAsked() {
        InputAsker asker = mock(InputAsker.class);
        when(asker.ask()).thenReturn("checkout book");
        assertEquals(bookCatalogue.defineBookMenuOutcome(asker), "Returning to main menu...");
    }
}