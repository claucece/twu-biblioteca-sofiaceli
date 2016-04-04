package com.twu.biblioteca.models.bookModelTests;

import com.twu.biblioteca.models.bookModel.Book;
import com.twu.biblioteca.models.bookModel.BookInventory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookInventoryTest {

    private BookInventory bookInventory;

    @Before
    public void setUp() {
        bookInventory = new BookInventory();
    }

    @Test
    public void shouldReturnProperBookList() {
        assertTrue(bookInventory.getList().get(0) instanceof Book);
        assertTrue(bookInventory.getList().get(2) instanceof Book);
    }

    @Test
    public void shouldReturnInventoryOfElements() {
    }

    @Test
    public void shouldAddElement() {
    }

    @Test
    public void shouldPrintError() {
    }

}