package com.jAviation.Utilities;

public class WindVector {
    private double direction;
    private Speed speed;

    public WindVector(double direction, Speed speed) {
        this.direction = direction;
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public Speed getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "WindVector{" +
                "direction=" + direction +
                ", speed=" + speed +
                '}';
    }
}
