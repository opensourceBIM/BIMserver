package org.bimserver.shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginClassloader;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginDescriptor;
import org.bimserver.plugins.PluginImplementation;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.tools.jar.resources.jar;

public class PluginManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(PluginManager.class);
	private final Map<Class<? extends Plugin>, Set<PluginContext>> implementations = new HashMap<Class<? extends Plugin>, Set<PluginContext>>();

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
							implementations.put(interfaceClass, new HashSet<PluginContext>());
						}
						LOGGER.info("Loading plugin " + implementationClassName);
						Plugin plugin = (Plugin) implementationClass.newInstance();
						Set<PluginContext> set = (Set<PluginContext>) implementations.get(interfaceClass);
						PluginContext pluginContext = new PluginContext();
						pluginContext.setPlugin(plugin);
						pluginContext.setLocation(projectRoot.getAbsolutePath());
						set.add(pluginContext);
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

	public void loadAllPluginsFromDirectoryOfJars(File directory) throws PluginException {
		if (!directory.isDirectory()) {
			throw new PluginException("No directory: " + directory.getAbsolutePath());
		}
		for (File file : directory.listFiles()) {
			if (file.getName().toLowerCase().endsWith(".jar")) {
				loadPluginsFromJar(file);
			}
		}
	}

	public void loadPluginsFromJar(File file) throws PluginException {
		if (!file.isFile()) {
			throw new PluginException("Not a file: " + file.getAbsolutePath());
		}
		try {
			JarInputStream jarInputStream = new JarInputStream(new FileInputStream(file));
			JarEntry entry = jarInputStream.getNextJarEntry();
			Map<String, byte[]> map = new HashMap<String, byte[]>();
			while (entry != null) {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				IOUtils.copy(jarInputStream, byteArrayOutputStream);
				map.put(entry.getName(), byteArrayOutputStream.toByteArray());
				entry = jarInputStream.getNextJarEntry();
			}
			if (map.containsKey("plugin/plugin.xml")) {
				System.out.println("yes");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private <T> Collection<T> getPlugins(Class<T> requiredInterfaceClass, boolean onlyEnabled) {
		Collection<T> plugins = new ArrayList<T>();
		for (Class interfaceClass : implementations.keySet()) {
			if (requiredInterfaceClass.isAssignableFrom(interfaceClass)) {
				for (PluginContext pluginContext : implementations.get(interfaceClass)) {
					if (!onlyEnabled || pluginContext.isEnabled()) {
						plugins.add((T) pluginContext.getPlugin());
					}
				}
			}
		}
		return plugins;
	}

	public Collection<IfcEnginePlugin> getAllIfcEnginePlugins(boolean onlyEnabled) {
		return getPlugins(IfcEnginePlugin.class, onlyEnabled);
	}

	public Collection<SerializerPlugin> getAllSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(SerializerPlugin.class, onlyEnabled);
	}
	
	public Collection<DeserializerPlugin> getAllDeserializerPlugins(boolean onlyEnabled) {
		return getPlugins(DeserializerPlugin.class, onlyEnabled);
	}

	public Collection<Plugin> getAllPlugins(boolean onlyEnabled) {
		return getPlugins(Plugin.class, onlyEnabled);
	}

	public PluginContext getPluginContext(Plugin plugin) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin() == plugin) {
					return pluginContext;
				}
			}
		}
		return null;
	}

	public void enablePlugin(String name) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin().getName().equals(name)) {
					pluginContext.setEnabled(true);
				}
			}
		}
	}

	public void disablePlugin(String name) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin().getName().equals(name)) {
					pluginContext.setEnabled(false);
				}
			}
		}
	}

	public Plugin getPlugin(String className, boolean onlyEnabled) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin().getName().equals(className)) {
					if (!onlyEnabled || pluginContext.isEnabled()) {
						return pluginContext.getPlugin();
					}
				}
			}
		}
		return null;
	}

	public boolean isEnabled(String className) {
		return getPlugin(className, true) != null;
	}
}