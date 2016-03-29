package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.controllers.InputAsker;
import com.twu.biblioteca.controllers.SlowPrinter;
import com.twu.biblioteca.models.ColorInventory;
import com.twu.biblioteca.models.Inventory;

public class BookCatalogue implements InputAsker {

    private Catalogue catalogue;
    private Inventory inventory;
    private Column column;
    private String resetColor = ColorInventory.getColor("RESET");
    private SlowPrinter printer;

    public BookCatalogue(Catalogue catalogue) {
        inventory = new Inventory();
        this.catalogue = new Catalogue(inventory);
        column = new Column();
        printer = new SlowPrinter();
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
        String information = "Returning to main menu......";
        System.out.println(line);
        printer.slowPrint(information, 50);
        return information;
    }

    public String defineBookMenuOutcome() {
        System.out.println("Please, select a choice from the menu above:");
        String input = ask();
        if (input.equals("checkout book")) {
            System.out.println("Please, write the title of the book you want to checkout");
            String titleToCheckout = ask();
            catalogue.checkoutBook(titleToCheckout);
            return informReturnToMainMenu();
        } else if (input.equals("return book")) {
            String titleToReturn = ask();
            catalogue.returnBook(titleToReturn);
            return informReturnToMainMenu();
        } else if (input.equals("main manu")) {
            return informReturnToMainMenu();
        }
        System.out.println("Invalid Option. Please, select a valid option!");
        return defineBookMenuOutcome();
    }

    @Override
    public String ask() {
        String input = scanner.nextLine().toLowerCase();
        return input;
    }
}
