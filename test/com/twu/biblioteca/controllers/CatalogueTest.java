package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookSpec;
import com.twu.biblioteca.models.Inventory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatalogueTest {

    private Inventory inventory;
    private Catalogue catalogue;

    @Before
    public void setUp() {
        inventory = new Inventory();
        catalogue = new Catalogue(inventory);
    }

    @Test
    public void shouldGetBookInformation() {
        String expected = "For whom the bells toll Ernest Hemingway 1980 FICTION \n" +
                "Demian                  Herman Hesse     1980 FICTION \n" +
                "Moby Dick               Herman Melville  1980 FICTION \n";
        String actual = catalogue.getBookInformation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutBooks() {
        String expected = "Thank you! Enjoy the book";
        String actual = catalogue.checkoutBook("Moby Dick");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnInventory() {
        String expected = "Book not found. Please, select a book from the list";
        String actual = catalogue.checkoutBook("The Art Of Love");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveCheckoutBookFromInventory() {
        Book book = new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL));
        List<Book> bookList = catalogue.removeBookFromInventory(book);
        assertFalse(bookList.contains(book));
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        String expected = "Thank you for returning the book.";
        catalogue.checkoutBook("Moby Dick");
        String actual = catalogue.returnBook("Moby Dick");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnList() {
        String expected = "That is not a valid book to return.";
        String actual = catalogue.returnBook("Hamlet");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddCheckoutBookFromInventory() {
        List<Book> startList = inventory.getInventoryOfBooks();
        catalogue.checkoutBook("Moby Dick");
        catalogue.returnBook("Moby Dick");
        List<Book> finishList = inventory.getInventoryOfBooks();
        System.out.println(catalogue.getBookInformation());
        assertEquals(startList.size(), finishList.size());
    }
}