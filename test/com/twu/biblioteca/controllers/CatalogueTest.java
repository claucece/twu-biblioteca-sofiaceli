package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Inventory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatalogueTest {

    private Catalogue catalogue;
    private Inventory inventory;

    @Before
    public void setUp() {
        catalogue = new Catalogue();
        inventory = new Inventory();
    }

    @Test
    public void shouldReturnBookInformation() {
        String expected = "For whom the bells toll Ernest Hemingway 1980 FICTION \n" +
                "Demian                  Herman Hesse     1980 FICTION \n" +
                "Moby Dick               Herman Melville  1980 FICTION \n";
        String actual = catalogue.getBookInformation(inventory);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutBooks() {
        String expected = "Moby Dick";
        String actual = catalogue.checkoutBook("3").getSpec().getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnInventory() {
        Book expected = null;
        Book actual = catalogue.checkoutBook("4");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveCheckoutBookFromInventory() {
        Book notContainedBook = catalogue.checkoutBook("3");
        List<Book> actualList = catalogue.removeBookFromInventory(notContainedBook);
        System.out.println(inventory.getInventoryOfBooks());
        System.out.println(catalogue.removeBookFromInventory(notContainedBook));
        assertFalse(actualList.contains(notContainedBook));
    }

    @Test
    public void shouldInventoryRemainStaticEvenWhenObjectsAreRemoved() {
        Book notContainedBook = catalogue.checkoutBook("3");
        List<Book> expected = inventory.getInventoryOfBooks();
        List<Book> actual = catalogue.removeBookFromInventory(notContainedBook);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldInventoryRemainStaticEvenWhenObjectsAreNotRemoved() {
        Book notContainedBook = catalogue.checkoutBook("4");
        List<Book> expected = inventory.getInventoryOfBooks();
        List<Book> actual = catalogue.removeBookFromInventory(notContainedBook);
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        String expected = "Moby Dick";
        String actual = catalogue.returnBookToInventory("3").getSpec().getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnList() {
        Book expected = null;
        Book actual = catalogue.returnBookToInventory("4");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddCheckoutBookFromInventory() {
        List<Book> startList = inventory.getInventoryOfBooks();
        System.out.println(startList.size());
        Book notContainedBook = catalogue.checkoutBook("3");
        List<Book> removedElementList = inventory.getInventoryOfBooks();
        System.out.println(removedElementList.size());
        Book containedBook = catalogue.returnBookToInventory("3");
        List<Book> finishList = inventory.getInventoryOfBooks();
        System.out.println(finishList.size());
        assertEquals(startList.size(), finishList.size());
    }
}