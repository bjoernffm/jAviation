package com.jAviation.Utilities;

import com.jAviation.Models.GeoPoint;

public class GeoCalculator {
    public static GeoPoint project(GeoPoint geoPoint, double magneticHeading, Length distance) {
        double lat = Math.toRadians(geoPoint.getLat());
        double lon = Math.toRadians(geoPoint.getLon());
        double direction = Math.toRadians(magneticHeading);
        double dist = Math.toRadians(distance.toUnit(Length.Unit.NAUTICAL_MILE))/60;

        double newLat = Math.asin(Math.sin(lat)*Math.cos(dist)+Math.cos(lat)*Math.sin(dist)*Math.cos(direction));

        double x = Math.cos(dist)-Math.sin(lat)*Math.sin(newLat);
        double y = Math.sin(direction)*Math.sin(dist)*Math.cos(lat);
        double newDLon = -1*Math.atan2(y, x);

        double part1 = (lon-newDLon+Math.PI);
        double part2 = (int) ((lon-newDLon+Math.PI)/2/Math.PI);
        double newLon = part1-part2-Math.PI;

        return new GeoPoint(Math.toDegrees(newLat), Math.toDegrees(newLon));
    }

    public static Vector getVector(GeoPoint geoPointFrom, GeoPoint geoPointTo) {
        var latFrom = Math.toRadians(geoPointFrom.getLat());
        var lonFrom = Math.toRadians(geoPointFrom.getLon());
        var latTo = Math.toRadians(geoPointTo.getLat());
        var lonTo = Math.toRadians(geoPointTo.getLon());

        var temp = Math.sin(latFrom)*Math.sin(latTo)+Math.cos(latFrom)*Math.cos(latTo)*Math.cos(lonFrom-lonTo);

        var distance = new Length(6371.229/1.852*Math.acos(temp), Length.Unit.NAUTICAL_MILE);

        var correction = 360;
        if (geoPointFrom.getLon()-geoPointTo.getLon() < 0) {
            correction = 0;
        }

        var direction = Math.abs(Math.acos(Math.sin(latTo)/Math.sin(Math.acos(temp))/Math.cos(latFrom)-Math.tan(latFrom)/Math.tan(Math.acos(temp)))*180/Math.PI-correction);

        return new Vector(direction, distance);
    }
}
