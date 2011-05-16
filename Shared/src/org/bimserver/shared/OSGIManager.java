package org.bimserver.shared;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OSGIManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(OSGIManager.class);
	private Framework framework;
	
	public OSGIManager() {
	}
	
	public void start() {
		ServiceLoader<FrameworkFactory> serviceLoader = ServiceLoader.load(FrameworkFactory.class);
		Iterator<FrameworkFactory> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			FrameworkFactory frameworkFactory = iterator.next();
			Map<String, String> config = new HashMap<String, String>();
			framework = frameworkFactory.newFramework(config);
			LOGGER.info("Using " + framework.getClass().getName() + " as OSGI framework");
			try {
				framework.start();
				Set<Bundle> bundles = new LinkedHashSet<Bundle>();
//				install("file:C:\\Software\\Eclipse3.5\\plugins\\org.eclipse.core.runtime_3.5.0.v20090525.jar", bundles);
				install("file:../Utils", bundles);
				install("file:../Emf", bundles);
				install("file:../Store", bundles);
				install("file:../buildingSMARTLibrary", bundles);
				install("file:../Plugins", bundles);
				install("file:../Shared", bundles);
				install("file:../CityGML", bundles);
				install("file:../O3d", bundles);
				install("file:../Ifc", bundles);
				install("file:../Collada", bundles);
				install("file:../IFCEngine", bundles);
				for (Bundle bundle : bundles) {
					LOGGER.info("Starting " + bundle.getLocation());
					bundle.start();
				}
			} catch (BundleException e) {
				LOGGER.error("", e);
			}
		}
	}

	private void install(String location, Set<Bundle> bundles) throws BundleException {
		Bundle bundle = framework.getBundleContext().installBundle(location);
		bundles.add(bundle);
	}

	public Set<IfcEnginePlugin> getIfcPlugins() {
		Set<IfcEnginePlugin> ifcEnginePlugins = new HashSet<IfcEnginePlugin>();
		try {
			ServiceReference[] serviceReferences = framework.getBundleContext().getServiceReferences(IfcEnginePlugin.class.getName(), null);
			if (serviceReferences != null) {
				for (ServiceReference serviceReference : serviceReferences) {
					IfcEnginePlugin ifcEnginePlugin = (IfcEnginePlugin) framework.getBundleContext().getService(serviceReference);
					LOGGER.info(ifcEnginePlugin.getName());
				}
			}
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
		return ifcEnginePlugins;
	}

	public Set<SerializerPlugin> getAllSerializerPlugins() {
		Set<SerializerPlugin> plugins = new HashSet<SerializerPlugin>();
		try {
			ServiceReference[] serviceReferences = framework.getBundleContext().getServiceReferences(SerializerPlugin.class.getName(), null);
			if (serviceReferences != null) {
				for (ServiceReference serviceReference : serviceReferences) {
					SerializerPlugin serializerPlugin = (SerializerPlugin) framework.getBundleContext().getService(serviceReference);
					LOGGER.info(serializerPlugin.getName());
					plugins.add(serializerPlugin);
				}
			}
		} catch (InvalidSyntaxException e) {
			LOGGER.error("", e);
		}
		return plugins;
	}
}