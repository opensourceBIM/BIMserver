package org.bimserver.ifc;

import org.bimserver.ifc.file.writer.IfcStepSerializerPlugin;
import org.bimserver.ifc.xml.writer.IfcXmlSerializerPlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class IfcActivator extends Plugin {

	private ServiceRegistration ifcStepSerializerServiceRegistration;
	private ServiceRegistration ifcXmlSerializerServiceRegistration;

	public IfcActivator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		ifcStepSerializerServiceRegistration = context.registerService(SerializerPlugin.class.getName(), new IfcStepSerializerPlugin(), null);
		ifcXmlSerializerServiceRegistration = context.registerService(SerializerPlugin.class.getName(), new IfcXmlSerializerPlugin(), null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		ifcStepSerializerServiceRegistration.unregister();
		ifcXmlSerializerServiceRegistration.unregister();
	}
}
