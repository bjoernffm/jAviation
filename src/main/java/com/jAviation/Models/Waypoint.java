package com.jAviation.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Waypoint extends GeoPoint {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    protected long id;

    protected String identifier;
    protected String countryCode;

    public Waypoint() {

    }

    public Waypoint(double lat, double lon, String identifier, String countryCode) {
        super(lat, lon);
        this.identifier = identifier;
        this.countryCode = countryCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
