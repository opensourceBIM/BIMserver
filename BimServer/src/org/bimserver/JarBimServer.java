package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.plugins.PluginException;
import org.bimserver.resources.JarResourceFetcher;
import org.bimserver.shared.exceptions.ServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JarBimServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JarBimServer.class);
	private BimServer bimServer;

	public static void main(String[] args) {
		String address = "127.0.0.1";
		String port = "8082";
		String homedir = "home";
		for (String arg : args) {
			if (arg.startsWith("address=")) {
				address = arg.substring(8);
				if (address.startsWith("\"") && address.endsWith("\"")) {
					address = address.substring(1, address.length() - 1);
				}
			} else if (arg.startsWith("port=")) {
				port = arg.substring(5);
				if (port.startsWith("\"") && port.endsWith("\"")) {
					port = port.substring(1, port.length() - 1);
				}
			} else if (arg.startsWith("homedir=")) {
				homedir = arg.substring(8);
				if (homedir.startsWith("\"") && homedir.endsWith("\"")) {
					homedir = homedir.substring(1, homedir.length() - 1);
				}
			}
		}
		final JarBimServer server = new JarBimServer();
		server.start(address, Integer.parseInt(port), homedir, "www");
	}

	public void stop() {
		LOGGER.info("Stopping server...");
		try {
			bimServer.stop();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		LOGGER.info("Server stopped successfully");
	}

	public void start(String address, int port, String homedir, String resourceBase) {
		// Strange hack needed for OSX
		if (homedir.startsWith("\"") && homedir.endsWith("\"")) {
			homedir = homedir.substring(1, homedir.length()-2);
		}
		System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");
		BimServerConfig bimServerConfig = new BimServerConfig();
		bimServerConfig.setHomeDir(new File(homedir));
		bimServerConfig.setResourceFetcher(new JarResourceFetcher());
		bimServerConfig.setStartEmbeddedWebServer(true);
		bimServerConfig.setPort(port);
		bimServerConfig.setClassPath(System.getProperty("java.class.path"));
		bimServer = new BimServer(bimServerConfig);
	 	try {
	 		bimServer.getEmbeddedWebServer().getContext().setResourceBase("www");
	 		bimServer.getPluginManager().loadAllPluginsFromDirectoryOfJars(new File("plugins"));
			bimServer.start();
			LOGGER.info("Server started successfully");
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (DatabaseInitException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (DatabaseRestartRequiredException e) {
			LOGGER.error("", e);
		}
	}
}