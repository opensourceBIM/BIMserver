package org.bimserver.combined;

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

import java.io.File;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.EmbeddedWebServer;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.LocalVersionConstructor;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerDescriptor;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginException;
import org.bimserver.servlets.JsonApiServlet;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimwebserver.BimWebServer;
import org.bimwebserver.jsp.LocalDevBimWebServerStarter;
import org.bimwebserver.jsp.LoginManager;
import org.bimwebserver.servlets.DownloadServlet;
import org.bimwebserver.servlets.ProgressServlet;
import org.bimwebserver.servlets.StreamingServlet;
import org.bimwebserver.servlets.UploadServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDevBimCombinedServerStarter {
	private org.eclipse.jetty.server.Server server;
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDevBimWebServerStarter.class);
	private BimServer bimServer;

	public static void main(String[] args) {
		new LocalDevBimCombinedServerStarter().start("localhost", 8080);
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

	public void start(String address, int port) {
		System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");
		BimServerConfig config = new BimServerConfig();
		config.setHomeDir(new File("home"));
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher());
		config.setStartEmbeddedWebServer(true);
		config.setClassPath(System.getProperty("java.class.path"));
		config.setPort(port);
		bimServer = new BimServer(config);
		LocalVersionConstructor.augmentWithSvn(bimServer.getVersionChecker().getLocalVersion());
	 	try {
	 		LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager());
		 	EmbeddedWebServer embeddedWebServer = bimServer.getEmbeddedWebServer();
		 	embeddedWebServer.getContext().addServlet(DownloadServlet.class, "/download/*");
		 	embeddedWebServer.getContext().addServlet(ProgressServlet.class, "/progress/*");
		 	embeddedWebServer.getContext().addServlet(UploadServlet.class, "/upload/*");
		 	embeddedWebServer.getContext().addServlet(JsonApiServlet.class, "/json/*");
		 	embeddedWebServer.getContext().addServlet(StreamingServlet.class, "/stream/*");
		 	embeddedWebServer.getContext().setResourceBase("../BimWebServer/www");
		 	BimWebServer bimWebServer = new BimWebServer(bimServer.getServiceInterfaces());
			embeddedWebServer.getContext().getServletContext().setAttribute("bimwebserver", bimWebServer);
	 		bimServer.start();
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				bimServer.getSystemService().setup("http://localhost:8080", "localhost", "no-reply@bimserver.org", "Administrator", "admin@bimserver.org", "admin");
			}
			
			ServerDescriptor serverDescriptor = StoreFactory.eINSTANCE.createServerDescriptor();
			serverDescriptor.setTitle("BIMWebServer");
			bimServer.getNotificationsManager().register(serverDescriptor);
			
			ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
			serviceDescriptor.setUrl("");
			serviceDescriptor.setName("Desktop Notifications");
			serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
			serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
			serviceDescriptor.setDescription("Desktop Notifications");
			
			bimServer.getNotificationsManager().register(serverDescriptor, serviceDescriptor, bimWebServer);
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (DatabaseInitException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (DatabaseRestartRequiredException e) {
			LOGGER.error("", e);
		}

	 	LoginManager.bimServerClientFactory = new BimServerClientFactory() {
			@Override
			public BimServerClient create(AuthenticationInfo authenticationInfo, String remoteAddress) {
				BimServerClient bimServerClient = new BimServerClient(bimServer.getPluginManager());
				bimServerClient.setAuthentication(authenticationInfo);
//				try {
//					bimServerClient.connectProtocolBuffers("localhost", 8020);
//				} catch (ConnectionException e) {
//					e.printStackTrace();
//				}
				bimServerClient.connectDirect(bimServer.getServiceFactory().newService(AccessMethod.WEB_INTERFACE, remoteAddress));
				return bimServerClient;
			}
		};
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}
}