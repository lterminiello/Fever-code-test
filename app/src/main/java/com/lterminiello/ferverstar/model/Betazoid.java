package com.lterminiello.ferverstar.model;

public class Betazoid extends Member {

    public Betazoid(final int id, final Area area) {
        super(id, area);
    }

    @Override
    public int getMultiplierRace() {
        switch (getArea()) {
        case ENGINEERING:
            return 3;
        case SCIENCE:
            return 2;
        case COMMAND:
            return 1;
        }
        return -1;
    }

    @Override
    public String getRaceName() {
        return "Betazoid";
    }
}
