package com.jAviation.Models.Navaids;

import com.jAviation.Utilities.Embedded.Frequency;

import javax.persistence.Entity;

@Entity
public class Vor extends Navaid {
    public Vor() {

    }

    public Vor(double lat, double lon, String identifier, String countryCode, String name, int elevation, Frequency frequency) {
        super(lat, lon, identifier, countryCode, name, elevation, frequency);
    }

    @Override
    public String toString() {
        return "Vor{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", name='" + name + '\'' +
                ", elevation=" + elevation +
                ", frequency=" + frequency +
                ", identifier='" + identifier + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
