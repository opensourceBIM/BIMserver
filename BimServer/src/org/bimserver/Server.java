package org.bimserver;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Random;

import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
	private org.eclipse.jetty.server.Server server;
	private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

	public static void main(String[] args) {
		String address = "localhost";
		String port = "8082";
		for (String arg : args) {
			if (arg.startsWith("address=")) {
				address = arg.substring(8);
			} else if (arg.startsWith("port=")) {
				port = arg.substring(5);
			}
		}
		final Server server = new Server();
		server.start(address, Integer.parseInt(port));
		// The CommandLine seems to disrupt the database initialization process
		CommandLine commandLine = new CommandLine(server);
		commandLine.start();
	}

	protected void stop() {
		LOGGER.info("Stopping server...");
		try {
			server.stop();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		LOGGER.info("Server stopped successfully");
	}

	public void start(String address, int port) {
		LOGGER.info("Starting server..." + address + " " + port);
		System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");
		server = new org.eclipse.jetty.server.Server();
		HashSessionIdManager hashSessionIdManager = new HashSessionIdManager(new Random());
		server.setSessionIdManager(hashSessionIdManager);
		SocketConnector socketConnector = new SocketConnector();
		socketConnector.setPort(port);
		socketConnector.setHost(address);
		server.addConnector(socketConnector);

		WebAppContext context = new WebAppContext(server, "", "/");
		context.setResourceBase("www");

		try {
			LOGGER.info("Starting web server...");
			server.start();
			LOGGER.info("Webserver successfully started");
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		LOGGER.info("Server started successfully, click on the \"launch webbrowser\" button, or go to: http://" + address + ":" + port);
	}
}