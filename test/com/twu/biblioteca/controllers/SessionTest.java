package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SessionTest {

    private Session session;
    private UserFinder userFinder;
    private User user = new User.Builder().libraryNumber("001-0001").password("loop").name("Klaus").emailAdress("klaus@leap.se").phoneNumber("123-123").build();

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