package org.vaadin.addon.leafletheat;

import com.vividsolutions.jts.geom.Geometry;
import java.util.Arrays;
import java.util.HashMap;
import org.vaadin.addon.leaflet.AbstractLeafletLayer;
import org.vaadin.addon.leaflet.jsonmodels.BasicMap;
import org.vaadin.addon.leaflet.jsonmodels.PointArray;
import org.vaadin.addon.leaflet.shared.Point;
import org.vaadin.addon.leaflet.util.JTSUtil;
import org.vaadin.addon.leafletheat.client.LHeatLayerState;

/**
 * A heat map layer.
 *
 */
public class LHeatMapLayer extends AbstractLeafletLayer {

    private PointArray points;

    private final BasicMap options = new BasicMap();

    {
        options.put("radius", 25);
    }

    public void setPoints(Point... array) {
        points = new PointArray(Arrays.asList(array));
        markAsDirty();
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);
        getState().latlngJson = points.asJson();
        getState().options = options.asJson();
    }

    @Override
    public Geometry getGeometry() {
        // TODO make this return multipoint
        return JTSUtil.toLineString(points.toArray(new Point[points.size()]));
    }

    /**
     * Sets the radius of each "point" of the heatmap, 25 by default
     *
     * @param radius
     */
    public void setRadius(int radius) {
        options.put("radius", radius);
        markAsDirty();
    }

    /**
     * Sets the the minimum opacity the heat will start at
     *
     * @param minOpacity
     */
    public void setMinOpacity(double minOpacity) {
        options.put("minOpacity", minOpacity);
        markAsDirty();
    }

    /**
     * @param maxZoom zoom level where the points reach maximum intensity (as
     * intensity scales with zoom), equals maxZoom of the map by default
     */
    public void setMaxZoom(double maxZoom) {
        options.put("maxZoom", maxZoom);
        markAsDirty();
    }

    /**
     * @param max maximum point intensity, 1.0 by default
     */
    public void setMax(double max) {
        options.put("max", max);
        markAsDirty();
    }

    /**
     * @param blur blur - amount of blur, 15 by default
     */
    public void setBlur(double blur) {
        options.put("blur", blur);
        markAsDirty();
    }

    /**
     *
     * @param gradient color gradient config, e.g. {0.4: 'blue', 0.65: 'lime',
     * 1: 'red'}
     */
    public void setGradient(HashMap<Double, String> gradient) {
        options.put("gradient", gradient);
    }

    @Override
    public LHeatLayerState getState() {
        return (LHeatLayerState) super.getState();
    }

}
