package org.bimserver;

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

import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
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
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.database.berkeley.BerkeleyKeyValueStore;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.endpoints.EndPointManager;
import org.bimserver.geometry.accellerator.GeometryAccellerator;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.longaction.LongActionManager;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.store.BooleanType;
import org.bimserver.models.store.ByteArrayType;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DoubleType;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.LongType;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PluginBundleType;
import org.bimserver.models.store.PluginBundleVersion;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.Project;
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
import org.bimserver.pb.server.ProtocolBuffersServer;
import org.bimserver.plugins.BasicServerInfo;
import org.bimserver.plugins.BasicServerInfoProvider;
import org.bimserver.plugins.MavenPluginRepository;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginBundle;
import org.bimserver.plugins.PluginBundleManager;
import org.bimserver.plugins.PluginBundleVersionIdentifier;
import org.bimserver.plugins.PluginChangeListener;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.plugins.web.WebModulePlugin;
import org.bimserver.pluginsettings.PluginSettingsCache;
import org.bimserver.renderengine.RenderEnginePoolFactory;
import org.bimserver.renderengine.RenderEnginePools;
import org.bimserver.renderengine.pooled.CommonsPoolingRenderEnginePoolFactory;
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
import org.bimserver.shared.reflector.RealtimeReflectorFactoryBuilder;
import org.bimserver.shared.reflector.ReflectorFactory;
import org.bimserver.templating.TemplateEngine;
import org.bimserver.utils.Formatters;
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

/*
 * Main class to start a BIMserver
 */
public class BimServer implements BasicServerInfoProvider {
	private static final String ENCRYPTIONKEY = "encryptionkey";

	private Logger LOGGER;

	private GregorianCalendar serverStartTime;
	private BimDatabase bimDatabase;
	private JobScheduler bimScheduler;
	private LongActionManager longActionManager;
	private SerializerFactory serializerFactory;
	private MergerFactory mergerFactory;
	private PluginManager pluginManager;
	private PluginBundleManager pluginBundleManager;
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
	private EmbeddedWebServerInterface embeddedWebServer;
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
	private Map<String, WebModulePlugin> webModules = new HashMap<String, WebModulePlugin>();
	private WebModulePlugin defaultWebModule;
	private ExecutorService executorService = Executors.newCachedThreadPool();
	private InternalServicesManager internalServicesManager;
	private MetaDataManager metaDataManager;
	private SchemaConverterManager schemaConverterManager = new SchemaConverterManager();
	private WebModuleManager webModuleManager;
	private MetricsRegistry metricsRegistry;
	private RenderEnginePools renderEnginePools;
	private MavenPluginRepository mavenPluginRepository;
	private AuthCache authCache;
	private GeometryAccellerator geometryAccellerator;
	private PluginSettingsCache pluginSettingsCache;

	/**
	 * Create a new BIMserver
	 * 
	 * @param config
	 *            Configuration of BIMserver
	 */
	public BimServer(BimServerConfig config) {
		System.setProperty("org.eclipse.emf.common.util.ReferenceClearingQueue", "false");
		this.config = config;
		try {
			if (config.getHomeDir() != null) {
				initHomeDir(config);
			}

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

			LOGGER.info("Starting BIMserver (" + System.getProperty("os.name") + ", " + System.getProperty("java.version") + ", " + System.getProperty("sun.arch.data.model") + "bit, Xmx: " + Formatters.bytesToString(Runtime.getRuntime().maxMemory()) + ")");

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

			Path tmp = config.getHomeDir().resolve("tmp");
			if (!Files.exists(tmp)) {
				Files.createDirectories(tmp);
			}
			Path homeDirIncoming = config.getHomeDir().resolve("incoming");
			if (!Files.exists(homeDirIncoming)) {
				Files.createDirectory(homeDirIncoming);
			}

			mavenPluginRepository = new MavenPluginRepository();
			pluginManager = new PluginManager(tmp, config.getClassPath(), serviceFactory, internalServicesManager, servicesMap, this);
			pluginBundleManager = new PluginBundleManager(pluginManager, mavenPluginRepository, config.getHomeDir().resolve("plugins"));
			metaDataManager = new MetaDataManager(tmp);
			pluginManager.setMetaDataManager(metaDataManager);
			LOGGER.debug("PluginManager created");

			try {
				LOGGER.debug("Version Checker created");
				versionChecker = new VersionChecker(config.getResourceFetcher());
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
			
			compareCache = new CompareCache();
			LOGGER.debug("Compare cache created");
			if (config.isStartEmbeddedWebServer()) {
//				embeddedWebServer = new EmbeddedWebServer(this, config.getDevelopmentBaseDir(), config.isLocalDev());
				LOGGER.debug("Embedded webserver created");
			}

			LOGGER.debug("Done with initial setup");
		} catch (Throwable e) {
			if (LOGGER == null) {
				e.printStackTrace();
			} else {
				LOGGER.error("", e);
			}
			if (serverInfoManager != null) {
				if (e.getMessage() != null) {
					serverInfoManager.setErrorMessage(e.getMessage());
				} else {
					serverInfoManager.setErrorMessage(e.toString());
				}
			}
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
			if (versionChecker != null) {
				SVersion localVersion = versionChecker.getLocalVersion();
				if (localVersion != null) {
					LOGGER.info("Version: " + localVersion.getFullString());
				} else {
					LOGGER.info("Unknown version");
				}
			} else {
				LOGGER.info("Unknown version");
			}
			
			if (config.getHomeDir() != null) {
				LOGGER.info("Using \"" + config.getHomeDir().toString() + "\" as homedir");
			} else {
				LOGGER.info("Not using a homedir");
			}

			try {
				pluginManager.setPluginChangeListener(new PluginChangeListener() {
					@Override
					public void pluginStateChanged(PluginContext pluginContext, boolean enabled) {
						// Reflect this change also in the database
						Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_PluginClassName(), new StringLiteral(pluginContext.getPlugin().getClass().getName()));
						DatabaseSession session = bimDatabase.createSession(OperationType.POSSIBLY_WRITE);
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
					public long pluginBundleUpdated(PluginBundle pluginBundle) {
						SPluginBundleVersion sPluginBundleVersion = pluginBundle.getPluginBundleVersion();
						try (DatabaseSession session = bimDatabase.createSession(OperationType.POSSIBLY_WRITE)) {
							PluginBundleVersion current = null;
							IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getPluginBundleVersion(), OldQuery.getDefault());
							for (PluginBundleVersion pbv : allOfType.getAll(PluginBundleVersion.class)) {
								if (pbv.getGroupId().equals(pluginBundle.getPluginBundleVersion().getGroupId()) && pbv.getArtifactId().equals(pluginBundle.getPluginBundleVersion().getArtifactId())) {
									// Current pluginBundle found
									current = pbv;
								}
							}
							
							if (current != null) {
								current.setDescription(sPluginBundleVersion.getArtifactId());
								current.setIcon(sPluginBundleVersion.getIcon());
								current.setMismatch(sPluginBundleVersion.isMismatch());
								current.setRepository(sPluginBundleVersion.getRepository());
								current.setType(getSConverter().convertFromSObject(sPluginBundleVersion.getType()));
								current.setVersion(sPluginBundleVersion.getVersion());
								current.setOrganization(sPluginBundleVersion.getOrganization());
								current.setName(sPluginBundleVersion.getName());
								current.setDate(sPluginBundleVersion.getDate());
								
								session.store(current);
								
								session.commit();
							}
							return current.getOid();
						} catch (BimserverDatabaseException e) {
							LOGGER.error("", e);
						} catch (ServiceException e) {
							LOGGER.error("", e);
						}
						return -1;
					}
					
					@Override
					public void pluginUpdated(long pluginBundleVersionId, PluginContext newPluginContext, SPluginInformation sPluginInformation) throws BimserverDatabaseException {
						try (DatabaseSession session = bimDatabase.createSession(OperationType.POSSIBLY_WRITE)) {
							Plugin plugin = newPluginContext.getPlugin();
							
							Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_Identifier(), new StringLiteral(newPluginContext.getIdentifier()));
							Map<Long, PluginDescriptor> pluginsFound = session.query(pluginCondition, PluginDescriptor.class, OldQuery.getDefault());
							for (PluginDescriptor pluginDescriptor : pluginsFound.values()) {
								pluginDescriptor.setIdentifier(newPluginContext.getIdentifier());
								pluginDescriptor.setPluginClassName(plugin.getClass().getName());
								pluginDescriptor.setDescription(newPluginContext.getDescription());
								pluginDescriptor.setName(sPluginInformation.getName());
								pluginDescriptor.setLocation(newPluginContext.getLocation().toString());
								pluginDescriptor.setPluginInterfaceClassName(getPluginInterface(plugin.getClass()).getName());
								pluginDescriptor.setEnabled(sPluginInformation.isEnabled());
								pluginDescriptor.setInstallForNewUsers(sPluginInformation.isInstallForNewUsers());
								PluginBundleVersion value = session.get(pluginBundleVersionId, OldQuery.getDefault());
								pluginDescriptor.setPluginBundleVersion(value);
								session.store(pluginDescriptor);

								if (sPluginInformation.isInstallForAllUsers()) {
									IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), OldQuery.getDefault());
									for (User user : allOfType.getAll(User.class)) {
										if (user.getState() == ObjectState.ACTIVE) {
											updateUserPlugin(session, user, pluginDescriptor, newPluginContext);
										}
									}
								}
								
								if (newPluginContext.getPlugin() instanceof WebModulePlugin) {
									ServerSettings serverSettings = getServerSettingsCache().getServerSettings();
									WebModulePluginConfiguration webPluginConfiguration = find(serverSettings.getWebModules(), newPluginContext.getIdentifier());
									if (webPluginConfiguration == null) {
										webPluginConfiguration = session.create(WebModulePluginConfiguration.class);
										serverSettings.getWebModules().add(webPluginConfiguration);
									}
									genericPluginConversion(newPluginContext, session, webPluginConfiguration, pluginDescriptor);
									String contextPath = "";
									
									for (Parameter parameter : webPluginConfiguration.getSettings().getParameters()) {
										if (parameter.getName().equals("contextPath")) {
											contextPath = ((StringType) parameter.getValue()).getValue();
										}
									}
									String identifier = webPluginConfiguration.getPluginDescriptor().getIdentifier();
									webModules.put(contextPath, (WebModulePlugin) pluginManager.getPlugin(identifier, true));
								} else if (newPluginContext.getPlugin() instanceof ServicePlugin) {
									IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), OldQuery.getDefault());
									List<InternalServicePluginConfiguration> all = new ArrayList<>(allOfType.getAll(InternalServicePluginConfiguration.class));
									for (InternalServicePluginConfiguration internalServicePluginConfiguration : all) {
										if (internalServicePluginConfiguration.getPluginDescriptor().getIdentifier().equals(newPluginContext.getIdentifier())) {
											activateService(internalServicePluginConfiguration.getUserSettings().getOid(), internalServicePluginConfiguration);
										}
									}
								}
							}

							try {
								session.commit();
							} catch (ServiceException e) {
								LOGGER.error("", e);
							}
						}
					}
					
					@Override
					public void pluginInstalled(long pluginBundleVersionId, PluginContext pluginContext, SPluginInformation sPluginInformation) throws BimserverDatabaseException {
						try (DatabaseSession session = bimDatabase.createSession(OperationType.POSSIBLY_WRITE)) {
							ServerSettings serverSettings = getServerSettingsCache().getServerSettings();

							Plugin plugin = pluginContext.getPlugin();
							
							Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_Identifier(), new StringLiteral(pluginContext.getIdentifier()));
							Map<Long, PluginDescriptor> pluginsFound = session.query(pluginCondition, PluginDescriptor.class, OldQuery.getDefault());
							PluginDescriptor pluginDescriptor = null;
							ObjectType settings = null;
							if (pluginsFound.size() > 0) {
								pluginDescriptor = pluginsFound.values().iterator().next(); 
								settings = pluginDescriptor.getSettings();
							} else {
								pluginDescriptor = session.create(PluginDescriptor.class);
								settings = convertSettings(session, pluginContext.getPlugin().getSystemSettingsDefinition());
								pluginDescriptor.setSettings(settings);
							}
							
							pluginDescriptor.setIdentifier(pluginContext.getIdentifier());
							pluginDescriptor.setPluginClassName(plugin.getClass().getName());
							pluginDescriptor.setDescription(pluginContext.getDescription());
							pluginDescriptor.setName(sPluginInformation.getName());
							pluginDescriptor.setLocation(pluginContext.getLocation().toString());
							pluginDescriptor.setPluginInterfaceClassName(getPluginInterface(plugin.getClass()).getName());
							pluginDescriptor.setEnabled(sPluginInformation.isEnabled());
							pluginDescriptor.setInstallForNewUsers(sPluginInformation.isInstallForNewUsers());
							pluginDescriptor.setPluginBundleVersion(session.get(pluginBundleVersionId, OldQuery.getDefault()));

							try {
								pluginContext.initialize(new org.bimserver.plugins.PluginConfiguration(settings));
							} catch (PluginException e) {
								LOGGER.error("", e);
							}
							
							if (pluginDescriptor.getPluginClassName().contentEquals("org.ifcopenshell.IfcOpenShellEnginePlugin")) {
								if (serverSettings.getDefaultRenderEnginePlugin() == null) {
									serverSettings.setDefaultRenderEnginePlugin(pluginDescriptor);
									session.store(serverSettings);
								}
							}
							
							if (sPluginInformation.isInstallForAllUsers()) {
								IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), OldQuery.getDefault());
								for (User user : allOfType.getAll(User.class)) {
									if (user.getState() == ObjectState.ACTIVE) {
										updateUserPlugin(session, user, pluginDescriptor, pluginContext);
									}
								}
							}
							
							if (pluginContext.getPlugin() instanceof WebModulePlugin) {
								WebModulePluginConfiguration webPluginConfiguration = find(serverSettings.getWebModules(), pluginContext.getIdentifier());
								if (webPluginConfiguration == null) {
									webPluginConfiguration = session.create(WebModulePluginConfiguration.class);
									serverSettings.getWebModules().add(webPluginConfiguration);
									genericPluginConversion(pluginContext, session, webPluginConfiguration, pluginDescriptor);
									session.store(serverSettings);
								}
								String contextPath = "";
								
								for (Parameter parameter : webPluginConfiguration.getSettings().getParameters()) {
									if (parameter.getName().equals("contextPath")) {
										contextPath = ((StringType) parameter.getValue()).getValue();
									}
								}
								webModules.put(contextPath, (WebModulePlugin) pluginManager.getPlugin(pluginContext.getIdentifier(), true));
							}
							
							try {
								session.commit();
							} catch (ServiceException e) {
								LOGGER.error("", e);
							}
						}
					}

					@Override
					public void pluginUninstalled(PluginContext pluginContext) {
						// Reflect this change also in the database
						Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_Identifier(), new StringLiteral(pluginContext.getIdentifier()));
						DatabaseSession session = bimDatabase.createSession(OperationType.POSSIBLY_WRITE);
						try {
							Map<Long, PluginDescriptor> pluginsFound = session.query(pluginCondition, PluginDescriptor.class, OldQuery.getDefault());
							if (pluginsFound.size() == 0) {
								LOGGER.error("Error removing plugin-state in database, plugin " + pluginContext.getPlugin().getClass().getName() + " not found");
							} else if (pluginsFound.size() == 1) {
								PluginDescriptor pluginDescriptor = pluginsFound.values().iterator().next();
								for (PluginConfiguration pluginConfiguration : pluginDescriptor.getConfigurations()) {
									session.delete(pluginConfiguration, -1);
								}
								if (pluginContext.getPlugin() instanceof WebModulePlugin) {
									ServerSettings serverSettings = getServerSettingsCache().getServerSettings();
									WebModulePluginConfiguration webPluginConfiguration = find(serverSettings.getWebModules(), pluginContext.getIdentifier());
									serverSettings.getWebModules().remove(webPluginConfiguration);
									session.store(serverSettings);
									
									String contextPath = "";
									
									for (Parameter parameter : webPluginConfiguration.getSettings().getParameters()) {
										if (parameter.getName().equals("contextPath")) {
											contextPath = ((StringType) parameter.getValue()).getValue();
										}
									}
									webModules.remove(contextPath);
								}
								session.delete(pluginDescriptor, -1);
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
					public long pluginBundleInstalled(PluginBundle pluginBundle) {
						try (DatabaseSession session = bimDatabase.createSession(OperationType.POSSIBLY_WRITE)) {
							PluginBundleVersion current = null;
							IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getPluginBundleVersion(), OldQuery.getDefault());
							for (PluginBundleVersion pbv : allOfType.getAll(PluginBundleVersion.class)) {
								if (pbv.getGroupId().equals(pluginBundle.getPluginBundleVersion().getGroupId()) && pbv.getArtifactId().equals(pluginBundle.getPluginBundleVersion().getArtifactId())) {
									// Current pluginBundle found
									current = pbv;
								}
							}

							PluginBundleVersion pluginBundleVersion = null;
							if (current != null) {
								pluginBundleVersion = current;
								session.store(pluginBundleVersion);
							} else {
								pluginBundleVersion = session.create(PluginBundleVersion.class);
							}
							SPluginBundleVersion sPluginBundleVersion = pluginBundle.getPluginBundleVersion();
							
							// SConverter should be used here, but it does not seem to trigger the database session in the rights way, just copying over field for now
							
							pluginBundleVersion.setArtifactId(sPluginBundleVersion.getArtifactId());
							pluginBundleVersion.setDescription(sPluginBundleVersion.getArtifactId());
							pluginBundleVersion.setGroupId(sPluginBundleVersion.getGroupId());
							pluginBundleVersion.setIcon(sPluginBundleVersion.getIcon());
							pluginBundleVersion.setMismatch(sPluginBundleVersion.isMismatch());
							pluginBundleVersion.setRepository(sPluginBundleVersion.getRepository());
							pluginBundleVersion.setType(getSConverter().convertFromSObject(sPluginBundleVersion.getType()));
							pluginBundleVersion.setVersion(sPluginBundleVersion.getVersion());
							pluginBundleVersion.setOrganization(sPluginBundleVersion.getOrganization());
							pluginBundleVersion.setName(sPluginBundleVersion.getName());
							pluginBundleVersion.setDate(sPluginBundleVersion.getDate());
							
							session.commit();
							return pluginBundleVersion.getOid();
						} catch (BimserverDatabaseException e) {
							LOGGER.error("", e);
						} catch (ServiceException e) {
							LOGGER.error("", e);
						}
						return -1;
					}

					@Override
					public void pluginBundleUninstalled(PluginBundle pluginBundle) {
					}
				});
			} catch (Exception e) {
				LOGGER.error("", e);
			}

			try {
				metaDataManager.init(true);
				pluginManager.initAllLoadedPlugins();
			} catch (PluginException e) {
				LOGGER.error("", e);
			}
			serverStartTime = new GregorianCalendar();

			longActionManager = new LongActionManager(this);

			Set<EPackage> packages = new LinkedHashSet<>();
			packages.add(Ifc2x3tc1Package.eINSTANCE);
			packages.add(Ifc4Package.eINSTANCE);
			templateEngine = new TemplateEngine();
			ResourceFetcher resourceFetcher = config.getResourceFetcher();
			if (resourceFetcher.isDirectory("emailtemplates")) {
				templateEngine.init(resourceFetcher.getURL("emailtemplates"));
			} else {
				LOGGER.info("No email templates found");
			}
			Path databaseDir = config.getHomeDir().resolve("database");
			BerkeleyKeyValueStore keyValueStore = new BerkeleyKeyValueStore(databaseDir, config.getBdbEnvironmentProperties());

			geometryAccellerator = new GeometryAccellerator(this);
			
			schemaConverterManager.registerConverter(new Ifc2x3tc1ToIfc4SchemaConverterFactory());
			schemaConverterManager.registerConverter(new Ifc4ToIfc2x3tc1SchemaConverterFactory());

			authCache = new AuthCache(this);
			
			
			pluginSettingsCache = new PluginSettingsCache(this);
			metricsRegistry = new MetricsRegistry();

			Path mavenPath = config.getHomeDir().resolve("maven");
			if (!Files.exists(mavenPath)) {
				Files.createDirectories(mavenPath);
			}

			OldQuery.setPackageMetaDataForDefaultQuery(metaDataManager.getPackageMetaData("store"));

			bimDatabase = new Database(this, packages, keyValueStore, metaDataManager);
			try {
				bimDatabase.init();
			} catch (DatabaseRestartRequiredException e) {
				bimDatabase.close();
				keyValueStore = new BerkeleyKeyValueStore(databaseDir, config.getBdbEnvironmentProperties());
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

			try (DatabaseSession encsession = bimDatabase.createSession(OperationType.POSSIBLY_WRITE)) {
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
			}
			
			cleanupStaleData();

			serverInfoManager.init(this);

			webModuleManager = new WebModuleManager(this);

			jsonHandler = new JsonHandler(this);

			serializerFactory = new SerializerFactory();

			serverSettingsCache = new ServerSettingsCache(bimDatabase);

			for (String schema : new String[]{"ifc2x3tc1", "ifc4"}) {
				for (String type : new String[] {"geometry", "stdlib"}) {
					try {
						PackageMetaData packageMetaData = getMetaDataManager().getPackageMetaData(schema);
						JsonQueryObjectModelConverter jsonQueryObjectModelConverter = new JsonQueryObjectModelConverter(packageMetaData);
						String queryNameSpace = schema + "-" + type;
						if (type.contentEquals("stdlib")) {
							Include objectPlacement = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ObjectPlacement", true);
							
							// The sole reason is to make sure this is done once, and then cached
							objectPlacement.makeDirectRecursive(new HashSet<>());
						}
					} catch (QueryException e) {
						LOGGER.error(schema + " " + type, e);
					}
				}
			}
			
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

			diskCacheManager = new DiskCacheManager(this, config.getHomeDir().resolve("cache"));
			newDiskCacheManager = new NewDiskCacheManager(this, config.getHomeDir().resolve("cache"));

			mergerFactory = new MergerFactory(this);

			RealtimeReflectorFactoryBuilder factoryBuilder = new RealtimeReflectorFactoryBuilder(servicesMap);
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
			
			if (getServerInfoManager().getServerState() == ServerState.SETUP) {
				getServerInfoManager().setServerState(ServerState.RUNNING);
			}
		} catch (Throwable e) {
			LOGGER.error("", e);
			serverInfoManager.setErrorMessage(e.getMessage());
		}
	}

	private void cleanupStaleData() throws BimserverDatabaseException {
		LOGGER.info("Checking for stale records, this can take some time...");
		long s = System.nanoTime();
		try (DatabaseSession session = bimDatabase.createSession(OperationType.POSSIBLY_WRITE)) {
			for (Project project : session.getAll(Project.class)) {
				if (project.getCheckinInProgress() == 0) {
					continue;
				}
				if (project.getName().equals("INT-Store")) {
					continue;
				}
				int recordsRemoved = 0;
				if (project.getRevisions().size() == 0) {
					recordsRemoved += checkPidRid(session, project, project.getId(), 0);
				} else {
					ConcreteRevision lastConcreteRevision = project.getLastConcreteRevision();
					if (lastConcreteRevision != null) {
						recordsRemoved += checkPidRid(session, project, project.getId(), lastConcreteRevision.getId());
					}
				}
				if (recordsRemoved > 0) {
					LOGGER.info("Removed " + recordsRemoved + " stale records for project " + project.getName());
				}
				project.setCheckinInProgress(0);
				session.store(project);
			}
			session.commit();
		} catch (ServiceException e1) {
			LOGGER.error("", e1);
		}
		long e = System.nanoTime();
		LOGGER.info("Done checking for stale records (" + ((e - s) / 1000000) + " ms)");
	}

	private int checkPidRid(DatabaseSession session, Project project, int pid, int rid) throws BimserverDatabaseException, BimserverLockConflictException {
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.putInt(pid);

		int removed = 0;
		
		KeyValueStore keyValueStore = session.getKeyValueStore();
		PackageMetaData packageMetaData = bimDatabase.getMetaDataManager().getPackageMetaData(project.getSchema());
		for (EClass eClass : packageMetaData.getAllClasses()) {
			String tableName = bimDatabase.getTableName(eClass);
			if (!keyValueStore.isTransactional(session, tableName)) {
				try (RecordIterator iterator = keyValueStore.getRecordIterator(tableName, buffer.array(), buffer.array(), session, true)) {
					Record record = iterator.next();
					while (record != null) {
						ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
						if (keyBuffer.capacity() != 16) {
							throw new BimserverDatabaseException("Unexpected key size: " + keyBuffer.capacity());
						}
						int foundPid = keyBuffer.getInt(); // pid
						if (foundPid != pid) {
							throw new RuntimeException("PID does not match, this should never happen, please contact developer");
						}
						keyBuffer.getLong(); // oid
						int recordRid = -keyBuffer.getInt(); // rid
						if (recordRid > rid) {
							keyValueStore.delete(tableName, record.getKey(), session);
							removed++;
						}
						record = iterator.next();
					}
				}
			}
		}
		return removed;
	}

	public MavenPluginRepository getMavenPluginRepository() {
		return mavenPluginRepository;
	}
	
	public SecretKeySpec getEncryptionKey() {
		return encryptionkey;
	}

	public NewDiskCacheManager getNewDiskCacheManager() {
		return newDiskCacheManager;
	}

	private <T extends PluginConfiguration> T find(List<T> list, String identifier) {
		for (T t : list) {
			if (t.getPluginDescriptor() == null) {
				// throw new RuntimeException("No PluginDescriptor!");
			} else {
				if (t.getPluginDescriptor().getIdentifier().equals(identifier)) {
					return t;
				}
			}
		}
		return null;
	}

	private void genericPluginConversion(PluginContext pluginContext, DatabaseSession session, PluginConfiguration pluginConfiguration, PluginDescriptor pluginDescriptor) throws BimserverDatabaseException {
		try {
			Plugin plugin = pluginContext.getPlugin();
			pluginConfiguration.setName(pluginDescriptor.getName());
			pluginConfiguration.setPluginDescriptor(pluginDescriptor);

			// For the opposite of setPluginDescriptor
			// session.store(pluginDescriptor); Disabled for now, this creates
			// massive lists, that are not really useful...

			pluginConfiguration.setDescription(pluginContext.getDescription());
			pluginConfiguration.setEnabled(true);
			pluginConfiguration.setSettings(convertSettings(session, plugin.getUserSettingsDefinition()));
		} catch (NoClassDefFoundError e) {
			// ignore for now
		}
	}

	private PluginDescriptor getPluginDescriptor(DatabaseSession session, String identifier) throws BimserverDatabaseException {
		return session.querySingle(StorePackage.eINSTANCE.getPluginDescriptor_Identifier(), identifier);
	}

	public Class<?> getPluginInterface(Class<?> plugin) {
		for (Class<?> inter : plugin.getInterfaces()) {
			if (inter == Plugin.class) {
				return plugin;
			}
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

	@SuppressWarnings("unchecked")
	public void updateUserPlugin(DatabaseSession session, User user, PluginDescriptor pluginDescriptor, PluginContext pluginContext) throws BimserverDatabaseException {
		if (pluginDescriptor.isInstallForNewUsers()) {
			UserSettings userSettings = user.getUserSettings();
			if (userSettings == null) {
				userSettings = session.create(UserSettings.class);
				user.setUserSettings(userSettings);
				session.store(user);
			}
			
			Class<?> pluginInterface = getPluginInterface(pluginContext.getPlugin().getClass());
			String originalPluginInterfaceName = pluginInterface.getSimpleName();
			String pluginInterfaceName = pluginInterface.getSimpleName();
			if (pluginInterfaceName.endsWith("Plugin")) {
				pluginInterfaceName = pluginInterfaceName.substring(0, pluginInterfaceName.length() - 6);
			}
			
			if (pluginInterfaceName.equals("StreamingSerializer")) {
				pluginInterfaceName = "Serializer";
			} else if (pluginInterfaceName.equals("MessagingStreamingSerializer")) {
				pluginInterfaceName = "MessagingSerializer";
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
			if (listRefName.equals("messagingSerializers")) {
				listRefName = "serializers";
			}
			EReference listReference = (EReference) userSettingsClass.getEStructuralFeature(listRefName);
			if (listReference == null) {
				LOGGER.warn(listRefName + " not found");
				return;
			}
			EReference defaultReference = (EReference) userSettingsClass.getEStructuralFeature("default" + pluginInterfaceName);
			EClass pluginConfigurationClass = (EClass) StorePackage.eINSTANCE.getEClassifier((pluginInterfaceName.equals("Service") ? "Internal" : "") + pluginInterfaceName + "PluginConfiguration");
			
			List<PluginConfiguration> list = (List<PluginConfiguration>) userSettings.eGet(listReference);
			PluginConfiguration pluginConfiguration = find(list, pluginContext.getIdentifier());
			if (pluginConfiguration == null) {
				pluginConfiguration = (PluginConfiguration) session.create(pluginConfigurationClass);
				if (pluginConfiguration instanceof SerializerPluginConfiguration) {
					boolean streaming = originalPluginInterfaceName.equals("StreamingSerializerPlugin") || originalPluginInterfaceName.equals("MessagingStreamingSerializerPlugin");
					((SerializerPluginConfiguration) pluginConfiguration).setStreaming(streaming);
				} else if (pluginConfiguration instanceof InternalServicePluginConfiguration) {
					((InternalServicePluginConfiguration)pluginConfiguration).setUserSettings(userSettings);
				}

				list.add(pluginConfiguration);
				genericPluginConversion(pluginContext, session, pluginConfiguration, pluginDescriptor);
			}

			if (pluginInterfaceName.equals("Service")) {
				activateService(user.getOid(), (InternalServicePluginConfiguration) pluginConfiguration);
			}
			
			if (defaultReference != null) {
				if (userSettings.eGet(defaultReference) == null && pluginInterfaceName.contentEquals("RenderEngine")) {
					PluginDescriptor defaultRenderEnginePlugin = getServerSettingsCache().getServerSettings().getDefaultRenderEnginePlugin();
					if (defaultRenderEnginePlugin != null && pluginDescriptor.getOid() == defaultRenderEnginePlugin.getOid()) {
						LOGGER.info("Setting default render engine for user " + user.getUsername() + " to " + defaultRenderEnginePlugin.getName());
						userSettings.eSet(defaultReference, pluginConfiguration);
					}
				}
			}
			
			session.store(userSettings);
		}
	}

	public void updateUserSettings(DatabaseSession session, User user) throws BimserverLockConflictException, BimserverDatabaseException {
		UserSettings userSettings = user.getUserSettings();
		if (userSettings == null) {
			userSettings = session.create(UserSettings.class);
			user.setUserSettings(userSettings);
			session.store(user);
		}
		
		for (Entry<PluginContext, Plugin> pluginEntry : pluginManager.getAllPlugins(true).entrySet()) {
			if (pluginEntry.getValue() instanceof WebModulePlugin || pluginEntry.getValue() instanceof ModelCheckerPlugin) {
				// Non-user related types of plugins
				continue;
			}
			PluginDescriptor pluginDescriptor = getPluginDescriptor(session, pluginEntry.getKey().getIdentifier());
			if (pluginDescriptor == null)  {
				LOGGER.error("No plugin descriptor found: " + pluginEntry.getKey().getIdentifier());
//				throw new BimserverDatabaseException("No plugin descriptor found: " + pluginEntry.getKey().getIdentifier());
			} else {
				updateUserPlugin(session, user, pluginDescriptor, pluginEntry.getKey());
			}
		}
		
		session.store(userSettings);
	}

	public RenderEnginePools getRenderEnginePools() {
		return renderEnginePools;
	}

	public ObjectType convertSettings(DatabaseSession session, ObjectDefinition objectDefinition) throws BimserverDatabaseException {
		ObjectType settings = session.create(ObjectType.class);
		if (objectDefinition != null) {
			for (ParameterDefinition parameterDefinition : objectDefinition.getParameters()) {
				Parameter parameter = session.create(Parameter.class);
				parameter.setName(parameterDefinition.getName());
				parameter.setIdentifier(parameterDefinition.getIdentifier());
				if (parameterDefinition.getDefaultValue() != null) {
					Type value = cloneAndAdd(session, parameterDefinition.getDefaultValue());
					parameter.setValue(value);
				}
				settings.getParameters().add(parameter);
			}
		}
		return settings;
	}

	public Type cloneAndAdd(DatabaseSession session, Type input) throws BimserverDatabaseException {
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
		} else if (input instanceof ByteArrayType) {
			ByteArrayType byteArrayType = session.create(ByteArrayType.class);
			byteArrayType.setValue(((ByteArrayType) input).getValue());
			session.store(byteArrayType);
			return byteArrayType;
		}
		return null;
	}

	@SuppressWarnings("unused")
	private WebModulePluginConfiguration findWebModule(ServerSettings serverSettings, String identifier) {
		for (Entry<PluginContext, WebModulePlugin> entry : pluginManager.getAllWebPlugins(true).entrySet()) {
			WebModulePluginConfiguration webPluginConfiguration = find(serverSettings.getWebModules(), identifier);
			if (entry.getKey().getIdentifier().equals(identifier)) {
				return webPluginConfiguration;
			}
		}
		return null;
	}

	private void initDatabaseDependantItems() throws BimserverDatabaseException {
		LOGGER.info("Initializing database dependant logic...");
		long start = System.nanoTime();
		notificationsManager.init();

		getSerializerFactory().init(pluginManager, bimDatabase, this);
		try {
			DatabaseSession session = bimDatabase.createSession(OperationType.POSSIBLY_WRITE);
			try {
				updatePlugins(session);
				session.commit();
			} catch (ServiceException e) {
				LOGGER.error("", e);
			} finally {
				session.close();
			}

			int renderEngineProcesses = getServerSettingsCache().getServerSettings().getRenderEngineProcesses();
			RenderEnginePoolFactory renderEnginePoolFactory = new CommonsPoolingRenderEnginePoolFactory(renderEngineProcesses);

			renderEnginePools = new RenderEnginePools(this, renderEnginePoolFactory);
			
			session = bimDatabase.createSession(OperationType.POSSIBLY_WRITE);
//			createDatabaseObjects(session);
			
			ServerSettings serverSettings = serverSettingsCache.getServerSettings();

			for (Entry<PluginContext, WebModulePlugin> entry : pluginManager.getAllWebPlugins(true).entrySet()) {
				WebModulePluginConfiguration webPluginConfiguration = find(serverSettings.getWebModules(), entry.getKey().getIdentifier());
				if (webPluginConfiguration == null) {
					webPluginConfiguration = session.create(WebModulePluginConfiguration.class);
					serverSettings.getWebModules().add(webPluginConfiguration);
					PluginDescriptor pluginDescriptor = getPluginDescriptor(session, entry.getKey().getIdentifier());
					if (pluginDescriptor == null) {
						throw new BimserverDatabaseException("No plugin descriptor found: " + entry.getKey().getIdentifier());
					}
					genericPluginConversion(entry.getKey(), session, webPluginConfiguration, pluginDescriptor);
				} else {
					if (webPluginConfiguration == serverSettings.getWebModule()) {
						setDefaultWebModule(entry.getValue());
					}
				}
			}

			// Set the default
//			if (serverSettings.getWebModule() == null) {
//				WebModulePluginConfiguration bimviewsWebModule = findWebModule(serverSettings, "BIM Views");
//				if (bimviewsWebModule != null) {
//					serverSettings.setWebModule(bimviewsWebModule);
//					setDefaultWebModule(pluginManager.getWebModulePlugin(bimviewsWebModule.getPluginDescriptor().getPluginClassName(), true));
//				} else {
//					WebModulePluginConfiguration defaultWebModule = findWebModule(serverSettings, "org.bimserver.defaultwebmodule.DefaultWebModulePlugin");
//					if (defaultWebModule != null) {
//						serverSettings.setWebModule(defaultWebModule);
//						setDefaultWebModule(pluginManager.getWebModulePlugin(defaultWebModule.getPluginDescriptor().getPluginClassName(), true));
//					}
//				}
//			}
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
			List<WebModulePluginConfiguration> webModuleConfigurations = serverSettingsCache.getServerSettings().getWebModules();
			for (WebModulePluginConfiguration webModulePluginConfiguration : webModuleConfigurations) {
				String contextPath = "";
				for (Parameter parameter : webModulePluginConfiguration.getSettings().getParameters()) {
					if (parameter.getName().equals("contextPath")) {
						contextPath = ((StringType) parameter.getValue()).getValue();
					}
				}
				String identifier = webModulePluginConfiguration.getPluginDescriptor().getIdentifier();
				webModules.put(contextPath, (WebModulePlugin) pluginManager.getPlugin(identifier, true));
			}
			// if (serverSettingsCache.getServerSettings().getWebModule() !=
			// null) {
			// defaultWebModule = (WebModulePlugin)
			// pluginManager.getPlugin(serverSettingsCache.getServerSettings().getWebModule().getPluginDescriptor().getPluginClassName(),
			// true);
			// }

			try (DatabaseSession databaseSession = getDatabase().createSession(OperationType.POSSIBLY_WRITE)) {
				ExtendedDataSchema htmlSchema = (ExtendedDataSchema) databaseSession.querySingle(StorePackage.eINSTANCE.getExtendedDataSchema_Name(), "GEOMETRY_GENERATION_REPORT_HTML_1_1");
				ExtendedDataSchema jsonSchema = (ExtendedDataSchema) databaseSession.querySingle(StorePackage.eINSTANCE.getExtendedDataSchema_Name(), "GEOMETRY_GENERATION_REPORT_JSON_1_1");
				
				if (htmlSchema == null) {
					htmlSchema = createExtendedDataSchema(databaseSession, "GEOMETRY_GENERATION_REPORT_HTML_1_1", "text/html");
				}
				if (jsonSchema == null) {
					jsonSchema = createExtendedDataSchema(databaseSession, "GEOMETRY_GENERATION_REPORT_JSON_1_1", "application/json");
				}
				databaseSession.commit();
			} catch (ServiceException e) {
				LOGGER.error("", e);
			}
			
			Integer protocolBuffersPort = getServerSettingsCache().getServerSettings().getProtocolBuffersPort();
			if (protocolBuffersPort >= 1 && protocolBuffersPort <= 65535) {
				try {
					protocolBuffersMetaData = new ProtocolBuffersMetaData();
					protocolBuffersMetaData.load(servicesMap, ProtocolBuffersBimServerClientFactory.class);

					protocolBuffersServer = new ProtocolBuffersServer(protocolBuffersMetaData, serviceFactory, servicesMap, protocolBuffersPort);
					protocolBuffersServer.start();
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}

			bimServerClientFactory = new DirectBimServerClientFactory<ServiceInterface>(serverSettingsCache.getServerSettings().getSiteAddress(), serviceFactory, servicesMap, pluginManager, metaDataManager);
			pluginManager.setBimServerClientFactory(bimServerClientFactory);
			
			try (DatabaseSession session2 = bimDatabase.createSession(OperationType.READ_ONLY)) {
				IfcModelInterface pluginBundleVersions = session2.getAllOfType(StorePackage.eINSTANCE.getPluginBundleVersion(), OldQuery.getDefault());
				for (PluginBundleVersion pluginBundleVersion : pluginBundleVersions.getAll(PluginBundleVersion.class)) {
					if (pluginBundleVersion.getType() == PluginBundleType.MAVEN || pluginBundleVersion.getType() == PluginBundleType.LOCAL) {
						PluginBundleVersionIdentifier pluginBundleVersionIdentifier = new PluginBundleVersionIdentifier(pluginBundleVersion.getGroupId(), pluginBundleVersion.getArtifactId(), pluginBundleVersion.getVersion());
						
						IfcModelInterface pluginDescriptors = session2.getAllOfType(StorePackage.eINSTANCE.getPluginDescriptor(), OldQuery.getDefault());
						
						List<SPluginInformation> plugins = new ArrayList<>();
						
						for (PluginDescriptor pluginDescriptor : pluginDescriptors.getAll(PluginDescriptor.class)) {
							if (pluginDescriptor.getPluginBundleVersion() == pluginBundleVersion && pluginDescriptor.getEnabled()) {
								SPluginInformation sPluginInformation = new SPluginInformation();
								
								sPluginInformation.setEnabled(true);
								sPluginInformation.setDescription(pluginDescriptor.getDescription());
								sPluginInformation.setIdentifier(pluginDescriptor.getIdentifier());
								sPluginInformation.setInstallForAllUsers(pluginDescriptor.isInstallForNewUsers());
								sPluginInformation.setInstallForNewUsers(pluginDescriptor.isInstallForNewUsers());
								sPluginInformation.setName(pluginDescriptor.getName());
								sPluginInformation.setType(pluginManager.getPluginTypeFromClass(pluginDescriptor.getPluginClassName()));
								
								plugins.add(sPluginInformation);
							}
						}
						
						try {
							pluginBundleManager.loadFromPluginDir(pluginBundleVersionIdentifier, getSConverter().convertToSObject(pluginBundleVersion), plugins, serverSettingsCache.getServerSettings().isPluginStrictVersionChecking());
						} catch (Exception e) {
							LOGGER.error("", e);
						}
					}
				}
			} catch (Exception e) {
				throw new BimserverDatabaseException(e);
			}
		} catch (BimserverLockConflictException e) {
			throw new BimserverDatabaseException(e);
//		} catch (PluginException e) {
//			throw new BimserverDatabaseException(e);
		} catch (RenderEngineException e) {
			throw new BimserverDatabaseException(e);
		}
		long end = System.nanoTime();
		LOGGER.info("Done initializing database dependant logic (" + ((end - start) / 1000000) + "ms)");
	}

	/**
	 * Load all users from the database and their configured services. Registers each service.
	 * 
	 * @throws BimserverDatabaseException
	 * @throws BimserverLockConflictException
	 */
	public void activateServices() throws BimserverDatabaseException, BimserverLockConflictException {
		try (DatabaseSession session = bimDatabase.createSession(OperationType.READ_ONLY)) {
			IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), OldQuery.getDefault());
			for (User user : allOfType.getAll(User.class)) {
				updateUserSettings(session, user);
				UserSettings userSettings = user.getUserSettings();
	
				for (InternalServicePluginConfiguration internalServicePluginConfiguration : userSettings.getServices()) {
					activateService(user.getOid(), internalServicePluginConfiguration);
				}
			}
		}
	}
	
	public void activateService(long uoid, InternalServicePluginConfiguration internalServicePluginConfiguration) {
		ServicePlugin servicePlugin = getPluginManager().getServicePlugin(internalServicePluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
		
		if (servicePlugin == null) {
			LOGGER.warn("Plugin " + internalServicePluginConfiguration.getPluginDescriptor().getPluginClassName() + " not found");
		} else {
			SInternalServicePluginConfiguration sInternalService = (SInternalServicePluginConfiguration) getSConverter().convertToSObject(internalServicePluginConfiguration);
			
			try {
				servicePlugin.unregister(sInternalService);
				servicePlugin.register(uoid, sInternalService, getPluginSettingsCache().getPluginSettings(internalServicePluginConfiguration.getOid()));
			} catch (Throwable e) {
				LOGGER.error("", e);
			}
		}
	}

	public WebModuleManager getWebModuleManager() {
		return webModuleManager;
	}

	private void updatePlugins(DatabaseSession session) throws BimserverDatabaseException {
		Map<PluginContext, Plugin> allPlugins = pluginManager.getAllPlugins(false);
		for (PluginContext pluginContext : allPlugins.keySet()) {
			Plugin plugin = pluginContext.getPlugin();
			Condition pluginCondition = new AttributeCondition(StorePackage.eINSTANCE.getPluginDescriptor_Identifier(), new StringLiteral(pluginContext.getIdentifier()));
			Map<Long, PluginDescriptor> results = session.query(pluginCondition, PluginDescriptor.class, OldQuery.getDefault());
			if (results.size() == 0) {
				PluginDescriptor pluginDescriptor = session.create(PluginDescriptor.class);
				pluginDescriptor.setIdentifier(pluginContext.getIdentifier());
				pluginDescriptor.setPluginClassName(plugin.getClass().getName());
				pluginDescriptor.setName(plugin.getClass().getSimpleName());
				pluginDescriptor.setDescription(pluginContext.getDescription());
				pluginDescriptor.setLocation(pluginContext.getLocation().toString());
				pluginDescriptor.setPluginInterfaceClassName(getPluginInterface(plugin.getClass()).getName());
				pluginDescriptor.setEnabled(true);
			} else if (results.size() == 1) {
				PluginDescriptor pluginDescriptor = results.values().iterator().next();
				pluginDescriptor.setIdentifier(pluginContext.getIdentifier());
				pluginDescriptor.setPluginClassName(plugin.getClass().getName());
				pluginDescriptor.setName(plugin.getClass().getSimpleName());
				pluginDescriptor.setDescription(pluginContext.getDescription());
				pluginDescriptor.setLocation(pluginContext.getLocation().toString());
				pluginDescriptor.setPluginInterfaceClassName(getPluginInterface(plugin.getClass()).getName());
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
	
	public static void initHomeDir(BimServerConfig config) throws IOException {
		String[] filesToCheck = new String[] { "logback.xml" };
		String[] directoriesToCheck = new String[] { "emailtemplates" };
		if (!Files.exists(config.getHomeDir())) {
			Files.createDirectories(config.getHomeDir());
		}
		if (Files.exists(config.getHomeDir()) && Files.isDirectory(config.getHomeDir())) {
			ResourceFetcher resourceFetcher = config.getResourceFetcher();
			for (String fileToCheck : filesToCheck) {
				byte[] data = resourceFetcher.getData(fileToCheck);
				if (data != null) {
					Path destFile = config.getHomeDir().resolve(fileToCheck);
					if (!Files.exists(destFile)) {
						FileUtils.writeByteArrayToFile(destFile.toFile(), data);
					}
				}
			}
			for (String directoryToCheck : directoriesToCheck) {
				Path destFile = config.getHomeDir().resolve(directoryToCheck);
				Files.createDirectories(destFile);
				for (String key : resourceFetcher.listKeys(directoryToCheck)) {
					if (resourceFetcher.isDirectory(directoryToCheck + "/" + key)) {
						Path destDir2 = destFile.resolve(key);
						for (String key2 : resourceFetcher.listKeys(directoryToCheck + "/" + key)) {
							byte[] data = resourceFetcher.getData(directoryToCheck + "/" + key + "/" + key2);
							if (data != null) {
								FileUtils.writeByteArrayToFile(destDir2.resolve(key2).toFile(), data);
							}
						}
					} else {
						byte[] data = resourceFetcher.getData(directoryToCheck + "/" + key);
						if (data != null) {
							FileUtils.writeByteArrayToFile(destFile.resolve(key).toFile(), data);
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
			try {
				bimDatabase.close();
			} catch (Throwable t) {
			}
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
		pluginBundleManager.close();
		LOGGER.info("BIMserver stopped");
//		ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();
//		if (loggerFactory instanceof LoggerContext) {
//		    LoggerContext context = (LoggerContext) loggerFactory;
//		    context.stop();
//		}
	}

	public PluginManager getPluginManager() {
		return pluginManager;
	}
	
	public PluginBundleManager getPluginBundleManager() {
		return pluginBundleManager;
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

	public EmbeddedWebServerInterface getEmbeddedWebServer() {
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

	public void setEmbeddedWebServer(EmbeddedWebServerInterface embeddedWebServer) {
		this.embeddedWebServer = embeddedWebServer;
	}
	
	public AuthCache getAuthCache() {
		return authCache;
	}
	
	public GeometryAccellerator getGeometryAccellerator() {
		return geometryAccellerator;
	}
	
	public PluginSettingsCache getPluginSettingsCache() {
		return pluginSettingsCache;
	}

	@Override
	public BasicServerInfo getBasicServerInfo() {
		BasicServerInfo basicServerInfo = new BasicServerInfo(getServerSettingsCache().getServerSettings().getSiteAddress());
		return basicServerInfo;
	}
	
	public UUID getUuid() {
		return bimDatabase.getUuid();
	}
	
	private ExtendedDataSchema createExtendedDataSchema(DatabaseSession databaseSession, String name, String contentType) throws BimserverDatabaseException {
		ExtendedDataSchema extendedDataSchema = databaseSession.create(ExtendedDataSchema.class);
		extendedDataSchema.setName(name);
		extendedDataSchema.setContentType(contentType);
		return extendedDataSchema;
	}
}