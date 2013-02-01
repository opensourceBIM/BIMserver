package org.bimserver.tests;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.LocalVersionConstructor;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.JsonBimServerClientFactory;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestCreateGuidEmf.class,
        TestCreateGuidLowLevelCalls.class,
        TestLoadCompleteModel.class,
        TestMultiCheckinAndDownload.class,
        TestReadTrim.class,
        TestDeleteObjectsEmf.class,
        TestSingleCheckinAndDownload.class})
public class AllTests {
	public static BimServer bimServer;
	public static boolean running = false;
	private static BimServerClientFactory factory;

	@BeforeClass
	public static void beforeClass() {
		running = true;
		setup();
	}

	private static void setup() {
		// Create a config
		BimServerConfig config = new BimServerConfig();
		File home = new File("home");
		
		// Remove the home dir if it's there
		if (home.exists()) {
			try {
				FileUtils.deleteDirectory(home);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		config.setHomeDir(home);
		config.setStartEmbeddedWebServer(true);
		config.setPort(8080);
		config.setInitialProtocolBuffersPort(8020);
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher());
		config.setClassPath(System.getProperty("java.class.path"));
		
		bimServer = new BimServer(config);
		LocalVersionConstructor.augmentWithSvn(bimServer.getVersionChecker().getLocalVersion());
		try {
			// Load plugins
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager());

			// Start it
			bimServer.start();
			
			// Get a client, not using any protocol (direct connection)
			BimServerClient client = bimServer.getBimServerClientFactory().create();

			// Setup the server
			client.getServiceInterface().setup("http://localhost:8080", "localhost", "noreply@bimserver.org", "Administrator", "admin@bimserver.org", "admin");
			
			client.disconnect();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@AfterClass
	public static void afterClass() {
		bimServer.stop();
		running = false;
	}

	public static BimServerClientFactory getFactory() {
		if (factory == null) {
			factory = new JsonBimServerClientFactory("http://localhost:8080");
		}
		return factory;
	}
	
	public static BimServer getBimServer() {
		if (bimServer == null) {
			setup();
		}
		return bimServer;
	}
}