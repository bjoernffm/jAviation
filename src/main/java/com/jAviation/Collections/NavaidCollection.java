package com.jAviation.Collections;

import com.jAviation.Models.Navaids.Navaid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NavaidCollection extends ArrayList<Navaid> {
    public List<Navaid> getByIdentifier(String identifier, String countryCode) {
        return this
                .stream()
                .filter(c -> c.getIdentifier().equals(identifier) && c.getCountryCode().equals(countryCode))
                .collect(Collectors.toList());
    }
}
