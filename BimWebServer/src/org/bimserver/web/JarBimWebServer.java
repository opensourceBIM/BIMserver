package org.bimserver.web;

import java.io.File;
import java.util.Random;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.plugins.PluginException;
import org.bimserver.resources.JarResourceFetcher;
import org.bimserver.shared.ServerException;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JarBimWebServer {
	private org.eclipse.jetty.server.Server server;
	private static final Logger LOGGER = LoggerFactory.getLogger(JarBimWebServer.class);

	public static void main(String[] args) {
		String address = "127.0.0.1";
		String port = "8082";
		String homedir = "home";
		for (String arg : args) {
			if (arg.startsWith("address=")) {
				address = arg.substring(8);
			} else if (arg.startsWith("port=")) {
				port = arg.substring(5);
			} else if (arg.startsWith("homedir=")) {
				homedir = arg.substring(8);
			}
		}
		final JarBimWebServer server = new JarBimWebServer();
		server.start(address, Integer.parseInt(port), homedir, "www");
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

	public void start(String address, int port, String homedir, String resourceBase) {
		System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");
		BimServer bimServer = new BimServer(new File(homedir), new JarResourceFetcher());
	 	try {
			bimServer.getPluginManager().loadAllPluginsFromDirectoryOfJars(new File("plugins"));
			bimServer.start();
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (DatabaseInitException e) {
			LOGGER.error("", e);
		} catch (BimDatabaseException e) {
			LOGGER.error("", e);
		} catch (DatabaseRestartRequiredException e) {
			LOGGER.error("", e);
		}
		
		server = new org.eclipse.jetty.server.Server();
		HashSessionIdManager hashSessionIdManager = new HashSessionIdManager(new Random());
		server.setSessionIdManager(hashSessionIdManager);
		SocketConnector socketConnector = new SocketConnector();
		socketConnector.setPort(port);
		socketConnector.setHost(address);
		server.addConnector(socketConnector);

		WebAppContext context = new WebAppContext(server, "", "/");
		context.setAttribute("bimserver", bimServer);
		context.setResourceBase(resourceBase);

		try {
			server.start();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		LOGGER.info("Server started successfully, click on the \"launch webbrowser\" button, or go to: http://" + address + ":" + port);
	}
}