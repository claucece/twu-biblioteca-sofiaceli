package com.twu.biblioteca.models.colorModelTests;

import com.twu.biblioteca.models.colorModel.Color;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {

    private Color color;

    @Before
    public void setUp() {
        color = new Color.Builder().ansiSequence("\u001B[31m").colorName("RED").build();
    }

    @Test
    public void shouldReturnAnsiEscape() {
        String expected = color.getAnsiEscape();
        String actual = "\u001B[31m";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnColorName() {
        String expected = color.getColorName();
        String actual = "RED";
        assertEquals(expected, actual);
    }
}