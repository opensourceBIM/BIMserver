package org.bimserver.test;

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

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.EmbeddedWebServer;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.DirectBimServerClientFactory;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.utils.PathUtils;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.LoggerFactory;
public class AllTests {
	public static BimServer bimServer;
	public static boolean running = false;

	@BeforeClass
	public static void beforeClass() {
		running = true;
		setup();
	}

	private static void setup() {
		// Create a config
		Path home = Paths.get("tmptestdata/home-" + new Random().nextInt(1000000000));
		
		// Remove the home dir if it's there
		if (Files.exists(home)) {
			try {
				PathUtils.removeDirectoryWithContent(home);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		BimServerConfig config = new BimServerConfig();
		config.setHomeDir(home);
		config.setStartEmbeddedWebServer(true);
		config.setPort(7010);
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher(Paths.get("../")));
		config.setClassPath(System.getProperty("java.class.path"));
		
		bimServer = new BimServer(config);
		try {
			bimServer.setEmbeddedWebServer(new EmbeddedWebServer(bimServer, null, false));
			
			// CHANGE THESE TO MATCH YOUR CONFIGURATION
//			Path[] pluginDirectories = new Path[]{Paths.get("C:\\Git\\IfcPlugins\\IfcPlugins"), Paths.get("C:\\Git\\IfcOpenShell-BIMserver-plugin")};
			
			// Start it
			bimServer.start();

			// Load plugins
//			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);

			// Get a client, not using any protocol (direct connection)
			BimServerClientInterface client = bimServer.getBimServerClientFactory().create();

			// Setup the server
			client.getAdminInterface().setup("http://localhost:7010", "Test Name", "Test Description", "noicon", "Administrator", "admin@bimserver.org", "admin");
			ServiceMap serviceMap = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL);
			serviceMap.getSettingsInterface().setCacheOutputFiles(false);
			
			((DirectBimServerClientFactory)bimServer.getBimServerClientFactory()).setBaseAddress("http://localhost:7010");
		
			client.disconnect();
			
			client = bimServer.getBimServerClientFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			String pluginsString = System.getProperty("plugins");
			if (pluginsString != null) {
				String[] plugins = pluginsString.split(";");
				Path[] paths = new Path[plugins.length];
				int i=0;
				for (String p : plugins) {
					paths[i++] = Paths.get(p);
				}
				LocalDevPluginLoader.loadPlugins(bimServer.getPluginBundleManager(), paths);
			} else {
				LoggerFactory.getLogger(AllTests.class).info("Installing plugins");
				client.getPluginInterface().installPluginBundle("https://repo1.maven.org/maven2/", "org.opensourcebim", "ifcplugins", null, null);
				client.getPluginInterface().installPluginBundle("https://repo1.maven.org/maven2/", "org.opensourcebim", "binaryserializers", null, null);
				client.getPluginInterface().installPluginBundle("https://repo1.maven.org/maven2/", "org.opensourcebim", "ifcopenshellplugin", null, null);
			}

			client.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@AfterClass
	public static void afterClass() {
		resetBimServer();
	}

	public static BimServerClientFactory getFactory() {
		if (bimServer == null) {
			setup();
		}
		BimServerClientFactory bimServerClientFactory = bimServer.getBimServerClientFactory();
		return bimServerClientFactory;
	}
	
	public static BimServer getBimServer() {
		if (bimServer == null) {
			setup();
		}
		return bimServer;
	}

	public static void resetBimServer() {
		try {
			if (bimServer != null) {
				bimServer.stop();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				bimServer = null;
				running = false;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}