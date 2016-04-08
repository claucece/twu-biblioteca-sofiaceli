package com.twu.biblioteca;

import com.twu.biblioteca.controllers.Session;
import com.twu.biblioteca.controllers.UserFinder;
import com.twu.biblioteca.views.AuthentificationMenu;
import com.twu.biblioteca.views.Home;

class BibliotecaLauncher {

    public static void main(String[] args) throws Exception {
        Home home = new Home();
        home.printWelcomeMessage();
        System.out.println();
        home.printHomeLogo();
        System.out.println();
        Session session = new Session();
        UserFinder userFinder = new UserFinder();
        AuthentificationMenu authentificationMenu = new AuthentificationMenu();
        authentificationMenu.defineTypeOfUser(userFinder);
    }

}

