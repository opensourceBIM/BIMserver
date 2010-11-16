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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import nl.tue.buildingsmart.emf.DerivedReader;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.berkeley.BerkeleyColumnDatabase;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.database.store.log.ServerStarted;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.FileFieldIgnoreMap;
import org.bimserver.ifc.PackageDefinition;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.querycompiler.QueryCompiler;
import org.bimserver.servlets.CompileServlet;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.utils.TempUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerInitializer implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerInitializer.class);
	private static GregorianCalendar serverStartTime;
	private static BimDatabase bimDatabase;
	private BimScheduler bimScheduler;
	private static ResourceFetcher resourceFetcher;
	private static ServletContext servletContext;
	private LongActionManager longActionManager;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			LOGGER.info("Starting ServerInitializer");
			ServerType serverType = detectServerType(servletContextEvent.getServletContext());
			LOGGER.info("Detected server type: " + serverType + " (" + System.getProperty("os.name") + ", " + System.getProperty("sun.arch.data.model") + "bit)");
			if (serverType == ServerType.UNKNOWN) {
				LOGGER.error("Server type not detected, stopping initialization");
				return;
			}
			servletContext = servletContextEvent.getServletContext();
			resourceFetcher = createResourceFetcher(serverType, servletContext);
			URL resource = resourceFetcher.getResource("settings.xml");
			Settings settings = Settings.readFromUrl(resource);
			ServerSettings.setSettings(settings);
			serverStartTime = new GregorianCalendar();
			SchemaDefinition schema = loadIfcSchema(resourceFetcher);
			Set<Ifc2x3Package> packages = CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE);

			bimScheduler = new BimScheduler();
			bimScheduler.start();

			longActionManager = new LongActionManager();
			longActionManager.start();
			
			FieldIgnoreMap fieldIgnoreMap = new FileFieldIgnoreMap(packages, resourceFetcher);
			TemplateEngine.getTemplateEngine().init(resourceFetcher.getResource("templates/"));
			File databaseDir = new File(ServerSettings.getSettings().getDatabaseLocation());
			BerkeleyColumnDatabase columnDatabase = new BerkeleyColumnDatabase(databaseDir);
			bimDatabase = new Database(packages, columnDatabase, fieldIgnoreMap);
			Version version = VersionChecker.init(resourceFetcher).getLocalVersion();

			File schemaFile = resourceFetcher.getFile("IFC2X3_FINAL.exp").getAbsoluteFile();
			LOGGER.info("Using " + schemaFile + " as engine schema");

			File nativeFolder = resourceFetcher.getFile("lib/");
			IfcEngineFactory ifcEngineFactory = new IfcEngineFactory(schemaFile, nativeFolder, resourceFetcher);

			CompileServlet.database = bimDatabase;
			
			URL colladSettingsFile = resourceFetcher.getResource("collada.xml");
			PackageDefinition colladaSettings = PackageDefinition.readFromFile(colladSettingsFile);
			
			TempUtils.makeTempDir("bimserver");
			EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
			emfSerializerFactory.init(version, schema, fieldIgnoreMap, ifcEngineFactory, colladaSettings);
			emfSerializerFactory.initSerializers();
			ServiceFactory.init(bimDatabase, emfSerializerFactory, schema, longActionManager, ifcEngineFactory);
			ServiceInterface adminService = ServiceFactory.getINSTANCE().newService(AccessMethod.INTERNAL);
			((Service)adminService).loginAsAdmin();
			LoginManager.setAdminService(adminService);

			RestApplication.serviceFactory = ServiceFactory.getINSTANCE();
			
			if (serverType == ServerType.DEPLOYED_WAR) {
				File libDir = new File(servletContext.getRealPath("/") + "WEB-INF" + File.separator + "lib");
				LOGGER.info("adding lib dir: " + libDir.getAbsolutePath());
				QueryCompiler.addJarFolder(libDir);
			}
			
			ServerStarted serverStarted = LogFactory.eINSTANCE.createServerStarted();
			serverStarted.setDate(new Date());
			serverStarted.setAccessMethod(AccessMethod.INTERNAL);
			serverStarted.setExecutor(null);
			BimDatabaseSession session = bimDatabase.createSession();
			try {
				session.store(serverStarted, new CommitSet(Database.STORE_PROJECT_ID, -1));
				session.saveOidCounter();
				session.commit();
			} finally {
				session.close();
			}
		} catch (Exception e) {
			ServerInfo.setErrorMessage(e.getMessage());
			LOGGER.error("", e);
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
			e.printStackTrace();
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
			String string = new String(buffer, 0, red, "UTF-8");
			inputStream.close();
			return string;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String readFile(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[100];
			int red = fis.read(buffer);
			String string = new String(buffer, 0, red, "UTF-8");
			fis.close();
			return string;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ResourceFetcher createResourceFetcher(ServerType serverType, final ServletContext servletContext) {
		switch (serverType) {
		case DEV_ENVIRONMENT:
			return new LocalDevelopmentResourceFetcher();
		case DEPLOYED_WAR:
			return new WarResourceFetcher(servletContext);
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
}