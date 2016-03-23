package com.twu.biblioteca;

import com.twu.biblioteca.views.Home;
import com.twu.biblioteca.views.Menu;

import java.util.Scanner;

public class BibliotecaLauncher {

    public static void main(String[] args) {
        Home home = new Home();
        home.printWelcomeMessage();
        System.out.println();
        home.printHomeLogo();
        System.out.println();
        home.printLineBreak();
        home.selectFromMenu();
        Menu menu = new Menu();
        menu.printMenu();
        home.printLineBreak();
        menu.setScene();

    }

}

