package com.twu.biblioteca.views;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AuthentificationMenuTest {


    private AuthentificationMenu authetificationMenu;

    @Before
    public void setUp() {
        authetificationMenu = new AuthentificationMenu();
    }

    @Test
    public void methodAsksForKindOfUser() throws Exception {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    authetificationMenu.defineTypeOfUser();
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