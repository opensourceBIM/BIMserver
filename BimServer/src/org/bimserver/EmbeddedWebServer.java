package org.bimserver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbeddedWebServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedWebServer.class);
	private WebAppContext context;
	private Server server;

	public EmbeddedWebServer(BimServer bimServer, boolean localDev) {
		server = new Server();
//		Disabled 26-04-2015, I am pretty sure we don't use session anymore at all
//		HashSessionIdManager hashSessionIdManager = new HashSessionIdManager(new Random()); // Should be SecureRandom, but this makes startup slow on certain systems
//		server.setSessionIdManager(hashSessionIdManager);
		ServerConnector socketConnector = new ServerConnector(server);
		socketConnector.setPort(bimServer.getConfig().getPort());
		server.addConnector(socketConnector);
		context = new WebAppContext(server, "", "/");
		context.setTempDirectory(bimServer.getHomeDir().resolve("jettytmp").toFile());
		if (localDev) {
			// TODO document why
			context.setDefaultsDescriptor("www/WEB-INF/webdefault.xml");
		}
		context.getServletContext().setAttribute("bimserver", bimServer);
		if (context.getResourceBase() == null) {
			context.setResourceBase("../BimServer/www");
		}
	}
	
	public void start() {
		try {
			server.start();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	public WebAppContext getContext() {
		return context;
	}

	public void shutdown() {
		try {
			server.stop();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}