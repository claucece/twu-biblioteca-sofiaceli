package com.twu.biblioteca.controllers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ColumnTest {

    private Column column;

    @Before
    public void setUp() throws Exception {
        column = new Column();
    }

    @Test
    public void shouldAddLine() {
        String title = "For whom the bells toll";
        List<String> titleList = asList(title);
        List<List<String>> expected = column.addLine(title);
        List<List<String>> actual = asList(titleList);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldConvertToString() {
        String title = "For whom the bells toll";
        List<String> titleList = asList(title);
        List<List<String>> list = asList(titleList);
        Column column = new Column();
        column.addLine(title);
        String actual = column.toString();
        String expected = "For whom the bells toll " +
                "\n";
        assertEquals(expected, actual);
    }

}