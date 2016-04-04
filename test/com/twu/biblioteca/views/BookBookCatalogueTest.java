package com.twu.biblioteca.views;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookBookCatalogueTest {

    private BookCatalogue bookCatalogue;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        bookCatalogue = new BookCatalogue();
    }

    @Test
    public void shouldReturnBookInformation() {
        String expected = "for whom the bells toll Ernest Hemingway 1980 FICTION NOVEL       \n" +
                "demian                  Herman Hesse     1980 FICTION NOVEL       \n" +
                "moby dick               Herman Melville  1980 FICTION SHORT_STORY " +
                "\n";
        String actual = bookCatalogue.returnCatalogue();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintMenuItems() {
        System.setOut(new PrintStream(outContent));
        String actual = "--> Checkout Book   --> Return Book   --> Return To Main Menu   \n";
        assertEquals(bookCatalogue.toLineColumn(), actual);
    }


}