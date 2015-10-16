package org.bimserver.plugins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.Schema;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.classloaders.DelegatingClassLoader;
import org.bimserver.plugins.classloaders.EclipsePluginClassloader;
import org.bimserver.plugins.classloaders.FileJarClassLoader;
import org.bimserver.plugins.classloaders.PublicFindClassClassLoader;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.modelmerger.ModelMergerPlugin;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaException;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.MessagingSerializerPlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewExtendedDataOnProjectHandler;
import org.bimserver.plugins.services.NewExtendedDataOnRevisionHandler;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.plugins.stillimagerenderer.StillImageRenderPlugin;
import org.bimserver.plugins.web.WebModulePlugin;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.utils.PathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginManager {
	private static final Map<String, FileSystem> fileSystems = new HashMap<>();
	private static final Logger LOGGER = LoggerFactory.getLogger(PluginManager.class);
	private final Map<Class<? extends Plugin>, Set<PluginContext>> implementations = new LinkedHashMap<Class<? extends Plugin>, Set<PluginContext>>();
	private final Set<Path> loadedLocations = new HashSet<>();
	private final Set<PluginChangeListener> pluginChangeListeners = new HashSet<PluginChangeListener>();
	private Path tempDir;
	private final String baseClassPath;
	private ServiceFactory serviceFactory;
	private NotificationsManagerInterface notificationsManagerInterface;
	private SServicesMap servicesMap;
	private BimServerClientFactory bimServerClientFactory;
	private MetaDataManager metaDataManager;

	public PluginManager(Path tempDir, String baseClassPath, ServiceFactory serviceFactory, NotificationsManagerInterface notificationsManagerInterface, SServicesMap servicesMap) {
		LOGGER.debug("Creating new PluginManager");
		this.tempDir = tempDir;
		this.baseClassPath = baseClassPath;
		this.serviceFactory = serviceFactory;
		this.notificationsManagerInterface = notificationsManagerInterface;
		this.servicesMap = servicesMap;
	}

	public PluginManager() {
		this.tempDir = Paths.get(System.getProperty("java.io.tmpdir"));
		this.baseClassPath = null;
	}

	public void loadPluginsFromEclipseProjectNoExceptions(Path projectRoot) {
		try {
			loadPluginsFromEclipseProject(projectRoot);
		} catch (PluginException e) {
			LOGGER.error("", e);
		}
	}
	
	public void loadPluginsFromEclipseProject(Path projectRoot) throws PluginException {
		for (Path path : loadedLocations) {
			if (projectRoot.startsWith(path)) {
				// Already loaded this plugin, or a "parent plugin"
				return;
			}
		}
		if (!Files.isDirectory(projectRoot)) {
			throw new PluginException("No directory: " + projectRoot.toString());
		}
		Path pluginFolder = projectRoot.resolve("plugin");
		if (!Files.isDirectory(pluginFolder)) {
			throw new PluginException("No 'plugin' directory found in " + projectRoot.toString());
		}
		Path pluginFile = pluginFolder.resolve("plugin.xml");
		if (!Files.exists(pluginFile)) {
			throw new PluginException("No 'plugin.xml' found in " + pluginFolder.toString());
		}
		try {
			PluginDescriptor pluginDescriptor = getPluginDescriptor(Files.newInputStream(pluginFile));
			DelegatingClassLoader delegatingClassLoader = new DelegatingClassLoader(getClass().getClassLoader());
			PublicFindClassClassLoader previous = new PublicFindClassClassLoader(getClass().getClassLoader()){
				@Override
				public Class<?> findClass(String name) throws ClassNotFoundException {
					return null;
				}

				@Override
				public URL findResource(String name) {
					return null;
				}

				@Override
				public void dumpStructure(int indent) {
				}
			};
			for (Dependency dependency : pluginDescriptor.getDependencies()) {
				Path path = projectRoot.getParent().resolve(dependency.getPath());
				
				DelegatingClassLoader depDelLoader = new DelegatingClassLoader(previous);
				Path depLibFolder = path.resolve("lib");
				loadDependencies(depLibFolder, delegatingClassLoader);
				EclipsePluginClassloader depLoader = new EclipsePluginClassloader(depDelLoader, path);
				previous = depLoader;
			}
			delegatingClassLoader.add(previous);
			Path libFolder = projectRoot.resolve("lib");
			loadDependencies(libFolder, delegatingClassLoader);
			EclipsePluginClassloader pluginClassloader = new EclipsePluginClassloader(delegatingClassLoader, projectRoot);
//			pluginClassloader.dumpStructure(0);
			loadedLocations.add(projectRoot);
			loadPlugins(pluginClassloader, projectRoot.toString(), projectRoot.resolve("bin").toString(), pluginDescriptor, PluginSourceType.ECLIPSE_PROJECT);
		} catch (JAXBException e) {
			throw new PluginException(e);
		} catch (FileNotFoundException e) {
			throw new PluginException(e);
		} catch (IOException e) {
			throw new PluginException(e);
		}
	}

	private void loadDependencies(Path libFolder, DelegatingClassLoader classLoader) throws FileNotFoundException, IOException {
		if (Files.isDirectory(libFolder)) {
			for (Path libFile : PathUtils.getDirectories(libFolder)) {
				if (libFile.getFileName().toString().toLowerCase().endsWith(".jar")) {
					FileJarClassLoader jarClassLoader = new FileJarClassLoader(this, classLoader, libFile);
					classLoader.add(jarClassLoader);
				} else if (Files.isDirectory(libFile)) {
					for (Path libFile2 : PathUtils.getDirectories(libFile)) {
						if (libFile2.getFileName().toString().toLowerCase().endsWith(".jar")) {
							FileJarClassLoader jarClassLoader = new FileJarClassLoader(this, classLoader, libFile2);
							classLoader.add(jarClassLoader);
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void loadPlugins(ClassLoader classLoader, String location, String classLocation, PluginDescriptor pluginDescriptor, PluginSourceType pluginType) throws PluginException {
		for (PluginImplementation pluginImplementation : pluginDescriptor.getImplementations()) {
			if (pluginImplementation.isEnabled()) {
				String interfaceClassName = pluginImplementation.getInterfaceClass().trim().replace("\n", "");
				try {
					Class interfaceClass = classLoader.loadClass(interfaceClassName);
					String implementationClassName = pluginImplementation.getImplementationClass().trim().replace("\n", "");
					try {
						Class implementationClass = classLoader.loadClass(implementationClassName);
						Plugin plugin = (Plugin) implementationClass.newInstance();
						loadPlugin(interfaceClass, location, classLocation, plugin, classLoader, pluginType, pluginImplementation);
					} catch (NoClassDefFoundError e) {
						throw new PluginException("Implementation class '" + implementationClassName + "' not found", e);
					} catch (ClassNotFoundException e) {
						throw new PluginException("Implementation class '" + implementationClassName + "' not found in " + location, e);
					} catch (InstantiationException e) {
						throw new PluginException(e);
					} catch (IllegalAccessException e) {
						throw new PluginException(e);
					}
				} catch (ClassNotFoundException e) {
					throw new PluginException("Interface class '" + interfaceClassName + "' not found", e);
				} catch (Error e) {
					throw new PluginException(e);
				}
			} else {
				LOGGER.info("Plugin " + pluginImplementation.getImplementationClass() + " is disabled in plugin.xml");
			}
		}
	}

	private PluginDescriptor getPluginDescriptor(InputStream inputStream) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(PluginDescriptor.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		PluginDescriptor pluginDescriptor = (PluginDescriptor) unmarshaller.unmarshal(inputStream);
		return pluginDescriptor;
	}

	public void loadAllPluginsFromDirectoryOfJars(Path directory) throws PluginException, IOException {
		LOGGER.debug("Loading all plugins from " + directory.toString());
		if (!Files.isDirectory(directory)) {
			throw new PluginException("No directory: " + directory.toString());
		}
		for (Path file : PathUtils.getDirectories(directory)) {
			if (file.getFileName().toString().toLowerCase().endsWith(".jar")) {
				try {
					loadPluginsFromJar(file);
				} catch (PluginException e) {
					LOGGER.error("", e);
				}
			}
		}
	}

	public void loadPluginsFromJar(Path file) throws PluginException {
		for (Path path : loadedLocations) {
			if (file.startsWith(path)) {
				// Already loaded this plugin, or a "parent plugin"
				return;
			}
		}
		LOGGER.debug("Loading plugins from " + file.toString());
		if (!Files.exists(file)) {
			throw new PluginException("Not a file: " + file.toString());
		}
		try {
			FileJarClassLoader jarClassLoader = new FileJarClassLoader(this, getClass().getClassLoader(), file);
			InputStream pluginStream = jarClassLoader.getResourceAsStream("plugin/plugin.xml");
			if (pluginStream == null) {
				throw new PluginException("No plugin/plugin.xml found in " + file.getFileName().toString());
			}
			PluginDescriptor pluginDescriptor = getPluginDescriptor(pluginStream);
			if (pluginDescriptor == null) {
				throw new PluginException("No plugin descriptor could be created");
			}
			LOGGER.debug(pluginDescriptor.toString());
			loadedLocations.add(file);
			loadPlugins(jarClassLoader, file.toAbsolutePath().toString(), file.toAbsolutePath().toString(), pluginDescriptor, PluginSourceType.JAR_FILE);
		} catch (JAXBException e) {
			throw new PluginException(e);
		} catch (FileNotFoundException e) {
			throw new PluginException(e);
		} catch (IOException e) {
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

	public Collection<RenderEnginePlugin> getAllRenderEnginePlugins(boolean onlyEnabled) {
		return getPlugins(RenderEnginePlugin.class, onlyEnabled);
	}

	public Collection<StillImageRenderPlugin> getAllStillImageRenderPlugins(boolean onlyEnabled) {
		return getPlugins(StillImageRenderPlugin.class, onlyEnabled);
	}

	public Collection<QueryEnginePlugin> getAllQueryEnginePlugins(boolean onlyEnabled) {
		return getPlugins(QueryEnginePlugin.class, onlyEnabled);
	}

	public Collection<SerializerPlugin> getAllSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(SerializerPlugin.class, onlyEnabled);
	}

	public Collection<MessagingSerializerPlugin> getAllMessagingSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(MessagingSerializerPlugin.class, onlyEnabled);
	}

	public Collection<DeserializerPlugin> getAllDeserializerPlugins(boolean onlyEnabled) {
		return getPlugins(DeserializerPlugin.class, onlyEnabled);
	}

	public Collection<Plugin> getAllPlugins(boolean onlyEnabled) {
		return getPlugins(Plugin.class, onlyEnabled);
	}

	public PluginContext getPluginContext(Plugin plugin) {
		// TODO make more efficient
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getPlugin() == plugin) {
					return pluginContext;
				}
			}
		}
		throw new RuntimeException("No plugin context found for " + plugin);
	}

	/**
	 * Load all plugins that can be found in the current classloader, if you downloaded a BIMserver client library and 
	 * added certain plugins to the classpath, this method should be able to find and load them
	 */
	public void loadPluginsFromCurrentClassloader() {
		try {
			Enumeration<URL> resources = getClass().getClassLoader().getResources("plugin/plugin.xml");
			while (resources.hasMoreElements()) {
				URL url = resources.nextElement();
				LOGGER.info("Loading " + url);
				PluginDescriptor pluginDescriptor = getPluginDescriptor(url.openStream());
				loadPlugins(getClass().getClassLoader(), url.toString(), url.toString(), pluginDescriptor, PluginSourceType.INTERNAL);
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
	
	public SchemaDefinition requireSchemaDefinition(String name) throws PluginException {
		Collection<SchemaPlugin> allSchemaPlugins = getAllSchemaPlugins(true);
		if (allSchemaPlugins.size() == 0) {
			throw new SchemaException("No schema plugins found");
		}
		for (SchemaPlugin schemaPlugin : allSchemaPlugins) {
			if (!schemaPlugin.isInitialized()) {
				schemaPlugin.init(this);
			}
			if (schemaPlugin.getSchemaVersion().toLowerCase().equals(name.toLowerCase())) {
				return schemaPlugin.getSchemaDefinition(new PluginConfiguration());
			}
		}
		throw new PluginException("No schema definition found for " + name);
	}
	
	public DeserializerPlugin requireDeserializer(String extension) throws DeserializeException {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(extension, true);
		if (allDeserializerPlugins.size() == 0) {
			throw new DeserializeException("No deserializers found for type '" + extension + "'");
		} else {
			return allDeserializerPlugins.iterator().next();
		}
	}

	public RenderEnginePlugin requireRenderEngine() throws PluginException {
		Collection<RenderEnginePlugin> allRenderEnginePlugins = getAllRenderEnginePlugins(true);
		if (allRenderEnginePlugins.size() == 0) {
			throw new RenderEngineException("A working RenderEngine is required");
		}
		RenderEnginePlugin renderEnginePlugin = allRenderEnginePlugins.iterator().next();
		if (!renderEnginePlugin.isInitialized()) {
			renderEnginePlugin.init(this);
		}
		return renderEnginePlugin;
	}
	
	public ObjectIDM requireObjectIDM() throws ObjectIDMException {
		Collection<ObjectIDMPlugin> plugins = getPlugins(ObjectIDMPlugin.class, true);
		if (plugins.size() == 0) {
			throw new ObjectIDMException("An ObjectIDM is required");
		}
		return plugins.iterator().next().getObjectIDM(new PluginConfiguration());
	}

	public Path getTempDir() {
		return tempDir;
	}

	public void loadPlugin(Class<? extends Plugin> interfaceClass, String location, String classLocation, Plugin plugin, ClassLoader classLoader, PluginSourceType pluginType, PluginImplementation pluginImplementation) throws PluginException {
		LOGGER.debug("Loading plugin " + plugin.getClass().getSimpleName() + " of type " + interfaceClass.getSimpleName());
		if (!Plugin.class.isAssignableFrom(interfaceClass)) {
			throw new PluginException("Given interface class (" + interfaceClass.getName() + ") must be a subclass of " + Plugin.class.getName());
		}
		if (!implementations.containsKey(interfaceClass)) {
			implementations.put(interfaceClass, new LinkedHashSet<PluginContext>());
		}
		Set<PluginContext> set = (Set<PluginContext>) implementations.get(interfaceClass);
		try {
			set.add(new PluginContext(this, classLoader, pluginType, location, plugin, pluginImplementation, classLocation));
		} catch (IOException e) {
			throw new PluginException(e);
		}
	}
	
	/**
	 * This method will initialize all the loaded plugins
	 * 
	 * @throws PluginException
	 */
	public void initAllLoadedPlugins() throws PluginException {
		LOGGER.debug("Initializig all loaded plugins");
		for (Class<? extends Plugin> pluginClass : implementations.keySet()) {
			Set<PluginContext> set = implementations.get(pluginClass);
			for (PluginContext pluginContext : set) {
				try {
					Plugin plugin = pluginContext.getPlugin();
					if (!plugin.isInitialized()) {
						plugin.init(this);
					}
				} catch (Throwable e) {
					LOGGER.error("", e);
					pluginContext.setEnabled(false, false);
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
	
	public DeserializerPlugin getFirstDeserializer(String extension, Schema schema, boolean onlyEnabled) throws PluginException {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(extension, onlyEnabled);
		Iterator<DeserializerPlugin> iterator = allDeserializerPlugins.iterator();
		while (iterator.hasNext()) {
			DeserializerPlugin next = iterator.next();
			if (!next.getSupportedSchemas().contains(schema)) {
				iterator.remove();
			}
		}
		if (allDeserializerPlugins.size() == 0) {
			throw new PluginException("No deserializers with extension " + extension + " found");
		}
		return allDeserializerPlugins.iterator().next();
	}

	public SchemaPlugin getFirstSchemaPlugin(String schema, boolean onlyEnabled) throws PluginException {
		Collection<SchemaPlugin> allSchemaPlugins = getAllSchemaPlugins(onlyEnabled);
		if (allSchemaPlugins.size() == 0) {
			throw new PluginException("No schema plugins found");
		}
		for (SchemaPlugin schemaPlugin : allSchemaPlugins) {
			if (schemaPlugin.getSchemaVersion().equals(schema)) {
				if (!schemaPlugin.isInitialized()) {
					schemaPlugin.init(this);
				}
				return schemaPlugin;
			}
		}
		return null;
	}

	public ObjectIDMPlugin getObjectIDMByName(String className, boolean onlyEnabled) {
		return getPluginByClassName(ObjectIDMPlugin.class, className, onlyEnabled);
	}

	public RenderEnginePlugin getRenderEngine(String className, boolean onlyEnabled) {
		return getPluginByClassName(RenderEnginePlugin.class, className, onlyEnabled);
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

	public void loadAllPluginsFromEclipseWorkspace(Path file, boolean showExceptions) throws PluginException, IOException {
		if (file != null && Files.isDirectory(file)) {
			for (Path project : PathUtils.getDirectories(file)) {
				if (Files.isDirectory(project)) {
					Path pluginDir = project.resolve("plugin");
					if (Files.exists(pluginDir)) {
						Path pluginFile = pluginDir.resolve("plugin.xml");
						if (Files.exists(pluginFile)) {
							if (showExceptions) {
								loadPluginsFromEclipseProject(project);
							} else {
								loadPluginsFromEclipseProjectNoExceptions(project);
							}
						}
					}
				}
			}
		}
	}
	
	public void loadAllPluginsFromEclipseWorkspaces(Path directory, boolean showExceptions) throws PluginException, IOException {
		if (!Files.isDirectory(directory)) {
			return;
		}
		if (Files.exists(directory.resolve("plugin/plugin.xml"))) {
			if (showExceptions) {
				loadPluginsFromEclipseProject(directory);
			} else {
				loadPluginsFromEclipseProjectNoExceptions(directory);
			}
		}
		loadAllPluginsFromEclipseWorkspace(directory, showExceptions);
		for (Path workspace : PathUtils.getDirectories(directory)) {
			if (Files.isDirectory(workspace)) {
				loadAllPluginsFromEclipseWorkspace(workspace, showExceptions);
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

	public void registerNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewRevisionHandler newRevisionHandler) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.registerInternalNewRevisionHandler(uoid, serviceDescriptor, newRevisionHandler);
		}
	}

	public void unregisterNewRevisionHandler(ServiceDescriptor serviceDescriptor) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.unregisterInternalNewRevisionHandler(serviceDescriptor);
		}
	}
	
	public SServicesMap getServicesMap() {
		return servicesMap;
	}

	public StillImageRenderPlugin getFirstStillImageRenderPlugin() throws PluginException {
		Collection<StillImageRenderPlugin> allPlugins = getAllStillImageRenderPlugins(true);
		if (allPlugins.size() == 0) {
			throw new PluginException("No still image render plugins found");
		}
		StillImageRenderPlugin plugin = allPlugins.iterator().next();
		if (!plugin.isInitialized()) {
			plugin.init(this);
		}
		return plugin;
		
	}

	public Parameter getParameter(PluginContext pluginContext, String name) {
		return null;
	}

	public SerializerPlugin getSerializerPlugin(String className, boolean onlyEnabled) {
		return (SerializerPlugin) getPlugin(className, onlyEnabled);
	}

	public MessagingSerializerPlugin getMessagingSerializerPlugin(String className, boolean onlyEnabled) {
		return (MessagingSerializerPlugin) getPlugin(className, onlyEnabled);
	}

	public WebModulePlugin getWebModulePlugin(String className, boolean onlyEnabled) {
		return (WebModulePlugin) getPlugin(className, onlyEnabled);
	}

	public Collection<WebModulePlugin> getAllWebPlugins(boolean onlyEnabled) {
		return getPlugins(WebModulePlugin.class, onlyEnabled);
	}

	public Collection<ModelCheckerPlugin> getAllModelCheckerPlugins(boolean onlyEnabled) {
		return getPlugins(ModelCheckerPlugin.class, onlyEnabled);
	}

	public ModelCheckerPlugin getModelCheckerPlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ModelCheckerPlugin.class, className, onlyEnabled);
	}

	public BimServerClientInterface getLocalBimServerClientInterface(AuthenticationInfo tokenAuthentication) throws ServiceException, ChannelConnectionException {
		return bimServerClientFactory.create(tokenAuthentication);
	}

	public void setBimServerClientFactory(BimServerClientFactory bimServerClientFactory) {
		this.bimServerClientFactory = bimServerClientFactory;
	}

	public void registerNewExtendedDataOnProjectHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnProjectHandler newExtendedDataHandler) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.registerInternalNewExtendedDataOnProjectHandler(uoid, serviceDescriptor, newExtendedDataHandler);
		}
	}

	public void registerNewExtendedDataOnRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, NewExtendedDataOnRevisionHandler newExtendedDataHandler) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.registerInternalNewExtendedDataOnRevisionHandler(uoid, serviceDescriptor, newExtendedDataHandler);
		}
	}
	
	public DeserializerPlugin getDeserializerPlugin(String pluginClassName, boolean onlyEnabled) {
		return getPluginByClassName(DeserializerPlugin.class, pluginClassName, onlyEnabled);
	}

	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
	}
	
	public void setMetaDataManager(MetaDataManager metaDataManager) {
		this.metaDataManager = metaDataManager;
	}
	
	public FileSystem getOrCreateFileSystem(String location) throws IOException {
		FileSystem fileSystem = fileSystems.get(location);
		if (fileSystem == null) {
			URI uri = URI.create("jar:file:" + new File(location).toURI());
			Map<String, String> env = new HashMap<>();
			env.put("create", "true");
			try {
				fileSystem = FileSystems.newFileSystem(uri, env, null);
				LOGGER.info("Created VFS for " + location);
			} catch (FileSystemAlreadyExistsException e) {
				LOGGER.error(location, e);
			}
			fileSystems.put(location, fileSystem);
		}
		return fileSystem;
	}
}