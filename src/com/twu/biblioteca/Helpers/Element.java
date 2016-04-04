package com.twu.biblioteca.helpers;

import com.twu.biblioteca.helpers.ElementSpec;

public abstract class Element {

    private static String id;
    private ElementSpec spec;

    public Element(ElementSpec spec) {
        this.spec = spec;
    }

    public String getId() {
        return id;
    }

    public ElementSpec getSpec() {
        return spec;
    }
}
