package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.controllers.InputAsker;
import com.twu.biblioteca.models.Inventory;

public class Menu {

    private Inventory bibliotecaInventory;
    private Column column;
    private BookCatalogue bookCatalogue;
    private Catalogue catalogue;

    public Menu() {
        bibliotecaInventory = new Inventory();
        column = new Column();
        bookCatalogue = new BookCatalogue(catalogue);
    }

    public String printMenu() {
        String option1 = "--> List books  ";
        String option2 = "--> Search books  ";
        String option3 = "--> Quit  ";
        column.addLine(option1, option2, option3);
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
                return bookCatalogue.defineOuput1(asker);
                //bookCatalogue.returnCatalogue();
            } else if (input.equals("quit")) {
                return exit();
            } else {
                String error = "Select a valid option!";
                System.out.println(error);
            }
        return defineOuput(asker);
    }

}
