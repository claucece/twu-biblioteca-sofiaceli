package com.twu.biblioteca.controllers;

import org.junit.Test;

import org.mockito.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SlowPrinterTest {

    @Test(expected = InterruptedException.class)
    public void shouldCatchIfThreadIsInterrupted() throws InterruptedException {
        SlowPrinter printer = mock(SlowPrinter.class);
        String message = "Welcome";
        when(printer.slowPrint(message, 30)).thenThrow(InterruptedException.class);
        assertTrue(throwException());
    }

    private boolean throwException() throws InterruptedException {
        throw new InterruptedException();
    }

}