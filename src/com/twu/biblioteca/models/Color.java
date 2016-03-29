package com.twu.biblioteca.models;

public class Color {

    private final String ansiEscape;
    private final String colorName;

    public static class Builder {
        private String ansiEscape = "\u001B[0m";
        private String colorName = "RESET";

        public Builder ansiSequence(String value) {
            ansiEscape = value;
            return this;
        }

        public Builder colorName(String value) {
            colorName = value;
            return this;
        }

        public Color build() {
            return new Color(this);
        }
    }

    Color(Builder builder) {
        ansiEscape = builder.ansiEscape;
        colorName = builder.colorName;
    }

    public String getAnsiEscape() {
        return ansiEscape;
    }

    public String getColorName() {
        return colorName;
    }

}
