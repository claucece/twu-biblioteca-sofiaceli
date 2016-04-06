package com.twu.biblioteca.models.book;

import com.twu.biblioteca.helpers.AbstractElementSpec;

import java.util.EnumMap;
import java.util.Map;

public class BookSpec extends AbstractElementSpec {

    private Genre.Type type;
    private Genre genre;

    public enum Genre {
        DRAMA, NARRATIVE, MYTH, NOVEL, SHORT_STORY;

        public enum Type {
            FICTION(DRAMA, NOVEL, SHORT_STORY), NONFICTION(NARRATIVE, MYTH);

            private final Genre[] genre;

            Type(Genre ... genre) {
                this.genre = genre;
            }

            private static final Map<Genre, Type> typeSpec = new EnumMap<Genre, Type>(Genre.class);

            static {
                for (Genre genre : Genre.values()) {
                    for (Type type : Type.values()) {
                        typeSpec.put(genre, type);
                    }
                }
            }
        }
    }

    public BookSpec(String title, String author, String publishedYear, Genre.Type type, Genre genre, String rating) {
        super(title, author, publishedYear, rating);
        this.type = type;
        this.genre = genre;
    }

    public String getType() {
        return type.toString();
    }

    public String getGenre() {
        return genre.toString();
    }

}
