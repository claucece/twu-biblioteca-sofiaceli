package com.twu.biblioteca.models.MovieModel;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.ListOfElements;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MovieInventory implements Inventory {

    private static List<Element> movies;

    private MovieInventory() {
        movies = new LinkedList<Element>();
        for (Element element : ListOfElements.VALUES) {
            if (element.getClass() == Movie.class) {
                movies.add(element);
            }
            //System.out.println(books);
        }
    }

    public static MovieInventory valueOf() {
        return new MovieInventory();
    }

    @Override
    public List<Element> getList() {
        return movies;
    }

    public boolean isListEqualToInventory() {
        return Collections.disjoint(getList(), ListOfElements.VALUES) && !(getList().isEmpty());
    }

    @Override
    public List<Element> returnInventoryOfElements() {
        if (isListEqualToInventory()) {
            addElement();
        } else if (getList().isEmpty()) {
            printError();
        }
        return movies;
    }

    @Override
    public List<Element> addElement() {
        for (Element movie : ListOfElements.VALUES) {
            if (movie.getClass() == Movie.class) {
                movies.add(movie);
            }
        }
        return movies;
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("No available books!");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}
