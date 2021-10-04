package com.jAviation.Utilities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WindComponentTest {

    WindComponent windComponent1;
    WindComponent windComponent2;

    @BeforeEach
    void setUp() {
        windComponent1 = new WindComponent(90, new WindVector(120, new Speed(27, Speed.Unit.KTS)));
        windComponent2 = new WindComponent(270, new WindVector(120, new Speed(27, Speed.Unit.KTS)));
    }

    @Test
    void getHeading() {
        assertEquals(90, windComponent1.getHeading());
    }

    @Test
    void getWindVector() {
        assertEquals(120, windComponent1.getWindVector().getDirection());
        assertEquals(27, windComponent1.getWindVector().getSpeed().toUnit(Speed.Unit.KTS));
    }

    @Test
    void hasHeadwind() {
        assertEquals(true, windComponent1.hasHeadwind());
        assertEquals(false, windComponent2.hasHeadwind());
    }

    @Test
    void hasBackwind() {
        assertEquals(false, windComponent1.hasBackwind());
        assertEquals(true, windComponent2.hasBackwind());
    }

    @Test
    void hasLeftCrosswind() {
        assertEquals(false, windComponent1.hasLeftCrosswind());
        assertEquals(true, windComponent2.hasLeftCrosswind());
    }

    @Test
    void hasRightCrosswind() {
        assertEquals(true, windComponent1.hasRightCrosswind());
        assertEquals(false, windComponent2.hasRightCrosswind());
    }

    @Test
    void hasCrosswind() {
        assertEquals(true, windComponent1.hasCrosswind());
        assertEquals(true, windComponent2.hasCrosswind());
    }

    @Test
    void testToString() {
        assertEquals("WindComponent{heading=90.0, windVector=WindVector{direction=120.0, speed=Speed{value=13.9mps}}}", windComponent1.toString());
    }

    @Test
    void getHeadwindSpeed() {
        var windComponent = new WindComponent(0, new WindVector(0, new Speed(10, Speed.Unit.MPS)));
        assertEquals(10, windComponent.getHeadwindSpeed().toUnit(Speed.Unit.MPS));

        windComponent = new WindComponent(0, new WindVector(90, new Speed(10, Speed.Unit.MPS)));
        assertTrue((windComponent.getHeadwindSpeed().toUnit(Speed.Unit.MPS) < 0.00000001));

        windComponent = new WindComponent(0, new WindVector(270, new Speed(10, Speed.Unit.MPS)));
        assertTrue((windComponent.getHeadwindSpeed().toUnit(Speed.Unit.MPS) > -0.00000001));
    }

    @Test
    void getCrosswindSpeed() {
        var windComponent = new WindComponent(0, new WindVector(0, new Speed(10, Speed.Unit.MPS)));
        assertEquals(0, windComponent.getCrosswindSpeed().toUnit(Speed.Unit.MPS));

        windComponent = new WindComponent(0, new WindVector(90, new Speed(10, Speed.Unit.MPS)));
        assertEquals(10, windComponent.getCrosswindSpeed().toUnit(Speed.Unit.MPS));

        windComponent = new WindComponent(0, new WindVector(270, new Speed(10, Speed.Unit.MPS)));
        assertEquals(-10, windComponent.getCrosswindSpeed().toUnit(Speed.Unit.MPS));
    }
}