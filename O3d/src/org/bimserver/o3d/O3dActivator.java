package org.bimserver.o3d;

import org.bimserver.plugins.serializers.SerializerPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class O3dActivator implements BundleActivator {

	private ServiceRegistration o3dJsonServiceRegistration;
	private ServiceRegistration o3dTgzServiceRegistration;

	public O3dActivator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		o3dJsonServiceRegistration = context.registerService(SerializerPlugin.class.getName(), new O3dJsonSerializerPlugin(), null);
		o3dTgzServiceRegistration = context.registerService(SerializerPlugin.class.getName(), new O3dTgzSerializerPlugin(), null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		o3dJsonServiceRegistration.unregister();
		o3dTgzServiceRegistration.unregister();
	}
}