package com.jAviation.Collections;

import com.jAviation.Models.Airports.Procedures.Approach;
import com.jAviation.Models.Airports.Procedures.Procedure;
import com.jAviation.Models.Airports.Procedures.Sid;
import com.jAviation.Models.Airports.Procedures.Star;

import java.util.ArrayList;
import java.util.List;

public class ProcedureCollection {
    private List<Sid> sids = new ArrayList<Sid>();
    private List<Star> stars = new ArrayList<Star>();
    private List<Approach> approaches = new ArrayList<Approach>();

    public Procedure add(Procedure procedure) {
        if(procedure instanceof Sid) {
            this.sids.add((Sid) procedure);
        }
        return procedure;
    }

    public List<Sid> getSids() {
        return sids;
    }
}
