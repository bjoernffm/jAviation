package com.jAviation.Models.Airports;

import com.jAviation.Collections.RunwayCollection;
import com.jAviation.Models.GroundStation;

public class Airport extends GroundStation {
    protected RunwayCollection runways = new RunwayCollection();

    public Airport(double lat, double lon, String identifier, String countryCode, String name, int elevation) {
        super(lat, lon, identifier, countryCode, name, elevation);
    }

    public RunwayCollection getRunways() {
        return runways;
    }
}
