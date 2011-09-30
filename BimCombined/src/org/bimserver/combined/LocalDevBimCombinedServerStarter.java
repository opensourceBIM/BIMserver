package org.bimserver.combined;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerState;
import org.bimserver.plugins.PluginException;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.web.LocalDevBimWebServerStarter;
import org.bimserver.web.LoginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDevBimCombinedServerStarter {
	private org.eclipse.jetty.server.Server server;
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevBimWebServerStarter.class);
	private BimServer bimServer;

	public static void main(String[] args) {
		new LocalDevBimCombinedServerStarter().start("localhost", 80);
	}

	public void stop() {
		LOGGER.info("Stopping server...");
		try {
			server.stop();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		LOGGER.info("Server stopped successfully");
	}

	public void start(String address, int port) {
		System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");
		BimServerConfig config = new BimServerConfig();
		config.setHomeDir(new File("home"));
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher());
		config.setStartEmbeddedWebServer(true);
		bimServer = new BimServer(config);
	 	try {
	 		LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager());
	 		bimServer.start();
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				bimServer.getSystemService().setup("http://localhost", "localhost", "Administrator", "admin@bimserver.org", "admin", true);
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			e.printStackTrace();
		}
	 	
	 	LocalDevBimWebServerStarter webServerStarter = new LocalDevBimWebServerStarter();
	 	webServerStarter.start(address, port, "../BimWebServer/www");
		
	 	LoginManager.bimServerClientFactory = new BimServerClientFactory() {
			@Override
			public BimServerClient create() {
				BimServerClient bimServerClient = new BimServerClient();
//				bimServerClient.connectProtocolBuffers("localhost", 8020);
				bimServerClient.connectDirect(bimServer.getServiceFactory().newService(AccessMethod.WEB_INTERFACE));
				return bimServerClient;
			}
		};
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}
}