package com.twu.biblioteca.controllers;

public class SessionTest {

    private Session session;
    private Session secondSession;
    private UserFinder userFinder;

//    @Test
//    public void shouldCreateSessionIfUserParamsAreValid() throws Exception {
//        InputAsker asker = mock(InputAsker.class);
//        InputAsker secondAsker = mock(InputAsker.class);
//        session = new Session();
//        when(asker.ask()).thenReturn("forloop");
//        when(secondAsker.ask()).thenReturn("001-0001");
//        assertEquals(session.newSession(secondAsker, asker), "User authenticated. New session created.");
//    }
//
//    @Test
//    public void shouldNotCreateSessionIfUserParamsAreNotValid() throws Exception {
//        InputAsker asker = mock(InputAsker.class);
//        InputAsker secondAsker = mock(InputAsker.class);
//        session = new Session();
//        when(asker.ask()).thenReturn("forlooplop");
//        when(secondAsker.ask()).thenReturn("001-0001");
//        assertEquals(session.newSession(asker, secondAsker), "User not authenticated. New session not created.");
//    }
}