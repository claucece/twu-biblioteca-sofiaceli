package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.BookModel.Book;
import com.twu.biblioteca.models.BookModel.BookSpec;
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
        String actual = catalogue.putBookInformationInColumns();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutBooks() {
        boolean actual = catalogue.isACheckoutBook("Moby Dick");
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnInventory() {
        boolean actual = catalogue.isACheckoutBook("The Art Of Love");
        assertEquals(false, actual);
    }

    @Test
    public void shouldRemoveCheckoutBookFromInventory() {
        Book book = new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL));
        boolean bookList = catalogue.removeBookFromInventory(book);
        assertFalse(inventory.returnInventoryOfBooks().contains(book));
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        catalogue.isACheckoutBook("Moby Dick");
        boolean actual = catalogue.isABookReturn("Moby Dick");
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToReturnBookThatIsNotOnList() {
        boolean actual = catalogue.isABookReturn("Hamlet");
        assertEquals(false, actual);
    }

//    @Test
//    public void shouldAddCheckoutBookFromInventory() {
//        List<Book> startList = inventory.returnInventoryOfBooks();
//        catalogue.isACheckoutBook("Moby Dick");
//        catalogue.isABookReturn("Moby Dick");
//        List<Book> finishList = inventory.returnInventoryOfBooks();
//        assertEquals(startList.size(), finishList.size());
//    }
}