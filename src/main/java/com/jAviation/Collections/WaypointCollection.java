package com.jAviation.Collections;

import com.jAviation.Models.Navaids.Navaid;
import com.jAviation.Models.Waypoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WaypointCollection extends ArrayList<Waypoint> {
    public List<Waypoint> getByIdentifier(String identifier, String countryCode) {
        return this
                .stream()
                .filter(c -> c.getIdentifier().equals(identifier) && c.getCountryCode().equals(countryCode))
                .collect(Collectors.toList());
    }
}
