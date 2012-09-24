package org.bimwebserver.jsp;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.plugins.PluginManager;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDevBimWebServerStarter {
	private org.eclipse.jetty.server.Server server;
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevBimWebServerStarter.class);

	public static void main(String[] args) {
		final LocalDevBimWebServerStarter server = new LocalDevBimWebServerStarter();
		server.start("localhost", 80, "www");
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

	public void start(String address, int port, String resourceBase) {
		System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");

	 	LOGGER.info("Starting BIMWebServer");
	 	
		server = new org.eclipse.jetty.server.Server();
		HashSessionIdManager hashSessionIdManager = new HashSessionIdManager(new Random());
		server.setSessionIdManager(hashSessionIdManager);
		SocketConnector socketConnector = new SocketConnector();
		socketConnector.setPort(port);
		socketConnector.setHost(address);
		server.addConnector(socketConnector);

		final PluginManager pluginManager = new PluginManager(new File("tmp"), null, null, null);
		
		LoginManager.bimServerClientFactory = new BimServerClientFactory() {
			@Override
			public BimServerClient create(AuthenticationInfo authenticationInfo, String remoteAddress) {
				BimServerClient bimServerClient = new BimServerClient(pluginManager);
				bimServerClient.setAuthentication(authenticationInfo);
				try {
					bimServerClient.connectSoap("http://localhost:8080/soap", false);
				} catch (ConnectionException e) {
					e.printStackTrace();
				}
				return bimServerClient;
			}
		};
		
		WebAppContext context = new WebAppContext(server, "", "/");
		context.setResourceBase(resourceBase);

		try {
			server.start();
			LOGGER.info("BIMWebServer started successfully, click on the \"launch webbrowser\" button, or go to: http://" + address + ":" + port);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}