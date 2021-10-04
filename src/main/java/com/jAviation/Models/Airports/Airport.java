package com.jAviation.Models.Airports;

import com.jAviation.Collections.RunwayCollection;
import com.jAviation.Models.GroundStation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
