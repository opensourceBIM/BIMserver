package org.bimserver.collada;

import org.bimserver.plugins.serializers.SerializerPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ColladaActivator implements BundleActivator {

	private ServiceRegistration colladaServiceRegistration;
	private ServiceRegistration kmzServiceRegistration;

	public ColladaActivator() {
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		colladaServiceRegistration = context.registerService(SerializerPlugin.class.getName(), new ColladaSerializerPlugin(), null);
		kmzServiceRegistration = context.registerService(SerializerPlugin.class.getName(), new KmzSerializerPlugin(), null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		colladaServiceRegistration.unregister();
		kmzServiceRegistration.unregister();
	}
}