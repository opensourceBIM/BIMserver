package org.bimserver.tests;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.EmbeddedWebServer;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.utils.PathUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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
		Path home = Paths.get("home-" + new Random().nextInt(1000000000));
		
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
			bimServer.setEmbeddedWebServer(new EmbeddedWebServer(bimServer, Paths.get("."), false));
			
			// CHANGE THESE TO MATCH YOUR CONFIGURATION
//			Path[] pluginDirectories = new Path[]{Paths.get("C:\\Git\\IfcPlugins\\IfcPlugins"), Paths.get("C:\\Git\\IfcOpenShell-BIMserver-plugin")};
			
			// Start it
			bimServer.start();

			// Load plugins
//			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);

			// Get a client, not using any protocol (direct connection)
			BimServerClientInterface client = bimServer.getBimServerClientFactory().create();

			// Setup the server
			client.getAdminInterface().setup("http://localhost:8080", "Test Name", "Test Description", "noicon", "Administrator", "admin@bimserver.org", "admin");
		
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
				LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), paths);
			} else {
				client.getPluginInterface().installPluginBundle("~/.m2/repository", "org.opensourcebim", "ifcplugins", null, null);
//				client.getPluginInterface().installPluginBundle("~/.m2/repository", "org.opensourcebim", "binaryserializers", null, null);
				client.getPluginInterface().installPluginBundle("~/.m2/repository", "org.opensourcebim", "ifcopenshellplugin", null, null);
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
		System.out.println(bimServerClientFactory);
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