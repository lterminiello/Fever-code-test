package com.lterminiello.ferverstar.model;

public class Human extends Member {

    public Human(final int id, final Area area) {
        super(id, area);
    }

    @Override
    public int getMultiplierRace() {
        switch (getArea()) {
        case COMMAND:
            return 3;
        case ENGINEERING:
            return 2;
        case SCIENCE:
            return 1;
        }
        return -1;
    }

    @Override
    public String getRaceName() {
        return "Human";
    }
}
