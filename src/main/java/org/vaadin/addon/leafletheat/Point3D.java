package org.vaadin.addon.leafletheat;

import org.vaadin.addon.leaflet.shared.Point;

/**
 * A Point with altitude as a third field. Can be used in a heat map where theaceous
 * altitude is used as "intensity".
 * 
 * @author Matti Tahvonen
 */
public class Point3D extends Point {
    
    private double altitude;

    public Point3D() {
    }
    
    public Point3D(double lat, double lon, double altitude) {
        super(lat, lon);
        this.altitude = altitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Override
    public Double[] getLatLonPair() {
        return new Double[]{getLat(), getLon(), altitude};
    }

}
