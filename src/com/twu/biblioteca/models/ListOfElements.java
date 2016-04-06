package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.models.book.Book;
import com.twu.biblioteca.models.movie.Movie;
import com.twu.biblioteca.models.book.BookSpec;
import com.twu.biblioteca.models.movie.MovieSpec;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOfElements {

    private static final Element[] PRIVATE_VALUES = {(new Book(new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL, "10"))),
            (new Book(new BookSpec("Demian", "Herman Hesse", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL, "10"))),
            (new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.SHORT_STORY, "10"))),
            (new Movie(new MovieSpec("Lola rennt", "Tom Tykwer", "1998", "10", "Independant", "Suspense"))),
            (new Movie(new MovieSpec("Being John Malkovich", "Spike Jonze", "1999", "10", "Independant", "Suspense"))),
            (new Movie(new MovieSpec("Blue Velvet", "David Lynch", "1986", "10", "Independant", "Suspense"))),
    };

    public static final List<Element> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

}
