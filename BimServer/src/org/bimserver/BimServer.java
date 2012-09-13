package org.bimserver;

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
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.bimserver.cache.CompareCache;
import org.bimserver.cache.DiskCacheManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.berkeley.BerkeleyKeyValueStore;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.deserializers.EmfDeserializerFactory;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.logging.CustomFileAppender;
import org.bimserver.longaction.LongActionManager;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.ModelCompare;
import org.bimserver.models.store.ModelMerger;
import org.bimserver.models.store.ObjectIDM;
import org.bimserver.models.store.QueryEngine;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.ServerInfo;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.notifications.NotificationsManager;
import org.bimserver.pb.server.ProtocolBuffersServer;
import org.bimserver.pb.server.ServiceFactoryRegistry;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginChangeListener;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.PluginType;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.modelmerger.ModelMergerPlugin;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ReflectiveRpcChannel;
import org.bimserver.templating.TemplateEngine;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.version.VersionChecker;
import org.bimserver.webservices.Service;
import org.bimserver.webservices.ServiceInterfaceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Main class to start a BIMserver
 */
public class BimServer {
	private Logger LOGGER;

	private GregorianCalendar serverStartTime;
	private BimDatabase bimDatabase;
	private JobScheduler bimScheduler;
	private LongActionManager longActionManager;
	private ServiceInterface systemService;
	private EmfSerializerFactory emfSerializerFactory;
	private EmfDeserializerFactory emfDeserializerFactory;
	private MergerFactory mergerFactory;
	private PluginManager pluginManager;
	private MailSystem mailSystem;
	private DiskCacheManager diskCacheManager;
	private ServerInfoManager serverInfoManager;
	private ServiceInterfaceFactory serviceFactory;
	private VersionChecker versionChecker;
	private TemplateEngine templateEngine;
	private NotificationsManager notificationsManager;
	private CompareCache compareCache;
	private ProtocolBuffersMetaData protocolBuffersMetaData;
	private SService serviceInterfaceService;
	private SService notificationInterfaceService;
	private EmbeddedWebServer embeddedWebServer;
	private final BimServerConfig config;
	private ProtocolBuffersServer protocolBuffersServer;
	private CommandLine commandLine;

	/**
	 * Create a new BIMserver
	 * 
	 * @param homeDir
	 *            A directory where the user can store instance specific
	 *            configuration files
	 * @param resourceFetcher
	 *            A resource fetcher
	 */
	public BimServer(BimServerConfig config) {
		this.config = config;
		try {
			if (config.getHomeDir() != null) {
				initHomeDir();
			}

			fixLogging();

			LOGGER = LoggerFactory.getLogger(BimServer.class);

			LOGGER.info("Starting BIMserver");
			if (config.getHomeDir() != null) {
				LOGGER.info("Using \"" + config.getHomeDir().getAbsolutePath() + "\" as homedir");
			} else {
				LOGGER.info("Not using a homedir");
			}

			serverInfoManager = new ServerInfoManager();

			UncaughtExceptionHandler uncaughtExceptionHandler = new UncaughtExceptionHandler() {
				@Override
				public void uncaughtException(Thread t, Throwable e) {
					if (e instanceof OutOfMemoryError) {
						serverInfoManager.setOutOfMemory();
						LOGGER.error("", e);
					} else if (e instanceof Error) {
						serverInfoManager.setErrorMessage(e.getMessage());
						LOGGER.error("", e);
					}
				}
			};

			Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);

			versionChecker = new VersionChecker(config.getResourceFetcher());

			try {
				pluginManager = new PluginManager(new File(config.getHomeDir(), "tmp"), config.getClassPath());
				pluginManager.addPluginChangeListener(new PluginChangeListener() {
					@Override
					public void pluginStateChanged(PluginContext pluginContext, boolean enabled) {
						// Reflect this change also in the database
						Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPlugin_Name(), new StringLiteral(pluginContext.getPlugin().getClass()
								.getName()));
						DatabaseSession session = bimDatabase.createSession();
						try {
							Map<Long, org.bimserver.models.store.Plugin> pluginsFound = session.query(pluginCondition, org.bimserver.models.store.Plugin.class, false, null);
							if (pluginsFound.size() == 0) {
								LOGGER.error("Error changing plugin-state in database, plugin " + pluginContext.getPlugin().getClass().getName() + " not found");
							} else if (pluginsFound.size() == 1) {
								org.bimserver.models.store.Plugin pluginFound = pluginsFound.values().iterator().next();
								pluginFound.setEnabled(pluginContext.isEnabled());
								session.store(pluginFound);
							} else {
								LOGGER.error("Error, too many plugin-objects found in database for name " + pluginContext.getPlugin().getClass().getName());
							}
							session.commit();
						} catch (BimserverDatabaseException e) {
							LOGGER.error("", e);
						} finally {
							session.close();
						}
					}
				});
				pluginManager.loadPlugin(ObjectIDMPlugin.class, "Internal", "Internal", new SchemaFieldObjectIDMPlugin(), getClass().getClassLoader(), PluginType.INTERNAL);
			} catch (Exception e) {
				LOGGER.error("", e);
			}

			compareCache = new CompareCache();
			if (config.isStartEmbeddedWebServer()) {
				embeddedWebServer = new EmbeddedWebServer(this);
			}
		} catch (Throwable e) {
			if (LOGGER == null) {
				e.printStackTrace();
			}
			LOGGER.error("", e);
			serverInfoManager.setErrorMessage(e.getMessage());
		}
	}

	public void start() throws DatabaseInitException, BimserverDatabaseException, PluginException, DatabaseRestartRequiredException, ServerException {
		try {
			SVersion localVersion = versionChecker.getLocalVersion();
			if (localVersion != null) {
				LOGGER.info("Version: " + localVersion.getMajor() + "." + localVersion.getMinor() + "." + localVersion.getRevision() + " - " + localVersion.getDate());
			} else {
				LOGGER.info("Unknown version");
			}

			pluginManager.initAllLoadedPlugins();
			serverStartTime = new GregorianCalendar();

			longActionManager = new LongActionManager(this);

			Set<Ifc2x3tc1Package> packages = CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE);
			templateEngine = new TemplateEngine();
			templateEngine.init(config.getResourceFetcher().getResource("templates/"));
			File databaseDir = new File(config.getHomeDir(), "database");
			BerkeleyKeyValueStore keyValueStore = new BerkeleyKeyValueStore(databaseDir);
			bimDatabase = new Database(this, packages, keyValueStore);
			try {
				bimDatabase.init();
			} catch (DatabaseRestartRequiredException e) {
				bimDatabase.close();
				keyValueStore = new BerkeleyKeyValueStore(databaseDir);
				bimDatabase = new Database(this, packages, keyValueStore);
				try {
					bimDatabase.init();
				} catch (InconsistentModelsException e1) {
					LOGGER.error("", e);
					serverInfoManager.setServerState(ServerState.FATAL_ERROR);
					serverInfoManager.setErrorMessage("Inconsistent models");
				}
			} catch (InconsistentModelsException e) {
				LOGGER.error("", e);
				serverInfoManager.setServerState(ServerState.FATAL_ERROR);
				serverInfoManager.setErrorMessage("Inconsistent models");
			}

			protocolBuffersMetaData = new ProtocolBuffersMetaData();
			try {
				protocolBuffersMetaData.load(config.getResourceFetcher().getResource("service.desc"));
				protocolBuffersMetaData.load(config.getResourceFetcher().getResource("notification.desc"));
			} catch (IOException e) {
				LOGGER.error("", e);
			}

			serviceInterfaceService = new SService(new File("../Shared/src/org/bimserver/shared/ServiceInterface.java"), ServiceInterface.class);
			notificationInterfaceService = new SService(new File("../Shared/src/org/bimserver/shared/NotificationInterface.java"), NotificationInterface.class);

			notificationsManager = new NotificationsManager(this);
			notificationsManager.start();

			serverInfoManager.init(this);
			serverInfoManager.update();

			emfSerializerFactory = new EmfSerializerFactory();
			emfDeserializerFactory = new EmfDeserializerFactory();

			if (serverInfoManager.getServerState() == ServerState.MIGRATION_REQUIRED) {
				serverInfoManager.registerStateChangeListener(new StateChangeListener() {
					@Override
					public void stateChanged(ServerState oldState, ServerState newState) {
						if (oldState == ServerState.MIGRATION_REQUIRED && newState == ServerState.RUNNING) {
							try {
								initDatabaseDependantItems();
							} catch (BimserverDatabaseException e) {
								LOGGER.error("", e);
							}
						}
					}
				});
			} else {
				initDatabaseDependantItems();
			}

			mailSystem = new MailSystem(this);

			serviceFactory = new ServiceInterfaceFactory(this);
			if (config.isStartEmbeddedWebServer()) {
				embeddedWebServer.start();
			}

			diskCacheManager = new DiskCacheManager(this, new File(config.getHomeDir(), "cache"));

			mergerFactory = new MergerFactory(this);
			setSystemService(serviceFactory.newService(AccessMethod.INTERNAL, "internal"));
			try {
				if (!((Service) getSystemService()).loginAsSystem()) {
					throw new RuntimeException("System user not found");
				}
			} catch (ServiceException e) {
				LOGGER.error("", e);
			}

			bimScheduler = new JobScheduler(this);
			bimScheduler.start();

			DatabaseSession session = bimDatabase.createSession();
			try {
				ServiceFactoryRegistry serviceFactoryRegistry = new ServiceFactoryRegistry();
				serviceFactoryRegistry.registerServiceFactory(serviceFactory);
				protocolBuffersServer = new ProtocolBuffersServer(protocolBuffersMetaData, serviceFactoryRegistry, serviceInterfaceService, getServerSettings(session)
						.getProtocolBuffersPort());
				protocolBuffersServer.registerService(new ReflectiveRpcChannel(serviceFactory, protocolBuffersMetaData, serviceInterfaceService));
				protocolBuffersServer.start();
			} catch (Exception e) {
				LOGGER.error("", e);
			}

			ServerStarted serverStarted = LogFactory.eINSTANCE.createServerStarted();
			serverStarted.setDate(new Date());
			serverStarted.setAccessMethod(AccessMethod.INTERNAL);
			serverStarted.setExecutor(null);
			try {
				session.store(serverStarted);
				session.commit();
			} catch (BimserverLockConflictException e) {
				throw new BimserverDatabaseException(e);
			} finally {
				session.close();
			}
			if (config.isStartCommandLine()) {
				commandLine = new CommandLine(this);
				commandLine.start();
			}
			LOGGER.info("Done starting BIMserver");
		} catch (Throwable e) {
			serverInfoManager.setErrorMessage(e.getMessage());
			LOGGER.error("", e);
		}
	}

	public ServerSettings getServerSettings(DatabaseSession session) {
		try {
			IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getServerSettings(), false, null);
			List<ServerSettings> settingsList = allOfType.getAll(ServerSettings.class);
			if (settingsList.size() == 1) {
				ServerSettings settings = settingsList.get(0);
				return settings;
			}
		} catch (BimserverLockConflictException e) {
			e.printStackTrace();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Serializers, deserializers, ifcengines etc... all have counterparts as
	 * objects in the database for configuration purposes, this methods syncs
	 * both versions
	 */
	private void createDatabaseObjects() throws BimserverLockConflictException, BimserverDatabaseException, PluginException, BimserverConcurrentModificationDatabaseException {
		DatabaseSession session = bimDatabase.createSession();

		IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), false, null);
		for (User user : allOfType.getAll(User.class)) {
			updateUserSettings(session, user);
		}
		session.commit();
	}

	private <T extends org.bimserver.models.store.Plugin> T find(List<T> list, String name) {
		for (T t : list) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}
	
	public void updateUserSettings(DatabaseSession session, User user) throws BimserverLockConflictException, BimserverDatabaseException {
		UserSettings userSettings = user.getSettings();
		if (userSettings == null) {
			userSettings = StoreFactory.eINSTANCE.createUserSettings();
			user.setSettings(userSettings);
			session.store(userSettings);
			session.store(user);
		}
		for (ObjectIDMPlugin objectIDMPlugin : pluginManager.getAllObjectIDMPlugins(true)) {
			String name = objectIDMPlugin.getDefaultObjectIDMName();
			ObjectIDM found = find(userSettings.getObjectIDMs(), name);
			if (found == null) {
				ObjectIDM objectIDM = StoreFactory.eINSTANCE.createObjectIDM();
				userSettings.getObjectIDMs().add(objectIDM);
				objectIDM.setName(name);
				objectIDM.setClassName(objectIDMPlugin.getClass().getName());
				objectIDM.setEnabled(true);
				if (userSettings.getDefaultObjectIDM() == null && objectIDMPlugin.getClass() == SchemaFieldObjectIDMPlugin.class) {
					userSettings.setDefaultObjectIDM(objectIDM);
				}
				session.store(objectIDM);
			} else {
				if (userSettings.getDefaultObjectIDM() == null && objectIDMPlugin.getClass() == SchemaFieldObjectIDMPlugin.class) {
					userSettings.setDefaultObjectIDM(found);
				}
			}
		}
		if (userSettings.getDefaultObjectIDM() == null && !userSettings.getObjectIDMs().isEmpty()) {
			userSettings.setDefaultObjectIDM(userSettings.getObjectIDMs().get(0));
		}
		for (IfcEnginePlugin ifcEnginePlugin : pluginManager.getAllIfcEnginePlugins(true)) {
			String name = ifcEnginePlugin.getDefaultIfcEngineName();
			IfcEngine found = find(userSettings.getIfcEngines(), name);
			if (found == null) {
				IfcEngine ifcEngine = StoreFactory.eINSTANCE.createIfcEngine();
				userSettings.getIfcEngines().add(ifcEngine);
				ifcEngine.setClassName(ifcEnginePlugin.getClass().getName());
				ifcEngine.setName(name);
				ifcEngine.setEnabled(true);
				session.store(ifcEngine);
				if (userSettings.getDefaultIfcEngine() == null && ifcEnginePlugin.getClass().getName().equals("org.bimserver.ifcengine.TNOIfcEnginePlugin")) {
					userSettings.setDefaultIfcEngine(ifcEngine);
				}
			} else {
				if (userSettings.getDefaultIfcEngine() == null && ifcEnginePlugin.getClass().getName().equals("org.bimserver.ifcengine.TNOIfcEnginePlugin")) {
					userSettings.setDefaultIfcEngine(found);
				}
			}
		}
		if (userSettings.getDefaultIfcEngine() == null && !userSettings.getIfcEngines().isEmpty()) {
			userSettings.setDefaultIfcEngine(userSettings.getIfcEngines().get(0));
		}
		for (QueryEnginePlugin queryEnginePlugin : pluginManager.getAllQueryEnginePlugins(true)) {
			String name = queryEnginePlugin.getDefaultQueryEngineName();
			QueryEngine found = find(userSettings.getQueryengines(), name);
			if (found == null) {
				QueryEngine queryEngine = StoreFactory.eINSTANCE.createQueryEngine();
				userSettings.getQueryengines().add(queryEngine);
				queryEngine.setClassName(queryEnginePlugin.getClass().getName());
				queryEngine.setName(name);
				queryEngine.setEnabled(true);
				if (userSettings.getDefaultQueryEngine() == null && queryEnginePlugin.getClass().getName().equals("nl.wietmazairac.bimql.BimQLQueryEnginePlugin")) {
					userSettings.setDefaultQueryEngine(queryEngine);
				}
				session.store(queryEngine);
			} else {
				if (userSettings.getDefaultQueryEngine() == null && queryEnginePlugin.getClass().getName().equals("nl.wietmazairac.bimql.BimQLQueryEnginePlugin")) {
					userSettings.setDefaultQueryEngine(found);
				}
			}
		}
		if (userSettings.getDefaultQueryEngine() == null && !userSettings.getQueryengines().isEmpty()) {
			userSettings.setDefaultQueryEngine(userSettings.getQueryengines().get(0));
		}
		for (ModelMergerPlugin modelMergerPlugin : pluginManager.getAllModelMergerPlugins(true)) {
			String name = modelMergerPlugin.getDefaultModelMergerName();
			ModelMerger found = find(userSettings.getModelmergers(), name);
			if (found == null) {
				ModelMerger modelMerger = StoreFactory.eINSTANCE.createModelMerger();
				userSettings.getModelmergers().add(modelMerger);
				modelMerger.setClassName(modelMergerPlugin.getClass().getName());
				modelMerger.setName(name);
				modelMerger.setEnabled(true);
				if (userSettings.getDefaultModelMerger() == null && modelMergerPlugin.getClass().getName().equals("org.bimserver.merging.BasicModelMergerPlugin")) {
					userSettings.setDefaultModelMerger(modelMerger);
				}
				session.store(modelMerger);
			} else {
				if (userSettings.getDefaultModelMerger() == null && modelMergerPlugin.getClass().getName().equals("org.bimserver.merging.BasicModelMergerPlugin")) {
					userSettings.setDefaultModelMerger(found);
				}
			}
		}
		if (userSettings.getDefaultModelMerger() == null && !userSettings.getModelmergers().isEmpty()) {
			userSettings.setDefaultModelMerger(userSettings.getModelmergers().get(0));
		}
		for (ModelComparePlugin modelComparePlugin : pluginManager.getAllModelComparePlugins(true)) {
			String name = modelComparePlugin.getDefaultModelCompareName();
			ModelCompare found = find(userSettings.getModelcompares(), name);
			if (found == null) {
				ModelCompare modelcompare = StoreFactory.eINSTANCE.createModelCompare();
				userSettings.getModelcompares().add(modelcompare);
				modelcompare.setClassName(modelComparePlugin.getClass().getName());
				modelcompare.setName(name);
				modelcompare.setEnabled(true);
				if (userSettings.getDefaultModelCompare() == null && modelComparePlugin.getClass().getName().equals("org.bimserver.ifc.compare.GuidBasedModelComparePlugin")) {
					userSettings.setDefaultModelCompare(modelcompare);
				}
				session.store(modelcompare);
			} else {
				if (userSettings.getDefaultModelCompare() == null && modelComparePlugin.getClass().getName().equals("org.bimserver.ifc.compare.GuidBasedModelComparePlugin")) {
					userSettings.setDefaultModelCompare(found);
				}
			}
		}
		if (userSettings.getDefaultModelCompare() == null && !userSettings.getModelcompares().isEmpty()) {
			userSettings.setDefaultModelCompare(userSettings.getModelcompares().get(0));
		}
		for (SerializerPlugin serializerPlugin : pluginManager.getAllSerializerPlugins(true)) {
			String name = serializerPlugin.getDefaultSerializerName();
			Serializer found = find(userSettings.getSerializers(), name);
			if (found == null) {
				Serializer serializer = StoreFactory.eINSTANCE.createSerializer();
				userSettings.getSerializers().add(serializer);
				serializer.setClassName(serializerPlugin.getClass().getName());
				serializer.setName(name);
				serializer.setEnabled(true);
				serializer.setDescription(serializerPlugin.getDescription());
				serializer.setContentType(serializerPlugin.getDefaultContentType());
				serializer.setExtension(serializerPlugin.getDefaultExtension());
				serializer.setObjectIDM(userSettings.getDefaultObjectIDM());
				serializer.setIfcEngine(userSettings.getDefaultIfcEngine());
				if (userSettings.getDefaultSerializer() == null && serializerPlugin.getClass().getName().equals("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin")) {
					userSettings.setDefaultSerializer(serializer);
				}
				session.store(serializer);
			} else {
				if (userSettings.getDefaultSerializer() == null && serializerPlugin.getClass().getName().equals("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin")) {
					userSettings.setDefaultSerializer(found);
				}
			}
		}
		if (userSettings.getDefaultSerializer() == null && !userSettings.getSerializers().isEmpty()) {
			userSettings.setDefaultSerializer(userSettings.getSerializers().get(0));
		}
		for (DeserializerPlugin deserializerPlugin : pluginManager.getAllDeserializerPlugins(true)) {
			String name = deserializerPlugin.getDefaultDeserializerName();
			Deserializer found = find(userSettings.getDeserializers(), name);
			if (found == null) {
				Deserializer deserializer = StoreFactory.eINSTANCE.createDeserializer();
				userSettings.getDeserializers().add(deserializer);
				deserializer.setClassName(deserializerPlugin.getClass().getName());
				deserializer.setName(name);
				deserializer.setEnabled(true);
				deserializer.setDescription(deserializerPlugin.getDescription());
				session.store(deserializer);
			}
		}
		Collection<Plugin> allPlugins = pluginManager.getAllPlugins(false);
		for (Plugin plugin : allPlugins) {
			Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPlugin_Name(), new StringLiteral(plugin.getClass().getName()));
			Map<Long, org.bimserver.models.store.Plugin> results = session.query(pluginCondition, org.bimserver.models.store.Plugin.class, false, null);
			if (results.size() == 0) {
				org.bimserver.models.store.Plugin pluginObject = StoreFactory.eINSTANCE.createPlugin();
				pluginObject.setName(plugin.getClass().getName());
				pluginObject.setEnabled(true); // New plugins are enabled by
												// default
				session.store(pluginObject);
			} else if (results.size() == 1) {
				org.bimserver.models.store.Plugin pluginObject = results.values().iterator().next();
				pluginManager.getPluginContext(plugin).setEnabled(pluginObject.getEnabled(), false);
			} else {
				LOGGER.error("Multiple plugin objects found with the same name: " + plugin.getClass().getName());
			}
		}
		session.store(userSettings);
	}

	private void initDatabaseDependantItems() throws BimserverDatabaseException {
		getEmfSerializerFactory().init(pluginManager, bimDatabase);
		getEmfDeserializerFactory().init(pluginManager, bimDatabase);
		try {
			createDatabaseObjects();
		} catch (BimserverLockConflictException e) {
			throw new BimserverDatabaseException(e);
		} catch (PluginException e) {
			throw new BimserverDatabaseException(e);
		}
	}

	public File getHomeDir() {
		return config.getHomeDir();
	}

	public LongActionManager getLongActionManager() {
		return longActionManager;
	}

	private void fixLogging() throws IOException {
		File file = new File(config.getHomeDir(), "logs/bimserver.log");
		CustomFileAppender appender = new CustomFileAppender(file);
		System.out.println("Logging to: " + file.getAbsolutePath());
		Enumeration<?> currentLoggers = LogManager.getCurrentLoggers();
		LogManager.getRootLogger().addAppender(appender);
		while (currentLoggers.hasMoreElements()) {
			Object nextElement = currentLoggers.nextElement();
			org.apache.log4j.Logger logger2 = (org.apache.log4j.Logger) nextElement;
			logger2.addAppender(appender);
		}
	}

	private void initHomeDir() throws IOException {
		String[] filesToCheck = new String[] { "logs", "tmp", "log4j.xml", "templates" };
		if (!config.getHomeDir().exists()) {
			config.getHomeDir().mkdir();
		}
		if (config.getHomeDir().exists() && config.getHomeDir().isDirectory()) {
			for (String fileToCheck : filesToCheck) {
				File sourceFile = config.getResourceFetcher().getFile(fileToCheck);
				if (sourceFile != null && sourceFile.exists()) {
					File destFile = new File(config.getHomeDir(), fileToCheck);
					if (!destFile.exists()) {
						if (sourceFile.isDirectory()) {
							destFile.mkdir();
							for (File f : sourceFile.listFiles()) {
								if (f.isFile()) {
									FileUtils.copyFile(f, new File(destFile, f.getName()));
								}
							}
						} else {
							FileUtils.copyFile(sourceFile, destFile);
						}
					}
				}
			}
		}
	}

	public BimDatabase getDatabase() {
		return bimDatabase;
	}

	public ResourceFetcher getResourceFetcher() {
		return config.getResourceFetcher();
	}

	public GregorianCalendar getServerStartTime() {
		return serverStartTime;
	}

	public void setSystemService(ServiceInterface systemService) {
		this.systemService = systemService;
	}

	public ServiceInterface getSystemService() {
		return systemService;
	}

	public MergerFactory getMergerFactory() {
		return mergerFactory;
	}

	public void stop() {
		LOGGER.info("Stopping BIMserver");
		if (bimDatabase != null) {
			bimDatabase.close();
		}
		if (bimScheduler != null) {
			bimScheduler.close();
		}
		if (longActionManager != null) {
			longActionManager.shutdown();
		}
		if (notificationsManager != null) {
			notificationsManager.shutdown();
		}
		if (embeddedWebServer != null) {
			embeddedWebServer.shutdown();
		}
		if (protocolBuffersServer != null) {
			protocolBuffersServer.shutdown();
		}
		if (commandLine != null) {
			commandLine.shutdown();
		}
	}

	public PluginManager getPluginManager() {
		return pluginManager;
	}

	public MailSystem getMailSystem() {
		return mailSystem;
	}

	public EmfSerializerFactory getEmfSerializerFactory() {
		return emfSerializerFactory;
	}

	public EmfDeserializerFactory getEmfDeserializerFactory() {
		return emfDeserializerFactory;
	}

	public DiskCacheManager getDiskCacheManager() {
		return diskCacheManager;
	}

	public String getClassPath() {
		return config.getClassPath();
	}

	public ServerInfo getServerInfo() {
		return serverInfoManager.getServerInfo();
	}

	public ServiceInterfaceFactory getServiceFactory() {
		return serviceFactory;
	}

	public VersionChecker getVersionChecker() {
		return versionChecker;
	}

	public TemplateEngine getTemplateEngine() {
		return templateEngine;
	}

	public CompareCache getCompareCache() {
		return compareCache;
	}

	public NotificationsManager getNotificationsManager() {
		return notificationsManager;
	}

	public ServerInfoManager getServerInfoManager() {
		return serverInfoManager;
	}

	public SService getServiceInterfaceService() {
		return serviceInterfaceService;
	}

	public ProtocolBuffersMetaData getProtocolBuffersMetaData() {
		return protocolBuffersMetaData;
	}

	public BimServerConfig getConfig() {
		return config;
	}

	public EmbeddedWebServer getEmbeddedWebServer() {
		return embeddedWebServer;
	}

	public SService getNotificationInterfaceService() {
		return notificationInterfaceService;
	}
}