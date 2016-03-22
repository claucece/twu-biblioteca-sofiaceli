package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ColorInventoryTest {

    ColorInventory colorInventory;

    @Before
    public void setUp() {
        colorInventory = new ColorInventory();
    }

    @Test
    public void shouldCheckDecimalOfRomaNumber() {
        List<Color> colors = colorInventory.VALUES;
        String expected = colors.get(0).getColorName();
        String actual = "black";
        assertEquals(expected, actual);
    }
}