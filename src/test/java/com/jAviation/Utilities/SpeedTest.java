package com.jAviation.Utilities;

import com.jAviation.Utilities.Embedded.Speed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeedTest {
    @Test
    public void test() {
        var length = new Speed(100, Speed.Unit.KTS);
        assertEquals(100, length.toUnit(Speed.Unit.KTS));
    }
}