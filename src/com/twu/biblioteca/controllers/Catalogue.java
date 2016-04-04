package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.Element;

public interface Catalogue {

    String putInformationInColumns();

    boolean removeFromInventory(Element element);

    boolean isACheckout(String title);

    void addToInventory(Element element);

    boolean isAReturn(String title);

}
