package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.Schema;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.interfaces.objects.SPluginType;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerErrorCode;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.StreamingDeserializerPlugin;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.modelmerger.ModelMergerPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.MessagingSerializerPlugin;
import org.bimserver.plugins.serializers.MessagingStreamingSerializerPlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
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
import org.bimserver.shared.PluginClassLoaderProvider;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SServicesMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginManager implements PluginManagerInterface, PluginClassLoaderProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(PluginManager.class);
	private static Unmarshaller PLUGIN_DESCRIPTOR_UNMARSHALLER;
	private final Map<Class<? extends Plugin>, Set<PluginContext>> implementations = new LinkedHashMap<>();
	private final Map<Plugin, PluginContext> pluginToPluginContext = new HashMap<>();

	private final Path tempDir;
	private final String baseClassPath;
	private final ServiceFactory serviceFactory;
	private final NotificationsManagerInterface notificationsManagerInterface;
	private final SServicesMap servicesMap;
	private PluginChangeListener pluginChangeListener;
	private BimServerClientFactory bimServerClientFactory;
	private MetaDataManager metaDataManager;
	private BasicServerInfoProvider basicServerInfoProvider;

	static {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PluginDescriptor.class);
			PLUGIN_DESCRIPTOR_UNMARSHALLER = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			LOGGER.error("", e);
		}
	}
	
	public PluginManager(Path tempDir, String baseClassPath, ServiceFactory serviceFactory, NotificationsManagerInterface notificationsManagerInterface,
			SServicesMap servicesMap, BasicServerInfoProvider basicServerInfoProvider) {
		this.basicServerInfoProvider = basicServerInfoProvider;
		LOGGER.debug("Creating new PluginManager");
		this.tempDir = tempDir;
		this.baseClassPath = baseClassPath;
		this.serviceFactory = serviceFactory;
		this.notificationsManagerInterface = notificationsManagerInterface;
		this.servicesMap = servicesMap;
	}

	public PluginDescriptor getPluginDescriptor(InputStream inputStream) throws JAXBException, IOException {
		try {
			PluginDescriptor pluginDescriptor = (PluginDescriptor) PLUGIN_DESCRIPTOR_UNMARSHALLER.unmarshal(inputStream);
			return pluginDescriptor;
		} finally {
			inputStream.close();
		}
	}

	public PluginDescriptor getPluginDescriptor(byte[] bytes) throws JAXBException, IOException {
		return getPluginDescriptor(new ByteArrayInputStream(bytes));
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	private <T> Map<PluginContext, T> getPlugins(Class<T> requiredInterfaceClass, boolean onlyEnabled) {
		Map<PluginContext, T> plugins = new HashMap<>();
		for (Class interfaceClass : implementations.keySet()) {
			if (requiredInterfaceClass.isAssignableFrom(interfaceClass)) {
				for (PluginContext pluginContext : implementations.get(interfaceClass)) {
					if (!onlyEnabled || pluginContext.isEnabled()) {
						plugins.put(pluginContext, (T) pluginContext.getPlugin());
					}
				}
			}
		}
		return plugins;
	}

	public Map<PluginContext, RenderEnginePlugin> getAllRenderEnginePlugins(boolean onlyEnabled) {
		return getPlugins(RenderEnginePlugin.class, onlyEnabled);
	}

	public Map<PluginContext, StillImageRenderPlugin> getAllStillImageRenderPlugins(boolean onlyEnabled) {
		return getPlugins(StillImageRenderPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, QueryEnginePlugin> getAllQueryEnginePlugins(boolean onlyEnabled) {
		return getPlugins(QueryEnginePlugin.class, onlyEnabled);
	}

	public Map<PluginContext, SerializerPlugin> getAllSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(SerializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, MessagingSerializerPlugin> getAllMessagingSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(MessagingSerializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, MessagingStreamingSerializerPlugin> getAllMessagingStreamingSerializerPlugins(boolean onlyEnabled) {
		return getPlugins(MessagingStreamingSerializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, DeserializerPlugin> getAllDeserializerPlugins(boolean onlyEnabled) {
		return getPlugins(DeserializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, StreamingDeserializerPlugin> getAllStreamingDeserializerPlugins(boolean onlyEnabled) {
		return getPlugins(StreamingDeserializerPlugin.class, onlyEnabled);
	}

	public Collection<StreamingDeserializerPlugin> getAllStreamingDeserializerPlugins(String extension, boolean onlyEnabled) {
		Collection<StreamingDeserializerPlugin> allDeserializerPlugins = getAllStreamingDeserializerPlugins(onlyEnabled).values();
		Iterator<StreamingDeserializerPlugin> iterator = allDeserializerPlugins.iterator();
		while (iterator.hasNext()) {
			StreamingDeserializerPlugin deserializerPlugin = iterator.next();
			if (!deserializerPlugin.canHandleExtension(extension)) {
				iterator.remove();
			}
		}
		return allDeserializerPlugins;
	}

	public Map<PluginContext, StreamingSerializerPlugin> getAllStreamingSeserializerPlugins(boolean onlyEnabled) {
		return getPlugins(StreamingSerializerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, Plugin> getAllPlugins(boolean onlyEnabled) {
		return getPlugins(Plugin.class, onlyEnabled);
	}

	public PluginContext getPluginContext(Plugin plugin) {
		PluginContext pluginContext = pluginToPluginContext.get(plugin);
		if (pluginContext == null) {
			throw new RuntimeException("No plugin context found for " + plugin);
		}
		return pluginContext;
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

	public Plugin getPlugin(String identifier, boolean onlyEnabled) {
		for (Set<PluginContext> pluginContexts : implementations.values()) {
			for (PluginContext pluginContext : pluginContexts) {
				if (pluginContext.getIdentifier().equals(identifier)) {
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

	public void setPluginChangeListener(PluginChangeListener pluginChangeListener) {
		this.pluginChangeListener = pluginChangeListener;
	}

	public Collection<DeserializerPlugin> getAllDeserializerPlugins(String extension, boolean onlyEnabled) {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(onlyEnabled).values();
		Iterator<DeserializerPlugin> iterator = allDeserializerPlugins.iterator();
		while (iterator.hasNext()) {
			DeserializerPlugin deserializerPlugin = iterator.next();
			if (!deserializerPlugin.canHandleExtension(extension)) {
				iterator.remove();
			}
		}
		return allDeserializerPlugins;
	}

	public DeserializerPlugin requireDeserializer(String extension) throws DeserializeException {
		Collection<DeserializerPlugin> allDeserializerPlugins = getAllDeserializerPlugins(extension, true);
		if (allDeserializerPlugins.size() == 0) {
			throw new DeserializeException(DeserializerErrorCode.NO_SUITABLE_DESERIALIZER_FOUND, "No deserializers found for type '" + extension + "'");
		} else {
			return allDeserializerPlugins.iterator().next();
		}
	}

	public Path getTempDir() {
		if (!Files.isDirectory(tempDir)) {
			try {
				Files.createDirectories(tempDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tempDir;
	}

	public PluginContext loadPlugin(PluginBundle pluginBundle, Class<? extends Plugin> interfaceClass, URI location, String classLocation, Plugin plugin, ClassLoader classLoader, PluginSourceType pluginType,
			AbstractPlugin pluginImplementation, Set<org.bimserver.plugins.Dependency> dependencies, String identifier) throws PluginException {
		LOGGER.debug("Loading plugin " + plugin.getClass().getSimpleName() + " of type " + interfaceClass.getSimpleName());
		if (!Plugin.class.isAssignableFrom(interfaceClass)) {
			throw new PluginException("Given interface class (" + interfaceClass.getName() + ") must be a subclass of " + Plugin.class.getName());
		}
		if (!implementations.containsKey(interfaceClass)) {
			implementations.put(interfaceClass, new LinkedHashSet<PluginContext>());
		}
		Set<PluginContext> set = (Set<PluginContext>) implementations.get(interfaceClass);
		try {
			PluginContext pluginContext = new PluginContext(this, pluginBundle, interfaceClass, classLoader, pluginType, pluginImplementation.getDescription(), location, plugin, classLocation, dependencies, identifier);
			pluginToPluginContext.put(plugin, pluginContext);
			set.add(pluginContext);
			return pluginContext;
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
					pluginContext.initialize(pluginContext.getSystemSettings());
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

	public StreamingDeserializerPlugin getFirstStreamingDeserializer(String extension, Schema schema, boolean onlyEnabled) throws PluginException {
		Collection<StreamingDeserializerPlugin> allDeserializerPlugins = getAllStreamingDeserializerPlugins(extension, onlyEnabled);
		Iterator<StreamingDeserializerPlugin> iterator = allDeserializerPlugins.iterator();
		while (iterator.hasNext()) {
			StreamingDeserializerPlugin next = iterator.next();
			if (!next.getSupportedSchemas().contains(schema)) {
				iterator.remove();
			}
		}
		if (allDeserializerPlugins.size() == 0) {
			throw new PluginException("No deserializers with extension " + extension + " found");
		}
		return allDeserializerPlugins.iterator().next();
	}

	public RenderEnginePlugin getRenderEnginePlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(RenderEnginePlugin.class, className, onlyEnabled);
	}

	private <T extends Plugin> T getPluginByClassName(Class<T> clazz, String className, boolean onlyEnabled) {
		Collection<T> allPlugins = getPlugins(clazz, onlyEnabled).values();
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

	public Map<PluginContext, ModelMergerPlugin> getAllModelMergerPlugins(boolean onlyEnabled) {
		return getPlugins(ModelMergerPlugin.class, onlyEnabled);
	}

	public Map<PluginContext, ModelComparePlugin> getAllModelComparePlugins(boolean onlyEnabled) {
		return getPlugins(ModelComparePlugin.class, onlyEnabled);
	}

	public ModelMergerPlugin getModelMergerPlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ModelMergerPlugin.class, className, onlyEnabled);
	}

	public ModelComparePlugin getModelComparePlugin(String className, boolean onlyEnabled) {
		return getPluginByClassName(ModelComparePlugin.class, className, onlyEnabled);
	}

	public Map<PluginContext, ServicePlugin> getAllServicePlugins(boolean onlyEnabled) {
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

	public void unregisterNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor) {
		if (notificationsManagerInterface != null) {
			notificationsManagerInterface.unregisterInternalNewRevisionHandler(uoid, serviceDescriptor.getIdentifier());
		}
	}

	public SServicesMap getServicesMap() {
		return servicesMap;
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

	public Map<PluginContext, WebModulePlugin> getAllWebPlugins(boolean onlyEnabled) {
		return getPlugins(WebModulePlugin.class, onlyEnabled);
	}

	public Map<PluginContext, ModelCheckerPlugin> getAllModelCheckerPlugins(boolean onlyEnabled) {
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

	public StreamingDeserializerPlugin getStreamingDeserializerPlugin(String pluginClassName, boolean onlyEnabled) {
		return getPluginByClassName(StreamingDeserializerPlugin.class, pluginClassName, onlyEnabled);
	}

	public StreamingSerializerPlugin getStreamingSerializerPlugin(String pluginClassName, boolean onlyEnabled) {
		return getPluginByClassName(StreamingSerializerPlugin.class, pluginClassName, onlyEnabled);
	}

	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
	}

	public void setMetaDataManager(MetaDataManager metaDataManager) {
		this.metaDataManager = metaDataManager;
	}

	public FileSystem getOrCreateFileSystem(URI uri) throws IOException {
		FileSystem fileSystem = null;
		try {
			fileSystem = FileSystems.getFileSystem(uri);
		} catch (FileSystemNotFoundException e) {
			Map<String, String> env = new HashMap<>();
			env.put("create", "true");
			fileSystem = FileSystems.newFileSystem(uri, env, null);
			LOGGER.debug("Created VFS for " + uri);
		}
		return fileSystem;
	}

	public MessagingStreamingSerializerPlugin getMessagingStreamingSerializerPlugin(String className, boolean onlyEnabled) {
		return (MessagingStreamingSerializerPlugin) getPlugin(className, onlyEnabled);
	}

	public List<SPluginInformation> getPluginInformationFromJar(Path file) throws PluginException, FileNotFoundException, IOException, JAXBException {
		try (JarFile jarFile = new JarFile(file.toFile())) {
			ZipEntry entry = jarFile.getEntry("plugin/plugin.xml");
			if (entry == null) {
				throw new PluginException("No plugin/plugin.xml found in " + file.getFileName().toString());
			}
			InputStream pluginStream = jarFile.getInputStream(entry);
			return getPluginInformationFromPluginFile(pluginStream);
		}
	}

	public List<SPluginInformation> getPluginInformationFromJar(InputStream jarInputStream) throws PluginException, FileNotFoundException, IOException, JAXBException {
		try (JarInputStream jarInputStream2 = new JarInputStream(jarInputStream)) {
			JarEntry next = jarInputStream2.getNextJarEntry();
			while (next != null) {
				if (next.getName().equals("plugin/plugin.xml")) {
					return getPluginInformationFromPluginFile(jarInputStream2);
				}
				next = jarInputStream2.getNextJarEntry();
			}
		}
		return null;
	}

	public List<SPluginInformation> getPluginInformationFromPluginFile(InputStream inputStream) throws PluginException, FileNotFoundException, IOException, JAXBException {
		PluginDescriptor pluginDescriptor = getPluginDescriptor(inputStream);
		if (pluginDescriptor == null) {
			throw new PluginException("No plugin descriptor could be created");
		}
		List<SPluginInformation> list = new ArrayList<>();
		processPluginDescriptor(pluginDescriptor, list);
		return list;
	}

	public void processPluginDescriptor(PluginDescriptor pluginDescriptor, List<SPluginInformation> list) {
		for (AbstractPlugin pluginImplementation : pluginDescriptor.getPlugins()) {
			if (pluginImplementation instanceof JavaPlugin) {
				JavaPlugin javaPlugin = (JavaPlugin) pluginImplementation;
				SPluginInformation sPluginInformation = new SPluginInformation();
				String name = javaPlugin.getName();
				// TODO when all plugins have a name, this code can go
				if (name == null) {
					name = javaPlugin.getImplementationClass();
				}
				sPluginInformation.setName(name);
				sPluginInformation.setDescription(javaPlugin.getDescription());
				sPluginInformation.setEnabled(true);

				// For java plugins we use the implementation class as
				// identifier
				sPluginInformation.setIdentifier(javaPlugin.getImplementationClass());

				sPluginInformation.setType(getPluginTypeFromClass(javaPlugin.getInterfaceClass()));
				list.add(sPluginInformation);
			} else if (pluginImplementation instanceof org.bimserver.plugins.WebModulePlugin) {
				org.bimserver.plugins.WebModulePlugin webModulePlugin = (org.bimserver.plugins.WebModulePlugin) pluginImplementation;
				SPluginInformation sPluginInformation = new SPluginInformation();
				sPluginInformation.setIdentifier(webModulePlugin.getIdentifier());
				sPluginInformation.setName(webModulePlugin.getName());
				sPluginInformation.setDescription(webModulePlugin.getDescription());
				sPluginInformation.setType(SPluginType.WEB_MODULE);
				sPluginInformation.setEnabled(true);
				list.add(sPluginInformation);
			}
		}
	}

	public List<SPluginInformation> getPluginInformationFromPluginFile(Path file) throws PluginException, FileNotFoundException, IOException, JAXBException {
		List<SPluginInformation> list = new ArrayList<>();
		try (InputStream pluginStream = Files.newInputStream(file)) {
			PluginDescriptor pluginDescriptor = getPluginDescriptor(pluginStream);
			if (pluginDescriptor == null) {
				throw new PluginException("No plugin descriptor could be created");
			}
			processPluginDescriptor(pluginDescriptor, list);
		}
		return list;
	}

	public SPluginType getPluginTypeFromClass(String className) {
		switch (className) {
		case "org.bimserver.plugins.deserializers.DeserializerPlugin":
			return SPluginType.DESERIALIZER;
		case "org.bimserver.plugins.deserializers.StreamingDeserializerPlugin":
			return SPluginType.DESERIALIZER;
		case "org.bimserver.plugins.serializers.SerializerPlugin":
			return SPluginType.SERIALIZER;
		case "org.bimserver.plugins.serializers.StreamingSerializerPlugin":
			return SPluginType.SERIALIZER;
		case "org.bimserver.plugins.serializers.MessagingStreamingSerializerPlugin":
			return SPluginType.SERIALIZER;
		case "org.bimserver.plugins.serializers.MessagingSerializerPlugin":
			return SPluginType.SERIALIZER;
		case "org.bimserver.plugins.modelchecker.ModelCheckerPlugin":
			return SPluginType.MODEL_CHECKER;
		case "org.bimserver.plugins.modelmerger.ModelMergerPlugin":
			return SPluginType.MODEL_MERGER;
		case "org.bimserver.plugins.modelcompare.ModelComparePlugin":
			return SPluginType.MODEL_COMPARE;
		case "org.bimserver.plugins.objectidms.ObjectIDMPlugin":
			return SPluginType.OBJECT_IDM;
		case "org.bimserver.plugins.queryengine.QueryEnginePlugin":
			return SPluginType.QUERY_ENGINE;
		case "org.bimserver.plugins.services.ServicePlugin":
			return SPluginType.SERVICE;
		case "org.bimserver.plugins.renderengine.RenderEnginePlugin":
			return SPluginType.RENDER_ENGINE;
		case "org.bimserver.plugins.stillimagerenderer.StillImageRenderPlugin":
			return SPluginType.STILL_IMAGE_RENDER;
		case "org.bimserver.plugins.web.WebModulePlugin":
			return SPluginType.WEB_MODULE;
		}
		return null;
	}

	@Override
	public void notifyPluginStateChange(PluginContext pluginContext, boolean enabled) {
		if (pluginChangeListener != null) {
			pluginChangeListener.pluginStateChanged(pluginContext, enabled);
		}
	}

	@Override
	public SerializerPlugin getSerializerPlugin(String pluginClassName) {
		return getPluginByClassName(SerializerPlugin.class, pluginClassName, true);
	}

	@Override
	public BasicServerInfo getBasicServerInfo() {
		return basicServerInfoProvider.getBasicServerInfo();
	}

	public long pluginBundleUpdated(PluginBundle pluginBundle) {
		if (pluginChangeListener != null) {
			return pluginChangeListener.pluginBundleUpdated(pluginBundle);
		}
		return -1;
	}

	public void pluginUpdated(long pluginBundleVersionId, PluginContext pluginContext, SPluginInformation sPluginInformation) throws BimserverDatabaseException {
		if (pluginChangeListener != null) {
			pluginChangeListener.pluginUpdated(pluginBundleVersionId, pluginContext, sPluginInformation);
		}
	}

	public long pluginBundleInstalled(PluginBundle pluginBundle) {
		if (pluginChangeListener != null) {
			return pluginChangeListener.pluginBundleInstalled(pluginBundle);
		}
		return -1;
	}

	public void pluginInstalled(long pluginBundleVersionId, PluginContext pluginContext, SPluginInformation sPluginInformation) throws BimserverDatabaseException {
		if (pluginChangeListener != null) {
			pluginChangeListener.pluginInstalled(pluginBundleVersionId, pluginContext, sPluginInformation);
		}
	}

	public void pluginUninstalled(PluginContext pluginContext) {
		if (pluginChangeListener != null) {
			pluginChangeListener.pluginUninstalled(pluginContext);
		}
	}

	public void pluginBundleUninstalled(PluginBundle pluginBundle) {
		if (pluginChangeListener != null) {
			pluginChangeListener.pluginBundleUninstalled(pluginBundle);
		}
	}

	public void removeImplementation(PluginContext pluginContext) {
		Set<PluginContext> set = implementations.get(pluginContext.getPluginInterface());
		set.remove(pluginContext);
	}

	@Override
	public ClassLoader getClassLoaderFor(String pluginClassName) {
		for (Class<? extends Plugin> class1 : implementations.keySet()) {
			Set<PluginContext> set = implementations.get(class1);
			for (PluginContext pluginContext : set) {
				if (pluginContext.getPlugin().getClass().getName().contentEquals(pluginClassName)) {
					return pluginContext.getPlugin().getClass().getClassLoader();
				}
			}
		}
		return getClass().getClassLoader();
	}
}