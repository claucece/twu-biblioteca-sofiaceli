package com.twu.biblioteca.models;

import java.util.EnumMap;
import java.util.Map;

public class BookSpec {

    private String title;
    private String author;
    private String publishedYear;
    private Genre.Type type;

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

    public BookSpec(String title, String author, String publishedYear, Genre.Type type) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public String toString() {
        return type.toString();
    }

    public String getType() {
        return type.toString();
    }

}
