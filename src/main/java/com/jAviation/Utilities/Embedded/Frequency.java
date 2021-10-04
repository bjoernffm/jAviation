package com.jAviation.Utilities.Embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Frequency {
    public enum Unit {
        Hz(1),
        KHz(1000),
        MHz(1000 * 1000);

        private int factor;

        private Unit(int factor) {
            this.factor = factor;
        }
    }

    // in Hz
    @Column(name = "frequency_in_hz")
    private double value;

    public Frequency() {

    }

    public Frequency(double value, Frequency.Unit unit) {
        this.value = value * unit.factor;
    }

    public double toUnit(Frequency.Unit unit) {
        return this.value / unit.factor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Frequency{" +
                "value=" + value +
                "Hz}";
    }
}
