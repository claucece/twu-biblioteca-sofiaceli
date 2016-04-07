package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionTest {

    private Session session;
    private Session secondSession;
    private UserFinder userFinder;

    @Test
    public void shouldCreateSessionIfUserParamsAreValid() throws Exception {
        InputAsker asker = mock(InputAsker.class);
        InputAsker secondAsker = mock(InputAsker.class);
        session = new Session();
        when(asker.ask()).thenReturn("forloop");
        when(secondAsker.ask()).thenReturn("001-0001");
        assertEquals(session.newSession(secondAsker, asker), "User authenticated. New session created.");
    }

//    @Test
//    public void shouldNotCreateSessionIfUserParamsAreNotValid() throws Exception {
//        session = new Session();
//        InputAsker asker = mock(InputAsker.class);
//        when(asker.ask()).thenReturn("001-0006");
//        assertEquals(session.newSession(asker), "User not authenticated. New session not created.");
//    }
}