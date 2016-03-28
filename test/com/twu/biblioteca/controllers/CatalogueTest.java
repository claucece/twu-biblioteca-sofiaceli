package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Book;
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
        String expected = "Moby Dick";
        String actual = catalogue.checkoutBook("Moby Dick").getSpec().getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnInventory() {
        Book expected = null;
        Book actual = catalogue.checkoutBook("The Art Of Love");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveCheckoutBookFromInventory() {
        Book checkoutBook = catalogue.checkoutBook("Moby Dick");
        List<Book> bookList = catalogue.removeBookFromInventory(checkoutBook);
        assertFalse(bookList.contains(checkoutBook));
    }

    @Test
    public void shouldInventoryChangeInSizeWhenObjectsAreRemoved() {
        Book checkoutBook = catalogue.checkoutBook("Moby Dick");
        List<Book> actual = catalogue.removeBookFromInventory(checkoutBook);
        System.out.println(actual.size());
        assertEquals(2, actual.size());
    }

    @Test
    public void shouldInventoryRemainStaticEvenWhenObjectsAreNotRemoved() {
        Book notContainedBook = catalogue.checkoutBook("Don Quixote");
        List<Book> actual = catalogue.removeBookFromInventory(notContainedBook);
        assertEquals(3, actual.size());
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        String expected = "Moby Dick";
        String actual = catalogue.returnBook("Moby Dick").getSpec().getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnList() {
        Book expected = null;
        Book actual = catalogue.returnBook("Hamlet");
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