package com.twu.biblioteca;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Inventory {

    private List<Book> books;
    private Book book;
    private BookSpec bookspec;
    private String id;

    public Inventory() {
        books = new LinkedList<Book>();
        book = new Book(id, bookspec);
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> addBook(BookSpec spec) {
        books.add(book);
        return books;
    }

    public Book getBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    //public List<DogPet> search(DogPetSpec searchSpec) {
    //    List<DogPet> matchingDogs = new LinkedList<>();
    //    for (DogPet i : dogs) { //for-each loop. Looks better.
    //        DogPet dog = i;
    //        if (dog.getSpec().matches(searchSpec))
    //            matchingDogs.add(dog);
    //    }
    //    return matchingDogs;
    //}


}
