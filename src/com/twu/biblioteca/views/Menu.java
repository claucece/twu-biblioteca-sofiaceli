package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.ListOfBooks;

import java.util.Scanner;

public class Menu {

    private Inventory bibliotecaInventory;
    private Column column;
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private ListOfBooks listOfBooks;
    private boolean keepGoing = false;
    private Catalogue catalogue;

    public Menu() {
        bibliotecaInventory = new Inventory();
        column = new Column();
        listOfBooks = new ListOfBooks();
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
        String heading4 = "Genre";
        column.addLine(heading1, heading2, heading3, heading4);
        String toPrint = column.toString();
        System.out.println(toPrint);
        return toPrint;
    }

    //public String processUserInput() {
    //    return input = getInputFromUser(new Scanner(System.in));
    //}

    public String getInputFromUser(Scanner scanner) {
        System.out.println("Please, select a choise");
        input = scanner.nextLine().toLowerCase();
        return input;
    }

    public String setScene() {
        String inputFromUser = getInputFromUser(scanner);
        if (inputFromUser.equals("list books")) {
            catalogue.getBookInformation(bibliotecaInventory);
            return setScene();
        }
        if (inputFromUser.equals("quit")) {
            String bye = "Thanks for your visit. Bye!";
            System.out.println(bye);
            return bye;
        } else {
            String error = "Select a valid option!";
            System.out.println(error);
            return setScene();
        }
    }

    // toreview and add test
    public boolean keepGoing() {
        return true;
    }

}
