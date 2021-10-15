package com.jAviation.Models;

import java.util.LinkedList;

public class Airway extends LinkedList<Waypoint> {
    protected String name;

    public Airway(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
