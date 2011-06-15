package org.bimserver.plugins;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginManager {
	private final Logger LOGGER = LoggerFactory.getLogger(PluginManager.class);
	private final Map<Class<? extends Plugin>, Set<PluginContext>> implementations = new HashMap<Class<? extends Plugin>, Set<PluginContext>>();
	private final Set<PluginChangeListener> pluginChangeListeners = new HashSet<PluginChangeListener>();

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
			PluginDescriptor pluginDescriptor = getPluginDescriptor(new FileInputStream(pluginFile));
			PluginClassloader pluginClassloader = new PluginClassloader(new File(projectRoot, "bin"));
			loadPlugins(pluginClassloader, projectRoot.getAbsolutePath(), pluginDescriptor);
		} catch (JAXBException e) {
			throw new PluginException(e);
		} catch (FileNotFoundException e) {
			throw new PluginException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private void loadPlugins(ClassLoader classLoader, String location, PluginDescriptor pluginDescriptor) throws PluginException {
		for (PluginImplementation pluginImplementation : pluginDescriptor.getImplementations()) {
			String interfaceClassName = pluginImplementation.getInterfaceClass();
			try {
				Class interfaceClass = classLoader.loadClass(interfaceClassName);
				String implementationClassName = pluginImplementation.getImplementationClass();
				try {
					Class implementationClass = classLoader.loadClass(implementationClassName);
					if (!implementations.containsKey(interfaceClass)) {
						implementations.put(interfaceClass, new HashSet<PluginContext>());
					}
					LOGGER.info("Loading plugin " + implementationClassName);
					Plugin plugin = (Plugin) implementationClass.newInstance();
					Set<PluginContext> set = (Set<PluginContext>) implementations.get(interfaceClass);
					PluginContext pluginContext = new PluginContext(this);
					pluginContext.setPlugin(plugin);
					pluginContext.setLocation(location);
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
	}

	private PluginDescriptor getPluginDescriptor(InputStream inputStream) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(PluginDescriptor.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		PluginDescriptor pluginDescriptor = (PluginDescriptor) unmarshaller.unmarshal(inputStream);
		return pluginDescriptor;
	}

	public void loadAllPluginsFromDirectoryOfJars(File directory) throws PluginException {
		LOGGER.info("Loading all plugin jars from " + directory.getAbsolutePath());
		if (!directory.isDirectory()) {
			throw new PluginException("No directory: " + directory.getAbsolutePath());
		}
		for (File file : directory.listFiles()) {
			if (file.getName().toLowerCase().endsWith(".jar")) {
				try {
					loadPluginsFromJar(file);
				} catch (PluginException e) {
					LOGGER.error("", e);
				}
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
			jarInputStream.close();
			if (map.containsKey("plugin/plugin.xml")) {
				byte[] bs = map.get("plugin/plugin.xml");
				PluginDescriptor pluginDescriptor = getPluginDescriptor(new ByteArrayInputStream(bs));
				loadPlugins(new MapClassLoader(map), file.getAbsolutePath(), pluginDescriptor);
			}
		} catch (FileNotFoundException e) {
			throw new PluginException(e);
		} catch (IOException e) {
			throw new PluginException(e);
		} catch (JAXBException e) {
			throw new PluginException(e);
		}
	}

	@SuppressWarnings("unchecked")
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
	
	public void addPluginChangeListener(PluginChangeListener pluginChangeListener) {
		pluginChangeListeners.add(pluginChangeListener);
	}

	public void notifyPluginStateChange(PluginContext pluginContext, boolean enabled) {
		for (PluginChangeListener pluginChangeListener : pluginChangeListeners) {
			pluginChangeListener.pluginStateChanged(pluginContext, enabled);
		}
	}
}