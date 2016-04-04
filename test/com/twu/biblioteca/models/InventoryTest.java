package com.twu.biblioteca.models;

import com.twu.biblioteca.controllers.BookCatalogue;
import com.twu.biblioteca.models.BookModel.BookInventory;
import org.junit.Before;

public class InventoryTest {

    private BookInventory bookInventory;
    private BookCatalogue bookCatalogue;

    @Before
    public void setUp() {
        bookInventory = BookInventory.valueOf();
        bookCatalogue = new BookCatalogue(bookInventory);
    }

//    @Test
//    public void shouldAddBook() {
//        Book expectedBook = bookInventory.getListOfBooks().get(0);
//        String expected = expectedBook.getSpec().getAuthor();
//        String actual = bookInventory.returnInventoryOfBooks().get(0).getSpec().getAuthor();
//        assertEquals(expected, actual);
//    }

}