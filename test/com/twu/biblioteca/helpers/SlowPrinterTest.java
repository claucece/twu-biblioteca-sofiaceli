package com.twu.biblioteca.helpers;

import com.twu.biblioteca.helpers.SlowPrinter;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class SlowPrinterTest {

    @Test(expected = InterruptedException.class)
    public void shouldCatchIfThreadIsInterrupted() throws InterruptedException {
        SlowPrinter printer = mock(SlowPrinter.class);
        String message = "Welcome";
        printer.printSlowly(message, 10);
        assertTrue(throwException());
    }

    private boolean throwException() throws InterruptedException {
        throw new InterruptedException();
    }

}