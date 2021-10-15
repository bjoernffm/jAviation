package com.jAviation.Models.Airports;

import com.jAviation.Models.GeoPoint;
import com.jAviation.Models.GroundStation;
import com.jAviation.Utilities.Embedded.Length;
import com.jAviation.Utilities.Embedded.WindComponent;
import com.jAviation.Utilities.Embedded.WindVector;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

public class PairedRunway {
    private String identifier;
    private Runway start;
    private Runway end;
    private Length length;
    private Length width;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Runway getStart() {
        return start;
    }

    public void setStart(Runway start) {
        this.start = start;
    }

    public Runway getEnd() {
        return end;
    }

    public void setEnd(Runway end) {
        this.end = end;
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

    public static String getPairedIdentifierByRunway(Runway runway) {
        String reversedLetterSuffix = runway.getLetterSuffix();

        if(runway.getLetterSuffix().equals("L")) {
            reversedLetterSuffix = "R";
        } else if(runway.getLetterSuffix().equals("R")) {
            reversedLetterSuffix = "L";
        }

        if (runway.getNumber() <= 18) {
            return runway.getIdentifier() + "/" + (runway.getNumber()+18) + reversedLetterSuffix;
        } else {
            return String.format("%02d", runway.getNumber()-18) + reversedLetterSuffix + "/" + runway.getIdentifier();
        }
    }

    @Override
    public String toString() {
        return "PairedRunway{" +
                "identifier='" + identifier + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
