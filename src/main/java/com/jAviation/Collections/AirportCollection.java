package com.jAviation.Collections;

import com.jAviation.Models.Airports.Airport;

import java.util.HashMap;

public class AirportCollection extends HashMap<String, Airport> {
    public Airport add(Airport airport) {
        this.put(airport.getIdentifier(), airport);

        return airport;
    }
}
