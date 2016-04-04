package com.twu.biblioteca.models;

import com.twu.biblioteca.models.colorModel.Color;
import com.twu.biblioteca.models.colorModel.ColorList;
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