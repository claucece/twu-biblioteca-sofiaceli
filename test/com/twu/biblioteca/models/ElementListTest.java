package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.Element;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ElementListTest {

    @Test
    public void shouldHaveExistanceOfBookElementInList() {
        List<Element> elements = ElementsList.VALUES;
        String expected = elements.get(0).getTitle();
        String actual = "for whom the bells toll";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveExistanceOfMovieElementInList() {
        List<Element> elements = ElementsList.VALUES;
        String expected = elements.get(3).getTitle();
        String actual = "lola rennt";
        assertEquals(expected, actual);
    }

}