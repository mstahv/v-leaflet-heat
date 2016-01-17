package org.vaadin.addon.leafletheat.client;

import org.vaadin.addon.leafletheat.LHeatMapLayer;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.vaadin.shared.ui.Connect;
import org.peimari.gleaflet.client.AbstractJsonOptions;
import org.peimari.gleaflet.client.Layer;
import org.peimari.gleaflet.client.LatLng;
import org.peimari.gleaflet.heat.client.HeatMapLayer;
import org.vaadin.addon.leaflet.client.AbstractLeafletLayerConnector;

@Connect(LHeatMapLayer.class)
public class LHeatLayerConnector extends
        AbstractLeafletLayerConnector<AbstractJsonOptions> {

    private HeatMapLayer layer;

    public LHeatLayerConnector() {
    }

    @Override
    public LHeatLayerState getState() {
        return (LHeatLayerState) super.getState();
    }

    @Override
    protected AbstractJsonOptions createOptions() {
        return AbstractJsonOptions.createObject().cast();
    }

    @Override
    protected void update() {
        if(layer != null) {
            removeLayerFromParent();
        }
        JsArray<LatLng> latlongs = JsonUtils.safeEval(getState().latlngJson);
        AbstractJsonOptions conf = JsonUtils.safeEval(getState().options);
        
        layer = HeatMapLayer.create(latlongs, conf);
        addToParent(layer);
    }

    @Override
    public Layer getLayer() {
        return layer;
    }

}
