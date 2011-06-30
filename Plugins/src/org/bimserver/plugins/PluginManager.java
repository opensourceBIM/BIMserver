package org.bimserver.plugins;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.guidanceproviders.GuidanceProviderPlugin;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaException;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginManager {
	private final Logger LOGGER = LoggerFactory.getLogger(PluginManager.class);
	private final Map<Class<? extends Plugin>, Set<PluginContext>> implementations = new HashMap<Class<? extends Plugin>, Set<PluginContext>>();
	private final Set<PluginChangeListener> pluginChangeListeners = new HashSet<PluginChangeListener>();
	private final ResourceFetcher resourceFetcher;
	private File homeDir;
	private final String baseClassPath;

	public PluginManager(ResourceFetcher resourceFetcher, File homeDir, String baseClassPath) {
		this.resourceFetcher = resourceFetcher;
		this.homeDir = homeDir;
		this.baseClassPath = baseClassPath;
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
			File libFolder = new File(projectRoot, "lib");
			DelegatingClassLoader delegatingClassLoader = new DelegatingClassLoader(getClass().getClassLoader());
			if (libFolder.isDirectory()) {
				for (File libFile : libFolder.listFiles()) {
					if (libFile.getName().toLowerCase().endsWith(".jar")) {
						JarClassLoader jarClassLoader = new JarClassLoader(delegatingClassLoader, libFile);
						delegatingClassLoader.add(jarClassLoader);
					}
				}
			}
			EclipsePluginClassloader pluginClassloader = new EclipsePluginClassloader(delegatingClassLoader, projectRoot);
			loadPlugins(pluginClassloader, projectRoot.getAbsolutePath(), pluginDescriptor);
		} catch (JAXBException e) {
			throw new PluginException(e);
		} catch (FileNotFoundException e) {
			throw new PluginException(e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void loadPlugins(ClassLoader classLoader, String location, PluginDescriptor pluginDescriptor) throws PluginException {
		for (PluginImplementation pluginImplementation : pluginDescriptor.getImplementations()) {
			String interfaceClassName = pluginImplementation.getInterfaceClass();
			try {
				Class interfaceClass = classLoader.loadClass(interfaceClassName);
				String implementationClassName = pluginImplementation.getImplementationClass();
				try {
					Class implementationClass = classLoader.loadClass(implementationClassName);
					Plugin plugin = (Plugin) implementationClass.newInstance();
					loadPlugin(interfaceClass, location, plugin);
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
		if (!directory.isDirectory()) {
			throw new PluginException("No directory: " + directory.getAbsolutePath());
		}
		for (File file : directory.listFiles()) {
			if (file.getName().toLowerCase().endsWith(".jar")) {
				try {
					loadPluginsFromJar(file);
				} catch (PluginException e) {
					e.printStackTrace();
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
			JarClassLoader jarClassLoader = new JarClassLoader(getClass().getClassLoader(), file);
			InputStream pluginStream = jarClassLoader.getResourceAsStream("plugin/plugin.xml");
			PluginDescriptor pluginDescriptor = getPluginDescriptor(pluginStream);
			loadPlugins(jarClassLoader, file.getAbsolutePath(), pluginDescriptor);
		} catch (JAXBException e) {
			throw new PluginException(e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	
	public Collection<GuidanceProviderPlugin> getAllGuidanceProviders(boolean onlyEnabled) {
		return getPlugins(GuidanceProviderPlugin.class, onlyEnabled);
	}

	public Collection<IfcEnginePlugin> getAllIfcEnginePlugins(boolean onlyEnabled) {
		return getPlugins(IfcEnginePlugin.class, onlyEnabled);
	}

	public Collection<SerializerPlugin> getAllSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(SerializerPlugin.class, onlyEnabled);
	}

	public SerializerPlugin getFirstSerializerPlugin(String contentType, boolean onlyEnabled) throws PluginException {
		Collection<SerializerPlugin> allSerializerPlugins = getAllSerializerPlugins(contentType, onlyEnabled);
		if (allSerializerPlugins.size() == 0) {
			throw new PluginException("No serializers for contentType " + contentType + " found");
		}
		return allSerializerPlugins.iterator().next();
	}
	
	public Collection<SerializerPlugin> getAllSerializerPlugins(String contentType, boolean onlyEnabled) {
		Collection<SerializerPlugin> plugins = getPlugins(SerializerPlugin.class, onlyEnabled);
		Iterator<SerializerPlugin> iterator = plugins.iterator();
		while (iterator.hasNext()) {
			SerializerPlugin serializerPlugin = iterator.next();
			if (!serializerPlugin.getDefaultContentType().equalsIgnoreCase(contentType)) {
				iterator.remove();
			}
		}
		return plugins;
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

	public Collection<DeserializerPlugin> getAllDeserializerPlugins(String extension, boolean onlyEnabled) {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(onlyEnabled);
		Iterator<DeserializerPlugin> iterator = allDeserializerPlugins.iterator();
		while (iterator.hasNext()) {
			DeserializerPlugin deserializerPlugin = iterator.next();
			if (!deserializerPlugin.canHandleExtension(extension)) {
				iterator.remove();
			}
		}
		return allDeserializerPlugins;
	}

	public Collection<SchemaPlugin> getAllSchemaPlugins(boolean onlyEnabled) {
		return getPlugins(SchemaPlugin.class, onlyEnabled);
	}
	
	public SchemaDefinition requireSchemaDefinition() throws PluginException {
		Collection<SchemaPlugin> allSchemaPlugins = getAllSchemaPlugins(true);
		if (allSchemaPlugins.size() == 0) {
			throw new SchemaException("No schema plugins found");
		}
		SchemaPlugin schemaPlugin = allSchemaPlugins.iterator().next();
		if (!schemaPlugin.isInitialized()) {
			schemaPlugin.init(this);
		}
		return schemaPlugin.getSchemaDefinition();
	}
	
	public DeserializerPlugin requireDeserializer(String type) throws DeserializeException {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(type, true);
		if (allDeserializerPlugins.size() == 0) {
			throw new DeserializeException("No deserializers found for type '" + type + "'");
		} else {
			return allDeserializerPlugins.iterator().next();
		}
	}

	public IfcEnginePlugin requireIfcEngine() throws PluginException {
		Collection<IfcEnginePlugin> allIfcEnginePlugins = getAllIfcEnginePlugins(true);
		if (allIfcEnginePlugins.size() == 0) {
			throw new IfcEngineException("A working IfcEngine is required");
		}
		IfcEnginePlugin ifcEnginePlugin = allIfcEnginePlugins.iterator().next();
		if (!ifcEnginePlugin.isInitialized()) {
			ifcEnginePlugin.init(this);
		}
		return ifcEnginePlugin;
	}
	
	/*
	 * This will try to find at least one serializer for the content-type "application/ifc", if none are found an exception is throws, if more than 1 is found, the first one is returned
	 */
	public EmfSerializer requireIfcStepSerializer() throws SerializerException {
		String contentType = "application/ifc";
		Collection<SerializerPlugin> serializerPlugins = getAllSerializerPlugins(contentType, true);
		if (serializerPlugins.isEmpty()) {
			throw new SerializerException("A working serializer for the content type " + contentType + " is required");
		}
		SerializerPlugin serializerPlugin = serializerPlugins.iterator().next();
		EmfSerializer ifcSerializer = serializerPlugin.createSerializer();
		return ifcSerializer;
	}

	public GuidanceProvider requireGuidanceProvider() throws GuidanceProviderException {
		Collection<GuidanceProviderPlugin> plugins = getPlugins(GuidanceProviderPlugin.class, true);
		if (plugins.size() == 0) {
			throw new GuidanceProviderException("A guidance provider is required");
		}
		return plugins.iterator().next().getGuidanceProvider();
	}

	public ResourceFetcher getResourceFetcher() {
		return resourceFetcher;
	}

	public File getHomeDir() {
		return homeDir;
	}

	public void loadPlugin(Class<? extends Plugin> interfaceClass, String location, Plugin plugin) {
		if (!implementations.containsKey(interfaceClass)) {
			implementations.put(interfaceClass, new HashSet<PluginContext>());
		}
		Set<PluginContext> set = (Set<PluginContext>) implementations.get(interfaceClass);
		PluginContext pluginContext = new PluginContext(this);
		pluginContext.setPlugin(plugin);
		pluginContext.setLocation(location);
		set.add(pluginContext);
	}
	
	public void initAllLoadedPlugins() {
		for (Class<? extends Plugin> pluginClass : implementations.keySet()) {
			Set<PluginContext> set = implementations.get(pluginClass);
			for (PluginContext pluginContext : set) {
				try {
					Plugin plugin = pluginContext.getPlugin();
					if (!plugin.isInitialized()) {
						plugin.init(this);
					}
				} catch (Exception e) {
					LOGGER.error("", e);
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * Returns a complete classpath for all loaded plugins
	 */
	public String getCompleteClassPath() {
		StringBuilder sb = new StringBuilder();
		if (baseClassPath != null) {
			sb.append(baseClassPath + File.pathSeparator);
		}
		for (Class<? extends Plugin> pluginClass : implementations.keySet()) {
			Set<PluginContext> set = implementations.get(pluginClass);
			for (PluginContext pluginContext : set) {
				sb.append(pluginContext.getLocation() + File.pathSeparator);
			}
		}
		return sb.toString();
	}
	
	public DeserializerPlugin getFirstDeserializer(String extension, boolean onlyEnabled) throws PluginException {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(extension, onlyEnabled);
		if (allDeserializerPlugins.size() == 0) {
			throw new PluginException("No deserializers with extension " + extension + " found");
		}
		return allDeserializerPlugins.iterator().next();
	}

	public SchemaPlugin getFirstSchemaPlugin(boolean onlyEnabled) throws PluginException {
		Collection<SchemaPlugin> allSchemaPlugins = getAllSchemaPlugins(onlyEnabled);
		if (allSchemaPlugins.size() == 0) {
			throw new PluginException("No schema plugins found");
		}
		SchemaPlugin schemaPlugin = allSchemaPlugins.iterator().next();
		if (!schemaPlugin.isInitialized()) {
			schemaPlugin.init(this);
		}
		return schemaPlugin;
	}
}