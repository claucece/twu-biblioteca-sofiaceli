package com.twu.biblioteca.models.movie;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.ElementsList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MovieInventory extends Inventory {

    private static List<Element> movies;
    private String name = "movie";

    public MovieInventory() {
        movies = new LinkedList<Element>();
        for (Element element : ElementsList.VALUES) {
            if (element.getClass() == Movie.class) {
                movies.add(element);
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Element> getList() {
        return movies;
    }

    public boolean isListEqualToInventory() {
        return Collections.disjoint(getList(), ElementsList.VALUES) && !(getList().isEmpty());
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
        for (Element movie : ElementsList.VALUES) {
            if (movie.getClass() == Movie.class) {
                movies.add(movie);
            }
        }
        return movies;
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("No available movies!");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}
