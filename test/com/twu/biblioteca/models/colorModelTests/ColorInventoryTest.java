package com.twu.biblioteca.models.colorModelTests;

import com.twu.biblioteca.models.color.Color;
import com.twu.biblioteca.models.color.ColorList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ColorInventoryTest {

    @Test
    public void should() {
        List<Color> colors = ColorList.VALUES;
        String expected = colors.get(0).getColorName();
        String actual = "BLACK";
        assertEquals(expected, actual);
    }
}