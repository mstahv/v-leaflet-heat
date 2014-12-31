package org.vaadin.addon.leafletheat.client;


import com.google.gwt.core.client.EntryPoint;
import org.peimari.gleaflet.heat.client.resources.LeafletHeatResourceInjector;

public class EagerHeatLoader implements EntryPoint {

	@Override
	public void onModuleLoad() {
		LeafletHeatResourceInjector.ensureInjected();
	}

}
