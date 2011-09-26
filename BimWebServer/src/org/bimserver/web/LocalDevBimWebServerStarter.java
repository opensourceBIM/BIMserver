package org.bimserver.web;

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

import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
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

	 	LoginManager.bimServerClientFactory = new BimServerClientFactory() {
			@Override
			public BimServerClient create() {
				return new BimServerClient();
			}
		};
	 	
	 	LOGGER.info("Starting BIMWebServer");
	 	
		server = new org.eclipse.jetty.server.Server();
		HashSessionIdManager hashSessionIdManager = new HashSessionIdManager(new Random());
		server.setSessionIdManager(hashSessionIdManager);
		SocketConnector socketConnector = new SocketConnector();
		socketConnector.setPort(port);
		socketConnector.setHost(address);
		server.addConnector(socketConnector);

		LoginManager.bimServerClientFactory = new BimServerClientFactory() {
			@Override
			public BimServerClient create() {
				return new BimServerClient();
			}
		};
		
		WebAppContext context = new WebAppContext(server, "", "/");
		context.setResourceBase(resourceBase);

		try {
			server.start();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		LOGGER.info("BIMWebServer started successfully, click on the \"launch webbrowser\" button, or go to: http://" + address + ":" + port);
	}
}