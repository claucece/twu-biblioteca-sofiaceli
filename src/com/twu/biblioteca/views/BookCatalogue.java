package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.controllers.InputAsker;
import com.twu.biblioteca.models.ColorInventory;
import com.twu.biblioteca.models.Inventory;

public class BookCatalogue {

    private Catalogue catalogue;
    private Inventory inventory;
    private Column column;
    private String resetColor = ColorInventory.getColor("RESET");

    public BookCatalogue(Catalogue catalogue) {
        inventory = new Inventory();
        this.catalogue = new Catalogue(inventory);
        column = new Column();
    }

    public String returnCatalogue() {
        System.out.println(catalogue.getBookInformation());
        return catalogue.getBookInformation();
    }

    public String printBookCatalogueMenu() {
        returnCatalogue();
        String color = ColorInventory.getColor("INVERT");
        String option1 = "--> Checkout Book  ";
        String option2 = "--> Return Book  ";
        String option3 = "--> Return To Main Menu  ";
        column.addLine(option1, option2, option3);
        String toBookMenu = column.toString();
        System.out.println(color + toBookMenu + resetColor);
        return toBookMenu;
    }

    public String writeBookName() {
        String bookTitle = "Please, write a book title";
        System.out.println(bookTitle);
        return bookTitle;
    }

    public String informReturnToMainMenu() {
        String line = "-------------";
        String information = "Returning to main menu...";
        System.out.println(line + "\n" + information);
        return information;
    }

    public String defineBookMenuOutcome(InputAsker asker) {
        String input = asker.ask();
        if (input.equals("checkout book")) {
            String titleToCheckout = asker.ask();
            catalogue.checkoutBook(titleToCheckout);
            return informReturnToMainMenu();
        } else if (input.equals("return book")) {
            String titleToReturn = asker.ask();
            catalogue.returnBook(titleToReturn);
            return informReturnToMainMenu();
        } else if (input.equals("main manu")) {
            return informReturnToMainMenu();
        }
        System.out.println("Invalid Option. Please, select a valid option!");
        return defineBookMenuOutcome(asker);
    }
}
