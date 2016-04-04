package com.twu.biblioteca.models;

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
