package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.Element;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListOfBooksTest {

    @Test
    public void shouldHaveExistanceOfBookElementInList() {
        List<Element> elements = ListOfElements.VALUES;
        String expected = elements.get(0).getSpec().getTitle();
        String actual = "for whom the bells toll";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveExistanceOfMovieElementInList() {
        List<Element> elements = ListOfElements.VALUES;
        String expected = elements.get(3).getSpec().getTitle();
        String actual = "lola rennt";
        assertEquals(expected, actual);
    }

}