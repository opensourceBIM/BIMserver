package org.bimserver;

import java.util.Random;

import org.bimserver.servlets.RestServlet;
import org.bimserver.servlets.SyndicationServlet;
import org.bimserver.servlets.WebServiceServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.server.session.HashSessionIdManager;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbeddedWebServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedWebServer.class);
	private WebAppContext context;
	private Server server;

	public EmbeddedWebServer(BimServer bimServer) {
		server = new Server();
		HashSessionIdManager hashSessionIdManager = new HashSessionIdManager(new Random());
		server.setSessionIdManager(hashSessionIdManager);
		SocketConnector socketConnector = new SocketConnector();
		socketConnector.setPort(bimServer.getConfig().getPort());
		server.addConnector(socketConnector);
		context = new WebAppContext(server, "", "/");
		context.addServlet(WebServiceServlet.class.getName(), "/soap/*");
		ServletHolder restServletHolder = context.addServlet(RestServlet.class.getName(), "/rest/*");
		restServletHolder.setInitParameter("javax.ws.rs.Application", "willbeoverridden");
		context.addServlet(SyndicationServlet.class.getName(), "/syndication/*");
		context.getServletContext().setAttribute("bimserver", bimServer);
	}
	
	public void start() {
		if (context.getResourceBase() == null) {
			context.setResourceBase("../BimServer/www");
		}
		try {
			server.start();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	public WebAppContext getContext() {
		return context;
	}
}