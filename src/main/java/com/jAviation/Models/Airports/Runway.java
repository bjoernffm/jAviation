package com.jAviation.Models.Airports;

import com.jAviation.Models.GroundStation;
import com.jAviation.Utilities.Length;
import com.jAviation.Utilities.WindComponent;
import com.jAviation.Utilities.WindVector;

public class Runway extends GroundStation {
    private Length length;
    private Length width;
    private int heading;

    public Runway(double lat, double lon, String identifier, String countryCode, String name, int elevation, Length length, Length width, int heading) {
        super(lat, lon, identifier, countryCode, name, elevation);
        this.length = length;
        this.width = width;
        this.heading = heading;
    }

    public Length getLength() {
        return length;
    }

    public Length getWidth() {
        return width;
    }

    public int getHeading() {
        return heading;
    }

    public WindComponent getWindComponent(WindVector windVector) {
        return new WindComponent(this.heading, windVector);
    }

    @Override
    public String toString() {
        return "Runway{" +
                "length=" + length +
                ", width=" + width +
                ", heading=" + heading +
                ", lat=" + lat +
                ", lon=" + lon +
                ", name='" + name + '\'' +
                ", elevation=" + elevation +
                ", identifier='" + identifier + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
