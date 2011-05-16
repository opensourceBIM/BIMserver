package org.bimserver.ifcengine;

import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class IfcEngineActivator implements BundleActivator {

	private ServiceRegistration ifcEngineServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		ifcEngineServiceRegistration = context.registerService(IfcEnginePlugin.class.getName(), new CppIfcEnginePlugin(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		ifcEngineServiceRegistration.unregister();
	}
}