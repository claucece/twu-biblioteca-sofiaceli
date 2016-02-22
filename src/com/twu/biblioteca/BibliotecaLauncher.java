package com.twu.biblioteca;

public class BibliotecaLauncher {

    public static void main(String[] args) {
        Home home = new Home();
        home.printWelcomeMessage();
        System.out.println();
        home.printHomeLogo();
        System.out.println();
        home.printBreak();
        home.selectFromMenu();
        Menu menu = new Menu();
        menu.printMenu();
        home.printBreak();
        menu.getInputFromUser();

      }

}

