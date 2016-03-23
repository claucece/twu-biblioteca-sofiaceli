package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void shouldAddBook() {
        inventory.addBook();
        Book expectedBook = inventory.getInventoryOfBooks().get(0);
        String expected = expectedBook.getSpec().getAuthor();
        String actual = "Ernest Hemingway";
        assertEquals(expected, actual);
    }

//    @Test
//    public void shouldReturnBookById() {
//        String expected = "Ficciones";
//        Book book = new Book("3", new BookSpec("Ficciones", "Jorge Luis Borges", "1989"));
//        Book actualBook = inventory.addBook(book);
//        String actual = inventory.getBook("3").getSpec().getTitle();
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    //public void shouldGetAllBooks() {
//    //    inventory.addBook(book);
//    //    String expected = inventory.getBookInformation(book);
//    //    String actual = "For whom the bells toll Ernest Hemingway 1980 " +
//    //            "\n";
//    //    assertEquals(expected, actual);
//    //}
}