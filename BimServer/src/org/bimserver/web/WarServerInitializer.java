package org.bimserver.web;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.resources.WarResourceFetcher;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.utils.PathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarServerInitializer implements ServletContextListener {

	private BimServer bimServer;
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		Path homeDir = null;
		if (servletContext.getAttribute("homedir") != null) {
			homeDir = Paths.get((String) servletContext.getAttribute("homedir"));
		}
		if (homeDir == null && servletContext.getInitParameter("homedir") != null) {
			homeDir = Paths.get(servletContext.getInitParameter("homedir"));
		}

		boolean autoMigrate = false;
		if (servletContext.getAttribute("autoMigrate") != null) {
			autoMigrate = (boolean) servletContext.getAttribute("autoMigrate");
		}
		if (autoMigrate == false && servletContext.getInitParameter("autoMigrate") != null) {
			autoMigrate = Boolean.valueOf(servletContext.getInitParameter("autoMigrate"));
		}
		
		String realPath = servletContext.getRealPath("/");
		if (!realPath.endsWith("/")) {
			realPath = realPath + "/";
		}
		Path baseDir = Paths.get(realPath + "WEB-INF");
		if (homeDir == null) {
			homeDir = baseDir;
		}
		ResourceFetcher resourceFetcher = new WarResourceFetcher(servletContext, homeDir);
		BimServerConfig config = new BimServerConfig();
		config.setAutoMigrate(autoMigrate);
		config.setHomeDir(homeDir);
		config.setResourceFetcher(resourceFetcher);
		try {
			config.setClassPath(makeClassPath(resourceFetcher.getFile("lib")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		config.setStartEmbeddedWebServer(false);
		bimServer = new BimServer(config);
		
		Logger LOGGER = LoggerFactory.getLogger(WarServerInitializer.class);
		LOGGER.info("Servlet Context Name: " + servletContext.getServletContextName());
		
		List<Path> files = resourceFetcher.getFiles("plugins");
		try {
			for (Path file : files) {
				bimServer.getPluginManager().loadAllPluginsFromDirectoryOfJars(file);
			}
			bimServer.start();
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (DatabaseInitException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (DatabaseRestartRequiredException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		servletContext.setAttribute("bimserver", bimServer);
	}
	
	private String makeClassPath(Path file) {
		// Added for Tomcat8
		if (file == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		try {
			for (Path f : PathUtils.list(file)) {
				if (f.getFileName().toString().toLowerCase().endsWith(".jar")) {
					sb.append(f.toString() + File.pathSeparator);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		servletContextEvent.getServletContext().removeAttribute("bimserver");
		if (bimServer != null) {
			bimServer.stop();
		}
	}
}