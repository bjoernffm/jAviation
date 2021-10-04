package com.jAviation;

import com.jAviation.Models.GeoPoint;
import com.jAviation.Models.Navaids.Navaid;
import com.jAviation.Utilities.Files.AirportsFile;
import com.jAviation.Utilities.Files.NavaidsFile;
import com.jAviation.Utilities.Files.ProcedureFile;
import com.jAviation.Utilities.GeoCalculator;
import com.jAviation.Utilities.Length;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //var file = new AirportsFile("%HOMEPATH%\\OneDrive - ISHGroup\\Desktop\\Programmierprojekt\\navdata\\Airports.txt");
        var file = new NavaidsFile("src\\main\\resources\\navdata\\Navaids.txt");
        //var file2 = new ProcedureFile("%HOMEPATH%\\OneDrive - ISHGroup\\Desktop\\Programmierprojekt\\navdata\\Proc\\EDGS.txt", file);
        //var sid = file2.getProcedures().getSids().get(4).getWaypoints().get(2);

        var mtr = file.getNavaids().getByIdentifier("MTR", "ED").get(0);
        var wrb = file.getNavaids().getByIdentifier("WRB", "ED").get(0);
        System.out.println(mtr.getVectorTo(wrb));
    }
}
