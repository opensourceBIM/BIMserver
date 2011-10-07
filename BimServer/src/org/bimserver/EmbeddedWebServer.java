package org.bimserver;

import java.util.Random;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbeddedWebServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedWebServer.class);

	public void start() {
		Server server = new Server();
		HashSessionIdManager hashSessionIdManager = new HashSessionIdManager(new Random());
		server.setSessionIdManager(hashSessionIdManager);
		SocketConnector socketConnector = new SocketConnector();
		socketConnector.setPort(8080);
		socketConnector.setHost("localhost");
		server.addConnector(socketConnector);
		WebAppContext context = new WebAppContext(server, "", "/");
		context.setResourceBase("www");
		context.getServletContext().setAttribute("bimserver", this);
		try {
			server.start();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}