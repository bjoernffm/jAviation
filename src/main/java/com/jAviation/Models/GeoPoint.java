package com.jAviation.Models;

import com.jAviation.Utilities.GeoCalculator;
import com.jAviation.Utilities.Embedded.Vector;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GeoPoint {
    protected double lat;
    protected double lon;

    public GeoPoint() {

    }

    public GeoPoint(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "GeoPoint{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    public boolean isNorthernHemisphere() {
        return (this.lat >= 0);
    }

    public boolean isSouthernHemisphere() {
        return (this.lat < 0);
    }

    public boolean isEasternHemisphere() {
        return (this.lon >= 0);
    }

    public boolean isWesternHemisphere() {
        return (this.lon < 0);
    }

    public char getLatDirection() {
        if(this.isSouthernHemisphere()) {
            return 'S';
        }

        return 'N';
    }

    public char getLonDirection() {
        if(this.isWesternHemisphere()) {
            return 'W';
        }

        return 'E';
    }

    public int getLatDegrees() {
        return (int) Math.abs(this.lat);
    }

    public double getLatMinutes() {
        return (Math.abs(this.lat) - this.getLatDegrees()) * 60;
    }

    public double getLatSeconds() {
        return ((Math.abs(this.lat) - this.getLatDegrees()) - (((int) this.getLatMinutes())/60.)) * 3600;
    }

    public int getLonDegrees() {
        return (int) Math.abs(this.lon);
    }

    public double getLonMinutes() {
        return (Math.abs(this.lon) - this.getLonDegrees()) * 60;
    }

    public double getLonSeconds() {
        return ((Math.abs(this.lon) - this.getLonDegrees()) - (((int) this.getLonMinutes())/60.)) * 3600;
    }

    public String toDecimal() {
        return this.getLat() + "," + this.getLon();
    }

    public String toDD() {
        // 27.00N 087.00W
        return "";
    }

    public String toDDM() {
        // 43° 55,83'N 60° 001,37'W
        var sb = new StringBuilder();
        sb.append(String.format("%02d° %05.2f'%s ", this.getLatDegrees(), this.getLatMinutes(), this.getLatDirection()));
        sb.append(String.format("%03d° %05.2f'%s", this.getLonDegrees(), this.getLonMinutes(), this.getLonDirection()));

        return sb.toString();
    }

    public String toDMS() {
        // 27° 18' 00.00"N 087° 00' 00.00"W
        var sb = new StringBuilder();
        sb.append(String.format("%02d° %02d' %05.2f\"%s ", this.getLatDegrees(), (int) this.getLatMinutes(), this.getLatSeconds(), this.getLatDirection()));
        sb.append(String.format("%03d° %02d' %05.2f\"%s", this.getLonDegrees(), (int) this.getLonMinutes(), this.getLonSeconds(), this.getLonDirection()));

        return sb.toString();
    }

    public String toGPS() {
        return this.toDDM().replaceAll("[°\\s',\"]+", "");
    }

    public Vector getVectorTo(GeoPoint geoPoint) {
        return GeoCalculator.getVector(this, geoPoint);
    }
}
