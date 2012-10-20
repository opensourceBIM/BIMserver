package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.classloaders.DelegatingClassLoader;
import org.bimserver.plugins.classloaders.EclipsePluginClassloader;
import org.bimserver.plugins.classloaders.JarClassLoader;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.modelmerger.ModelMergerPlugin;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaException;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.meta.ServicesMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginManager {
	private final Logger LOGGER = LoggerFactory.getLogger(PluginManager.class);
	private final Map<Class<? extends Plugin>, Set<PluginContext>> implementations = new LinkedHashMap<Class<? extends Plugin>, Set<PluginContext>>();
	private final Set<PluginChangeListener> pluginChangeListeners = new HashSet<PluginChangeListener>();
	private File tempDir;
	private final String baseClassPath;
	private ServiceFactory serviceFactory;
	private NotificationsManagerInterface notificationsManagerInterface;
	private ServicesMap servicesMap;

	public PluginManager(File tempDir, String baseClassPath, ServiceFactory serviceFactory, NotificationsManagerInterface notificationsManagerInterface, ServicesMap servicesMap) {
		this.tempDir = tempDir;
		this.baseClassPath = baseClassPath;
		this.serviceFactory = serviceFactory;
		this.notificationsManagerInterface = notificationsManagerInterface;
		this.servicesMap = servicesMap;
	}

	public PluginManager() {
		this.tempDir = new File(System.getProperty("java.io.tmpdir"));
		this.baseClassPath = null;
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
			loadPlugins(pluginClassloader, projectRoot.getAbsolutePath(), new File(projectRoot, "bin").getAbsolutePath(), pluginDescriptor, PluginType.ECLIPSE_PROJECT);
		} catch (JAXBException e) {
			throw new PluginException(e);
		} catch (FileNotFoundException e) {
			throw new PluginException(e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void loadPlugins(ClassLoader classLoader, String location, String classLocation, PluginDescriptor pluginDescriptor, PluginType pluginType) throws PluginException {
		for (PluginImplementation pluginImplementation : pluginDescriptor.getImplementations()) {
			String interfaceClassName = pluginImplementation.getInterfaceClass();
			try {
				Class interfaceClass = classLoader.loadClass(interfaceClassName);
				String implementationClassName = pluginImplementation.getImplementationClass();
				try {
					Class implementationClass = classLoader.loadClass(implementationClassName);
					Plugin plugin = (Plugin) implementationClass.newInstance();
					loadPlugin(interfaceClass, location, classLocation, plugin, classLoader, pluginType);
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
			loadPlugins(jarClassLoader, file.getAbsolutePath(), file.getAbsolutePath(), pluginDescriptor, PluginType.JAR_FILE);
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
	
	public Collection<ObjectIDMPlugin> getAllObjectIDMPlugins(boolean onlyEnabled) {
		return getPlugins(ObjectIDMPlugin.class, onlyEnabled);
	}

	public Collection<IfcEnginePlugin> getAllIfcEnginePlugins(boolean onlyEnabled) {
		return getPlugins(IfcEnginePlugin.class, onlyEnabled);
	}

	public Collection<QueryEnginePlugin> getAllQueryEnginePlugins(boolean onlyEnabled) {
		return getPlugins(QueryEnginePlugin.class, onlyEnabled);
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

	public void loadPluginsFromCurrentClassloader() {
		try {
			Enumeration<URL> resources = getClass().getClassLoader().getResources("plugin/plugin.xml");
			while (resources.hasMoreElements()) {
				URL url = resources.nextElement();
				LOGGER.info("Loading " + url);
				PluginDescriptor pluginDescriptor = getPluginDescriptor(url.openStream());
				loadPlugins(getClass().getClassLoader(), url.toString(), url.toString(), pluginDescriptor, PluginType.INTERNAL);
			}
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (JAXBException e) {
			LOGGER.error("", e);
		} catch (PluginException e) {
			LOGGER.error("", e);
		}
	}
	
	public void enablePlugin(String name) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin().getClass().getName().equals(name)) {
					pluginContext.setEnabled(true, true);
				}
			}
		}
	}

	public void disablePlugin(String name) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin().getClass().getName().equals(name)) {
					pluginContext.setEnabled(false, true);
				}
			}
		}
	}

	public Plugin getPlugin(String className, boolean onlyEnabled) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin().getClass().getName().equals(className)) {
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
	
	public DeserializerPlugin requireDeserializer(String extension) throws DeserializeException {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(extension, true);
		if (allDeserializerPlugins.size() == 0) {
			throw new DeserializeException("No deserializers found for type '" + extension + "'");
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
	public Serializer requireIfcStepSerializer() throws SerializerException {
		String contentType = "application/ifc";
		Collection<SerializerPlugin> serializerPlugins = getAllSerializerPlugins(contentType, true);
		if (serializerPlugins.isEmpty()) {
			throw new SerializerException("A working serializer for the content type " + contentType + " is required");
		}
		SerializerPlugin serializerPlugin = serializerPlugins.iterator().next();
		Serializer ifcSerializer = serializerPlugin.createSerializer();
		return ifcSerializer;
	}

	public ObjectIDM requireObjectIDM() throws ObjectIDMException {
		Collection<ObjectIDMPlugin> plugins = getPlugins(ObjectIDMPlugin.class, true);
		if (plugins.size() == 0) {
			throw new ObjectIDMException("An ObjectIDM is required");
		}
		return plugins.iterator().next().getObjectIDM();
	}

	public File getTempDir() {
		return tempDir;
	}

	public void loadPlugin(Class<? extends Plugin> interfaceClass, String location, String classLocation, Plugin plugin, ClassLoader classLoader, PluginType pluginType) throws PluginException {
		if (!Plugin.class.isAssignableFrom(interfaceClass)) {
			throw new PluginException("Given interface class (" + interfaceClass.getName() + ") must be a subclass of " + Plugin.class.getName());
		}
		if (!implementations.containsKey(interfaceClass)) {
			implementations.put(interfaceClass, new LinkedHashSet<PluginContext>());
		}
		Set<PluginContext> set = (Set<PluginContext>) implementations.get(interfaceClass);
		PluginContext pluginContext = new PluginContext(this, classLoader, pluginType, location);
		pluginContext.setPlugin(plugin);
		pluginContext.setClassLocation(classLocation);
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
				sb.append(pluginContext.getClassLocation() + File.pathSeparator);
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

	public ObjectIDMPlugin getObjectIDMByName(String className, boolean onlyEnabled) {
		return getPluginByClassName(ObjectIDMPlugin.class, className, onlyEnabled);
	}

	public IfcEnginePlugin getIfcEngine(String className, boolean onlyEnabled) {
		return getPluginByClassName(IfcEnginePlugin.class, className, onlyEnabled);
	}

	private <T extends Plugin> T getPluginByClassName(Class<T> clazz, String className, boolean onlyEnabled) {
		Collection<T> allPlugins = getPlugins(clazz, onlyEnabled);
		for (T t : allPlugins) {
			if (t.getClass().getName().equals(className)) {
				return t;
			}
		}
		return null;
	}
	
	public QueryEnginePlugin getQueryEngine(String className, boolean onlyEnabled) {
		return getPluginByClassName(QueryEnginePlugin.class, className, onlyEnabled);
	}

	public void loadAllPluginsFromEclipseWorkspace(File file) {
		for (File project : file.listFiles()) {
			File pluginDir = new File(project, "plugin");
			if (pluginDir.exists()) {
				File pluginFile = new File(pluginDir, "plugin.xml");
				if (pluginFile.exists()) {
					try {
						loadPluginsFromEclipseProject(project);
					} catch (PluginException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public Collection<ModelMergerPlugin> getAllModelMergerPlugins(boolean onlyEnabled) {
		return getPlugins(ModelMergerPlugin.class, onlyEnabled);
	}

	public Collection<ModelComparePlugin> getAllModelComparePlugins(boolean onlyEnabled) {
		return getPlugins(ModelComparePlugin.class, onlyEnabled);
	}

	public ModelMergerPlugin getModelMergerPlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ModelMergerPlugin.class, className, onlyEnabled);
	}

	public ModelComparePlugin getModelComparePlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ModelComparePlugin.class, className, onlyEnabled);
	}

	public Collection<ServicePlugin> getAllServicePlugins(boolean onlyEnabled) {
		return getPlugins(ServicePlugin.class, onlyEnabled);
	}

	public ServicePlugin getServicePlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ServicePlugin.class, className, onlyEnabled);
	}

	public ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void registerNewRevisionHandler(ServiceDescriptor serviceDescriptor, NewRevisionHandler newRevisionHandler) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.registerNewRevisionHandler(serviceDescriptor, newRevisionHandler);
		}
	}
	
	public ServicesMap getServicesMap() {
		return servicesMap;
	}
}