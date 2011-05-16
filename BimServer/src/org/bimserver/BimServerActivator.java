package org.bimserver;

import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.serializers.ObjectInfoSerializerPlugin;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class BimServerActivator extends Plugin {

	private ServiceRegistration objectInfoServiceRegistration;

	public BimServerActivator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		objectInfoServiceRegistration = context.registerService(SerializerPlugin.class.getName(), new ObjectInfoSerializerPlugin(), null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		objectInfoServiceRegistration.unregister();
	}
}
