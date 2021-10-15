package com.jAviation;

import com.jAviation.Models.Airway;
import com.jAviation.Utilities.Embedded.Length;
import com.jAviation.Utilities.Embedded.Vector;
import com.jAviation.Utilities.Factory;
import com.jAviation.Utilities.GeoCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        //SpringApplication.run(Main.class, args);
        //FileImporter.execute();

        var eddf = Factory.getAirportByIdentifier("EDDF");
        var runways = eddf.getPairedRunways();

        /*Airway a = new Airway("N850");
        var b = Factory.getWaypointsByIdentifier("WRB");
        a.add(b.get(0));
        var c = Factory.getWaypointsByIdentifier("XAROL");
        a.add(c.get(0));
        System.out.println(a);*/
    }
}
