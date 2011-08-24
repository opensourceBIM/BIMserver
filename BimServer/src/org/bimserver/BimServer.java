package org.bimserver;

import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.bimserver.ServerInfo.ServerState;
import org.bimserver.cache.ClashDetectionCache;
import org.bimserver.cache.CompareCache;
import org.bimserver.cache.DiskCacheManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.BerkeleyColumnDatabase;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.deserializers.EmfDeserializerFactory;
import org.bimserver.logging.CustomFileAppender;
import org.bimserver.longaction.LongActionManager;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.GuidanceProvider;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.pb.server.ReflectiveRpcChannel;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginChangeListener;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.guidanceproviders.GuidanceProviderPlugin;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.UserException;
import org.bimserver.templating.TemplateEngine;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.version.VersionChecker;
import org.bimserver.webservices.Service;
import org.bimserver.webservices.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.protobuf.socketrpc.RpcServer;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;

/*
 * Main class to start a BIMserver
 */
public class BimServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(BimServer.class);

	private GregorianCalendar serverStartTime;
	private BimDatabase bimDatabase;
	private JobScheduler bimScheduler;
	private ResourceFetcher resourceFetcher;
	private LongActionManager longActionManager;
	private ServiceInterface systemService;
	private File homeDir;
	private SettingsManager settingsManager;
	private EmfSerializerFactory emfSerializerFactory;
	private EmfDeserializerFactory emfDeserializerFactory;
	private MergerFactory mergerFactory;
	private PluginManager pluginManager;
	private MailSystem mailSystem;
	private DiskCacheManager diskCacheManager;
	private ServerInfo serverInfo = new ServerInfo();
	private ServiceFactory serviceFactory;
	private VersionChecker versionChecker;
	private TemplateEngine templateEngine;
	private ClashDetectionCache clashDetectionCache;
	private CompareCache compareCache;
	private final String classPath;

	private RpcServer protocolBuffersRpcServer;

	public BimServer(File homeDir, ResourceFetcher resourceFetcher) {
		this(homeDir, resourceFetcher, System.getProperty("java.class.path"));
	}

	/**
	 * Create a new BIMserver
	 * 
	 * @param homeDir
	 *            A directory where the user can store instance specific
	 *            configuration files
	 * @param resourceFetcher
	 *            A resource fetcher
	 */
	public BimServer(File homeDir, ResourceFetcher resourceFetcher, String classPath) {
		this.classPath = classPath;
		try {
			this.homeDir = homeDir;
			this.resourceFetcher = resourceFetcher;
			if (homeDir != null) {
				initHomeDir();
			}

			fixLogging();

			LOGGER.info("Starting BIMserver");
			if (homeDir != null) {
				LOGGER.info("Using \"" + homeDir.getAbsolutePath() + "\" as homedir");
			} else {
				LOGGER.info("Not using a homedir");
			}

			UncaughtExceptionHandler uncaughtExceptionHandler = new UncaughtExceptionHandler() {
				@Override
				public void uncaughtException(Thread t, Throwable e) {
					if (e instanceof OutOfMemoryError) {
						serverInfo.setOutOfMemory();
						LOGGER.error("", e);
					} else if (e instanceof Error) {
						serverInfo.setErrorMessage(e.getMessage());
						LOGGER.error("", e);
					}
				}
			};

			Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);

			versionChecker = new VersionChecker(resourceFetcher);

			try {
				pluginManager = new PluginManager(resourceFetcher, homeDir, classPath);
				pluginManager.addPluginChangeListener(new PluginChangeListener() {
					@Override
					public void pluginStateChanged(PluginContext pluginContext, boolean enabled) {
						// Reflect this change also in the database
						Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPlugin_Name(), new StringLiteral(pluginContext.getPlugin().getClass().getName()));
						BimDatabaseSession session = bimDatabase.createSession(true);
						try {
							Map<Long, org.bimserver.models.store.Plugin> pluginsFound = session.query(pluginCondition, org.bimserver.models.store.Plugin.class, false);
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
						} catch (BimDatabaseException e) {
							e.printStackTrace();
						} catch (BimDeadlockException e) {
							e.printStackTrace();
						} finally {
							session.close();
						}
					}
				});
				pluginManager.loadPlugin(GuidanceProviderPlugin.class, "Internal", "Internal", new SchemaFieldGuidanceProviderPlugin());
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("", e);
			}

			clashDetectionCache = new ClashDetectionCache();
			compareCache = new CompareCache();
		} catch (Throwable e) {
			serverInfo.setErrorMessage(e.getMessage());
			LOGGER.error("", e);
		}
	}

	public void start() throws DatabaseInitException, BimDatabaseException, PluginException, DatabaseRestartRequiredException, ServerException {
		pluginManager.initAllLoadedPlugins();
		serverStartTime = new GregorianCalendar();

		longActionManager = new LongActionManager();

		Set<Ifc2x3Package> packages = CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE);
		templateEngine = new TemplateEngine();
		templateEngine.init(resourceFetcher.getResource("templates/"));
		File databaseDir = new File(homeDir, "database");
		BerkeleyColumnDatabase columnDatabase = new BerkeleyColumnDatabase(databaseDir);
		bimDatabase = new Database(this, packages, columnDatabase);
		try {
			bimDatabase.init();
		} catch (DatabaseRestartRequiredException e) {
			bimDatabase.close();
			columnDatabase = new BerkeleyColumnDatabase(databaseDir);
			bimDatabase = new Database(this, packages, columnDatabase);
			try {
				bimDatabase.init();
			} catch (InconsistentModelsException e1) {
				LOGGER.error("", e);
				serverInfo.setServerState(ServerState.FATAL_ERROR);
				serverInfo.setErrorMessage("Inconsistent models");
			}
		} catch (InconsistentModelsException e) {
			LOGGER.error("", e);
			serverInfo.setServerState(ServerState.FATAL_ERROR);
			serverInfo.setErrorMessage("Inconsistent models");
		}

		try {
			createDatabaseObjects();
		} catch (BimDeadlockException e) {
			throw new BimDatabaseException(e);
		}

		settingsManager = new SettingsManager(bimDatabase);
		serverInfo.init(this);
		serverInfo.update();

		emfSerializerFactory = new EmfSerializerFactory();
		emfDeserializerFactory = new EmfDeserializerFactory();

		if (serverInfo.getServerState() == ServerState.MIGRATION_REQUIRED) {
			serverInfo.registerStateChangeListener(new StateChangeListener() {
				@Override
				public void stateChanged(ServerState oldState, ServerState newState) {
					if (oldState == ServerState.MIGRATION_REQUIRED && newState == ServerState.RUNNING) {
						initDatabaseDependantItems();
					}
				}
			});
		} else {
			initDatabaseDependantItems();
		}

		mailSystem = new MailSystem(settingsManager);

		diskCacheManager = new DiskCacheManager(new File(homeDir, "cache"), settingsManager);

		mergerFactory = new MergerFactory(settingsManager);
		serviceFactory = new ServiceFactory(this);
		setSystemService(serviceFactory.newService(AccessMethod.INTERNAL));
		try {
			if (!((Service) getSystemService()).loginAsSystem()) {
				throw new RuntimeException("System user not found");
			}
		} catch (UserException e) {
			e.printStackTrace();
		}

		// RestApplication.setServiceFactory(serviceFactory);

		bimScheduler = new JobScheduler(this);
		bimScheduler.start();

		protocolBuffersRpcServer = new RpcServer(SocketRpcConnectionFactories.createServerRpcConnectionFactory(8020), Executors.newFixedThreadPool(10), false);
		protocolBuffersRpcServer.registerBlockingService(org.bimserver.pb.Service.ServiceInterface.newReflectiveBlockingService(org.bimserver.pb.Service.ServiceInterface
				.newBlockingStub(new ReflectiveRpcChannel(serviceFactory))));
		protocolBuffersRpcServer.startServer();

		// if (serverType == ServerType.DEPLOYED_WAR) {
		// File libDir = new File(classPath);
		// LOGGER.info("adding lib dir: " + libDir.getAbsolutePath());
		// QueryCompiler.addJarFolder(libDir);
		// }

		ServerStarted serverStarted = LogFactory.eINSTANCE.createServerStarted();
		serverStarted.setDate(new Date());
		serverStarted.setAccessMethod(AccessMethod.INTERNAL);
		serverStarted.setExecutor(null);
		BimDatabaseSession session = bimDatabase.createSession(true);
		try {
			session.store(serverStarted);
			session.commit();
		} catch (BimDeadlockException e) {
			throw new BimDatabaseException(e);
		} finally {
			session.close();
		}
		CommandLine commandLine = new CommandLine(this);
		commandLine.start();
		LOGGER.info("Done starting BIMserver");
	}

	/*
	 * Serializers, deserializers, ifcengines etc... all have counterparts as
	 * objects in the database for configuration purposes, this methods syncs
	 * both versions
	 */
	private void createDatabaseObjects() throws BimDeadlockException, BimDatabaseException, PluginException {
		BimDatabaseSession session = bimDatabase.createSession(true);
		GuidanceProvider defaultGuidanceProvider = null;
		for (GuidanceProviderPlugin guidanceProviderPlugin : pluginManager.getAllGuidanceProviders(true)) {
			String name = guidanceProviderPlugin.getDefaultGuidanceProviderName();
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getGuidanceProvider_Name(), new StringLiteral(name));
			GuidanceProvider found = session.querySingle(condition, GuidanceProvider.class, false);
			if (found == null) {
				GuidanceProvider guidanceProvider = StoreFactory.eINSTANCE.createGuidanceProvider();
				guidanceProvider.setName(name);
				guidanceProvider.setClassName(guidanceProvider.getClass().getName());
				defaultGuidanceProvider = guidanceProvider;
				session.store(guidanceProvider);
			} else {
				defaultGuidanceProvider = found;
			}
		}
		for (SerializerPlugin serializerPlugin : pluginManager.getAllSerializerPlugins(true)) {
			String name = serializerPlugin.getDefaultSerializerName();
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getSerializer_Name(), new StringLiteral(name));
			Serializer found = session.querySingle(condition, Serializer.class, false);
			if (found == null) {
				Serializer serializer = StoreFactory.eINSTANCE.createSerializer();
				serializer.setClassName(serializerPlugin.getClass().getName());
				serializer.setName(name);
				serializer.setEnabled(true);
				serializer.setDescription(serializerPlugin.getDescription());
				serializer.setContentType(serializerPlugin.getDefaultContentType());
				serializer.setExtension(serializerPlugin.getDefaultExtension());
				serializer.setGuidanceProvider(defaultGuidanceProvider);
				session.store(serializer);
			}
		}
		for (DeserializerPlugin deserializerPlugin : pluginManager.getAllDeserializerPlugins(true)) {
			String name = deserializerPlugin.getDefaultDeserializerName();
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getDeserializer_Name(), new StringLiteral(name));
			Deserializer found = session.querySingle(condition, Deserializer.class, false);
			if (found == null) {
				Deserializer deserializer = StoreFactory.eINSTANCE.createDeserializer();
				deserializer.setClassName(deserializerPlugin.getClass().getName());
				deserializer.setName(name);
				deserializer.setEnabled(true);
				deserializer.setDescription(deserializerPlugin.getDescription());
				session.store(deserializer);
			}
		}
		session.store(defaultGuidanceProvider);
		for (IfcEnginePlugin ifcEnginePlugin : pluginManager.getAllIfcEnginePlugins(true)) {
			String name = ifcEnginePlugin.getClass().getName();
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getIfcEngine_Name(), new StringLiteral(name));
			Serializer found = session.querySingle(condition, Serializer.class, false);
			if (found == null) {
				IfcEngine ifcEngine = StoreFactory.eINSTANCE.createIfcEngine();
				ifcEngine.setName(name);
				ifcEngine.setActive(false);
				session.store(ifcEngine);
			}
		}
		Collection<Plugin> allPlugins = pluginManager.getAllPlugins(false);
		for (Plugin plugin : allPlugins) {
			Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPlugin_Name(), new StringLiteral(plugin.getClass().getName()));
			Map<Long, org.bimserver.models.store.Plugin> results = session.query(pluginCondition, org.bimserver.models.store.Plugin.class, false);
			if (results.size() == 0) {
				org.bimserver.models.store.Plugin pluginObject = StoreFactory.eINSTANCE.createPlugin();
				pluginObject.setName(plugin.getClass().getName());
				pluginObject.setEnabled(true); // New plugins are enabled by
												// default
				session.store(pluginObject);
			} else if (results.size() == 1) {
				org.bimserver.models.store.Plugin pluginObject = results.values().iterator().next();
				pluginManager.getPluginContext(plugin).setEnabled(pluginObject.isEnabled());
			} else {
				LOGGER.error("Multiple plugin objects found with the same name: " + plugin.getClass().getName());
			}
		}
		session.commit();
	}

	private void initDatabaseDependantItems() {
		getEmfSerializerFactory().init(pluginManager, bimDatabase);
		getEmfDeserializerFactory().init(pluginManager, bimDatabase);
	}

	public File getHomeDir() {
		return homeDir;
	}

	public SettingsManager getSettingsManager() {
		return settingsManager;
	}

	public LongActionManager getLongActionManager() {
		return longActionManager;
	}

	private void fixLogging() throws IOException {
		File file = new File(homeDir, "logs/bimserver.log");
		CustomFileAppender appender = new CustomFileAppender(file);
		System.out.println("Logging to: " + file.getAbsolutePath());
		Enumeration<?> currentLoggers = LogManager.getCurrentLoggers();
		while (currentLoggers.hasMoreElements()) {
			Object nextElement = currentLoggers.nextElement();
			((org.apache.log4j.Logger) nextElement).addAppender(appender);
		}
	}

	private void initHomeDir() throws IOException {
		String[] filesToCheck = new String[] { "logs", "tmp", "collada.xml", "ignore.xml", "ignoreexceptions", "log4j.xml", "templates" };
		if (!homeDir.exists()) {
			homeDir.mkdir();
		}
		if (homeDir.exists() && homeDir.isDirectory()) {
			for (String fileToCheck : filesToCheck) {
				File sourceFile = resourceFetcher.getFile(fileToCheck);
				if (sourceFile != null && sourceFile.exists()) {
					File destFile = new File(homeDir, fileToCheck);
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
		return resourceFetcher;
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
		return classPath;
	}

	public ServerInfo getServerInfo() {
		return serverInfo;
	}

	public ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public VersionChecker getVersionChecker() {
		return versionChecker;
	}

	public TemplateEngine getTemplateEngine() {
		return templateEngine;
	}

	public ClashDetectionCache getClashDetectionCache() {
		return clashDetectionCache;
	}

	public CompareCache getCompareCache() {
		return compareCache;
	}
}