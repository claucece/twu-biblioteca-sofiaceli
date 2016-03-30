package com.twu.biblioteca.models;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ColorInventoryTest {

    @Test
    public void should() {
        List<Color> colors = ColorInventory.VALUES;
        String expected = colors.get(0).getColorName();
        String actual = "BLACK";
        assertEquals(expected, actual);
    }
}