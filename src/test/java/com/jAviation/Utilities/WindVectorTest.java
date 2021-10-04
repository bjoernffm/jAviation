package com.jAviation.Utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WindVectorTest {

    @Test
    void getDirection() {
        var vector = new WindVector(320, new Speed(10, Speed.Unit.KTS));
        assertEquals(320, vector.getDirection());
    }

    @Test
    void getSpeed() {
        var vector = new WindVector(10, new Speed(20, Speed.Unit.KTS));
        assertEquals(20, vector.getSpeed().toUnit(Speed.Unit.KTS));
    }

    @Test
    void testToString() {
        var vector = new WindVector(37, new Speed(24, Speed.Unit.MPS));
        assertEquals("WindVector{direction=37.0, speed=Speed{value=24.0mps}}", vector.toString());
    }
}