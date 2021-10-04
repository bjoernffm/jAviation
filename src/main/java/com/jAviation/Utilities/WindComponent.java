package com.jAviation.Utilities;

public class WindComponent {
    private double heading;
    private WindVector windVector;

    public WindComponent(double heading, WindVector windVector) {
        this.heading = heading;
        this.windVector = windVector;
    }

    public double getHeading() {
        return heading;
    }

    public WindVector getWindVector() {
        return windVector;
    }

    public Speed getHeadwindSpeed() {
        var factor = Math.cos(Math.toRadians(this.windVector.getDirection() - this.heading));
        var speed = this.windVector.getSpeed().toUnit(Speed.Unit.MPS);

        return new Speed(factor * speed, Speed.Unit.MPS);
    }

    public Speed getCrosswindSpeed() {
        var factor = Math.sin(Math.toRadians(this.windVector.getDirection() - this.heading));
        var speed = this.windVector.getSpeed().toUnit(Speed.Unit.MPS);

        return new Speed(factor * speed, Speed.Unit.MPS);
    }

    public boolean hasHeadwind() {
        return (this.getHeadwindSpeed().toUnit(Speed.Unit.MPS) >= 0);
    }

    public boolean hasBackwind() {
        return (this.getHeadwindSpeed().toUnit(Speed.Unit.MPS) < 0);
    }

    public boolean hasLeftCrosswind() {
        return (this.getCrosswindSpeed().toUnit(Speed.Unit.MPS) < 0);
    }

    public boolean hasRightCrosswind() {
        return (this.getCrosswindSpeed().toUnit(Speed.Unit.MPS) > 0);
    }

    public boolean hasCrosswind() {
        return (this.getCrosswindSpeed().toUnit(Speed.Unit.MPS) != 0);
    }

    @Override
    public String toString() {
        return "WindComponent{" +
                "heading=" + heading +
                ", windVector=" + windVector +
                '}';
    }
}
