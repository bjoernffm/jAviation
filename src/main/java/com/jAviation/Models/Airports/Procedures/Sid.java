package com.jAviation.Models.Airports.Procedures;

import com.jAviation.Models.Waypoint;

public class Sid extends Procedure {
    private String runway;

    public Sid(String name, String runway) {
        super(name);
        this.runway = runway;
    }

    public String getRunway() {
        return runway;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();

        /*for(Waypoint wp: this.waypoints) {
            sb.append(wp.getIdentifier()+" ");
        }*/
        return "Sid{" +
                "name='" + name + '\'' +
                ", runway='" + runway + '\'' +
                ", waypoints='" + sb.substring(0, sb.length()-1).toString() + '\'' +
                '}';
    }
}
