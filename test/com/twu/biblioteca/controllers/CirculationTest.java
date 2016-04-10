package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.models.book.BookInventory;
import com.twu.biblioteca.models.book.Book;
import com.twu.biblioteca.models.movie.Movie;
import com.twu.biblioteca.models.movie.MovieInventory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CirculationTest {

    private BookInventory bookInventory;
    private MovieInventory movieInventory;
    private Circulation bookCirculation;
    private Circulation movieCirculation;

    @Before
    public void setUp() {
        bookInventory = new BookInventory();
        movieInventory = new MovieInventory();
        bookCirculation = new Circulation(bookInventory);
        movieCirculation = new Circulation(movieInventory);
    }

    @Test
    public void shouldGetBookInformation() {
        String expected = "for whom the bells toll Ernest Hemingway 1980 FICTION NOVEL       Rating: 10 \n" +
                "demian                  Herman Hesse     1980 FICTION NOVEL       Rating: 10 \n" +
                "moby dick               Herman Melville  1980 FICTION SHORT_STORY Rating: 10 " +
                "\n";
        String actual = bookCirculation.putInformationInColumns(bookInventory);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMovieInformation() {
        String expected = "lola rennt           Tom Tykwer  1998 Independant Suspense Rating: 9.5 \n" +
                "being john malkovich Spike Jonze 1999 Independant Suspense Rating: 9.8 \n" +
                "blue velvet          David Lynch 1986 Independant Suspense Rating: 9.9 " +
                "\n";
        String actual = movieCirculation.putInformationInColumns(movieInventory);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutBooks() {
        boolean actual = bookCirculation.isACheckout("Moby Dick", bookInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldBeAbleToCheckoutMovies() {
        boolean actual = bookCirculation.isACheckout("Lola Rennt", movieInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutMovieThatIsNotOnBookInventory() {
        boolean actual = bookCirculation.isACheckout("Lola Rennt", bookInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnMovieInventory() {
        boolean actual = movieCirculation.isACheckout("Moby Dick", movieInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookThatIsNotOnInventory() {
        boolean actual = bookCirculation.isACheckout("The Art Of Love", bookInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldNotBeAbleToCheckoutMovieThatIsNotOnInventory() {
        boolean actual = bookCirculation.isACheckout("Dodgeball", movieInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldRemoveCheckoutBookFromInventory() {
        Book book = new Book("Moby Dick", "Herman Melville", "1980", Book.Genre.Type.FICTION, Book.Genre.NOVEL, "10");
        bookCirculation.removeFromInventory(book, bookInventory);
        assertFalse(bookInventory.returnInventoryOfElements().contains(book));
    }

    @Test
    public void shouldRemoveCheckoutMovieFromInventory() {
        Movie movie = new Movie("Titanic", "James Cameron", "1997", "10", "FICTION", "ROMANTIC");
        movieCirculation.removeFromInventory(movie, movieInventory);
        assertFalse(movieInventory.returnInventoryOfElements().contains(movie));
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        bookCirculation.isACheckout("Moby Dick", bookInventory);
        boolean actual = bookCirculation.isAReturn("Moby Dick", bookInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldBeAbleToReturnMovies() {
        movieCirculation.isACheckout("Lola Rennt", movieInventory);
        boolean actual = movieCirculation.isAReturn("Lola Rennt", movieInventory);
        assertEquals(true, actual);
    }

    @Test
    public void shouldNotBeAbleToReturnBookThatIsNotOnList() {
        boolean actual = bookCirculation.isAReturn("Hamlet", bookInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldNotBeAbleToReturnMovieThatIsNotOnList() {
        boolean actual = movieCirculation.isAReturn("Eraser Head", movieInventory);
        assertEquals(false, actual);
    }

    @Test
    public void shouldAddCheckoutBookFromInventory() {
        List<Element> startList = bookInventory.returnInventoryOfElements();
        bookCirculation.isACheckout("Moby Dick", bookInventory);
        bookCirculation.isAReturn("Moby Dick", bookInventory);
        List<Element> finishList = bookInventory.returnInventoryOfElements();
        assertEquals(startList.size(), finishList.size());
    }
}