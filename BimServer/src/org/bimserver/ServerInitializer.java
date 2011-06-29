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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.resources.JarResourceFetcher;
import org.bimserver.resources.WarResourceFetcher;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class ServerInitializer implements ServletContextListener {
	private static BimServer bimServer;
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerInitializer.class);

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
		bimServer = new BimServer();
		
		ServerType serverType = detectServerType(servletContext);
		File baseDir = null;
		if (serverType == ServerType.DEV_ENVIRONMENT) {
			baseDir = new File("../BimServer/defaultsettings/" + "shared");
		} else if (serverType == ServerType.STANDALONE_JAR) {
			baseDir = new File("");
		} else if (serverType == ServerType.DEPLOYED_WAR) {
			baseDir = new File(servletContext.getRealPath("/") + "WEB-INF");
		}
		if (homeDir == null) {
			homeDir = baseDir;
		}
		ResourceFetcher resourceFetcher = createResourceFetcher(serverType, servletContext, homeDir);
		
		bimServer.init(homeDir, baseDir, resourceFetcher);
		try {
			bimServer.start();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PluginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		servletContext.setAttribute("bimserver", bimServer);
	}
	
	private ResourceFetcher createResourceFetcher(ServerType serverType, final ServletContext servletContext, File homeDir) {
		switch (serverType) {
		case DEV_ENVIRONMENT:
			return new LocalDevelopmentResourceFetcher();
		case DEPLOYED_WAR:
			return new WarResourceFetcher(servletContext, homeDir);
		case STANDALONE_JAR:
			return new JarResourceFetcher();
		}
		return null;
	}


	private String readUrl(URL resource) {
		try {
			InputStream inputStream = resource.openStream();
			byte[] buffer = new byte[100];
			int red = inputStream.read(buffer);
			String string = new String(buffer, 0, red, Charsets.UTF_8);
			inputStream.close();
			return string;
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	private String readFile(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[100];
			int red = fis.read(buffer);
			String string = new String(buffer, 0, red, Charsets.UTF_8);
			fis.close();
			return string;
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	private ServerType detectServerType(ServletContext servletContext) {
		String typeString = null;
		try {
			URL resource = servletContext.getResource("/servertype.txt");
			if (resource != null) {
				typeString = readUrl(resource);
			}
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
		}
		if (typeString == null) {
			File file = new File("servertype.txt");
			typeString = readFile(file);
		}
		if (typeString == null) {
			return ServerType.UNKNOWN;
		}
		return ServerType.valueOf(typeString);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		bimServer.stop();
	}
}