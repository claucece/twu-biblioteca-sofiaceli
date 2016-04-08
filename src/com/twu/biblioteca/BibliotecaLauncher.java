package com.twu.biblioteca;

import com.twu.biblioteca.views.AuthentificationMenu;
import com.twu.biblioteca.views.Home;

class BibliotecaLauncher {

    public static void main(String[] args) throws Exception {
        Home home = new Home();
        home.printWelcomeMessage();
        System.out.println();
        home.printHomeLogo();
        System.out.println();
        AuthentificationMenu authentificationMenu = new AuthentificationMenu();
        authentificationMenu.defineTypeOfUser();
        //home.selectFromMenu();
        //AnonymousUserMenu anonymousUserMenu = new AnonymousUserMenu();
        //anonymousUserMenu.printAnonymousUserMenu();
        //AuthetificatedUserMenu authetificatedUserMenu = new AuthetificatedUserMenu();
        //authetificatedUserMenu.defineTypeOfUser();
        //anonymousUserMenu.printAnonymousUserMenu();
    }

}

