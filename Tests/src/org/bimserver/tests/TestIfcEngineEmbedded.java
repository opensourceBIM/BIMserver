package org.bimserver.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.LocalVersionConstructor;
import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestIfcEngineEmbedded {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestIfcEngineEmbedded.class);
	
	
	public static void main(String[] args) {
		// The name of the IfcEnginePlugin to use, if an IfcEnginePlugin with this
		// name is not found in the list of all IfcEngines an exception is thrown.
		final String ifcEngineToUse = "org.ifcopenshell.IfcOpenShellEnginePlugin";
		// final String ifcEngineToUse = "org.bimserver.ifcengine.TNOJvmIfcEnginePlugin";
		
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
		
		// Create a BIMserver
		BimServer bimServer = new BimServer(config);
		LocalVersionConstructor.augmentWithSvn(bimServer.getVersionChecker().getLocalVersion());
		try {
			// Load plugins
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager());
			
			// Start it
			bimServer.start();
			
			// Get a client, not using any protocol (direct connection)
			BimServerClient client = bimServer.getBimServerClientFactory().create();

			// Setup the server
			client.getAdmin().setup("http://localhost:8080", "localhost", "noreply@bimserver.org", "Administrator", "admin@bimserver.org", "admin");
			
			// Authenticate
			client.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Iterate over the IfcEngines and see if there is one matching the classname specified above
			boolean ifcEngineFound = false;
			for (SRenderEnginePluginConfiguration conf : client.getPlugin().getAllRenderEngines(false)) {
				if (ifcEngineToUse.equals(conf.getClassName())) {
					client.getPlugin().setDefaultRenderEngine(conf.getOid());
					ifcEngineFound = true;
					LOGGER.info("Using " + conf.getName());
					break;
				}
			}
			
			if (!ifcEngineFound) {
				throw new RenderEngineException("No IfcEnginePlugin found with name " + ifcEngineToUse);
			}
			
			// Get a deserializer
			SDeserializerPluginConfiguration deserializer = client.getService().getSuggestedDeserializerForExtension("ifc");
						
			// Create a project
			SProject project = client.getService().addProject("test" + Math.random());

			// This is the test file
			File testIfcFile = new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc");

			// Checkin the file
			client.checkin(project.getOid(), "testing ifc engine", deserializer.getOid(), false, true, testIfcFile);

			// Update local project
			project = client.getService().getProjectByPoid(project.getOid());

			// Find collada serializer
			SSerializerPluginConfiguration serializer = client.getPlugin().getSerializerByContentType("application/collada");

			// Download as collada			
			client.download(project.getLastRevisionId(), serializer.getOid(), new File(testIfcFile.getName() + ".dae"));

			client.disconnect();
			bimServer.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}