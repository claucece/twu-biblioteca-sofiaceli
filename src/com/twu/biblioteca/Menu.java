package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    private Inventory bibliotecaInventory;
    private Columns column;
    private Book book = new Book("one", new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980"));
    ArrayList<Book> listOfBooks;
    Scanner input = new Scanner(System.in);

    public Menu() {
        bibliotecaInventory = new Inventory();
        column = new Columns();
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


    public String getInputFromUser() {
        System.out.println("Enter your choise:");
        String choise = input.nextLine();
        return choise;
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

    public Inventory setInventory(Inventory bibliotecaInventory) {
        this.bibliotecaInventory = bibliotecaInventory;
        return bibliotecaInventory;
    }

    public ArrayList<Book> initializeInventory() {
        Book book1 = bibliotecaInventory.addBook(new Book("1", new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980")));
        Book book2 = bibliotecaInventory.addBook(new Book("2", new BookSpec("Demian", "Herman Hesse", "1980")));
        Book book3 = bibliotecaInventory.addBook(new Book("3", new BookSpec("Moby Dick", "Herman Melville", "1980")));
        listOfBooks = new ArrayList<Book>(Arrays.asList(book1, book2, book3));
        return listOfBooks;
    }

    public String printBookInformation() {
        initializeInventory();
        String columns = null;
        for (Book book : listOfBooks) {
             columns = bibliotecaInventory.getBookInformation(book);
        }
        return columns;
    }


}
