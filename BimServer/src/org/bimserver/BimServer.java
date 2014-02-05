package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.bimserver.cache.CompareCache;
import org.bimserver.cache.DiskCacheManager;
import org.bimserver.client.DirectBimServerClientFactory;
import org.bimserver.client.json.JsonSocketReflectorFactory;
import org.bimserver.client.protocolbuffers.ProtocolBuffersBimServerClientFactory;
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
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.logging.CustomFileAppender;
import org.bimserver.longaction.LongActionManager;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.store.BooleanType;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.DoubleType;
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
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.ServerInfo;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.StringType;
import org.bimserver.models.store.Type;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.models.store.WebModulePluginConfiguration;
import org.bimserver.notifications.InternalServicesManager;
import org.bimserver.notifications.NotificationsManager;
import org.bimserver.openid.OpenIdManager;
import org.bimserver.pb.server.ProtocolBuffersServer;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginChangeListener;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.PluginSourceType;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.modelmerger.ModelMergerPlugin;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.plugins.web.WebModulePlugin;
import org.bimserver.serializers.SerializerFactory;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.InterfaceList;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.reflector.FileBasedReflectorFactoryBuilder;
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
	private SServicesMap servicesMap;
	private EmbeddedWebServer embeddedWebServer;
	private final BimServerConfig config;
	private ProtocolBuffersServer protocolBuffersServer;
	private JsonHandler jsonHandler;
	private CommandLine commandLine;
	private ServerSettingsCache serverSettingsCache;
	private ReflectorFactory reflectorFactory;
	private final EndPointManager endPointManager = new EndPointManager();
	private final SConverter sConverter = new SConverter();
	private final LongTransactionManager longTransactionManager = new LongTransactionManager();
	private JsonSocketReflectorFactory jsonSocketReflectorFactory;
	private SecretKeySpec encryptionkey;
	private BimServerClientFactory bimServerClientFactory;
	private Map<String, WebModulePlugin> webModules;
	private WebModulePlugin defaultWebModule;
	private ExecutorService executorService = Executors.newFixedThreadPool(50);
	private InternalServicesManager internalServicesManager;
	private OpenIdManager openIdManager;

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
					} else {
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

			servicesMap = InterfaceList.createSServicesMap();
			LOGGER.debug("SServiceMap Created");

			jsonSocketReflectorFactory = new JsonSocketReflectorFactory(servicesMap);
			LOGGER.debug("JsonSocketReflectorFactory created");

			serverInfoManager = new ServerInfoManager();
			LOGGER.debug("ServerInfoManager created");
			
			notificationsManager = new NotificationsManager(this, jsonSocketReflectorFactory);
			LOGGER.debug("NotificationsManager created");
			
			internalServicesManager = new InternalServicesManager(this, notificationsManager.getSiteAddress());
			LOGGER.debug("InternalServicesManager created");
			
			serviceFactory = new PublicInterfaceFactory(this);
			LOGGER.debug("PublicInterfaceFactory created");
			
			pluginManager = new PluginManager(new File(config.getHomeDir(), "tmp"), config.getClassPath(), serviceFactory, internalServicesManager, servicesMap);
			LOGGER.debug("PluginManager created");
			
			versionChecker = new VersionChecker(config.getResourceFetcher());
			LOGGER.debug("Version Checker created");

			compareCache = new CompareCache();
			LOGGER.debug("Compare cache created");
			if (config.isStartEmbeddedWebServer()) {
				embeddedWebServer = new EmbeddedWebServer(this, config.isLocalDev());
				LOGGER.debug("Embedded webserver created");
			}
			
			LOGGER.debug("Done with initial setup");
		} catch (Throwable e) {
			if (LOGGER == null) {
				e.printStackTrace();
			} else {
				LOGGER.error("", e);
			}
			serverInfoManager.setErrorMessage(e.getMessage());
		}
	}

	public Map<String, WebModulePlugin> getWebModules() {
		return webModules;
	}
	
	public WebModulePlugin getDefaultWebModule() {
		return defaultWebModule;
	}
	
	public JsonSocketReflectorFactory getJsonSocketReflectorFactory() {
		return jsonSocketReflectorFactory;
	}

	public ReflectorFactory getReflectorFactory() {
		return reflectorFactory;
	}

	public void start() throws DatabaseInitException, BimserverDatabaseException, PluginException, DatabaseRestartRequiredException, ServerException {
		try {
			LOGGER.debug("Starting BIMserver");
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
						} catch (ServiceException e) {
							LOGGER.error("", e);
						} finally {
							session.close();
						}
					}
				});
				pluginManager.loadPlugin(ObjectIDMPlugin.class, "Internal", "Internal", new SchemaFieldObjectIDMPlugin(), getClass().getClassLoader(), PluginSourceType.INTERNAL);
				pluginManager.loadPlugin(WebModulePlugin.class, "Internal", "Internal", new DefaultWebModulePlugin(), getClass().getClassLoader(), PluginSourceType.INTERNAL);
			} catch (Exception e) {
				LOGGER.error("", e);
			}

			try {
				pluginManager.initAllLoadedPlugins();
			} catch (PluginException e) {
				LOGGER.error("", e);
			}
			serverStartTime = new GregorianCalendar();

			longActionManager = new LongActionManager();

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
				if (!bimDatabase.getRegistry().has(ENCRYPTIONKEY, encsession)) {
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

			protocolBuffersMetaData = new ProtocolBuffersMetaData();
			protocolBuffersMetaData.load(servicesMap, ProtocolBuffersBimServerClientFactory.class);
			
			serverInfoManager.init(this);

			jsonHandler = new JsonHandler(this);
			
			serializerFactory = new SerializerFactory();
			deserializerFactory = new DeserializerFactory();

			serverSettingsCache = new ServerSettingsCache(bimDatabase);
			
			serverInfoManager.update();
			
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

			diskCacheManager = new DiskCacheManager(this, new File(config.getHomeDir(), "cache"));

			mergerFactory = new MergerFactory(this);

			FileBasedReflectorFactoryBuilder factoryBuilder = new FileBasedReflectorFactoryBuilder();
			reflectorFactory = factoryBuilder.newReflectorFactory();
			if (reflectorFactory == null) {
				throw new RuntimeException("No reflector factory!");
			}
			servicesMap.setReflectorFactory(reflectorFactory);

			bimScheduler = new JobScheduler(this);
			bimScheduler.start();

			try {
				protocolBuffersServer = new ProtocolBuffersServer(protocolBuffersMetaData, serviceFactory, servicesMap, config.getInitialProtocolBuffersPort());
				protocolBuffersServer.start();
			} catch (Exception e) {
				LOGGER.error("", e);
			}

			if (config.isStartEmbeddedWebServer()) {
				embeddedWebServer.start();
			}
			
			if (config.isStartCommandLine()) {
				commandLine = new CommandLine(this);
				commandLine.start();
			}
		} catch (Throwable e) {
			LOGGER.error("", e);
			serverInfoManager.setErrorMessage(e.getMessage());
		}
	}

	public SecretKeySpec getEncryptionKey() {
		return encryptionkey;
	}

	/*
	 * Serializers, deserializers, renderengines etc... all have counterparts as
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
			if (t.getPluginDescriptor() == null) {
//				throw new RuntimeException("No PluginDescriptor!");
			} else {
				if (t.getPluginDescriptor().getPluginClassName().equals(name)) {
					return t;
				}
			}
		}
		return null;
	}

	private void genericPluginConversion(DatabaseSession session, Plugin plugin, PluginConfiguration pluginConfiguration, PluginDescriptor pluginDescriptor) throws BimserverDatabaseException {
		try {
			pluginConfiguration.setName(plugin.getDefaultName());
			pluginConfiguration.setPluginDescriptor(pluginDescriptor);
			
			// For the opposite of setPluginDescriptor
			session.store(pluginDescriptor);
			
			pluginConfiguration.setDescription(plugin.getDescription());
			pluginConfiguration.setEnabled(true);
			pluginConfiguration.setSettings(convertSettings(session, plugin));
		} catch (NoClassDefFoundError e) {
			// ignore for now
		}
	}

	private PluginDescriptor getPluginDescriptor(DatabaseSession session, String pluginClassName) throws BimserverDatabaseException {
		Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_PluginClassName(), new StringLiteral(pluginClassName));
		return session.querySingle(condition, PluginDescriptor.class, Query.getDefault());
	}
	
	public void updateUserSettings(DatabaseSession session, User user) throws BimserverLockConflictException, BimserverDatabaseException {
		UserSettings userSettings = user.getUserSettings();
		if (userSettings == null) {
			userSettings = session.create(UserSettings.class);
			user.setUserSettings(userSettings);
			session.store(user);
		}
		for (ObjectIDMPlugin objectIDMPlugin : pluginManager.getAllObjectIDMPlugins(true)) {
			ObjectIDMPluginConfiguration objectIdmPluginConfiguration = find(userSettings.getObjectIDMs(), objectIDMPlugin.getClass().getName());
			if (objectIdmPluginConfiguration == null) {
				objectIdmPluginConfiguration = session.create(ObjectIDMPluginConfiguration.class);
				userSettings.getObjectIDMs().add(objectIdmPluginConfiguration);
				genericPluginConversion(session, objectIDMPlugin, objectIdmPluginConfiguration, getPluginDescriptor(session, objectIDMPlugin.getClass().getName()));
			}
			if (userSettings.getDefaultObjectIDM() == null && objectIDMPlugin.getClass() == SchemaFieldObjectIDMPlugin.class) {
				userSettings.setDefaultObjectIDM(objectIdmPluginConfiguration);
			}
		}
		if (userSettings.getDefaultObjectIDM() == null && !userSettings.getObjectIDMs().isEmpty()) {
			userSettings.setDefaultObjectIDM(userSettings.getObjectIDMs().get(0));
		}
		for (RenderEnginePlugin ifcEnginePlugin : pluginManager.getAllRenderEnginePlugins(true)) {
			RenderEnginePluginConfiguration ifcEnginePluginConfiguration = find(userSettings.getRenderEngines(), ifcEnginePlugin.getClass().getName());
			if (ifcEnginePluginConfiguration == null) {
				ifcEnginePluginConfiguration = session.create(RenderEnginePluginConfiguration.class);
				userSettings.getRenderEngines().add(ifcEnginePluginConfiguration);
				genericPluginConversion(session, ifcEnginePlugin, ifcEnginePluginConfiguration, getPluginDescriptor(session, ifcEnginePlugin.getClass().getName()));
			}
			if (userSettings.getDefaultRenderEngine() == null && ifcEnginePlugin.getClass().getName().equals("org.bimserver.ifcengine.TNOJvmRenderEnginePlugin")) {
				userSettings.setDefaultRenderEngine(ifcEnginePluginConfiguration);
			}
		}
		if (userSettings.getDefaultRenderEngine() == null && !userSettings.getRenderEngines().isEmpty()) {
			userSettings.setDefaultRenderEngine(userSettings.getRenderEngines().get(0));
		}
		for (QueryEnginePlugin queryEnginePlugin : pluginManager.getAllQueryEnginePlugins(true)) {
			QueryEnginePluginConfiguration queryEnginePluginConfiguration = find(userSettings.getQueryengines(), queryEnginePlugin.getClass().getName());
			if (queryEnginePluginConfiguration == null) {
				queryEnginePluginConfiguration = session.create(QueryEnginePluginConfiguration.class);
				userSettings.getQueryengines().add(queryEnginePluginConfiguration);
				genericPluginConversion(session, queryEnginePlugin, queryEnginePluginConfiguration, getPluginDescriptor(session, queryEnginePlugin.getClass().getName()));
			}
			if (userSettings.getDefaultQueryEngine() == null && queryEnginePlugin.getClass().getName().equals("nl.wietmazairac.bimql.BimQLQueryEnginePlugin")) {
				userSettings.setDefaultQueryEngine(queryEnginePluginConfiguration);
			}
		}
		if (userSettings.getDefaultQueryEngine() == null && !userSettings.getQueryengines().isEmpty()) {
			userSettings.setDefaultQueryEngine(userSettings.getQueryengines().get(0));
		}
		for (ModelMergerPlugin modelMergerPlugin : pluginManager.getAllModelMergerPlugins(true)) {
			ModelMergerPluginConfiguration modelMergerPluginConfiguration = find(userSettings.getModelmergers(), modelMergerPlugin.getClass().getName());
			if (modelMergerPluginConfiguration == null) {
				modelMergerPluginConfiguration = session.create(ModelMergerPluginConfiguration.class);
				userSettings.getModelmergers().add(modelMergerPluginConfiguration);
				genericPluginConversion(session, modelMergerPlugin, modelMergerPluginConfiguration, getPluginDescriptor(session, modelMergerPlugin.getClass().getName()));
			}
			if (userSettings.getDefaultModelMerger() == null && modelMergerPlugin.getClass().getName().equals("org.bimserver.merging.BasicModelMergerPlugin")) {
				userSettings.setDefaultModelMerger(modelMergerPluginConfiguration);
			}
		}
		if (userSettings.getDefaultModelMerger() == null && !userSettings.getModelmergers().isEmpty()) {
			userSettings.setDefaultModelMerger(userSettings.getModelmergers().get(0));
		}
		for (ModelComparePlugin modelComparePlugin : pluginManager.getAllModelComparePlugins(true)) {
			ModelComparePluginConfiguration modelComparePluginConfiguration = find(userSettings.getModelcompares(), modelComparePlugin.getClass().getName());
			if (modelComparePluginConfiguration == null) {
				modelComparePluginConfiguration = session.create(ModelComparePluginConfiguration.class);
				userSettings.getModelcompares().add(modelComparePluginConfiguration);
				genericPluginConversion(session, modelComparePlugin, modelComparePluginConfiguration, getPluginDescriptor(session, modelComparePlugin.getClass().getName()));
			}
			if (userSettings.getDefaultModelCompare() == null && modelComparePlugin.getClass().getName().equals("org.bimserver.ifc.compare.GuidBasedModelComparePlugin")) {
				userSettings.setDefaultModelCompare(modelComparePluginConfiguration);
			}
		}
		if (userSettings.getDefaultModelCompare() == null && !userSettings.getModelcompares().isEmpty()) {
			userSettings.setDefaultModelCompare(userSettings.getModelcompares().get(0));
		}
		for (SerializerPlugin serializerPlugin : pluginManager.getAllSerializerPlugins(true)) {
			SerializerPluginConfiguration serializerPluginConfiguration = find(userSettings.getSerializers(), serializerPlugin.getClass().getName());
			if (serializerPluginConfiguration == null) {
				serializerPluginConfiguration = session.create(SerializerPluginConfiguration.class);
				userSettings.getSerializers().add(serializerPluginConfiguration);
				genericPluginConversion(session, serializerPlugin, serializerPluginConfiguration, getPluginDescriptor(session, serializerPlugin.getClass().getName()));
				serializerPluginConfiguration.setObjectIDM(userSettings.getDefaultObjectIDM());
				serializerPluginConfiguration.setRenderEngine(userSettings.getDefaultRenderEngine());
			}
			if (userSettings.getDefaultSerializer() == null && serializerPlugin.getClass().getName().equals("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin")) {
				userSettings.setDefaultSerializer(serializerPluginConfiguration);
			}
		}
		if (userSettings.getDefaultSerializer() == null && !userSettings.getSerializers().isEmpty()) {
			userSettings.setDefaultSerializer(userSettings.getSerializers().get(0));
		}
		for (ServicePlugin servicePlugin : pluginManager.getAllServicePlugins(true)) {
			InternalServicePluginConfiguration internalServicePluginConfiguration = find(userSettings.getServices(), servicePlugin.getClass().getName());
			if (internalServicePluginConfiguration == null) {
				internalServicePluginConfiguration = session.create(InternalServicePluginConfiguration.class);
				userSettings.getServices().add(internalServicePluginConfiguration);
				genericPluginConversion(session, servicePlugin, internalServicePluginConfiguration, getPluginDescriptor(session, servicePlugin.getClass().getName()));
			}
		}
		for (DeserializerPlugin deserializerPlugin : pluginManager.getAllDeserializerPlugins(true)) {
			DeserializerPluginConfiguration deserializerPluginConfiguration = find(userSettings.getDeserializers(), deserializerPlugin.getClass().getName());
			if (deserializerPluginConfiguration == null) {
				deserializerPluginConfiguration = session.create(DeserializerPluginConfiguration.class);
				userSettings.getDeserializers().add(deserializerPluginConfiguration);
				genericPluginConversion(session, deserializerPlugin, deserializerPluginConfiguration, getPluginDescriptor(session, deserializerPlugin.getClass().getName()));
			}
		}
		session.store(userSettings);
	}

	private ObjectType convertSettings(DatabaseSession session, Plugin plugin) throws BimserverDatabaseException {
		ObjectType settings = session.create(ObjectType.class);
		ObjectDefinition settingsDefinition = plugin.getSettingsDefinition();
		if (plugin.getSettingsDefinition() != null) {
			for (ParameterDefinition parameterDefinition : settingsDefinition.getParameters()) {
				Parameter parameter = session.create(Parameter.class);
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
			BooleanType booleanType = session.create(BooleanType.class);
			booleanType.setValue(((BooleanType) input).isValue());
			session.store(booleanType);
			return booleanType;
		} else if (input instanceof StringType) {
			StringType stringType = session.create(StringType.class);
			stringType.setValue(((StringType) input).getValue());
			session.store(stringType);
			return stringType;
		} else if (input instanceof DoubleType) {
			DoubleType doubleType = session.create(DoubleType.class);
			doubleType.setValue(((DoubleType) input).getValue());
			session.store(doubleType);
			return doubleType;
		} else if (input instanceof LongType) {
			LongType longType = session.create(LongType.class);
			longType.setValue(((LongType) input).getValue());
			session.store(longType);
			return longType;
		}
		return null;
	}

	private void initDatabaseDependantItems() throws BimserverDatabaseException {
		serverSettingsCache.init();
		notificationsManager.init();

		getSerializerFactory().init(pluginManager, bimDatabase);
		getDeserializerFactory().init(pluginManager, bimDatabase);
		try {
			DatabaseSession session = bimDatabase.createSession();
			try {
				updatePlugins(session);
				session.commit();
			} catch (ServiceException e) {
				LOGGER.error("", e);
			} finally {
				session.close();
			}

			session = bimDatabase.createSession();
			try {
				for (InternalServicePluginConfiguration internalService : session.getAllOfType(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), InternalServicePluginConfiguration.class, Query.getDefault())) {
					if (internalService.getEnabled()) {
						ServicePlugin servicePlugin = pluginManager.getServicePlugin(internalService.getPluginDescriptor().getPluginClassName(), true);
						if (servicePlugin != null) {
							ObjectType settings = internalService.getSettings();
							servicePlugin.register(new org.bimserver.plugins.PluginConfiguration(settings));
						}
					}
				}
			} finally {
				session.close();
			}
			
			session = bimDatabase.createSession();
			createDatabaseObjects(session);
			
			ServerSettings serverSettings = serverSettingsCache.getServerSettings();
			for (WebModulePlugin webModulePlugin : pluginManager.getAllWebPlugins(true)) {
				WebModulePluginConfiguration webPluginConfiguration = find(serverSettings.getWebModules(), webModulePlugin.getClass().getName());
				if (webPluginConfiguration == null) {
					webPluginConfiguration = session.create(WebModulePluginConfiguration.class);
					serverSettings.getWebModules().add(webPluginConfiguration);
					genericPluginConversion(session, webModulePlugin, webPluginConfiguration, getPluginDescriptor(session, webModulePlugin.getClass().getName()));
				}
				if (serverSettings.getWebModule() == null && webModulePlugin.getClass().getName().equals("org.bimserver.bootstrap.BootstrapWebModulePlugin")) {
					serverSettings.setWebModule(webPluginConfiguration);
				}
			}
			session.store(serverSettings);
			
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Username(), new StringLiteral("system"));
			User systemUser = session.querySingle(condition, User.class, Query.getDefault());

			ServerStarted serverStarted = session.create(ServerStarted.class);
			serverStarted.setDate(new Date());
			serverStarted.setAccessMethod(AccessMethod.INTERNAL);
			serverStarted.setExecutor(systemUser);
			try {
				session.store(serverStarted);
				session.commit();
			} catch (BimserverLockConflictException e) {
				throw new BimserverDatabaseException(e);
			} catch (ServiceException e) {
				throw new BimserverDatabaseException(e);
			} finally {
				session.close();
			}
			
			webModules = new HashMap<String, WebModulePlugin>();
			DatabaseSession ses = bimDatabase.createSession();
			try {
				List<WebModulePluginConfiguration> webModuleConfigurations = serverSettingsCache.getServerSettings().getWebModules();
				for (WebModulePluginConfiguration webModulePluginConfiguration : webModuleConfigurations) {
					String contextPath = "";
					for (Parameter parameter : webModulePluginConfiguration.getSettings().getParameters()) {
						if (parameter.getName().equals("contextPath")) {
							contextPath = ((StringType)parameter.getValue()).getValue();
						}
					}
					webModules.put(contextPath, (WebModulePlugin) pluginManager.getPlugin(webModulePluginConfiguration.getPluginDescriptor().getPluginClassName(), true));
				}
				if (serverSettingsCache.getServerSettings().getWebModule() != null) {
					defaultWebModule = (WebModulePlugin) pluginManager.getPlugin(serverSettingsCache.getServerSettings().getWebModule().getPluginDescriptor().getPluginClassName(), true);
				}
			} finally {
				ses.close();
			}
			
			bimServerClientFactory = new DirectBimServerClientFactory<ServiceInterface>(serverSettingsCache.getServerSettings().getSiteAddress(), serviceFactory, servicesMap, pluginManager);
			pluginManager.setBimServerClientFactory(bimServerClientFactory);
		} catch (BimserverLockConflictException e) {
			throw new BimserverDatabaseException(e);
		} catch (PluginException e) {
			throw new BimserverDatabaseException(e);
		}
	}

	private Class<?> getPluginInterfaceClass(Plugin plugin) {
		for (Class<?> pluginInterface : plugin.getClass().getInterfaces()) {
			if (pluginInterface != Plugin.class && Plugin.class.isAssignableFrom(pluginInterface)) {
				return pluginInterface;
			}
		}
		if (plugin.getClass().getSuperclass() != Object.class) {
			for (Class<?> pluginInterface : plugin.getClass().getSuperclass().getInterfaces()) {
				if (pluginInterface != Plugin.class && Plugin.class.isAssignableFrom(pluginInterface)) {
					return pluginInterface;
				}
			}
			if (plugin.getClass().getSuperclass().getSuperclass() != Object.class) {
				for (Class<?> pluginInterface : plugin.getClass().getSuperclass().getSuperclass().getInterfaces()) {
					if (pluginInterface != Plugin.class && Plugin.class.isAssignableFrom(pluginInterface)) {
						return pluginInterface;
					}
				}
			}
			return plugin.getClass().getSuperclass();
		}
		return plugin.getClass();
	}
	
	private void updatePlugins(DatabaseSession session) throws BimserverDatabaseException {
		Collection<Plugin> allPlugins = pluginManager.getAllPlugins(false);
		for (Plugin plugin : allPlugins) {
			Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_PluginClassName(), new StringLiteral(plugin.getClass().getName()));
			Map<Long, PluginDescriptor> results = session.query(pluginCondition, PluginDescriptor.class, Query.getDefault());
			if (results.size() == 0) {
				PluginContext pluginContext = pluginManager.getPluginContext(plugin);
				PluginDescriptor pluginDescriptor = session.create(PluginDescriptor.class);
				pluginDescriptor.setPluginClassName(plugin.getClass().getName());
				pluginDescriptor.setSimpleName(plugin.getClass().getSimpleName());
				pluginDescriptor.setDescription(plugin.getDescription());
				pluginDescriptor.setLocation(pluginContext.getLocation());
				pluginDescriptor.setPluginInterfaceClassName(getPluginInterfaceClass(plugin).getName());
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
								} else if (f.isDirectory()) {
									File destDir2 = new File(destFile, f.getName());
									for (File x : f.listFiles()) {
										FileUtils.copyFile(x, new File(destDir2, x.getName()));
									}
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
		executorService.shutdown();
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

	public InternalServicesManager getInternalServicesManager() {
		return internalServicesManager;
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

	public SServicesMap getServicesMap() {
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

	public <T extends PublicInterface> T getService(Class<T> clazz) {
		return getServiceFactory().get(new SystemAuthorization(getServerSettingsCache().getServerSettings().getSessionTimeOutSeconds(), TimeUnit.SECONDS), AccessMethod.INTERNAL).get(clazz);
	}
	
	public LongTransactionManager getLongTransactionManager() {
		return longTransactionManager;
	}
	
	public ExecutorService getExecutorService() {
		return executorService;
	}
	
	public OpenIdManager getOpenIdManager() {
		return openIdManager;
	}
}
