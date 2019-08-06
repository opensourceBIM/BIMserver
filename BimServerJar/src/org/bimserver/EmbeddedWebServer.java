package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.nio.file.Paths;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.websocket.DeploymentException;
import javax.websocket.Session;

import org.bimserver.servlets.RootServlet;
import org.bimserver.servlets.websockets.jsr356.AdditionalWebSocketConfigurator;
import org.bimserver.servlets.websockets.jsr356.Jsr356Impl;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.jsr356.JsrSession;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbeddedWebServer implements EmbeddedWebServerInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedWebServer.class);
	private WebAppContext context;
	private Server server;

	@SuppressWarnings("unchecked")
	public EmbeddedWebServer(BimServer bimServer, String resourceBase, boolean localDev) {
		server = new Server(new QueuedThreadPool(200, 20));

		ServerConnector socketConnector = new ServerConnector(server);
		socketConnector.setPort(bimServer.getConfig().getPort());
		socketConnector.setIdleTimeout(10800000); // 3 hours for bulkcheckin
		socketConnector.setStopTimeout(10800000); // 3 hours for bulkcheckin
		server.addConnector(socketConnector);
		context = new WebAppContext(server, "", "/");
		context.setTempDirectory(bimServer.getHomeDir().resolve("jettytmp").toFile());

		try {
			org.eclipse.jetty.websocket.jsr356.server.ServerContainer configureContext = WebSocketServerContainerInitializer.configureContext(context);
			
			// TODO this speeds up local loading, but for remote loading it's probably faster to enable permessage-deflate
			configureContext.getWebSocketServerFactory().getExtensionFactory().unregister("permessage-deflate");
			
			Jsr356Impl.setServletContext(configureContext, context.getServletContext());
			Jsr356Impl.setAdditionalWebSocketConfigurator(new AdditionalWebSocketConfigurator() {
				@Override
				public void configure(Session websocketSession) {
					JsrSession jsrSession = (JsrSession)websocketSession;
					WebSocketPolicy policy = jsrSession.getPolicy();
					
					websocketSession.setMaxTextMessageBufferSize(1024 * 1024 * 64);
					websocketSession.setMaxBinaryMessageBufferSize(1024 * 1024 * 512);
					
					policy.setMaxTextMessageSize(1024 * 1024 * 64);
				}
			});
			configureContext.addEndpoint(Jsr356Impl.class);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (DeploymentException e) {
			e.printStackTrace();
		}
		
		if (localDev) {
			// TODO document why
//			context.setDefaultsDescriptor("../BimServer/www/WEB-INF/webdefault.xml");
		}
		
		ServletHolder servletHolder = new ServletHolder(new RootServlet());
		context.addServlet(servletHolder, "/*");
		
		try {
			// Only if the Jolokia agent is available (JAR is on the classpath) the servlet will be mapped, if the class is not found, no errors are logged
			context.addServlet((Class<? extends Servlet>) Class.forName("org.jolokia.http.AgentServlet"), "/jolokia/*");
			LOGGER.info("Jolokia agent listening on /jolokia");
		} catch (Throwable e) {
		}
		
		context.getServletContext().setAttribute("bimserver", bimServer);
		if (context.getResourceBase() == null) {
			if (resourceBase == null) {
				context.setResourceBase(Paths.get("www").toAbsolutePath().toString());
			} else {
				context.setResourceBase(resourceBase);
			}
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

	@Override
	public void setResourceBase(String resourceBase) {
		getContext().setResourceBase(resourceBase);
	}
}