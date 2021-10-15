package com.jAviation;

import com.jAviation.Models.Airports.Airport;
import com.jAviation.Utilities.Factory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/airports/")
public class AirportController {
    @GetMapping("{icao}")
    public Airport index(@PathVariable String icao) {
        var airport = Factory.getAirportByIdentifier(icao);

        return airport;
    }
}
