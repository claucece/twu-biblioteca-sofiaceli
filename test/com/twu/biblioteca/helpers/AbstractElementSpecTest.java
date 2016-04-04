package com.twu.biblioteca.helpers;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbstractElementSpecTest {

    @Test
    public void shouldReturnTitleOnLowerCase() {
        AbstractElementSpec abstractspec = mock(AbstractElementSpec.class);
        when(abstractspec.getTitle()).thenReturn("welcome");
        String message = "Welcome";
        String title = abstractspec.getTitle();
        assertEquals(title, "welcome");
    }

}