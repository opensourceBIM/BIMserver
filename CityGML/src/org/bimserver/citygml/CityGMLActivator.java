package org.bimserver.citygml;

import org.bimserver.plugins.serializers.SerializerPlugin;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class CityGMLActivator extends Plugin {

	private ServiceRegistration registerService;

	public CityGMLActivator() {
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		registerService = context.registerService(SerializerPlugin.class.getName(), new CityGmlSerializerPlugin(), null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		registerService.unregister();
	}
}
