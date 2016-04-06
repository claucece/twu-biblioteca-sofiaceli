package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.models.book.BookInventory;
import com.twu.biblioteca.models.book.Book;
import com.twu.biblioteca.models.book.BookSpec;
import com.twu.biblioteca.models.movie.Movie;
import com.twu.biblioteca.models.movie.MovieInventory;
import com.twu.biblioteca.models.movie.MovieSpec;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatalogueTest {

    private BookInventory bookInventory;
    private MovieInventory movieInventory;
    private Catalogue bookCatalogue;
    private Catalogue movieCatalogue;

    @Before
    public void setUp() {
        bookInventory = new BookInventory();
        movieInventory = new MovieInventory();
        bookCatalogue = new Catalogue(bookInventory);
        movieCatalogue = new Catalogue(movieInventory);
    }

    @Test
    public void shouldGetBookInformation() {
        String expected = "for whom the bells toll Ernest Hemingway 1980 FICTION NOVEL       \n" +
                "demian                  Herman Hesse     1980 FICTION NOVEL       \n" +
                "moby dick               Herman Melville  1980 FICTION SHORT_STORY " +
                "\n";
        String actual = bookCatalogue.putInformationInColumns(bookInventory);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMovieInformation() {
        String expected = "lola rennt           Tom Tykwer  1998 Independant Suspense \n" +
                "being john malkovich Spike Jonze 1999 Independant Suspense \n" +
                "blue velvet          David Lynch 1986 Independant Suspense " +
                "\n";
        String actual = movieCatalogue.putInformationInColumns(movieInventory);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutBooks() {
        boolean actual = bookCatalogue.isACheckout("Moby Dick", bookInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutMovies() {
        boolean actual = bookCatalogue.isACheckout("Lola Rennt", movieInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutMovieThatIsNotOnBookInventory() {
        boolean actual = bookCatalogue.isACheckout("Lola Rennt", bookInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnMovieInventory() {
        boolean actual = movieCatalogue.isACheckout("Moby Dick", movieInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnInventory() {
        boolean actual = bookCatalogue.isACheckout("The Art Of Love", bookInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutMovieThatIsNotOnInventory() {
        boolean actual = bookCatalogue.isACheckout("Dodgeball", movieInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldRemoveCheckoutBookFromInventory() {
        Book book = new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL, "10"));
        boolean bookList = bookCatalogue.removeFromInventory(book, bookInventory);
        assertFalse(bookInventory.returnInventoryOfElements().contains(book));
    }

    @Test
    public void shouldRemoveCheckoutMovieFromInventory() {
        Movie movie = new Movie(new MovieSpec("Titanic", "James Cameron", "1997", "10", "FICTION", "ROMANTIC"));
        boolean movieList = movieCatalogue.removeFromInventory(movie, movieInventory);
        assertFalse(movieInventory.returnInventoryOfElements().contains(movie));
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        bookCatalogue.isACheckout("Moby Dick", bookInventory);
        boolean actual = bookCatalogue.isAReturn("Moby Dick", bookInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldBeAbleToReturnMovies() {
        movieCatalogue.isACheckout("Lola Rennt", movieInventory);
        boolean actual = movieCatalogue.isAReturn("Lola Rennt", movieInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToReturnBookThatIsNotOnList() {
        boolean actual = bookCatalogue.isAReturn("Hamlet", bookInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldNotBeAbleToReturnMovieThatIsNotOnList() {
        boolean actual = movieCatalogue.isAReturn("Eraser Head", movieInventory);
        assertEquals(false, actual);
    }

    // and this is a bug
    @Test
    public void shouldNotBeAbleToReturnMovieThatIsOnBookList() {
        boolean actual = movieCatalogue.isAReturn("Moby Dick", movieInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldAddCheckoutBookFromInventory() {
        List<Element> startList = bookInventory.returnInventoryOfElements();
        bookCatalogue.isACheckout("Moby Dick", bookInventory);
        bookCatalogue.isAReturn("Moby Dick", bookInventory);
        List<Element> finishList = bookInventory.returnInventoryOfElements();
        assertEquals(startList.size(), finishList.size());
    }
}