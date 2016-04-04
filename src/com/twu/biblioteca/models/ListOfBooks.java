package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.models.BookModel.Book;
import com.twu.biblioteca.models.MovieModel.Movie;
import com.twu.biblioteca.models.BookModel.BookSpec;
import com.twu.biblioteca.models.MovieModel.MovieSpec;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOfBooks {

    private static final Element[] PRIVATE_VALUES = {(new Book(new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL))),
            (new Book(new BookSpec("Demian", "Herman Hesse", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL ))),
            (new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.SHORT_STORY))),
            (new Movie(new MovieSpec("Lola rennt", "Tom Tykwer", "1998", "10", "Independant", "Suspense"))),
            (new Movie(new MovieSpec("Being John Malkovich", "Spike Jonze", "1999", "10", "Independant", "Suspense"))),
            (new Movie(new MovieSpec("Blue Velvet", "David Lynch", "1986", "10", "Independant", "Suspense"))),
    };

    public static final List<Element> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

}
