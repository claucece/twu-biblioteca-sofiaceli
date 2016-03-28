package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.controllers.InputAsker;

public class Menu {

    private Column column;
    private BookCatalogue bookCatalogue;
    private Catalogue catalogue;

    public Menu() {
        column = new Column();
        bookCatalogue = new BookCatalogue(catalogue);
    }

    public String printMenu() {
        String option1 = "--> List books  ";
        String option2 = "--> Quit  ";
        column.addLine(option1, option2);
        String toMenu = column.toString();
        System.out.println(toMenu);
        return toMenu;
    }

    public String exit() {
        String bye = "Thanks for your visit. Bye!";
        System.out.println(bye);
        return bye;
    }

    public String defineOuput(InputAsker asker) {
        String input = asker.ask();
            if (input.equals("list books")) {
                bookCatalogue.printBookCatalogueMenu();
                bookCatalogue.defineBookMenuOutcome(asker);
            } else if (input.equals("quit")) {
                return exit();
            } else {
                String error = "Select a valid option!";
                System.out.println(error);
            }
        return defineOuput(asker);
    }

}
