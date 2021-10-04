package com.jAviation.Models;

public abstract class GroundStation extends Waypoint {
    protected String name;
    protected int elevation;

    public GroundStation(double lat, double lon, String identifier, String countryCode, String name, int elevation) {
        super(lat, lon, identifier, countryCode);
        this.name = name;
        this.elevation = elevation;
    }

    public String getName() {
        return name;
    }

    public int getElevation() {
        return elevation;
    }

    @Override
    public String toString() {
        return "GroundStation{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", name='" + name + '\'' +
                ", elevation=" + elevation +
                ", identifier='" + identifier + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
