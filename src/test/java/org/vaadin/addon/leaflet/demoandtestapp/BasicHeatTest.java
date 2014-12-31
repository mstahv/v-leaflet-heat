package org.vaadin.addon.leaflet.demoandtestapp;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.vaadin.addon.leaflet.*;
import org.vaadin.addon.leafletheat.LHeatMapLayer;
import org.vaadin.addon.leaflet.shared.Point;
import org.vaadin.addon.leaflet.util.JTSUtil;
import org.vaadin.addon.leafletheat.Point3D;
import org.vaadin.addonhelpers.AbstractTest;
import org.vaadin.maddon.layouts.MHorizontalLayout;

public class BasicHeatTest extends AbstractTest {

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
        leafletMap.setCenter(0, 0);
        leafletMap.setMinZoom(0);
        leafletMap.setMaxZoom(5);
        
        layer = new LHeatMapLayer();

        layer.setPoints(
                new Point3D(-30, -30, 0.25), 
                new Point3D(0, 0, 0.5),
                new Point3D(30, 30, 1),
                new Point3D(1, 30, 1),
                new Point3D(2, 31, 1),
                new Point3D(3, 32, 1),
                new Point3D(3, 30, 1),
                new Point3D(2, 32, 1),
                new Point3D(1, 31, 1)
        );
                
        HashMap<Double,String> gradient = new LinkedHashMap<>();
        // {0.4: 'blue', 0.65: 'lime', 1: 'red'}
        gradient.put(0.4, "blue");
        gradient.put(0.65, "lime");
        gradient.put(1.0, "red");
        
        layer.setGradient(gradient);

        leafletMap.addLayer(layer);
        
        leafletMap.zoomToContent();

        return leafletMap;
    }

}
