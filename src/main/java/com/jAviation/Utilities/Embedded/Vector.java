package com.jAviation.Utilities.Embedded;

import com.jAviation.Utilities.Embedded.Length;

public class Vector {
    private double direction;
    private Length length;

    public Vector(double direction, Length length) {
        this.direction = direction;
        this.length = length;
    }

    public double getDirection() {
        return direction;
    }

    public Length getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "direction=" + direction +
                ", length=" + length +
                '}';
    }
}
