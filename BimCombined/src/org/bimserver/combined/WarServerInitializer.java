package org.bimserver.combined;

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

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.resources.WarResourceFetcher;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.web.LoginManager;

public class WarServerInitializer implements ServletContextListener {

	private BimServer bimServer;
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		File homeDir = null;
		if (servletContext.getAttribute("homedir") != null) {
			homeDir = new File((String) servletContext.getAttribute("homedir"));
		}
		if (homeDir == null && servletContext.getInitParameter("homedir") != null) {
			homeDir = new File(servletContext.getInitParameter("homedir"));
		}
		
		File baseDir = new File(servletContext.getRealPath("/") + "WEB-INF");
		if (homeDir == null) {
			homeDir = baseDir;
		}
		ResourceFetcher resourceFetcher = new WarResourceFetcher(servletContext, homeDir);
		BimServerConfig config = new BimServerConfig();
		config.setHomeDir(homeDir);
		config.setResourceFetcher(resourceFetcher);
		config.setClassPath(makeClassPath(resourceFetcher.getFile("lib")));
		config.setStartEmbeddedWebServer(false);
		bimServer = new BimServer(config);
		
	 	LoginManager.bimServerClientFactory = new BimServerClientFactory() {
			@Override
			public BimServerClient create(AuthenticationInfo authenticationInfo, String remoteAddress) {
				BimServerClient bimServerClient = new BimServerClient(bimServer.getPluginManager());
				ServiceInterface newService = bimServer.getServiceFactory().newService(AccessMethod.WEB_INTERFACE, remoteAddress);
				bimServerClient.connectDirect(newService);
				return bimServerClient;
			}
		};
		
		File file = resourceFetcher.getFile("plugins");
		try {
			bimServer.getPluginManager().loadAllPluginsFromDirectoryOfJars(file);
			bimServer.start();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			e.printStackTrace();
		}
		servletContext.setAttribute("bimserver", bimServer);
	}
	
	private String makeClassPath(File file) {
		StringBuilder sb = new StringBuilder();
		for (File f : file.listFiles()) {
			if (f.getName().toLowerCase().endsWith(".jar")) {
				sb.append(f.getAbsolutePath() + File.pathSeparator);
			}
		}
		return sb.toString();
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		if (bimServer != null) {
			bimServer.stop();
		}
	}
}