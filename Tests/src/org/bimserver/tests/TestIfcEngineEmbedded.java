package org.bimserver.tests;

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
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.store.ServerState;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.utils.PathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestIfcEngineEmbedded {
	
	
	// The name of the IfcEnginePlugin to use, if an IfcEnginePlugin with this
	// name is not found in the list of all IfcEngines an exception is thrown.		
	private static final String RENDER_ENGINE = "org.ifcopenshell.IfcOpenShellEnginePlugin";
	// private static final String RENDER_ENGINE = "org.bimserver.ifcengine.TNOJvmIfcEnginePlugin";
	
	private static final String[] TEST_FILES = {"06-03-01_windows_in_curved_wall_vw.ifc", 
												"AC11-Institute-Var-2-IFC.ifc", 
												"AC90R1-Jasmin-Sun-105-2x3.ifc"};

	private static final boolean WIPE_HOMEDIR = true;
	
	
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestIfcEngineEmbedded.class);
	
	private static class AddProjectCheckinDownloadAction implements Runnable {
		private BimServer bimServer;
		private String filename;
		private Exception exception;
		
		public AddProjectCheckinDownloadAction(BimServer bimServer, String filename) {
			this.bimServer = bimServer;
			this.filename = filename;
			this.exception = null;
		}
		
		public void verify() throws Exception {
			if (exception != null) throw exception;
		}
		
		@Override
		public void run() {
			BimServerClientInterface client = null;
			try {
				// Get a client, not using any protocol (direct connection)
				client = bimServer.getBimServerClientFactory().create();
				// Authenticate
				client.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
				
				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", -1L);
				
				
				// Create a project
				SProject project = client.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
				
				// This is the test file
				Path testIfcFile = Paths.get("../TestData/data/" + filename);
				
				// Checkin the file
				client.checkinSync(project.getOid(), "testing ifc engine", deserializer.getOid(), false, testIfcFile);

				// Update local project
				project = client.getServiceInterface().getProjectByPoid(project.getOid());

				// Find collada serializer
				SSerializerPluginConfiguration serializer = client.getServiceInterface().getSerializerByContentType("application/collada");

				// Download as collada			
				client.download(project.getLastRevisionId(), serializer.getOid(), Paths.get(testIfcFile.getFileName().toString() + ".dae"));
			} catch (Exception e) {
				exception = e;
			} finally {
				if (client != null) {
					client.disconnect();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// Create a config
		BimServerConfig config = new BimServerConfig();
		Path home = Paths.get("home");
		
		// Remove the home dir if it's there
		if (WIPE_HOMEDIR) {
			try {
				PathUtils.removeDirectoryWithContent(home);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		config.setHomeDir(home);
		config.setStartEmbeddedWebServer(true);
		config.setPort(8080);
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher(Paths.get("../")));
		config.setClassPath(System.getProperty("java.class.path"));
		
		// Create a BIMserver
		BimServer bimServer = new BimServer(config);
		BimServerClientInterface client = null;
		try {
			// Load plugins
			Path[] pluginDirs = new Path[] {
				// TODO: Set these up yourself...
			};
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginBundleManager(), pluginDirs);
			
			// Start it
			bimServer.start();
			
			// Get a client, not using any protocol (direct connection)
			client = bimServer.getBimServerClientFactory().create();
			
			// Setup the server
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				client.getAdminInterface().setup("http://localhost:8080", "Administrator", "admin@bimserver.org", "admin", null, null, null);
			}			

			// Authenticate
			client.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Iterate over the IfcEngines and see if there is one matching the classname specified above
			boolean engineFound = false;
			for (SRenderEnginePluginConfiguration conf : client.getPluginInterface().getAllRenderEngines(false)) {
				SPluginDescriptor pluginDescriptor = client.getPluginInterface().getPluginDescriptor(conf.getPluginDescriptorId());
				if (RENDER_ENGINE.equals(pluginDescriptor.getPluginClassName())) {
					client.getPluginInterface().setDefaultRenderEngine(conf.getOid());
					engineFound = true;
					LOGGER.info("Using " + conf.getName());
					break;
				}
			}
			
			if (!engineFound) {
				throw new RenderEngineException("No IfcEnginePlugin found with name " + RENDER_ENGINE);
			}
			
			// Get a deserializer
			SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", -1L);
			if (deserializer == null) {
				throw new Exception("No deserializer found for IFC-SPF. Make sure plugin directories are correctly configured");
			}
			
			Thread[] threads = new Thread[TEST_FILES.length];
			AddProjectCheckinDownloadAction[] contexts = new AddProjectCheckinDownloadAction[TEST_FILES.length];
			
			for (int i = 0; i < TEST_FILES.length; ++i) {
				(threads[i] = new Thread(contexts[i] = new AddProjectCheckinDownloadAction(bimServer, TEST_FILES[i]))).start();
			}
			
			for (int i = 0; i < TEST_FILES.length; ++i) {
				threads[i].join();
			}
			
			for (int i = 0; i < TEST_FILES.length; ++i) {
				contexts[i].verify();
			}			
			
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			
			System.exit(1);
		} finally {
			try {
				client.disconnect();
			} catch (Throwable t) {}
			try {
				bimServer.stop();
			} catch (Throwable t) {}
		}
	}
}