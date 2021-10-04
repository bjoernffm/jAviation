package com.jAviation.Models.Airports;

import com.jAviation.Models.GroundStation;
import com.jAviation.Utilities.Embedded.Length;
import com.jAviation.Utilities.Embedded.WindComponent;
import com.jAviation.Utilities.Embedded.WindVector;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Runway extends GroundStation {
    @AttributeOverrides({
        @AttributeOverride(name="value",column=@Column(name="length_in_m"))
    })
    private Length length;
    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="width_in_m"))
    })
    private Length width;

    private int heading;

    public Runway() {

    }

    public Runway(double lat, double lon, String identifier, String countryCode, String name, int elevation, Length length, Length width, int heading) {
        super(lat, lon, identifier, countryCode, name, elevation);
        this.length = length;
        this.width = width;
        this.heading = heading;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    public Length getWidth() {
        return width;
    }

    public void setWidth(Length width) {
        this.width = width;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
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
