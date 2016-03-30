package com.twu.biblioteca;

import com.twu.biblioteca.views.Home;
import com.twu.biblioteca.views.Menu;

class BibliotecaLauncher {

    public static void main(String[] args) {
        Home home = new Home();
        home.printWelcomeMessage();
        System.out.println();
        home.printHomeLogo();
        System.out.println();
        home.selectFromMenu();
        Menu menu = new Menu();
        menu.toLineColumn();
        menu.defineOuput();
    }

}

