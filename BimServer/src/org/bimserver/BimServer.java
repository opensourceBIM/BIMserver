package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.bimserver.cache.CompareCache;
import org.bimserver.cache.DiskCacheManager;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.DirectBimServerClientFactory;
import org.bimserver.client.JsonSocketReflectorFactory;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.berkeley.BerkeleyKeyValueStore;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.deserializers.DeserializerFactory;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.endpoints.EndPointManager;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.SServiceInterfaceService;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.logging.CustomFileAppender;
import org.bimserver.longaction.LongActionManager;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.store.BooleanType;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.DoubleType;
import org.bimserver.models.store.IfcEnginePluginConfiguration;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.LongType;
import org.bimserver.models.store.ModelComparePluginConfiguration;
import org.bimserver.models.store.ModelMergerPluginConfiguration;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ObjectIDMPluginConfiguration;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.QueryEnginePluginConfiguration;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.ServerInfo;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.StringType;
import org.bimserver.models.store.Type;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.notifications.NotificationsManager;
import org.bimserver.pb.server.ProtocolBuffersServer;
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
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.serializers.SerializerFactory;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.ServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.reflector.ReflectorBuilder;
import org.bimserver.shared.reflector.ReflectorFactory;
import org.bimserver.templating.TemplateEngine;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.version.VersionChecker;
import org.bimserver.webservices.LongTransactionManager;
import org.bimserver.webservices.PublicInterfaceFactory;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Main class to start a BIMserver
 */
public class BimServer {
	private static final String ENCRYPTIONKEY = "encryptionkey";

	private Logger LOGGER;

	private GregorianCalendar serverStartTime;
	private BimDatabase bimDatabase;
	private JobScheduler bimScheduler;
	private LongActionManager longActionManager;
	private SerializerFactory serializerFactory;
	private DeserializerFactory deserializerFactory;
	private MergerFactory mergerFactory;
	private PluginManager pluginManager;
	private MailSystem mailSystem;
	private DiskCacheManager diskCacheManager;
	private ServerInfoManager serverInfoManager;
	private PublicInterfaceFactory serviceFactory;
	private VersionChecker versionChecker;
	private TemplateEngine templateEngine;
	private NotificationsManager notificationsManager;
	private CompareCache compareCache;
	private ProtocolBuffersMetaData protocolBuffersMetaData;
	private final ServicesMap servicesMap = new ServicesMap();
	private EmbeddedWebServer embeddedWebServer;
	private final BimServerConfig config;
	private ProtocolBuffersServer protocolBuffersServer;
	private final JsonHandler jsonHandler = new JsonHandler(this);
	private CommandLine commandLine;
	private ServerSettingsCache serverSettingsCache;
	private ReflectorFactory reflectorFactory;
	private final EndPointManager endPointManager = new EndPointManager();
	private final SConverter sConverter = new SConverter();
	private final LongTransactionManager longTransactionManager = new LongTransactionManager();
	private JsonSocketReflectorFactory jsonSocketReflectorFactory;
	private SecretKeySpec encryptionkey;
	private BimServerClientFactory bimServerClientFactory;

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
			LOGGER = LoggerFactory.getLogger(BimServer.class);

			LOGGER.info("Starting BIMserver");
			if (config.getHomeDir() != null) {
				LOGGER.info("Using \"" + config.getHomeDir().getAbsolutePath() + "\" as homedir");
			} else {
				LOGGER.info("Not using a homedir");
			}

			jsonSocketReflectorFactory = new JsonSocketReflectorFactory(servicesMap);

			serverInfoManager = new ServerInfoManager();
			notificationsManager = new NotificationsManager(this, jsonSocketReflectorFactory);
			serviceFactory = new PublicInterfaceFactory(this);

			pluginManager = new PluginManager(new File(config.getHomeDir(), "tmp"), config.getClassPath(), serviceFactory, notificationsManager, servicesMap);

			versionChecker = new VersionChecker(config.getResourceFetcher());

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

	public JsonSocketReflectorFactory getJsonSocketReflectorFactory() {
		return jsonSocketReflectorFactory;
	}

	public String getContent(URL url) {
		if (url != null) {
			try {
				InputStream inputStream = url.openStream();
				if (inputStream == null) {
					return null;
				}
				StringWriter out = new StringWriter();
				IOUtils.copy(inputStream, out);
				return out.toString();
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	public ReflectorFactory getReflectorFactory() {
		return reflectorFactory;
	}

	public void start() throws DatabaseInitException, BimserverDatabaseException, PluginException, DatabaseRestartRequiredException, ServerException {
		try {
			SVersion localVersion = versionChecker.getLocalVersion();
			if (localVersion != null) {
				LOGGER.info("Version: " + localVersion.getMajor() + "." + localVersion.getMinor() + "." + localVersion.getRevision() + " - " + localVersion.getDate());
			} else {
				LOGGER.info("Unknown version");
			}

			try {
				pluginManager.addPluginChangeListener(new PluginChangeListener() {
					@Override
					public void pluginStateChanged(PluginContext pluginContext, boolean enabled) {
						// Reflect this change also in the database
						Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_PluginClassName(), new StringLiteral(pluginContext.getPlugin()
								.getClass().getName()));
						DatabaseSession session = bimDatabase.createSession();
						try {
							Map<Long, PluginDescriptor> pluginsFound = session.query(pluginCondition, PluginDescriptor.class, Query.getDefault());
							if (pluginsFound.size() == 0) {
								LOGGER.error("Error changing plugin-state in database, plugin " + pluginContext.getPlugin().getClass().getName() + " not found");
							} else if (pluginsFound.size() == 1) {
								PluginDescriptor pluginConfiguration = pluginsFound.values().iterator().next();
								pluginConfiguration.setEnabled(pluginContext.isEnabled());
								session.store(pluginConfiguration);
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

			DatabaseSession encsession = bimDatabase.createSession();
			try {
				byte[] encryptionkeyBytes = null;
				if (!bimDatabase.getRegistry().has(ENCRYPTIONKEY)) {
					encryptionkeyBytes = new byte[16];
					new SecureRandom().nextBytes(encryptionkeyBytes);
					bimDatabase.getRegistry().save(ENCRYPTIONKEY, encryptionkeyBytes, encsession);
					encsession.commit();
				} else {
					encryptionkeyBytes = bimDatabase.getRegistry().readByteArray(ENCRYPTIONKEY, encsession);
				}
				encryptionkey = new SecretKeySpec(encryptionkeyBytes, "AES");
			} finally {
				encsession.close();
			}
			serverSettingsCache = new ServerSettingsCache(bimDatabase);

			notificationsManager.init();

			protocolBuffersMetaData = new ProtocolBuffersMetaData();
			try {
				protocolBuffersMetaData.load(config.getResourceFetcher().getResource("service.desc"));
				protocolBuffersMetaData.load(config.getResourceFetcher().getResource("notification.desc"));
			} catch (IOException e) {
				LOGGER.error("", e);
			}
			
			URL resource1 = config.getResourceFetcher().getResource("ServiceInterface.java");
			String content1 = getContent(resource1);
			SService serviceInterfaceMeta = new SServiceInterfaceService(content1, ServiceInterface.class);
			servicesMap.add(serviceInterfaceMeta);

			URL resource2 = config.getResourceFetcher().getResource("NotificationInterface.java");
			String content2 = getContent(resource2);
			servicesMap.add(new SService(content2, NotificationInterface.class, serviceInterfaceMeta));

			notificationsManager.start();

			serverInfoManager.init(this);
			serverInfoManager.update();

			serializerFactory = new SerializerFactory();
			deserializerFactory = new DeserializerFactory();

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

			if (config.isStartEmbeddedWebServer()) {
				embeddedWebServer.start();
			}

			diskCacheManager = new DiskCacheManager(this, new File(config.getHomeDir(), "cache"));

			mergerFactory = new MergerFactory(this);

			ReflectorBuilder reflectorBuilder = new ReflectorBuilder(servicesMap);
			reflectorFactory = reflectorBuilder.newReflectorFactory();
			if (reflectorFactory == null) {
				throw new RuntimeException("No reflector factory!");
			}
			servicesMap.setReflectorFactory(reflectorFactory);

			bimScheduler = new JobScheduler(this);
			bimScheduler.start();

			bimServerClientFactory = new DirectBimServerClientFactory<ServiceInterface>(serverSettingsCache.getServerSettings().getSiteAddress(), ServiceInterface.class, serviceFactory, servicesMap);
			
			DatabaseSession session = bimDatabase.createSession();
			try {
				for (InternalServicePluginConfiguration internalService : session.getAllOfType(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), InternalServicePluginConfiguration.class, Query.getDefault())) {
					if (internalService.getEnabled()) {
						ServicePlugin servicePlugin = pluginManager.getServicePlugin(internalService.getClassName(), true);
						if (servicePlugin != null) {
							servicePlugin.register(new org.bimserver.plugins.PluginConfiguration(internalService.getSettings()));
						}
					}
				}
			} finally {
				session.close();
			}
			
			try {
				protocolBuffersServer = new ProtocolBuffersServer(protocolBuffersMetaData, serviceFactory, servicesMap, config.getInitialProtocolBuffersPort());
				protocolBuffersServer.start();
			} catch (Exception e) {
				LOGGER.error("", e);
			}

			if (config.isStartCommandLine()) {
				commandLine = new CommandLine(this);
				commandLine.start();
			}
		} catch (Throwable e) {
			serverInfoManager.setErrorMessage(e.getMessage());
			LOGGER.error("", e);
		}
	}

	public SecretKeySpec getEncryptionKey() {
		return encryptionkey;
	}

	/*
	 * Serializers, deserializers, ifcengines etc... all have counterparts as
	 * objects in the database for configuration purposes, this methods syncs
	 * both versions
	 */
	private void createDatabaseObjects(DatabaseSession session) throws BimserverLockConflictException, BimserverDatabaseException, PluginException, BimserverConcurrentModificationDatabaseException {
		IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), Query.getDefault());
		for (User user : allOfType.getAll(User.class)) {
			updateUserSettings(session, user);
		}
	}

	private <T extends PluginConfiguration> T find(List<T> list, String name) {
		for (T t : list) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	public void updateUserSettings(DatabaseSession session, User user) throws BimserverLockConflictException, BimserverDatabaseException {
		UserSettings userSettings = user.getUserSettings();
		if (userSettings == null) {
			userSettings = session.create(StorePackage.eINSTANCE.getUserSettings());
			user.setUserSettings(userSettings);
			session.store(user);
		}
		for (ObjectIDMPlugin objectIDMPlugin : pluginManager.getAllObjectIDMPlugins(true)) {
			String name = objectIDMPlugin.getDefaultName();
			ObjectIDMPluginConfiguration objectIdmPluginConfiguration = find(userSettings.getObjectIDMs(), name);
			if (objectIdmPluginConfiguration == null) {
				objectIdmPluginConfiguration = session.create(StorePackage.eINSTANCE.getObjectIDMPluginConfiguration());
				userSettings.getObjectIDMs().add(objectIdmPluginConfiguration);
				objectIdmPluginConfiguration.setName(name);
				objectIdmPluginConfiguration.setClassName(objectIDMPlugin.getClass().getName());
				objectIdmPluginConfiguration.setDescription(objectIDMPlugin.getDescription());
				objectIdmPluginConfiguration.setEnabled(true);
				objectIdmPluginConfiguration.setSettings(convertSettings(session, objectIDMPlugin));
				if (userSettings.getDefaultObjectIDM() == null && objectIDMPlugin.getClass() == SchemaFieldObjectIDMPlugin.class) {
					userSettings.setDefaultObjectIDM(objectIdmPluginConfiguration);
				}
			} else {
				if (userSettings.getDefaultObjectIDM() == null && objectIDMPlugin.getClass() == SchemaFieldObjectIDMPlugin.class) {
					userSettings.setDefaultObjectIDM(objectIdmPluginConfiguration);
				}
			}
		}
		if (userSettings.getDefaultObjectIDM() == null && !userSettings.getObjectIDMs().isEmpty()) {
			userSettings.setDefaultObjectIDM(userSettings.getObjectIDMs().get(0));
		}
		for (IfcEnginePlugin ifcEnginePlugin : pluginManager.getAllIfcEnginePlugins(true)) {
			String name = ifcEnginePlugin.getDefaultName();
			IfcEnginePluginConfiguration ifcEnginePluginConfiguration = find(userSettings.getIfcEngines(), name);
			if (ifcEnginePluginConfiguration == null) {
				ifcEnginePluginConfiguration = session.create(StorePackage.eINSTANCE.getIfcEnginePluginConfiguration());
				userSettings.getIfcEngines().add(ifcEnginePluginConfiguration);
				ifcEnginePluginConfiguration.setClassName(ifcEnginePlugin.getClass().getName());
				ifcEnginePluginConfiguration.setName(name);
				ifcEnginePluginConfiguration.setDescription(ifcEnginePlugin.getDescription());
				ifcEnginePluginConfiguration.setEnabled(true);
				ifcEnginePluginConfiguration.setSettings(convertSettings(session, ifcEnginePlugin));
				if (userSettings.getDefaultIfcEngine() == null && ifcEnginePlugin.getClass().getName().equals("org.bimserver.ifcengine.TNOIfcEnginePlugin")) {
					userSettings.setDefaultIfcEngine(ifcEnginePluginConfiguration);
				}
			} else {
				if (userSettings.getDefaultIfcEngine() == null && ifcEnginePlugin.getClass().getName().equals("org.bimserver.ifcengine.TNOIfcEnginePlugin")) {
					userSettings.setDefaultIfcEngine(ifcEnginePluginConfiguration);
				}
			}
		}
		if (userSettings.getDefaultIfcEngine() == null && !userSettings.getIfcEngines().isEmpty()) {
			userSettings.setDefaultIfcEngine(userSettings.getIfcEngines().get(0));
		}
		for (QueryEnginePlugin queryEnginePlugin : pluginManager.getAllQueryEnginePlugins(true)) {
			String name = queryEnginePlugin.getDefaultName();
			QueryEnginePluginConfiguration queryEnginePluginConfiguration = find(userSettings.getQueryengines(), name);
			if (queryEnginePluginConfiguration == null) {
				queryEnginePluginConfiguration = session.create(StorePackage.eINSTANCE.getQueryEnginePluginConfiguration());
				userSettings.getQueryengines().add(queryEnginePluginConfiguration);
				queryEnginePluginConfiguration.setClassName(queryEnginePlugin.getClass().getName());
				queryEnginePluginConfiguration.setName(name);
				queryEnginePluginConfiguration.setDescription(queryEnginePlugin.getDescription());
				queryEnginePluginConfiguration.setEnabled(true);
				queryEnginePluginConfiguration.setSettings(convertSettings(session, queryEnginePlugin));
				if (userSettings.getDefaultQueryEngine() == null && queryEnginePlugin.getClass().getName().equals("nl.wietmazairac.bimql.BimQLQueryEnginePlugin")) {
					userSettings.setDefaultQueryEngine(queryEnginePluginConfiguration);
				}
			} else {
				if (userSettings.getDefaultQueryEngine() == null && queryEnginePlugin.getClass().getName().equals("nl.wietmazairac.bimql.BimQLQueryEnginePlugin")) {
					userSettings.setDefaultQueryEngine(queryEnginePluginConfiguration);
				}
			}
		}
		if (userSettings.getDefaultQueryEngine() == null && !userSettings.getQueryengines().isEmpty()) {
			userSettings.setDefaultQueryEngine(userSettings.getQueryengines().get(0));
		}
		for (ModelMergerPlugin modelMergerPlugin : pluginManager.getAllModelMergerPlugins(true)) {
			String name = modelMergerPlugin.getDefaultName();
			ModelMergerPluginConfiguration modelMergerPluginConfiguration = find(userSettings.getModelmergers(), name);
			if (modelMergerPluginConfiguration == null) {
				modelMergerPluginConfiguration = session.create(StorePackage.eINSTANCE.getModelMergerPluginConfiguration());
				userSettings.getModelmergers().add(modelMergerPluginConfiguration);
				modelMergerPluginConfiguration.setClassName(modelMergerPlugin.getClass().getName());
				modelMergerPluginConfiguration.setName(name);
				modelMergerPluginConfiguration.setDescription(modelMergerPlugin.getDescription());
				modelMergerPluginConfiguration.setEnabled(true);
				modelMergerPluginConfiguration.setSettings(convertSettings(session, modelMergerPlugin));
				if (userSettings.getDefaultModelMerger() == null && modelMergerPlugin.getClass().getName().equals("org.bimserver.merging.BasicModelMergerPlugin")) {
					userSettings.setDefaultModelMerger(modelMergerPluginConfiguration);
				}
			} else {
				if (userSettings.getDefaultModelMerger() == null && modelMergerPlugin.getClass().getName().equals("org.bimserver.merging.BasicModelMergerPlugin")) {
					userSettings.setDefaultModelMerger(modelMergerPluginConfiguration);
				}
			}
		}
		if (userSettings.getDefaultModelMerger() == null && !userSettings.getModelmergers().isEmpty()) {
			userSettings.setDefaultModelMerger(userSettings.getModelmergers().get(0));
		}
		for (ModelComparePlugin modelComparePlugin : pluginManager.getAllModelComparePlugins(true)) {
			String name = modelComparePlugin.getDefaultName();
			ModelComparePluginConfiguration modelComparePluginConfiguration = find(userSettings.getModelcompares(), name);
			if (modelComparePluginConfiguration == null) {
				modelComparePluginConfiguration = session.create(StorePackage.eINSTANCE.getModelComparePluginConfiguration());
				userSettings.getModelcompares().add(modelComparePluginConfiguration);
				modelComparePluginConfiguration.setClassName(modelComparePlugin.getClass().getName());
				modelComparePluginConfiguration.setName(name);
				modelComparePluginConfiguration.setDescription(modelComparePlugin.getDescription());
				modelComparePluginConfiguration.setEnabled(true);
				modelComparePluginConfiguration.setSettings(convertSettings(session, modelComparePlugin));
				if (userSettings.getDefaultModelCompare() == null && modelComparePlugin.getClass().getName().equals("org.bimserver.ifc.compare.GuidBasedModelComparePlugin")) {
					userSettings.setDefaultModelCompare(modelComparePluginConfiguration);
				}
			} else {
				if (userSettings.getDefaultModelCompare() == null && modelComparePlugin.getClass().getName().equals("org.bimserver.ifc.compare.GuidBasedModelComparePlugin")) {
					userSettings.setDefaultModelCompare(modelComparePluginConfiguration);
				}
			}
		}
		if (userSettings.getDefaultModelCompare() == null && !userSettings.getModelcompares().isEmpty()) {
			userSettings.setDefaultModelCompare(userSettings.getModelcompares().get(0));
		}
		for (SerializerPlugin serializerPlugin : pluginManager.getAllSerializerPlugins(true)) {
			String name = serializerPlugin.getDefaultName();
			SerializerPluginConfiguration serializerPluginConfiguration = find(userSettings.getSerializers(), name);
			if (serializerPluginConfiguration == null) {
				serializerPluginConfiguration = session.create(StorePackage.eINSTANCE.getSerializerPluginConfiguration());
				userSettings.getSerializers().add(serializerPluginConfiguration);
				serializerPluginConfiguration.setClassName(serializerPlugin.getClass().getName());
				serializerPluginConfiguration.setName(name);
				serializerPluginConfiguration.setEnabled(true);
				serializerPluginConfiguration.setDescription(serializerPlugin.getDescription());
				serializerPluginConfiguration.setContentType(serializerPlugin.getDefaultContentType());
				serializerPluginConfiguration.setExtension(serializerPlugin.getDefaultExtension());
				serializerPluginConfiguration.setObjectIDM(userSettings.getDefaultObjectIDM());
				serializerPluginConfiguration.setIfcEngine(userSettings.getDefaultIfcEngine());
				serializerPluginConfiguration.setNeedsGeometry(serializerPlugin.needsGeometry());
				serializerPluginConfiguration.setSettings(convertSettings(session, serializerPlugin));
				if (userSettings.getDefaultSerializer() == null && serializerPlugin.getClass().getName().equals("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin")) {
					userSettings.setDefaultSerializer(serializerPluginConfiguration);
				}
			} else {
				if (userSettings.getDefaultSerializer() == null && serializerPlugin.getClass().getName().equals("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin")) {
					userSettings.setDefaultSerializer(serializerPluginConfiguration);
				}
			}
		}
		if (userSettings.getDefaultSerializer() == null && !userSettings.getSerializers().isEmpty()) {
			userSettings.setDefaultSerializer(userSettings.getSerializers().get(0));
		}
		for (ServicePlugin servicePlugin : pluginManager.getAllServicePlugins(true)) {
			String name = servicePlugin.getTitle();
			InternalServicePluginConfiguration internalServicePluginConfiguration = find(userSettings.getServices(), name);
			if (internalServicePluginConfiguration == null) {
				internalServicePluginConfiguration = session.create(StorePackage.eINSTANCE.getInternalServicePluginConfiguration());
				userSettings.getServices().add(internalServicePluginConfiguration);
				internalServicePluginConfiguration.setClassName(servicePlugin.getClass().getName());
				internalServicePluginConfiguration.setName(name);
				internalServicePluginConfiguration.setEnabled(true);
				internalServicePluginConfiguration.setDescription(servicePlugin.getDescription());
				internalServicePluginConfiguration.setSettings(convertSettings(session, servicePlugin));
			}
		}
		for (DeserializerPlugin deserializerPlugin : pluginManager.getAllDeserializerPlugins(true)) {
			String name = deserializerPlugin.getDefaultName();
			DeserializerPluginConfiguration deserializerPluginConfiguration = find(userSettings.getDeserializers(), name);
			if (deserializerPluginConfiguration == null) {
				deserializerPluginConfiguration = session.create(StorePackage.eINSTANCE.getDeserializerPluginConfiguration());
				userSettings.getDeserializers().add(deserializerPluginConfiguration);
				deserializerPluginConfiguration.setClassName(deserializerPlugin.getClass().getName());
				deserializerPluginConfiguration.setName(name);
				deserializerPluginConfiguration.setEnabled(true);
				deserializerPluginConfiguration.setDescription(deserializerPlugin.getDescription());
				deserializerPluginConfiguration.setSettings(convertSettings(session, deserializerPlugin));
			}
		}
		session.store(userSettings);
	}

	private ObjectType convertSettings(DatabaseSession session, Plugin plugin) throws BimserverDatabaseException {
		ObjectType settings = session.create(StorePackage.eINSTANCE.getObjectType());
		ObjectDefinition settingsDefinition = plugin.getSettingsDefinition();
		if (plugin.getSettingsDefinition() != null) {
			for (ParameterDefinition parameterDefinition : settingsDefinition.getParameters()) {
				Parameter parameter = session.create(StorePackage.eINSTANCE.getParameter());
				parameter.setName(parameterDefinition.getName());
				if (parameterDefinition.getDefaultValue() != null) {
					Type value = cloneAndAdd(session, parameterDefinition.getDefaultValue());
					parameter.setValue(value);
				}
				settings.getParameters().add(parameter);
			}
		}
		return settings;
	}

	private Type cloneAndAdd(DatabaseSession session, Type input) throws BimserverDatabaseException {
		if (input instanceof BooleanType) {
			BooleanType booleanType = session.create(StorePackage.eINSTANCE.getBooleanType());
			booleanType.setValue(((BooleanType) input).isValue());
			session.store(booleanType);
			return booleanType;
		} else if (input instanceof StringType) {
			StringType stringType = session.create(StorePackage.eINSTANCE.getStringType());
			stringType.setValue(((StringType) input).getValue());
			session.store(stringType);
			return stringType;
		} else if (input instanceof DoubleType) {
			DoubleType doubleType = session.create(StorePackage.eINSTANCE.getDoubleType());
			doubleType.setValue(((DoubleType) input).getValue());
			session.store(doubleType);
			return doubleType;
		} else if (input instanceof LongType) {
			LongType longType = session.create(StorePackage.eINSTANCE.getLongType());
			longType.setValue(((LongType) input).getValue());
			session.store(longType);
			return longType;
		}
		return null;
	}

	private void initDatabaseDependantItems() throws BimserverDatabaseException {
		getSerializerFactory().init(pluginManager, bimDatabase);
		getDeserializerFactory().init(pluginManager, bimDatabase);
		try {
			DatabaseSession session = bimDatabase.createSession();

			createDatabaseObjects(session);
			updatePlugins(session);
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Username(), new StringLiteral("system"));
			User systemUser = session.querySingle(condition, User.class, Query.getDefault());

			ServerStarted serverStarted = session.create(LogPackage.eINSTANCE.getServerStarted());
			serverStarted.setDate(new Date());
			serverStarted.setAccessMethod(AccessMethod.INTERNAL);
			serverStarted.setExecutor(systemUser);
			try {
				session.store(serverStarted);
				session.commit();
			} catch (BimserverLockConflictException e) {
				throw new BimserverDatabaseException(e);
			} finally {
				session.close();
			}
		} catch (BimserverLockConflictException e) {
			throw new BimserverDatabaseException(e);
		} catch (PluginException e) {
			throw new BimserverDatabaseException(e);
		}
	}

	private void updatePlugins(DatabaseSession session) throws BimserverDatabaseException {
		Collection<Plugin> allPlugins = pluginManager.getAllPlugins(false);
		for (Plugin plugin : allPlugins) {
			Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_PluginClassName(), new StringLiteral(plugin.getClass().getName()));
			Map<Long, PluginDescriptor> results = session.query(pluginCondition, PluginDescriptor.class, Query.getDefault());
			if (results.size() == 0) {
				PluginDescriptor pluginDescriptor = session.create(StorePackage.eINSTANCE.getPluginDescriptor());
				pluginDescriptor.setPluginClassName(plugin.getClass().getName());
				pluginDescriptor.setEnabled(true); // New plugins are enabled by default
			} else if (results.size() == 1) {
				PluginDescriptor pluginDescriptor = results.values().iterator().next();
				pluginManager.getPluginContext(plugin).setEnabled(pluginDescriptor.getEnabled(), false);
			} else {
				LOGGER.error("Multiple plugin descriptor objects found with the same name: " + plugin.getClass().getName());
			}
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

	public SerializerFactory getSerializerFactory() {
		return serializerFactory;
	}

	public DeserializerFactory getDeserializerFactory() {
		return deserializerFactory;
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

	public BimServerClientFactory getBimServerClientFactory() {
		return bimServerClientFactory;
	}
	
	public PublicInterfaceFactory getServiceFactory() {
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

	public ProtocolBuffersMetaData getProtocolBuffersMetaData() {
		return protocolBuffersMetaData;
	}

	public BimServerConfig getConfig() {
		return config;
	}

	public EmbeddedWebServer getEmbeddedWebServer() {
		return embeddedWebServer;
	}

	public ServicesMap getServicesMap() {
		return servicesMap;
	}

	public JsonHandler getJsonHandler() {
		return jsonHandler;
	}
	
	public SConverter getSConverter() {
		return sConverter;
	}

	public EndPointManager getEndPointManager() {
		return endPointManager;
	}

	public ServerSettingsCache getServerSettingsCache() {
		return serverSettingsCache;
	}

	public ServiceInterface getSystemService() {
		return getServiceFactory().getService(ServiceInterface.class, new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL);
	}
	
	public LongTransactionManager getLongTransactionManager() {
		return longTransactionManager;
	}
}