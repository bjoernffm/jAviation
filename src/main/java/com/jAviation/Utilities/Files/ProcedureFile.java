package com.jAviation.Utilities.Files;

import com.jAviation.Collections.ProcedureCollection;
import com.jAviation.Models.Airports.Airport;
import com.jAviation.Models.Airports.Procedures.Procedure;
import com.jAviation.Models.Airports.Procedures.Sid;
import com.jAviation.Models.Waypoint;
import com.jAviation.Utilities.GeoCalculator;
import com.jAviation.Utilities.Length;

import java.io.IOException;

public class ProcedureFile extends File {
    private ProcedureCollection procedures = new ProcedureCollection();
    private static NavaidsFile navaidsFile;

    public ProcedureFile(String filename, NavaidsFile navaidsFile) throws IOException {
        super(filename);
        this.navaidsFile = navaidsFile;
        this.parse();
    }

    public ProcedureCollection getProcedures() {
        return procedures;
    }

    private void parse() {
        Procedure procedure = null;

        for(String line: this.getLines()) {
            var parts = line.trim().split(",");

            if(parts[0].equals("SID")) {
                procedure = parseSidLine(parts);
                //System.out.println(procedure);
            } else if(parts[0].equals("CA")) {
                // ignore
            } else if(parts[0].equals("CF")) {
                procedure.addWaypoint(parseCourseToFixLine(parts));
            } else if(parts[0].equals("DF")) {
                procedure.addWaypoint(parseDirectToFixLine(parts));
            } else if(parts[0].equals("TF")) {
                procedure.addWaypoint(parseTrackBetweenFixLine(parts));
            } else if(parts[0].equals("CD")) {
                procedure.addWaypoint(parseCourseToDmeLine(parts));
            } else if(line.isEmpty()) {
                if (procedure != null) {
                    this.procedures.add(procedure);
                }
            } else {
                //throw new Error("Unknown modifier "+line);
            }
        }
    }

    private static Sid parseSidLine(String[] parts) {
        var name = parts[1];
        var runway = parts[2];

        return new Sid(name, runway);
    }

    private static Waypoint parseCourseToFixLine(String[] parts) {
        var identifier = parts[1];
        var lat = Double.parseDouble(parts[2]);
        var lon = Double.parseDouble(parts[3]);

        return new Waypoint(lat, lon, identifier, "");
    }

    private static Waypoint parseDirectToFixLine(String[] parts) {
        return parseCourseToFixLine(parts);
    }

    private static Waypoint parseTrackBetweenFixLine(String[] parts) {
        return parseCourseToFixLine(parts);
    }

    private static Waypoint parseCourseToDmeLine(String[] parts) {
        var identifier = parts[5];
        var direction = Double.parseDouble(parts[8]);
        var distance = new Length(Double.parseDouble(parts[9]), Length.Unit.NAUTICAL_MILE);

        var list = navaidsFile.getNavaids().getByIdentifier(identifier, "ED");
        var point = GeoCalculator.project(list.get(0), direction-3, distance);

        return new Waypoint(point.getLat(), point.getLon(), "FIX", "");
    }
}
