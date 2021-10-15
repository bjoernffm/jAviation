package com.jAviation.Models.Airports;

import com.jAviation.Models.GroundStation;
import com.jAviation.Utilities.Embedded.Vector;
import com.jAviation.Utilities.GeoCalculator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Airport extends GroundStation {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    protected List<Runway> runways = new ArrayList<>();

    public Airport() {

    }

    public Airport(double lat, double lon, String identifier, String countryCode, String name, int elevation) {
        super(lat, lon, identifier, countryCode, name, elevation);
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public List<PairedRunway> getPairedRunways() {
        Map<String, PairedRunway> pairedRunways = new HashMap<String, PairedRunway>();

        // initial creation of paired runways
        for(Runway runway: runways) {
            String pairedIdentifier = PairedRunway.getPairedIdentifierByRunway(runway);
            PairedRunway pairedRunway = new PairedRunway();
            pairedRunway.setIdentifier(pairedIdentifier);
            pairedRunway.setLength(runway.getLength());
            pairedRunway.setWidth(runway.getWidth());

            if(pairedRunways.containsKey(pairedIdentifier)) {
                pairedRunway = pairedRunways.get(pairedIdentifier);
            }

            if (runway.getNumber() <= 18) {
                pairedRunway.setStart(runway);
            } else {
                pairedRunway.setEnd(runway);
            }

            pairedRunways.put(pairedIdentifier, pairedRunway);
        }

        // calculate mean variation
        double variationSum = 0;
        int variationSize = 0;
        List<Double> variations = new ArrayList<Double>();
        for(PairedRunway pairedRunway: pairedRunways.values()) {
            if(pairedRunway.getStart() != null && pairedRunway.getEnd() != null) {
                var vector = GeoCalculator.getVector(pairedRunway.getStart(), pairedRunway.getEnd());
                variationSum += (vector.getDirection() - pairedRunway.getStart().getHeading());
                variationSize++;
            }
        }
        double meanVariation = variationSum / variationSize;

        // recalculate missing points
        for(PairedRunway pairedRunway: pairedRunways.values()) {
            if(pairedRunway.getStart() == null && pairedRunway.getEnd() != null) {
                var start = GeoCalculator.project(pairedRunway.getEnd(), new Vector(pairedRunway.getEnd().getHeading()+meanVariation, pairedRunway.getEnd().getLength()));
                var runway = new Runway();
                runway.setLat(start.getLat());
                runway.setLon(start.getLon());
                pairedRunway.setStart(runway);
                System.out.println(pairedRunway.getEnd().toDecimal());
                System.out.println(pairedRunway.getStart().toDecimal());
            } else if(pairedRunway.getStart() != null && pairedRunway.getEnd() == null) {
                var end = GeoCalculator.project(pairedRunway.getStart(), new Vector(pairedRunway.getStart().getHeading()+meanVariation, pairedRunway.getStart().getLength()));
                var runway = new Runway();
                runway.setLat(end.getLat());
                runway.setLon(end.getLon());
                pairedRunway.setEnd(runway);
                System.out.println(pairedRunway.getEnd().toDecimal());
                System.out.println(pairedRunway.getStart().toDecimal());
            }
        }

        return new ArrayList<PairedRunway>(pairedRunways.values());
    }

    public void setRunways(List<Runway> runways) {
        this.runways = runways;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "runways=" + runways +
                ", lat=" + lat +
                ", lon=" + lon +
                ", name='" + name + '\'' +
                ", elevation=" + elevation +
                ", id=" + id +
                ", identifier='" + identifier + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
