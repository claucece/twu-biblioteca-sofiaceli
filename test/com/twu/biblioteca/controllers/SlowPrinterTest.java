package com.twu.biblioteca.controllers;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class SlowPrinterTest {

    @Test(expected = InterruptedException.class)
    public void shouldCatchIfThreadIsInterrupted() throws InterruptedException {
        SlowPrinter printer = mock(SlowPrinter.class);
        String message = "Welcome";
        printer.slowPrint(message, 10);
        assertTrue(throwException());
    }

    private boolean throwException() throws InterruptedException {
        throw new InterruptedException();
    }

}