package com.twu.biblioteca;

public class ListOfBooks {

    private Inventory bibliotecaInventory;

    public ListOfBooks() {
        bibliotecaInventory = new Inventory();
    }

    public Inventory setInventory(Inventory bibliotecaInventory) {
        this.bibliotecaInventory = bibliotecaInventory;
        return bibliotecaInventory;
    }

    public Inventory initializeInventory() {
        bibliotecaInventory.addBook(new Book("1", new BookSpec("For whom the bells toll", "Ernest Hemingway", "1980")));
        bibliotecaInventory.addBook(new Book("2", new BookSpec("Demian", "Herman Hesse", "1980")));
        bibliotecaInventory.addBook(new Book("3", new BookSpec("Moby Dick", "Herman Melville", "1980")));
        return bibliotecaInventory;
    }

    public String printBookInformation() {
        initializeInventory();
        return bibliotecaInventory.getBookInformation();
    }
}
