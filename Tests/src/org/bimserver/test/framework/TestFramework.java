package org.bimserver.test.framework;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.EmbeddedWebServer;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.models.store.ServerState;
import org.bimserver.plugins.PluginManager;
import org.bimserver.servlets.StreamingServlet;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestFramework {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestFramework.class);
	
	private final Set<VirtualUser> virtualUsers = new HashSet<VirtualUser>();
	private final TestConfiguration testConfiguration;
	private final TestResults testResults = new TestResults();
	private BimServer bimServer;

	private File[] pluginDirectories;

	public TestFramework(TestConfiguration testConfiguration, File[] pluginDirectories) {
		this.testConfiguration = testConfiguration;
		this.pluginDirectories = pluginDirectories;
	}
	
	public void start() {
		if (testConfiguration.isStartEmbeddedBimServer()) {
			if (testConfiguration.isCleanEnvironmentFirst()) {
				try {
					if (testConfiguration.getHomeDir().isDirectory()) {
						FileUtils.forceDelete(testConfiguration.getHomeDir());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			BimServerConfig bimServerConfig = new BimServerConfig();
			bimServerConfig.setStartEmbeddedWebServer(true);
			bimServerConfig.setHomeDir(testConfiguration.getHomeDir());
			bimServerConfig.setPort(8080);
			bimServerConfig.setResourceFetcher(new LocalDevelopmentResourceFetcher(new File("../")));
			bimServerConfig.setClassPath(System.getProperty("java.class.path"));
			bimServerConfig.setInitialProtocolBuffersPort(8020);
			bimServer = new BimServer(bimServerConfig);
			EmbeddedWebServer embeddedWebServer = bimServer.getEmbeddedWebServer();
		 	embeddedWebServer.getContext().addServlet(StreamingServlet.class, "/stream/*");
			try {
				LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), new File(".."), pluginDirectories);
				bimServer.start();
				// Convenience, setup the server to make sure it is in RUNNING state
				if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
					bimServer.getService(AdminInterface.class).setup("http://localhost", "localhost", "no-reply@bimserver.org", "Administrator", "admin@bimserver.org", "admin");
					bimServer.getService(SettingsInterface.class).setGenerateGeometryOnCheckin(false);
					bimServer.getService(SettingsInterface.class).setSendConfirmationEmailAfterRegistration(false);
				}
				
				// Change a setting so normal users can create projects
				bimServer.getService(SettingsInterface.class).setAllowUsersToCreateTopLevelProjects(true);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		if (!testConfiguration.getOutputFolder().exists()) {
			testConfiguration.getOutputFolder().mkdir();
		}
		VirtualUserFactory virtualUserFactory = new VirtualUserFactory(this, testConfiguration.getBimServerClientFactory());
		for (int i=0; i<testConfiguration.getNrVirtualUsers(); i++) {
			VirtualUser virtualUser = virtualUserFactory.create("Virtual User " + i);
			virtualUsers.add(virtualUser);
		}
		for (VirtualUser virtualUser : virtualUsers) {
			virtualUser.start();
		}
		org.bimserver.CommandLine commandLine = new org.bimserver.CommandLine(bimServer);
		commandLine.start();
	}

	public synchronized File getTestFile() {
		return testConfiguration.getTestFileProvider().getNewFile();
	}

	public synchronized void unsubsribe(VirtualUser virtualUser) {
		virtualUsers.remove(virtualUser);
		if (virtualUsers.isEmpty() && testConfiguration.isStopNoVirtualUsers()) {
			if (testConfiguration.isStartEmbeddedBimServer()) {
				bimServer.stop();
			}
		}
	}

	public TestConfiguration getTestConfiguration() {
		return testConfiguration;
	}

	public void stop() {
		for (VirtualUser virtualUser : virtualUsers) {
			virtualUser.shutdown();
		}
		if (testConfiguration.isStartEmbeddedBimServer()) {
			bimServer.stop();
		}
	}

	public void standby() {
		for (VirtualUser virtualUser : virtualUsers) {
			virtualUser.shutdown();
		}
	}

	public TestResults getResults() {
		return testResults;
	}

	public PluginManager getPluginManager() {
		return bimServer.getPluginManager();
	}
}