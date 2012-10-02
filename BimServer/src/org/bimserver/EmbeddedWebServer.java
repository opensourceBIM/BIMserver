package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import org.bimserver.servlets.SyndicationServlet;
import org.bimserver.servlets.WebServiceServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.server.session.HashSessionIdManager;
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
		SelectChannelConnector socketConnector = new SelectChannelConnector();
		socketConnector.setPort(bimServer.getConfig().getPort());
		server.addConnector(socketConnector);
		context = new WebAppContext(server, "", "/");
		context.addServlet(WebServiceServlet.class.getName(), "/soap/*");
//		ServletHolder restServletHolder = context.addServlet(RestServlet.class.getName(), "/rest/*");
//		restServletHolder.setInitParameter("javax.ws.rs.Application", "willbeoverridden");
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

	public void shutdown() {
		try {
			server.stop();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}