package org.bimserver.shared;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginClassloader;
import org.bimserver.plugins.PluginDescriptor;
import org.bimserver.plugins.PluginImplementation;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(PluginManager.class);
	private final Map<Class<? extends Plugin>, Set<? extends Plugin>> implementations = new HashMap<Class<? extends Plugin>, Set<? extends Plugin>>();

	public PluginManager() {
	}

	public void loadPluginsFromEclipseProject(File projectRoot) throws PluginException {
		if (!projectRoot.isDirectory()) {
			throw new PluginException("No directory: " + projectRoot.getAbsolutePath());
		}
		File pluginFolder = new File(projectRoot, "plugin");
		if (!pluginFolder.isDirectory()) {
			throw new PluginException("No 'plugin' directory found in " + projectRoot.getAbsolutePath());
		}
		File pluginFile = new File(pluginFolder, "plugin.xml");
		if (!pluginFile.isFile()) {
			throw new PluginException("No 'plugin.xml' found in " + pluginFolder.getAbsolutePath());
		}
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PluginDescriptor.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			PluginDescriptor pluginDescriptor = (PluginDescriptor) unmarshaller.unmarshal(pluginFile);
			PluginClassloader pluginClassloader = new PluginClassloader(new File(projectRoot, "bin"));
			for (PluginImplementation pluginImplementation : pluginDescriptor.getImplementations()) {
				String interfaceClassName = pluginImplementation.getInterfaceClass();
				try {
					Class interfaceClass = pluginClassloader.loadClass(interfaceClassName);
					String implementationClassName = pluginImplementation.getImplementationClass();
					try {
						Class implementationClass = pluginClassloader.loadClass(implementationClassName);
						if (!implementations.containsKey(interfaceClass)) {
							implementations.put(interfaceClass, new HashSet<Plugin>());
						}
						LOGGER.info("Loading plugin " + implementationClassName);
						Plugin plugin = (Plugin) implementationClass.newInstance();
						Set<Plugin> set = (Set<Plugin>) implementations.get(interfaceClass);
						set.add(plugin);
					} catch (ClassNotFoundException e) {
						throw new PluginException("Implementation class '" + implementationClassName + "' not found", e);
					} catch (InstantiationException e) {
						throw new PluginException(e);
					} catch (IllegalAccessException e) {
						throw new PluginException(e);
					}
				} catch (ClassNotFoundException e) {
					throw new PluginException("Interface class '" + interfaceClassName + "' not found", e);
				}
			}
		} catch (JAXBException e) {
			throw new PluginException(e);
		}
	}

	public void loadPluginsFromJar(File file) {
	}

	private <T> Collection<T> getPlugins(Class<T> requiredInterfaceClass) {
		Collection<T> plugins = new ArrayList<T>();
		for (Class interfaceClass : implementations.keySet()) {
			if (interfaceClass.getName().equals(requiredInterfaceClass.getName())) {
				for (Plugin plugin : implementations.get(interfaceClass)) {
					plugins.add((T) plugin);
				}
			}
		}
		return plugins;
	}

	public Collection<IfcEnginePlugin> getAllIfcEnginePlugins() {
		return getPlugins(IfcEnginePlugin.class);
	}

	public Collection<SerializerPlugin> getAllSerializerPlugins() {
		return getPlugins(SerializerPlugin.class);
	}
	
	public Collection<DeserializerPlugin> getAllDeserializerPlugins() {
		return getPlugins(DeserializerPlugin.class);
	}
}