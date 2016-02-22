package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    private Inventory bibliotecaInventory;
    private Columns column;
    private Book book = new Book("one", new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980"));
    ArrayList<Book> listOfBooks;

    public Menu() {
        bibliotecaInventory = new Inventory();
        column = new Columns();
    }

    public String printWelcomeMessage() {
        String welcome = "Hello and welcome to 'Menu', the Library Management " +
                "System from The Bangalore Public Library!" +
                "Keep reading to see the lists of books available";
        System.out.print(welcome);
        return welcome;
    }

    public String printHeader() {
        String heading1 = "Book_name";
        String heading2 = "Author_name";
        String heading3 = "Published_Year";
        column.addLine(heading1, heading2, heading3);
        String toPrint = column.toString();
        return toPrint;
    }

    public ArrayList<Book> addBooks() {
        Book book1 = bibliotecaInventory.addBook(new Book("1", new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980")));
        Book book2 = bibliotecaInventory.addBook(new Book("2", new BookSpec("Demian", "Herman Hesse", "1980")));
        Book book3 = bibliotecaInventory.addBook(new Book("3", new BookSpec("Moby Dick", "Herman Melville", "1980")));
        listOfBooks = new ArrayList<Book>(Arrays.asList(book1, book2, book3));
        return listOfBooks;
    }

    public ArrayList<Book> printBookInformation() {
        addBooks();
        for (Book book : listOfBooks) {
            bibliotecaInventory.getBookInformation(book);
        }
        return listOfBooks;
    }

    //public List<String> listBooks(List<String> bookList) {
    //    bookList.add("For whom the bell tolls, Ernest Hemmingway, 1930");
    //    bookList.add("Waiting for Godot, Samuel Beckett, 1940");
    //    return bookList;
    //}

    //public List<String> getBooks() {
    //    listBooks(bookList);
    //    for (String book : bookList) {
    //        System.out.println(book);
    //    }
    //    return bookList;
    //}

    public Inventory setInventory(Inventory bibliotecaInventory) {
        this.bibliotecaInventory = bibliotecaInventory;
        return bibliotecaInventory;
    }

    public Inventory initializeInventory(Inventory inventory) {
        inventory.addBook(new Book("one", new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980")));
        inventory.addBook(new Book("two", new BookSpec("bla", "Herman Hesse", "1990")));
        return inventory;
    }

    public Inventory getAllBooks() {
        getAllBooks();
        return bibliotecaInventory;
    }


}
