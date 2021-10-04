package com.jAviation.Models;

import java.util.ArrayList;
import java.util.List;

public class Airway {
    protected String name;
    protected List<Waypoint> waypoints = new ArrayList<Waypoint>();

    public Airway(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Waypoint addWaypoint(Waypoint waypoint) {
        this.waypoints.add(waypoint);
        return waypoint;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }
}
