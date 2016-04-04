package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.models.BookModel.Book;
import com.twu.biblioteca.models.MovieModel.Movie;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Inventory implements ErrorPrinter {

    private static List<Element> books;
    private static List<Element> movies;

    private Inventory() {
        books = new LinkedList<Element>();
        movies = new LinkedList<Element>();
        for (Element element : ListOfBooks.VALUES) {
            if (element.getClass() == Book.class) {
                books.add(element);
            }
            else if (element.getClass() == Movie.class){
                movies.add(element);
            }
            //    System.out.println(books);
            }
        }

    public static Inventory valueOf() {
        return new Inventory();
    }

    public List<Element> getListOfBooks() {
        return books;
    }

    private boolean isListEqualToInventory() {
        return Collections.disjoint(getListOfBooks(), ListOfBooks.VALUES) && !(getListOfBooks().isEmpty());
    }

    public List<Element> returnInventoryOfBooks() {
        if (isListEqualToInventory()) {
            addBook();
        } else if (getListOfBooks().isEmpty()) {
            printError();
        }
        return books;
    }

    private List<Element> addBook() {
        for (Element book : ListOfBooks.VALUES) {
            if (book.getClass() == Book.class) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("No available books!");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}
