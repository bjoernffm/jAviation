package com.jAviation.Utilities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {

    Length length;

    @BeforeEach
    void setUp() {
        length = new Length(100, Length.Unit.METER);
    }

    @Test
    void toUnit() {
        assertEquals(100, length.toUnit(Length.Unit.METER));
    }

    @Test
    void testToString() {
        assertEquals("Length{value=100.0m}", length.toString());
    }
}