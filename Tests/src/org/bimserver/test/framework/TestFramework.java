package org.bimserver.test.framework;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.models.store.ServerState;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.tests.TestFile;
import org.bimserver.tests.TestFileConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestFramework {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestFramework.class);
	
	private static final int NR_VIRTUAL_USERS = 1;
	private static final int NR_RUNS_PER_VIRTUAL_USER = 1;
	private static final File IFC_FILES_FOLDER = new File("../TestData/data");
	private static final boolean START_EMBEDDED_BIMSERVER = true;
	private static final boolean STOP_ON_EXCEPTION = true;
	
	private final List<File> files = new ArrayList<File>();
	private final Set<VirtualUser> virtualUsers = new HashSet<VirtualUser>();
	private final Random random = new Random();
	
	public static void main(String[] args) {
		new TestFramework().start();
	}

	private void start() {
		if (START_EMBEDDED_BIMSERVER) {
			BimServerConfig bimServerConfig = new BimServerConfig();
			bimServerConfig.setStartEmbeddedWebServer(true);
			bimServerConfig.setHomeDir(new File("home"));
			bimServerConfig.setPort(8080);
			bimServerConfig.setResourceFetcher(new LocalDevelopmentResourceFetcher());
			BimServer bimServer = new BimServer(bimServerConfig);
			try {
				LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager());
				bimServer.start();
				// Convenience, setup the server to make sure it is in RUNNING state
				if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
					bimServer.getSystemService().setup("http://localhost", "localhost", "Administrator", "admin@bimserver.org", "admin");
				}
				
				// Change a setting to normal users can create projects
				bimServer.getSettingsManager().getSettings().setAllowUsersToCreateTopLevelProjects(true);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		files.add(TestFile.AC11.getFile());
//		initFiles();
		RandomBimServerClientFactory randomBimServerClientFactory = new RandomBimServerClientFactory(Type.PROTOCOL_BUFFERS);
		VirtualUserFactory virtualUserFactory = new VirtualUserFactory(this, randomBimServerClientFactory);
		for (int i=0; i<NR_VIRTUAL_USERS; i++) {
			VirtualUser virtualUser = virtualUserFactory.create("" + i);
			virtualUser.setStopOnException(STOP_ON_EXCEPTION);
			virtualUser.setNrRuns(NR_RUNS_PER_VIRTUAL_USER);
			virtualUsers.add(virtualUser);
		}
		for (VirtualUser virtualUser : virtualUsers) {
			virtualUser.start();
		}
	}

	private void initFiles() {
		for (File file : IFC_FILES_FOLDER.listFiles()) {
			if (file.isFile() && !file.getName().contains(".svn")) {
				files.add(file);
			}
		}
	}

	public synchronized File getRandomFile() {
		return files.get(random.nextInt(files.size()));
	}

	public synchronized void unsubsribe(VirtualUser virtualUser) {
		virtualUsers.remove(virtualUser);
	}
}