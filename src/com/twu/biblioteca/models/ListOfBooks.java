package com.twu.biblioteca.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOfBooks {

    private static final Book[] PRIVATE_VALUES = {(new Book(new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980", BookSpec.Genre.Type.FICTION))),
            (new Book(new BookSpec("Demian", "Herman Hesse", "1980", BookSpec.Genre.Type.FICTION))),
            (new Book(new BookSpec("Moby Dick", "Herman Melville", "1980", BookSpec.Genre.Type.FICTION))),
    };

    public static final List<Book> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

}
