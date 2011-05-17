package org.bimserver;

import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.serializers.ObjectInfoSerializerPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class BimServerActivator implements BundleActivator {

	private ServiceRegistration objectInfoServiceRegistration;
	private ServerInitializer serverInitializer;

	public BimServerActivator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		objectInfoServiceRegistration = context.registerService(SerializerPlugin.class.getName(), new ObjectInfoSerializerPlugin(), null);
		serverInitializer = new ServerInitializer();
		serverInitializer.init();
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		objectInfoServiceRegistration.unregister();
		serverInitializer.close();
	}
}
