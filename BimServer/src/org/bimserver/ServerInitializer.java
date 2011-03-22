package org.bimserver;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.concurrent.Executors;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import nl.tue.buildingsmart.emf.DerivedReader;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.berkeley.BerkeleyColumnDatabase;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.FileFieldIgnoreMap;
import org.bimserver.ifc.PackageDefinition;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.logging.CustomFileAppender;
import org.bimserver.longaction.LongActionManager;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.store.UserType;
import org.bimserver.querycompiler.QueryCompiler;
import org.bimserver.resources.JarResourceFetcher;
import org.bimserver.resources.WarResourceFetcher;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.servlets.CompileServlet;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.templating.TemplateEngine;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.utils.TempUtils;
import org.bimserver.version.Version;
import org.bimserver.version.VersionChecker;
import org.bimserver.web.LoginManager;
import org.bimserver.webservices.RestApplication;
import org.bimserver.webservices.Service;
import org.bimserver.webservices.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.googlecode.protobuf.socketrpc.RpcServer;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;

public class ServerInitializer implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerInitializer.class);
	private static GregorianCalendar serverStartTime;
	private static BimDatabase bimDatabase;
	private JobScheduler bimScheduler;
	private static ResourceFetcher resourceFetcher;
	private static ServletContext servletContext;
	private LongActionManager longActionManager;
	private static ServiceInterface systemService;
	private File homeDir;
	private File baseDir;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			servletContext = servletContextEvent.getServletContext();
			if (servletContext.getAttribute("homedir") != null) {
				homeDir = new File((String) servletContext.getAttribute("homedir"));
			}
			if (homeDir == null && servletContext.getInitParameter("homedir") != null) {
				homeDir = new File(servletContext.getInitParameter("homedir"));
			}
			ServerType serverType = detectServerType(servletContextEvent.getServletContext());
			if (serverType == ServerType.DEV_ENVIRONMENT) {
				baseDir = new File("../BimServer/defaultsettings/" + "shared");
			} else if (serverType == ServerType.STANDALONE_JAR) {
				baseDir = new File("");
			} else if (serverType == ServerType.DEPLOYED_WAR) {
				baseDir = new File("");
			}
			if (homeDir == null) {
				homeDir = baseDir;
			}
			resourceFetcher = createResourceFetcher(serverType, servletContext, homeDir);
			if (homeDir != null) {
				initHomeDir();
			}

			fixLogging();

			LOGGER.info("Starting ServerInitializer");
			if (homeDir != null) {
				LOGGER.info("Using \"" + homeDir.getAbsolutePath() + "\" as homedir");
			} else {
				LOGGER.info("Not using a homedir");
			}

			UncaughtExceptionHandler uncaughtExceptionHandler = new UncaughtExceptionHandler() {
				@Override
				public void uncaughtException(Thread t, Throwable e) {
					if (e instanceof OutOfMemoryError) {
						ServerInfo.setOutOfMemory();
						LOGGER.error("", e);
					} else if (e instanceof Error) {
						ServerInfo.setErrorMessage(e.getMessage());
						LOGGER.error("", e);
					}
				}
			};

			Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);

			LOGGER.info("Detected server type: " + serverType + " (" + System.getProperty("os.name") + ", " + System.getProperty("sun.arch.data.model") + "bit)");
			if (serverType == ServerType.UNKNOWN) {
				LOGGER.error("Server type not detected, stopping initialization");
				return;
			}
			serverStartTime = new GregorianCalendar();
			SchemaDefinition schema = loadIfcSchema(resourceFetcher);
			Set<Ifc2x3Package> packages = CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE);

			bimScheduler = new JobScheduler();
			bimScheduler.start();

			longActionManager = new LongActionManager();

			FieldIgnoreMap fieldIgnoreMap = new FileFieldIgnoreMap(packages, resourceFetcher);
			TemplateEngine.getTemplateEngine().init(resourceFetcher.getResource("templates/"));
			File databaseDir = new File(homeDir, "database");
			BerkeleyColumnDatabase columnDatabase = new BerkeleyColumnDatabase(databaseDir);
			bimDatabase = new Database(packages, columnDatabase, fieldIgnoreMap);
			try {
				bimDatabase.init();
			} catch (DatabaseRestartRequiredException e) {
				bimDatabase.close();
				columnDatabase = new BerkeleyColumnDatabase(databaseDir);
				bimDatabase = new Database(packages, columnDatabase, fieldIgnoreMap);
				bimDatabase.init();
			}

			SettingsManager settingsManager = new SettingsManager(bimDatabase);
			MailSystem mailSystem = new MailSystem(settingsManager);

			ServerInfo.init(bimDatabase, settingsManager);
			ServerInfo.update();

			if (serverType == ServerType.DEV_ENVIRONMENT && columnDatabase.isNew()) {
				BimDatabaseSession session = bimDatabase.createSession();
				try {
					new AddUserDatabaseAction(session, AccessMethod.INTERNAL, settingsManager, mailSystem, "test@bimserver.org", "test", "Test User", UserType.USER, -1, false)
							.execute();
					session.commit();
				} finally {
					session.close();
				}
			}
			Version version = VersionChecker.init(resourceFetcher).getLocalVersion();

			File schemaFile = resourceFetcher.getFile("IFC2X3_FINAL.exp").getAbsoluteFile();
			LOGGER.info("Using " + schemaFile + " as engine schema");

			File nativeFolder = resourceFetcher.getFile("lib/" + File.separator + System.getProperty("sun.arch.data.model"));
			String classPath = null;
			if (serverType == ServerType.DEPLOYED_WAR) {
				// Because servers like Tomcat use complex classloading
				// constructions, the classpath system property gives not enough
				// info about the used classpaths, so here we tell the
				// IfcEngineFactory to use all jar files in the context
				classPath = servletContext.getRealPath("/") + "WEB-INF" + File.separator + "lib";
			}
			IfcEngineFactory ifcEngineFactory = new IfcEngineFactory(schemaFile, nativeFolder, new File(homeDir, "tmp"), classPath);

			CompileServlet.database = bimDatabase;
			CompileServlet.settingsManager = settingsManager;

			URL colladSettingsFile = resourceFetcher.getResource("collada.xml");
			PackageDefinition colladaSettings = PackageDefinition.readFromFile(colladSettingsFile);

			TempUtils.makeTempDir("bimserver");
			EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
			emfSerializerFactory.init(version, schema, fieldIgnoreMap, ifcEngineFactory, colladaSettings, resourceFetcher, settingsManager);
			emfSerializerFactory.initSerializers();
			ServiceFactory.init(bimDatabase, emfSerializerFactory, schema, longActionManager, ifcEngineFactory, fieldIgnoreMap, settingsManager, mailSystem);
			setSystemService(ServiceFactory.getINSTANCE().newService(AccessMethod.INTERNAL));
			if (!((Service) getSystemService()).loginAsSystem()) {
				throw new RuntimeException("System user not found");
			}
			LoginManager.setSystemService(getSystemService());

			RestApplication.setServiceFactory(ServiceFactory.getINSTANCE());

			// ProtocolBuffersServer protocolBuffersServer = new
			// ProtocolBuffersServer(8020);
			// protocolBuffersServer.start();

			RpcServer rpcServer = new RpcServer(SocketRpcConnectionFactories.createServerRpcConnectionFactory(8020), Executors.newFixedThreadPool(10), false);
			rpcServer.registerBlockingService(org.bimserver.pb.Service.ServiceInterface.newReflectiveBlockingService(org.bimserver.pb.Service.ServiceInterface.newBlockingStub(new ReflectiveRpcChannel(ServiceFactory.getINSTANCE()))));
			rpcServer.startServer();

			if (serverType == ServerType.DEPLOYED_WAR) {
				File libDir = new File(classPath);
				LOGGER.info("adding lib dir: " + libDir.getAbsolutePath());
				QueryCompiler.addJarFolder(libDir);
			}

			ServerStarted serverStarted = LogFactory.eINSTANCE.createServerStarted();
			serverStarted.setDate(new Date());
			serverStarted.setAccessMethod(AccessMethod.INTERNAL);
			serverStarted.setExecutor(null);
			BimDatabaseSession session = bimDatabase.createSession();
			try {
				session.store(serverStarted);
				session.commit();
			} finally {
				session.close();
			}
		} catch (Exception e) {
			ServerInfo.setErrorMessage(e.getMessage());
			LOGGER.error("", e);
		}
	}

	private void fixLogging() throws IOException {
		CustomFileAppender appender = new CustomFileAppender(new File(homeDir, "logs/bimserver.log"));
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

	public static BimDatabase getDatabase() {
		return bimDatabase;
	}

	public static ResourceFetcher getResourceFetcher() {
		return resourceFetcher;
	}

	private ServerType detectServerType(ServletContext servletContext) {
		String typeString = null;
		try {
			URL resource = servletContext.getResource("/servertype.txt");
			if (resource != null) {
				typeString = readUrl(resource);
			}
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
		}
		if (typeString == null) {
			File file = new File("servertype.txt");
			typeString = readFile(file);
		}
		if (typeString == null) {
			return ServerType.UNKNOWN;
		}
		return ServerType.valueOf(typeString);
	}

	private String readUrl(URL resource) {
		try {
			InputStream inputStream = resource.openStream();
			byte[] buffer = new byte[100];
			int red = inputStream.read(buffer);
			String string = new String(buffer, 0, red, Charsets.UTF_8);
			inputStream.close();
			return string;
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	private String readFile(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[100];
			int red = fis.read(buffer);
			String string = new String(buffer, 0, red, Charsets.UTF_8);
			fis.close();
			return string;
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	private ResourceFetcher createResourceFetcher(ServerType serverType, final ServletContext servletContext, File homeDir) {
		switch (serverType) {
		case DEV_ENVIRONMENT:
			return new LocalDevelopmentResourceFetcher();
		case DEPLOYED_WAR:
			return new WarResourceFetcher(servletContext, homeDir);
		case STANDALONE_JAR:
			return new JarResourceFetcher();
		}
		return resourceFetcher;
	}

	private SchemaDefinition loadIfcSchema(ResourceFetcher resourceFetcher) throws Exception {
		try {
			URL ifcSchemaFile = resourceFetcher.getResource("IFC2X3_FINAL.exp");
			if (ifcSchemaFile == null) {
				LOGGER.error("IFC-Schema file not found");
			} else {
				LOGGER.info("IFC-Schema file found");
				ExpressSchemaParser schemaParser = new ExpressSchemaParser(ifcSchemaFile);
				schemaParser.parse();
				SchemaDefinition schema = schemaParser.getSchema();
				new DerivedReader(ifcSchemaFile.openStream(), schema);
				if (schema != null) {
					LOGGER.info("IFC-Schema successfully loaded");
				} else {
					LOGGER.error("Error loading IFC-Schema");
				}
				return schema;
			}
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		LOGGER.info("Context is being destroyed");
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

	public static GregorianCalendar getServerStartTime() {
		return serverStartTime;
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static void setSystemService(ServiceInterface systemService) {
		ServerInitializer.systemService = systemService;
	}

	public static ServiceInterface getSystemService() {
		return systemService;
	}
}