package com.jAviation.Models.Navaids;

import com.jAviation.Models.GroundStation;
import com.jAviation.Utilities.Frequency;

public abstract class Navaid extends GroundStation {
    protected Frequency frequency;

    public Navaid(double lat, double lon, String identifier, String countryCode, String name, int elevation, Frequency frequency) {
        super(lat, lon, identifier, countryCode, name, elevation);
        this.frequency = frequency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "Navaid{" +
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
