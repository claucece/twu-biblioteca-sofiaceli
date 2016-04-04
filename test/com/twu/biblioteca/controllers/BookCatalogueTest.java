package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.BookModel.BookInventory;
import com.twu.biblioteca.models.BookModel.Book;
import com.twu.biblioteca.models.BookModel.BookSpec;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookCatalogueTest {

    private BookInventory bookInventory;
    private BookCatalogue bookCatalogue;

    @Before
    public void setUp() {
        bookInventory = BookInventory.valueOf();
        bookCatalogue = new BookCatalogue(bookInventory);
    }

    @Test
    public void shouldGetBookInformation() {
        String expected = "for whom the bells toll Ernest Hemingway 1980 FICTION NOVEL       \n" +
                "demian                  Herman Hesse     1980 FICTION NOVEL       \n" +
                "moby dick               Herman Melville  1980 FICTION SHORT_STORY " +
                "\n";
        String actual = bookCatalogue.putInformationInColumns();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutBooks() {
        boolean actual = bookCatalogue.isACheckout("Moby Dick");
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnInventory() {
        boolean actual = bookCatalogue.isACheckout("The Art Of Love");
        assertEquals(false, actual);
    }

    @Test
    public void shouldRemoveCheckoutBookFromInventory() {
        Book book = new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL));
        boolean bookList = bookCatalogue.removeBookFromInventory(book);
        assertFalse(bookInventory.returnInventoryOfElements().contains(book));
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        bookCatalogue.isACheckout("Moby Dick");
        boolean actual = bookCatalogue.isAReturn("Moby Dick");
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToReturnBookThatIsNotOnList() {
        boolean actual = bookCatalogue.isAReturn("Hamlet");
        assertEquals(false, actual);
    }

//    @Test
//    public void shouldAddCheckoutBookFromInventory() {
//        List<Book> startList = bookInventory.returnInventoryOfBooks();
//        bookCatalogue.isACheckout("Moby Dick");
//        bookCatalogue.isAReturn("Moby Dick");
//        List<Book> finishList = bookInventory.returnInventoryOfBooks();
//        assertEquals(startList.size(), finishList.size());
//    }
}