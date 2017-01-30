package org.bimserver.tests;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.EmbeddedWebServer;
import org.bimserver.LocalDevPluginLoader;
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
import org.bimserver.tests.lowlevel.SetString;
import org.bimserver.tests.lowlevel.UnsetReference;
import org.bimserver.tests.lowlevel.UnsetReferenceWithOpposite;
import org.bimserver.tests.serviceinterface.MultiCheckinAndDownload;
import org.bimserver.tests.serviceinterface.SingleCheckinAndDownload;
import org.bimserver.tests.serviceinterface.UpdateProject;
import org.bimserver.utils.PathUtils;
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
        SetString.class,
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
		Path home = Paths.get("home");
		
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
			
			client.getPluginInterface().installPluginBundle("http://central.maven.org/maven2", "org.opensourcebim", "ifcplugins", null, null);
			client.getPluginInterface().installPluginBundle("http://central.maven.org/maven2", "org.opensourcebim", "binaryserializers", null, null);
			
			client.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
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
			factory = bimServer.getBimServerClientFactory();
//			factory = new JsonBimServerClientFactory(bimServer.getMetaDataManager(), "http://localhost:8080");
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