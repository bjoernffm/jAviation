package com.jAviation.Models.Navaids;

import com.jAviation.Utilities.Frequency;

public class Ndb extends Navaid {
    public Ndb(double lat, double lon, String identifier, String countryCode, String name, int elevation, Frequency frequency) {
        super(lat, lon, identifier, countryCode, name, elevation, frequency);
    }

    @Override
    public String toString() {
        return "Ndb{" +
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
