package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.models.BookModel.BookInventory;
import com.twu.biblioteca.models.BookModel.Book;
import com.twu.biblioteca.models.BookModel.BookSpec;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatalogueTest {

    private BookInventory bookInventory;
    private Catalogue catalogue;

    @Before
    public void setUp() {
        bookInventory = new BookInventory();
        catalogue = new Catalogue(bookInventory);
    }

    @Test
    public void shouldGetBookInformation() {
        String expected = "for whom the bells toll Ernest Hemingway 1980 FICTION NOVEL       \n" +
                "demian                  Herman Hesse     1980 FICTION NOVEL       \n" +
                "moby dick               Herman Melville  1980 FICTION SHORT_STORY " +
                "\n";
        String actual = catalogue.putInformationInColumns(bookInventory);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutBooks() {
        boolean actual = catalogue.isACheckout("Moby Dick", bookInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnInventory() {
        boolean actual = catalogue.isACheckout("The Art Of Love", bookInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldRemoveCheckoutBookFromInventory() {
        Book book = new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL));
        boolean bookList = catalogue.removeFromInventory(book, bookInventory);
        assertFalse(bookInventory.returnInventoryOfElements().contains(book));
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        catalogue.isACheckout("Moby Dick", bookInventory);
        boolean actual = catalogue.isAReturn("Moby Dick", bookInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToReturnBookThatIsNotOnList() {
        boolean actual = catalogue.isAReturn("Hamlet", bookInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldAddCheckoutBookFromInventory() {
        List<Element> startList = bookInventory.returnInventoryOfElements();
        catalogue.isACheckout("Moby Dick", bookInventory);
        catalogue.isAReturn("Moby Dick", bookInventory);
        List<Element> finishList = bookInventory.returnInventoryOfElements();
        assertEquals(startList.size(), finishList.size());
    }
}