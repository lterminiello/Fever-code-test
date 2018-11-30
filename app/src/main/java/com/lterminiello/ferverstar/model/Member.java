package com.lterminiello.ferverstar.model;

public abstract class Member {

    private int id;
    private Area area;

    public Member(final int id, final Area area) {
        this.id = id;
        this.area = area;
    }

    public abstract int getMultiplierRace();

    public abstract String getRaceName();


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(final Area area) {
        this.area = area;
    }
}
