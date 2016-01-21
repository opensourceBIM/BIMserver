package org.bimserver;

import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;
import org.bimserver.cache.CompareCache;
import org.bimserver.cache.DiskCacheManager;
import org.bimserver.cache.NewDiskCacheManager;
import org.bimserver.client.DirectBimServerClientFactory;
import org.bimserver.client.json.JsonSocketReflectorFactory;
import org.bimserver.client.protocolbuffers.ProtocolBuffersBimServerClientFactory;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.berkeley.BerkeleyKeyValueStore;
import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.endpoints.EndPointManager;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.longaction.LongActionManager;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.store.BooleanType;
import org.bimserver.models.store.DoubleType;
import org.bimserver.models.store.LongType;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.PluginDescriptor;
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
import org.bimserver.pb.server.ProtocolBuffersServer;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginBundle;
import org.bimserver.plugins.PluginChangeListener;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.web.WebModulePlugin;
import org.bimserver.renderengine.RenderEnginePools;
import org.bimserver.schemaconverter.Ifc2x3tc1ToIfc4SchemaConverterFactory;
import org.bimserver.schemaconverter.Ifc4ToIfc2x3tc1SchemaConverterFactory;
import org.bimserver.schemaconverter.SchemaConverterManager;
import org.bimserver.serializers.SerializerFactory;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.InterfaceList;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.reflector.FileBasedReflectorFactoryBuilder;
import org.bimserver.shared.reflector.ReflectorFactory;
import org.bimserver.templating.TemplateEngine;
import org.bimserver.utils.PathUtils;
import org.bimserver.utils.StringUtils;
import org.bimserver.version.VersionChecker;
import org.bimserver.webservices.LongTransactionManager;
import org.bimserver.webservices.PublicInterfaceFactory;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;

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
	private MergerFactory mergerFactory;
	private PluginManager pluginManager;
	private MailSystem mailSystem;
	private DiskCacheManager diskCacheManager;
	private NewDiskCacheManager newDiskCacheManager;
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
	private ExecutorService executorService = Executors.newCachedThreadPool();
	private InternalServicesManager internalServicesManager;
	private MetaDataManager metaDataManager;
	private SchemaConverterManager schemaConverterManager = new SchemaConverterManager();
	private WebModuleManager webModuleManager;
	private MetricsRegistry metricsRegistry;
	private RenderEnginePools renderEnginePools;

	/**
	 * Create a new BIMserver
	 * 
	 * @param config
	 *            Configuration of BIMserver
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
				LOGGER.info("Using \"" + config.getHomeDir().toString() + "\" as homedir");
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

			pluginManager = new PluginManager(config.getHomeDir().resolve("tmp"), config.getHomeDir().resolve("plugins"), config.getClassPath(), serviceFactory, internalServicesManager, servicesMap);
			metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
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
				LOGGER.info("Version: " + localVersion.getFullString());
			} else {
				LOGGER.info("Unknown version");
			}

			try {
				pluginManager.addPluginChangeListener(new PluginChangeListener() {
					@Override
					public void pluginStateChanged(PluginContext pluginContext, boolean enabled) {
						// Reflect this change also in the database
						Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_PluginClassName(), new StringLiteral(pluginContext.getPlugin().getClass().getName()));
						DatabaseSession session = bimDatabase.createSession();
						try {
							Map<Long, PluginDescriptor> pluginsFound = session.query(pluginCondition, PluginDescriptor.class, OldQuery.getDefault());
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

					@Override
					public void pluginInstalled(PluginContext pluginContext) throws BimserverDatabaseException {
						// TODO allow user to select users to which to add this
						// plugin
						try (DatabaseSession session = bimDatabase.createSession()) {
							Plugin plugin = pluginContext.getPlugin();
							PluginBundle pluginBundle = pluginContext.getPluginBundle();
							
							PluginDescriptor pluginDescriptor = session.create(PluginDescriptor.class);
							pluginDescriptor.setPluginClassName(plugin.getClass().getName());
							pluginDescriptor.setSimpleName(plugin.getClass().getSimpleName());
							pluginDescriptor.setDescription(pluginContext.getDescription() + " " + pluginBundle.getVersion());
							pluginDescriptor.setLocation(pluginContext.getLocation().toString());
							pluginDescriptor.setPluginInterfaceClassName(getPluginInterfaceClass(plugin).getName());
							pluginDescriptor.setEnabled(true); // New plugins
																// are enabled
																// by default

							IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), OldQuery.getDefault());
							for (User user : allOfType.getAll(User.class)) {
								updateUserPlugin(session, user, pluginDescriptor, pluginContext);
							}
							try {
								session.commit();
							} catch (ServiceException e) {
								LOGGER.error("", e);
							}
						}
					}
				});
			} catch (Exception e) {
				LOGGER.error("", e);
			}

			try {
				metaDataManager.init();
				pluginManager.initAllLoadedPlugins();
			} catch (PluginException e) {
				LOGGER.error("", e);
			}
			serverStartTime = new GregorianCalendar();

			longActionManager = new LongActionManager();

			Set<EPackage> packages = new LinkedHashSet<>();
			packages.add(Ifc2x3tc1Package.eINSTANCE);
			packages.add(Ifc4Package.eINSTANCE);
			templateEngine = new TemplateEngine();
			templateEngine.init(config.getResourceFetcher().getResource("templates/"));
			Path databaseDir = config.getHomeDir().resolve("database");
			BerkeleyKeyValueStore keyValueStore = new BerkeleyKeyValueStore(databaseDir);

			schemaConverterManager.registerConverter(new Ifc2x3tc1ToIfc4SchemaConverterFactory());
			schemaConverterManager.registerConverter(new Ifc4ToIfc2x3tc1SchemaConverterFactory());

			metricsRegistry = new MetricsRegistry();

			OldQuery.setPackageMetaDataForDefaultQuery(metaDataManager.getPackageMetaData("store"));

			bimDatabase = new Database(this, packages, keyValueStore, metaDataManager);
			try {
				bimDatabase.init();
			} catch (DatabaseRestartRequiredException e) {
				bimDatabase.close();
				keyValueStore = new BerkeleyKeyValueStore(databaseDir);
				bimDatabase = new Database(this, packages, keyValueStore, metaDataManager);
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

			webModuleManager = new WebModuleManager(this);

			jsonHandler = new JsonHandler(this);

			serializerFactory = new SerializerFactory();

			serverSettingsCache = new ServerSettingsCache(bimDatabase);

			serverInfoManager.update();

			renderEnginePools = new RenderEnginePools(this);

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

			diskCacheManager = new DiskCacheManager(this, config.getHomeDir().resolve("cache"));
			newDiskCacheManager = new NewDiskCacheManager(this, config.getHomeDir().resolve("cache"));

			mergerFactory = new MergerFactory(this);

			FileBasedReflectorFactoryBuilder factoryBuilder = new FileBasedReflectorFactoryBuilder();
			reflectorFactory = factoryBuilder.newReflectorFactory();
			if (reflectorFactory == null) {
				throw new RuntimeException("No reflector factory!");
			}
			servicesMap.setReflectorFactory(reflectorFactory);

			bimScheduler = new JobScheduler(this);
			bimScheduler.start();

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
		IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), OldQuery.getDefault());
		for (User user : allOfType.getAll(User.class)) {
			updateUserSettings(session, user);
		}
	}

	public NewDiskCacheManager getNewDiskCacheManager() {
		return newDiskCacheManager;
	}

	private <T extends PluginConfiguration> T find(List<T> list, String name) {
		for (T t : list) {
			if (t.getPluginDescriptor() == null) {
				// throw new RuntimeException("No PluginDescriptor!");
			} else {
				if (t.getPluginDescriptor().getPluginClassName().equals(name)) {
					return t;
				}
			}
		}
		return null;
	}

	private void genericPluginConversion(PluginContext pluginContext, DatabaseSession session, PluginConfiguration pluginConfiguration, PluginDescriptor pluginDescriptor) throws BimserverDatabaseException {
		try {
			Plugin plugin = pluginContext.getPlugin();
			pluginConfiguration.setName(plugin.getDefaultName());
			pluginConfiguration.setPluginDescriptor(pluginDescriptor);

			// For the opposite of setPluginDescriptor
			// session.store(pluginDescriptor); Disabled for now, this creates
			// massive lists, that are not really useful...

			pluginConfiguration.setDescription(pluginContext.getDescription());
			pluginConfiguration.setEnabled(true);
			pluginConfiguration.setSettings(convertSettings(session, plugin));
		} catch (NoClassDefFoundError e) {
			// ignore for now
		}
	}

	private PluginDescriptor getPluginDescriptor(DatabaseSession session, String pluginClassName) throws BimserverDatabaseException {
		return session.querySingle(StorePackage.eINSTANCE.getPluginDescriptor_PluginClassName(), pluginClassName);
	}

	public Class<?> getPluginInterface(Class<?> plugin) {
		for (Class<?> inter : plugin.getInterfaces()) {
			for (Class<?> inter2 : inter.getInterfaces()) {
				if (inter2 == Plugin.class) {
					return inter;
				}
			}
		}
		if (plugin.getSuperclass() != null) {
			return getPluginInterface(plugin.getSuperclass());
		}
		return null;
	}

	public void updateUserPlugin(DatabaseSession session, User user, PluginDescriptor pluginDescriptor, PluginContext pluginContext) throws BimserverDatabaseException {
		UserSettings userSettings = user.getUserSettings();
		if (userSettings == null) {
			userSettings = session.create(UserSettings.class);
			user.setUserSettings(userSettings);
			session.store(user);
		}

		Class<?> pluginInterface = getPluginInterface(pluginContext.getPlugin().getClass());
		String pluginInterfaceName = pluginInterface.getSimpleName();
		if (pluginInterfaceName.endsWith("Plugin")) {
			pluginInterfaceName = pluginInterfaceName.substring(0, pluginInterfaceName.length() - 6);
		}

		if (pluginInterfaceName.equals("MessagingStreamingSerializer") || pluginInterfaceName.equals("MessagingSerializer") || pluginInterfaceName.equals("StreamingSerializer")) {
			pluginInterfaceName = "Serializer";
		}
		if (pluginInterfaceName.equals("StreamingDeserializer")) {
			pluginInterfaceName = "Deserializer";
		}
		if (pluginInterfaceName.equals("ModelChecker") || pluginInterfaceName.equals("WebModule")) {
			// ModelChecker and WebModule are not coupled to UserSettings but to
			// ServerSettings
			return;
		}

		EClass userSettingsClass = StorePackage.eINSTANCE.getUserSettings();
		String listRefName = StringUtils.firstLowerCase(pluginInterfaceName) + "s";
		EReference listReference = (EReference) userSettingsClass.getEStructuralFeature(listRefName);
		if (listReference == null) {
			LOGGER.warn(listRefName + " not found");
		}
		EReference defaultReference = (EReference) userSettingsClass.getEStructuralFeature("default" + pluginInterfaceName);
		EClass pluginConfigurationClass = (EClass) listReference.getEType();

		List<PluginConfiguration> list = (List<PluginConfiguration>) userSettings.eGet(listReference);
		PluginConfiguration pluginConfiguration = find(list, pluginContext.getPlugin().getClass().getName());
		if (pluginConfiguration == null) {
			pluginConfiguration = (PluginConfiguration) session.create(pluginConfigurationClass);
			list.add(pluginConfiguration);
			genericPluginConversion(pluginContext, session, pluginConfiguration, pluginDescriptor);
		}

		if (defaultReference != null) {
			if (userSettings.eGet(defaultReference) == null && !list.isEmpty()) {
				userSettings.eSet(defaultReference, list.get(0));
			}
		}
		session.store(userSettings);
	}

	public void updateUserSettings(DatabaseSession session, User user) throws BimserverLockConflictException, BimserverDatabaseException {
		UserSettings userSettings = user.getUserSettings();
		if (userSettings == null) {
			userSettings = session.create(UserSettings.class);
			user.setUserSettings(userSettings);
			session.store(user);
		}
		
		for (Entry<PluginContext, Plugin> pluginEntry : pluginManager.getAllPlugins(true).entrySet()) {
			updateUserPlugin(session, user, getPluginDescriptor(session, pluginEntry.getValue().getClass().getName()), pluginEntry.getKey());
		}
		
		session.store(userSettings);
	}

	public RenderEnginePools getRenderEnginePools() {
		return renderEnginePools;
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

	private WebModulePluginConfiguration findWebModule(ServerSettings serverSettings, String name) {
		for (WebModulePlugin webModulePlugin : pluginManager.getAllWebPlugins(true).values()) {
			WebModulePluginConfiguration webPluginConfiguration = find(serverSettings.getWebModules(), webModulePlugin.getClass().getName());
			if (webModulePlugin.getDefaultName().equals(name)) {
				return webPluginConfiguration;
			}
		}
		return null;
	}

	private void initDatabaseDependantItems() throws BimserverDatabaseException {
		serverSettingsCache.init();
		notificationsManager.init();

		getSerializerFactory().init(pluginManager, bimDatabase, this);
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
			createDatabaseObjects(session);

			ServerSettings serverSettings = serverSettingsCache.getServerSettings();

			for (Entry<PluginContext, WebModulePlugin> webModulePlugin : pluginManager.getAllWebPlugins(true).entrySet()) {
				WebModulePluginConfiguration webPluginConfiguration = find(serverSettings.getWebModules(), webModulePlugin.getValue().getClass().getName());
				if (webPluginConfiguration == null) {
					webPluginConfiguration = session.create(WebModulePluginConfiguration.class);
					serverSettings.getWebModules().add(webPluginConfiguration);
					genericPluginConversion(webModulePlugin.getKey(), session, webPluginConfiguration, getPluginDescriptor(session, webModulePlugin.getValue().getClass().getName()));
				} else {
					if (webPluginConfiguration == serverSettings.getWebModule()) {
						setDefaultWebModule(webModulePlugin.getValue());
					}
				}
			}

			// Set the default
			if (serverSettings.getWebModule() == null) {
				WebModulePluginConfiguration bimviewsWebModule = findWebModule(serverSettings, "BIM Views");
				if (bimviewsWebModule != null) {
					serverSettings.setWebModule(bimviewsWebModule);
					setDefaultWebModule(pluginManager.getWebModulePlugin(bimviewsWebModule.getPluginDescriptor().getPluginClassName(), true));
				} else {
					WebModulePluginConfiguration defaultWebModule = findWebModule(serverSettings, "org.bimserver.defaultwebmodule.DefaultWebModulePlugin");
					if (defaultWebModule != null) {
						serverSettings.setWebModule(defaultWebModule);
						setDefaultWebModule(pluginManager.getWebModulePlugin(defaultWebModule.getPluginDescriptor().getPluginClassName(), true));
					}
				}
			}
			session.store(serverSettings);

			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Username(), new StringLiteral("system"));
			User systemUser = session.querySingle(condition, User.class, OldQuery.getDefault());

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
							contextPath = ((StringType) parameter.getValue()).getValue();
						}
					}
					webModules.put(contextPath, (WebModulePlugin) pluginManager.getPlugin(webModulePluginConfiguration.getPluginDescriptor().getPluginClassName(), true));
				}
				// if (serverSettingsCache.getServerSettings().getWebModule() !=
				// null) {
				// defaultWebModule = (WebModulePlugin)
				// pluginManager.getPlugin(serverSettingsCache.getServerSettings().getWebModule().getPluginDescriptor().getPluginClassName(),
				// true);
				// }
			} finally {
				ses.close();
			}

			Integer protocolBuffersPort = getServerSettingsCache().getServerSettings().getProtocolBuffersPort();
			if (protocolBuffersPort >= 1 && protocolBuffersPort <= 65535) {
				try {
					protocolBuffersServer = new ProtocolBuffersServer(protocolBuffersMetaData, serviceFactory, servicesMap, protocolBuffersPort);
					protocolBuffersServer.start();
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}

			bimServerClientFactory = new DirectBimServerClientFactory<ServiceInterface>(serverSettingsCache.getServerSettings().getSiteAddress(), serviceFactory, servicesMap, pluginManager, metaDataManager);
			pluginManager.setBimServerClientFactory(bimServerClientFactory);
		} catch (BimserverLockConflictException e) {
			throw new BimserverDatabaseException(e);
		} catch (PluginException e) {
			throw new BimserverDatabaseException(e);
		}
	}

	public WebModuleManager getWebModuleManager() {
		return webModuleManager;
	}

	public static Class<?> getPluginInterfaceClass(Plugin plugin) {
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
		Map<PluginContext, Plugin> allPlugins = pluginManager.getAllPlugins(false);
		for (PluginContext pluginContext : allPlugins.keySet()) {
			Plugin plugin = pluginContext.getPlugin();
			Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_PluginClassName(), new StringLiteral(plugin.getClass().getName()));
			Map<Long, PluginDescriptor> results = session.query(pluginCondition, PluginDescriptor.class, OldQuery.getDefault());
			if (results.size() == 0) {
				PluginDescriptor pluginDescriptor = session.create(PluginDescriptor.class);
				pluginDescriptor.setPluginClassName(plugin.getClass().getName());
				pluginDescriptor.setSimpleName(plugin.getClass().getSimpleName());
				pluginDescriptor.setDescription(pluginContext.getDescription() + " " + pluginContext.getVersion());
				pluginDescriptor.setLocation(pluginContext.getLocation().toString());
				pluginDescriptor.setPluginInterfaceClassName(getPluginInterfaceClass(plugin).getName());
				pluginDescriptor.setEnabled(true); // New plugins are enabled by
													// default
			} else if (results.size() == 1) {
				PluginDescriptor pluginDescriptor = results.values().iterator().next();
				pluginDescriptor.setPluginClassName(plugin.getClass().getName());
				pluginDescriptor.setSimpleName(plugin.getClass().getSimpleName());
				pluginDescriptor.setDescription(pluginContext.getDescription() + " " + pluginContext.getVersion());
				pluginDescriptor.setLocation(pluginContext.getLocation().toString());
				pluginDescriptor.setPluginInterfaceClassName(getPluginInterfaceClass(plugin).getName());
				session.store(pluginDescriptor);
				pluginManager.getPluginContext(plugin).setEnabled(pluginDescriptor.getEnabled(), false);
			} else {
				LOGGER.error("Multiple plugin descriptor objects found with the same name: " + plugin.getClass().getName());
			}
		}
	}

	public Path getHomeDir() {
		return config.getHomeDir();
	}

	public LongActionManager getLongActionManager() {
		return longActionManager;
	}

	public void setDefaultWebModule(WebModulePlugin defaultWebModule) {
		this.defaultWebModule = defaultWebModule;
	}

	/**
	 * Add a file appender to every logger we can find (the loggers should already have been configured via logback.xml)
	 * 
	 * @throws IOException
	 */
	private void fixLogging() throws IOException {
		Path logFolder = config.getHomeDir().resolve("logs");
		if (!Files.isDirectory(logFolder)) {
			Files.createDirectories(logFolder);
		}
		Path file = logFolder.resolve("bimserver.log");

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		PatternLayoutEncoder ple = new PatternLayoutEncoder();

		ple.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
		ple.setContext(lc);
		ple.start();
		FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
		String filename = file.toAbsolutePath().toString();
		
		System.out.println("Logging to " + filename);
		
		fileAppender.setFile(filename);
		fileAppender.setEncoder(ple);
		fileAppender.setContext(lc);
		fileAppender.start();

		for (ch.qos.logback.classic.Logger log : lc.getLoggerList()) {
			if (log.getLevel() != null) {
				log.addAppender(fileAppender);
			}
		}
	}
	
	private void initHomeDir() throws IOException {
		String[] filesToCheck = new String[] { "logs", "tmp", "log4j.xml", "templates" };
		if (!Files.exists(config.getHomeDir())) {
			Files.createDirectories(config.getHomeDir());
		}
		if (Files.exists(config.getHomeDir()) && Files.isDirectory(config.getHomeDir())) {
			for (String fileToCheck : filesToCheck) {
				Path sourceFile = config.getResourceFetcher().getFile(fileToCheck);
				if (sourceFile != null && Files.exists(sourceFile)) {
					Path destFile = config.getHomeDir().resolve(fileToCheck);
					if (!Files.exists(destFile)) {
						if (Files.isDirectory(sourceFile)) {
							Files.createDirectories(destFile);
							for (Path f : PathUtils.list(sourceFile)) {
								if (Files.isDirectory(f)) {
									Path destDir2 = destFile.resolve(f.getFileName().toString());
									for (Path x : PathUtils.list(f)) {
										FileUtils.copyFile(x.toFile(), destDir2.resolve(x.getFileName().toString()).toFile());
									}
								} else {
									FileUtils.copyFile(f.toFile(), destFile.resolve(f.getFileName().toString()).toFile());
								}
							}
						} else {
							FileUtils.copyFile(sourceFile.toFile(), destFile.toFile());
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
		LOGGER.info("BIMserver stopped");
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

	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
	}

	public SchemaConverterManager getSchemaConverterManager() {
		return schemaConverterManager;
	}

	public MetricsRegistry getMetricsRegistry() {
		return metricsRegistry;
	}
}