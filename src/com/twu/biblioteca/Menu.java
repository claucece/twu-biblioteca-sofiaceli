package com.twu.biblioteca;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Inventory bibliotecaInventory;
    //private List<String> bookList;
    private Columns column;
    private Book book = new Book("one", new BookSpec("For whom the bells toll", "Ernest Hemingway", 1980));

    public Menu() {
        bibliotecaInventory = new Inventory();
        //bookList = new ArrayList<String>();
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

    public String printListOfBooks() {
        String title = book.getSpec().getTitle();
        String author = book.getSpec().getAuthor();
        String published_year = "lo";
        column.addLine(title, author, published_year);
        String toPrint = column.toString();
        return toPrint;
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
        inventory.addBook(new Book("one", new BookSpec("For whom the bells toll", "Ernest Hemingway", 1980)));
        inventory.addBook(new Book("two", new BookSpec("bla", "Herman Hesse", 1990)));
        return inventory;
    }

    public Inventory getAllBooks() {
        getAllBooks();
        return bibliotecaInventory;
    }


}
