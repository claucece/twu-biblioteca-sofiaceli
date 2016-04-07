package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionTest {

    private Session session;
    private UserFinder userFinder;

    @Test
    public void shouldCreateSessionIfUserParamsAreValid() {
        session = new Session();
        InputAsker asker = mock(InputAsker.class);
        when(asker.ask()).thenReturn("001-0001");
        assertEquals(session.newSession(asker), "User authenticated. New session created.");
    }

    @Test
    public void shouldNotCreateSessionIfUserParamsAreNotValid() {
        session = new Session();
        InputAsker asker = mock(InputAsker.class);
        when(asker.ask()).thenReturn("001-0006");
        assertEquals(session.newSession(asker), "User not authenticated. New session not created.");
    }
}