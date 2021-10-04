package com.jAviation.Utilities.Files;

import com.jAviation.Collections.AirportCollection;
import com.jAviation.Models.Airports.Airport;
import com.jAviation.Models.Airports.Runway;
import com.jAviation.Utilities.Length;

import java.io.IOException;

public class AirportsFile extends File {
    private AirportCollection airports = new AirportCollection();

    public AirportsFile(String filename) throws IOException {
        super(filename);
        this.parse();
    }

    private void parse() {
        Airport airport = null;

        for(String line: this.getLines()) {
            var parts = line.trim().split(",");

            if(parts[0].equals("A")) {
                if (airport != null) {
                    this.airports.add(airport);
                }

                airport = parseAirportLine(parts);
            } else if(parts[0].equals("R")) {
                airport.getRunways().add(parseRunwayLine(parts));
            }
        }

        this.airports.add(airport);
    }

    private static Airport parseAirportLine(String[] parts) {
        var lat = Double.parseDouble(parts[3]);
        var lon = Double.parseDouble(parts[4]);
        var identifier = parts[1];
        var countryCode = "EMPTY";
        var name = parts[2];
        var elevation = Integer.parseInt(parts[5]);

        return new Airport(lat, lon, identifier, countryCode, name, elevation);
    }

    private static Runway parseRunwayLine(String[] parts) {
        var lat = Double.parseDouble(parts[8]);
        var lon = Double.parseDouble(parts[9]);
        var identifier = parts[1];
        var countryCode = "EMPTY";
        var name = "R"+parts[1];
        var elevation = Integer.parseInt(parts[10]);
        var length = new Length(Double.parseDouble(parts[3]), Length.Unit.FEET);
        var width = new Length(Double.parseDouble(parts[4]), Length.Unit.FEET);
        var heading = Integer.parseInt(parts[2]);

        return new Runway(lat, lon, identifier, countryCode, name, elevation, length, width, heading);
    }

    public AirportCollection getAirports() {
        return airports;
    }
}
