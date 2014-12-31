package org.vaadin.addon.leaflet.demoandtestapp;

import com.vaadin.ui.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.vaadin.addon.leaflet.*;
import org.vaadin.addon.leafletheat.LHeatMapLayer;
import org.vaadin.addon.leaflet.shared.Point;
import org.vaadin.addonhelpers.AbstractTest;

public class LargeDatasetTest extends AbstractTest {

    private LHeatMapLayer layer;

    @Override
    public String getDescription() {
        return "Test leaflet heat map feature";
    }

    private LMap leafletMap;

    @Override
    public Component getTestComponent() {
        leafletMap = new LMap();
        leafletMap.setHeight("100%");
        
        leafletMap.addLayer(new LOpenStreetMapLayer());

        layer = new LHeatMapLayer();
        
        layer.setPoints(getPoints());

        leafletMap.addLayer(layer);

        leafletMap.zoomToContent();

        return leafletMap;
    }

    private Point[] getPoints() {
        List<Point> points = new ArrayList<>();
        try {
            List<String> lines = IOUtils.readLines(getClass().
                    getResourceAsStream("dataset"));
            for (String line : lines) {
                String[] parts = line.split(",");
                points.add(new Point(Double.parseDouble(parts[0]), Double.
                        parseDouble(parts[1])));
            }
        } catch (IOException ex) {
            Logger.getLogger(LargeDatasetTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        System.out.println("Read " + points.size() + "points");
        return points.toArray(new Point[0]);

    }

}
