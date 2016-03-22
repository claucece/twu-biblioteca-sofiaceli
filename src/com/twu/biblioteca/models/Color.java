package com.twu.biblioteca.models;

public class Color {

    private volatile int hashCode;
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


    // this two classes override equal so the hash of the object it is not the thing compared but the object and its values
    // itself. Due to the fact that equals is being overriden, hashcode must be overriden as well. For this a nonzero
    // initial value is needed: the value 17 is arbitrary. The value 31 was chosen because it is an odd prime. It is
    // multiplied by the int value decimal to make it dependant yielding a much better hash function. The hash code is
    // cached as the class is inmutable.
//    @Override
//    public boolean equals(Object obj) {
//        if ((this.symbol == ((RomanNumber) obj).symbol) && (this.decimal == ((RomanNumber) obj).decimal) &&
//                (this.repeatable == ((RomanNumber) obj).repeatable) && (this.substractable == ((RomanNumber) obj).substractable)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public int hashCode() {
//        int result = hashCode;
//        if (result == 0) {
//            result = 17;
//            result = 31 * result + decimal;
//            // result = 31 * i == (i << 5) - i; This will be better. I think is handled by the VM.
//            hashCode = result;
//        }
//        return result;
//    }
//
}
