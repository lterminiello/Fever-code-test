package com.lterminiello.ferverstar.model;

import android.graphics.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Area {

    SCIENCE("Science", Color.BLUE),
    COMMAND("Command", Color.RED),
    ENGINEERING("Engineering", Color.YELLOW);

    private static final Random RANDOM = new Random();
    private static final List<Area> VALUES =
        Collections.unmodifiableList(Arrays.asList(values()));

    private String name;
    private int color;

    Area(final String name, final int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public static Area randomArea() {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }
}
