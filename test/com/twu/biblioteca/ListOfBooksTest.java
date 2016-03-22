package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookSpec;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListOfBooksTest {

    private ListOfBooks listOfBooks;

    @Before
    public void setUp() throws Exception {
    listOfBooks = new ListOfBooks();
    }

//    @Test
//    public void shouldAddBook() {
//        Book book1 = new Book("1", new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980"));
//        String expected = "1";
//        String actual = listOfBooks.initializeInventory().addBook(book1).getId();
//        assertEquals(expected, actual);
//    }

}