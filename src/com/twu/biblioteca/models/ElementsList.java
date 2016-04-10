package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.models.book.Book;
import com.twu.biblioteca.models.movie.Movie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ElementsList {

    private static final Element[] PRIVATE_VALUES = {(new Book("For whom the bells toll", "Ernest Hemingway", "1980", Book.Genre.Type.FICTION, Book.Genre.NOVEL, "Rating: 10")),
            (new Book("Demian", "Herman Hesse", "1980", Book.Genre.Type.FICTION, Book.Genre.NOVEL, "Rating: 10")),
            (new Book("Moby Dick", "Herman Melville", "1980", Book.Genre.Type.FICTION, Book.Genre.SHORT_STORY, "Rating: 10")),
            (new Movie("Lola rennt", "Tom Tykwer", "1998", "Independant", "Suspense", "Rating: 9.5")),
            (new Movie("Being John Malkovich", "Spike Jonze", "1999", "Independant", "Suspense", "Rating: 9.8")),
            (new Movie("Blue Velvet", "David Lynch", "1986", "Independant", "Suspense", "Rating: 9.9")),
    };

    public static final List<Element> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

}
