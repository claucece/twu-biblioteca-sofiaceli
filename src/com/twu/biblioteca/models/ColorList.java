package com.twu.biblioteca.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColorList {

    private static final Color[] PRIVATE_VALUES = {new Color.Builder().ansiSequence("\u001B[30m").colorName("BLACK").build(),
            new Color.Builder().ansiSequence("\u001B[31m").colorName("RED").build(),
            new Color.Builder().ansiSequence("\u001B[32m").colorName("GREEN").build(),
            new Color.Builder().ansiSequence("\u001B[33m").colorName("YELLOW").build(),
            new Color.Builder().ansiSequence("\u001B[34m").colorName("BLUE").build(),
            new Color.Builder().ansiSequence("\u001B[35m").colorName("PURPLE").build(),
            new Color.Builder().ansiSequence("\u001B[36m").colorName("CYAN").build(),
            new Color.Builder().ansiSequence("\u001B[37m").colorName("WHITE").build(),
            new Color.Builder().ansiSequence("\u001B[0m").colorName("RESET").build(),
            new Color.Builder().ansiSequence("\u001B[1m").colorName("BOLD").build(),
            new Color.Builder().ansiSequence("\u001B[7m").colorName("INVERT").build(),
    };

    public static final List<Color> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    public static String getColor(String colorName) {
        for (Color color : VALUES) {
            if (colorName.equals(color.getColorName()))
                return color.getAnsiEscape();
        }
        return "\u001B[0m";
    }

}
