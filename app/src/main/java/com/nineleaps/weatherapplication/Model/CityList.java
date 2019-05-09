package com.nineleaps.weatherapplication.Model;

public class CityList {
    private int id;
    private String name,country;
    private Coord coord;

    public CityList() {

    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
