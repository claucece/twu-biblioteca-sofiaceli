package com.twu.biblioteca.models;

import com.twu.biblioteca.models.BookModel.Book;
import com.twu.biblioteca.models.BookModel.BookSpec;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOfMovies {

        private static final Book[] PRIVATE_VALUES = {(new Book(new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL))),
                (new Book(new BookSpec("Demian", "Herman Hesse", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.NOVEL ))),
                (new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION, BookSpec.Genre.SHORT_STORY))),
        };

        public static final List<Book> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

}
