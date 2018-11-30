package com.lterminiello.ferverstar.model;

public class Vulcan extends Member {

    public Vulcan(final int id, final Area area) {
        super(id, area);
    }

    @Override
    public int getMultiplierRace() {
        switch (getArea()) {
        case SCIENCE:
            return 3;
        case COMMAND:
            return 2;
        case ENGINEERING:
            return 1;
        }
        return -1;
    }

    @Override
    public String getRaceName() {
        return "Vulcan";
    }
}
