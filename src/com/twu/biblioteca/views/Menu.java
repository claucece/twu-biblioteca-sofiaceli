package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.controllers.InputAsker;
import com.twu.biblioteca.models.Inventory;

public class Menu {

    private Inventory bibliotecaInventory;
    private Column column;
    private Catalogue catalogue;

    public Menu() {
        bibliotecaInventory = new Inventory();
        column = new Column();
        catalogue = new Catalogue();
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

    public String printHeader() {
        String heading1 = "Book_name";
        String heading2 = "Author_name";
        String heading3 = "Published_Year";
        String heading4 = "Book_genre";
        column.addLine(heading1, heading2, heading3);
        String toPrint = column.toString();
        System.out.println(toPrint);
        return toPrint;
    }

    public String exit() {
        String bye = "Thanks for your visit. Bye!";
        System.out.println(bye);
        return bye;
    }

    public String setScene(InputAsker asker) {
        String input = asker.ask();
        if (input.equals("list books")) {
            catalogue.getBookInformation(bibliotecaInventory);
        } else if (input.equals("quit")) {
            return exit();
        } else {
            String error = "Select a valid option!";
            System.out.println(error);
        }
        return setScene(asker);
    }

    // to review and add test
    public boolean keepGoing() {
        return true;
    }


}
