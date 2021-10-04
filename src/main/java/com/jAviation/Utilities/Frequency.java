package com.jAviation.Utilities;

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
    private double value;

    public Frequency(double value, Frequency.Unit unit) {
        this.value = value * unit.factor;
    }

    public double toUnit(Frequency.Unit unit) {
        return this.value / unit.factor;
    }

    @Override
    public String toString() {
        return "Frequency{" +
                "value=" + value +
                "Hz}";
    }
}
