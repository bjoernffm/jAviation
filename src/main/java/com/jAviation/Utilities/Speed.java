package com.jAviation.Utilities;

public class Speed {
    public enum Unit {
        MPS(1),
        KPH(3.6),
        KTS(1.94384);

        private double factor;

        private Unit(double factor) {
            this.factor = factor;
        }
    }

    // in mps
    private double value;

    public Speed(double value, Unit unit) {
        this.value = value / unit.factor;
    }

    public double toUnit(Unit unit) {
        return this.value * unit.factor;
    }

    @Override
    public String toString() {
        return "Speed{" +
                "value=" + Math.round(value*10)/10. +
                "mps}";
    }
}
