package com.jAviation.Utilities.Files;

import com.jAviation.Collections.WaypointCollection;
import com.jAviation.Models.Navaids.*;
import com.jAviation.Utilities.Embedded.Frequency;

import java.io.IOException;

public class NavaidsFile extends File {
    private WaypointCollection navaids = new WaypointCollection();

    public NavaidsFile(String filename) throws IOException {
        super(filename);
        this.parse();
    }

    public WaypointCollection getNavaids() {
        return navaids;
    }

    private void parse() {
        for(String line: this.getLines()) {
            var parts = line.trim().split(",");

            var lat = Double.parseDouble(parts[6]);
            var lon = Double.parseDouble(parts[7]);
            var identifier = parts[0];
            var countryCode = parts[9];
            var name = parts[1];
            var elevation = Integer.parseInt(parts[8]);
            var frequency = Double.parseDouble(parts[2]);

            if(parts[3].equals("0") && parts[4].equals("0")) {
                // no radial and no dme capability
                navaids.add(new Ndb(lat, lon, identifier, countryCode, name, elevation, new Frequency(frequency, Frequency.Unit.KHz)));

            } else if(parts[3].equals("1") && parts[4].equals("0")) {
                // radial and no dme capability
                navaids.add(new Vor(lat, lon, identifier, countryCode, name, elevation, new Frequency(frequency, Frequency.Unit.MHz)));

            } else if(parts[3].equals("0") && parts[4].equals("1")) {
                // no radial and dme capability
                navaids.add(new Dme(lat, lon, identifier, countryCode, name, elevation, new Frequency(frequency, Frequency.Unit.MHz)));

            } else if(parts[3].equals("1") && parts[4].equals("1")) {
                // radial and dme capability
                navaids.add(new VorDme(lat, lon, identifier, countryCode, name, elevation, new Frequency(frequency, Frequency.Unit.MHz)));
            } else {
                throw new Error("Unknown modifier "+line);
            }
        }
    }
}
