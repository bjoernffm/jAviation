package com.jAviation.Utilities.Embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Length {
    public enum Unit {
        METER(1),
        KILOMETER(0.001),
        NAUTICAL_MILE(0.000539957),
        FEET(3.28084);

        private double factor;

        private Unit(double factor) {
            this.factor = factor;
        }
    }

    // in meter
    private double value;

    public Length() {

    }

    public Length(double value, Unit unit) {
        this.value = value / unit.factor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double toUnit(Unit unit) {
        return this.value * unit.factor;
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + Math.round(value*10)/10. +
                "m}";
    }
}
