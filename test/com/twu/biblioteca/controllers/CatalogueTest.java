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
        inventory = Inventory.valueOf();
        catalogue = new Catalogue(inventory);
    }

    @Test
    public void shouldGetBookInformation() {
        String expected = "for whom the bells toll Ernest Hemingway 1980 FICTION NOVEL       \n" +
                "demian                  Herman Hesse     1980 FICTION NOVEL       \n" +
                "moby dick               Herman Melville  1980 FICTION SHORT_STORY " +
                "\n";
        String actual = catalogue.getBookInformation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutBooks() {
        boolean actual = catalogue.checkoutBook("Moby Dick");
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnInventory() {
        boolean actual = catalogue.checkoutBook("The Art Of Love");
        assertEquals(false, actual);
    }

    @Test
    public void shouldRemoveCheckoutBookFromInventory() {
        Book book = new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL));
        List<Book> bookList = catalogue.removeBookFromInventory(book);
        assertFalse(bookList.contains(book));
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        catalogue.checkoutBook("Moby Dick");
        boolean actual = catalogue.returnBook("Moby Dick");
        System.out.println(inventory.getInventoryOfBooks());
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnList() {
        boolean actual = catalogue.returnBook("Hamlet");
        assertEquals(false, actual);
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