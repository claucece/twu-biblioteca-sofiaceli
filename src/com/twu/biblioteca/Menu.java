package com.twu.biblioteca;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Inventory bibliotecaInventory;
    private Columns column;
    private Scanner scanner = new Scanner(System.in);
    private String input;
    private ListOfBooks listOfBooks;
    private boolean keepGoing = false;

    public Menu() {
        bibliotecaInventory = new Inventory();
        column = new Columns();
        listOfBooks = new ListOfBooks();
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
        column.addLine(heading1, heading2, heading3);
        String toPrint = column.toString();
        System.out.println(toPrint);
        return toPrint;
    }

    //public String processUserInput() {
    //    return input = getInputFromUser(new Scanner(System.in));
    //}

    public String getInputFromUser(Scanner scanner) {
        System.out.println("Please, select a choise");
        input = scanner.nextLine();
        return input.toLowerCase();
    }

    public String setScene(String input) {
        keepGoing = true;
        while (keepGoing == true) {
            if (input.equals("list books")) {
                return listOfBooks.printBookInformation();
            } else if (input.equals("quit")) {
                String bye = "Thanks for your visit. Bye!";
                System.out.println(bye);
                keepGoing = false;
                return bye;
            } else {
                String error = "Select a valid option!";
                System.out.println(error);
                return error;
            }
        }
        return null;
    }

    public boolean keepGoing() {
        return true;
    }

}
