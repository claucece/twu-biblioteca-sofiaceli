package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookSpec;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private Inventory inventory;
    private BookSpec bookSpec;
    private Book book;

//    @Before
//    public void setUp() {
//        inventory = new Inventory();
//        bookSpec = new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980");
//        book = new Book("1", bookSpec);
//    }
//
//    @Test
//    public void shouldAddBook() {
//        Book expectedBook = new Book("2", new BookSpec("Nietzche and philosohpy", "Deleuze", "1970"));
//        String expected = expectedBook.getSpec().getAuthor();
//        Book actualBook = inventory.addBook(new Book("2", (new BookSpec("Nietzche and philosohpy", "Deleuze", "1970"))));
//        String actual = actualBook.getSpec().getAuthor();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnBookInformation() {
//        String expected = "Ficciones Jorge Luis Borges 1989 " +
//                "\n";
//        Book book = new Book("3", new BookSpec("Ficciones", "Jorge Luis Borges", "1989"));
//        Book actualBook = inventory.addBook(book);
//        String actual = inventory.getBookInformation();
//        assertEquals(expected, actual);
//    }
//
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