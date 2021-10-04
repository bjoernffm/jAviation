package com.jAviation;

import com.jAviation.Utilities.Factory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // FileImporter.execute();
        var airport = Factory.getAirportByIdentifier("FARG");
        System.out.println(airport);
    }
}
