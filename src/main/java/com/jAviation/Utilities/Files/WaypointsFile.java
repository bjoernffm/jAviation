package com.jAviation.Utilities.Files;

import com.jAviation.Collections.WaypointCollection;
import com.jAviation.Models.Waypoint;

import java.io.IOException;

public class WaypointsFile extends File {
    private WaypointCollection waypoints = new WaypointCollection();

    public WaypointsFile(String filename) throws IOException {
        super(filename);
        this.parse();
    }

    public WaypointCollection getWaypoints() {
        return waypoints;
    }

    private void parse() {
        for(String line: this.getLines()) {
            var parts = line.trim().split(",");

            var lat = Double.parseDouble(parts[1]);
            var lon = Double.parseDouble(parts[2]);
            var identifier = parts[0];
            var countryCode = "";
            try {
                countryCode = parts[3].trim();
            } catch (Exception e) {
            }

            waypoints.add(new Waypoint(lat, lon, identifier, countryCode));
        }
    }
}
