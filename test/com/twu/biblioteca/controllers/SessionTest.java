package com.twu.biblioteca.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SessionTest {

    private Session session;
    private UserFinder userFinder;

    @Before
    public void setUp() {
        userFinder = new UserFinder();
        session = new Session();
    }

    @Test
    public void methodAsksForChoiceOfUser() throws Exception {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    session.newSession(userFinder);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        t.join(1000);
        assertTrue(t.isAlive());
    }
}