package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.controllers.InputAsker;
import com.twu.biblioteca.models.ColorInventory;

public class Menu implements InputAsker{

    private Column column;
    private BookCatalogue bookCatalogue;
    private Catalogue catalogue;
    private String resetColor = ColorInventory.getColor("RESET");

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

    public String printLineBreak() {
        String color = ColorInventory.getColor("CYAN");
        String breakLine = "===================================================";
        System.out.println(color + breakLine + resetColor);
        return breakLine;
    }

    public String defineOuput() {
        String input = ask();
            if (input.equals("list books")) {
                printLineBreak();
                bookCatalogue.printBookCatalogueMenu();
                bookCatalogue.defineBookMenuOutcome();
            } else if (input.equals("quit")) {
                return exit();
            } else {
                String error = "Select a valid option!";
                System.out.println(error);
            }
        return defineOuput();
    }

    @Override
    public String ask() {
        out.println("Please, select a choice");
        String input = scanner.nextLine().toLowerCase();
        return input;
    }

}
