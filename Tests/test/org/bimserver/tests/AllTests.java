package org.bimserver.tests;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.tests.emf.CreateGuid;
import org.bimserver.tests.emf.DeleteObjects;
import org.bimserver.tests.emf.ListWalls;
import org.bimserver.tests.emf.LoadCompleteModel;
import org.bimserver.tests.emf.ReadTrim;
import org.bimserver.tests.emf.RemoveReferenceList;
import org.bimserver.tests.lowlevel.AddReferenceWithOpposite;
import org.bimserver.tests.lowlevel.AddReferenceWithOppositeExisting;
import org.bimserver.tests.lowlevel.CreateLists;
import org.bimserver.tests.lowlevel.CreateReferenceListsAndClear;
import org.bimserver.tests.lowlevel.CreateUnknownType;
import org.bimserver.tests.lowlevel.GetDataObjectsByType;
import org.bimserver.tests.lowlevel.IfcMeasureWithUnit;
import org.bimserver.tests.lowlevel.RemoveObject;
import org.bimserver.tests.lowlevel.RemoveObject2;
import org.bimserver.tests.lowlevel.RemoveReferenceWithOpposite;
import org.bimserver.tests.lowlevel.SetReferenceWithOpposite;
import org.bimserver.tests.lowlevel.UnsetReference;
import org.bimserver.tests.lowlevel.UnsetReferenceWithOpposite;
import org.bimserver.tests.serviceinterface.MultiCheckinAndDownload;
import org.bimserver.tests.serviceinterface.SingleCheckinAndDownload;
import org.bimserver.tests.serviceinterface.UpdateProject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
		AddReferenceWithOpposite.class,
		AddReferenceWithOppositeExisting.class,
        CreateGuid.class,
        CreateLists.class,
        CreateReferenceListsAndClear.class,
        CreateUnknownType.class,
        GetDataObjectsByType.class,
        IfcMeasureWithUnit.class,
        RemoveObject.class,
        RemoveObject2.class,
        RemoveReferenceWithOpposite.class,
        SetReferenceWithOpposite.class,
        UnsetReference.class,
        UnsetReferenceWithOpposite.class,
        DeleteObjects.class,
        ListWalls.class,
        LoadCompleteModel.class,
        MultiCheckinAndDownload.class,
        ReadTrim.class,
        SingleCheckinAndDownload.class,
        RemoveReferenceList.class,
        UpdateProject.class})
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
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher(new File("../")));
		config.setClassPath(System.getProperty("java.class.path"));
		
		bimServer = new BimServer(config);
		try {
			// CHANGE THESE TO MATCH YOUR CONFIGURATION
			File[] pluginDirectories = new File[]{new File("E:\\Git"), new File("E:\\Workspaces\\BIMserver")};
			
			
			// Load plugins
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), new File(".."), pluginDirectories);

			// Start it
			bimServer.start();
			
			// Get a client, not using any protocol (direct connection)
			BimServerClientInterface client = bimServer.getBimServerClientFactory().create();

			// Setup the server
			client.getAdminInterface().setup("http://localhost:8080", "localhost", "noreply@bimserver.org", "Administrator", "admin@bimserver.org", "admin");
			
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
//			factory = new ProtocolBuffersBimServerClientFactory("localhost", 8020, 8080);
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