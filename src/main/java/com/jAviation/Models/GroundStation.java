package com.jAviation.Models;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GroundStation extends Waypoint {
    protected String name;
    protected int elevation;

    public GroundStation() {

    }

    public GroundStation(double lat, double lon, String identifier, String countryCode, String name, int elevation) {
        super(lat, lon, identifier, countryCode);
        this.name = name;
        this.elevation = elevation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
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
