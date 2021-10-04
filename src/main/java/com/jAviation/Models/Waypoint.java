package com.jAviation.Models;

public class Waypoint extends GeoPoint {
    protected String identifier;
    protected String countryCode;

    public Waypoint(double lat, double lon, String identifier, String countryCode) {
        super(lat, lon);
        this.identifier = identifier;
        this.countryCode = countryCode;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", identifier='" + identifier + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
