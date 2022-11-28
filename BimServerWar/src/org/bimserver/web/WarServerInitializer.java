package org.bimserver.web;

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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.bimserver.BimServer;
import org.bimserver.BimServerConfig;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.Environment;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.resources.WarResourceFetcher;
import org.bimserver.servlets.websockets.jsr356.Jsr356Impl;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.utils.PathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class WarServerInitializer implements ServletContextListener {

	private BimServer bimServer;

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
			autoMigrate = (Boolean) servletContext.getAttribute("autoMigrate");
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

		ResourceFetcher resourceFetcher = new WarResourceFetcher(servletContext);

		BimServerConfig config = new BimServerConfig();
		config.setAutoMigrate(autoMigrate);
		config.setEnvironment(Environment.WAR);
		config.setHomeDir(homeDir);
		config.setResourceFetcher(resourceFetcher);

		if (homeDir != null) {
			// Basically doing this twice (also in BimServer.init), but this makes sure the logback.xml file is copied to the homedir
			try {
				BimServer.initHomeDir(config);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		setupLogging(homeDir);
		try {
			fixLogging(config);
			// TODO
//			config.setClassPath(makeClassPath(resourceFetcher.getFile("lib")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		config.setStartEmbeddedWebServer(false);
		bimServer = new BimServer(config);
		
		Jsr356Impl.setDefaultServletContext(servletContextEvent.getServletContext());

		Logger LOGGER = LoggerFactory.getLogger(WarServerInitializer.class);
		LOGGER.info("Servlet Context Name: " + servletContext.getServletContextName());
		LOGGER.info("Servlet Context Real Path: " + servletContext.getRealPath("/WEB-INF"));
		LOGGER.info("Application Server: " + servletContext.getServerInfo());

		try {
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
		}
		servletContext.setAttribute("bimserver", bimServer);
	}

	private void setupLogging(Path homeDir) {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);
			context.reset();
			configurator.doConfigure(homeDir.resolve("logback.xml").toFile());
		} catch (JoranException je) {
			// StatusPrinter will handle this
		}
		StatusPrinter.printInCaseOfErrorsOrWarnings(context);
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

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		servletContextEvent.getServletContext().removeAttribute("bimserver");
		if (bimServer != null) {
			bimServer.stop();
		}
	}
	
	/**
	 * Add a file appender to every logger we can find (the loggers should already have been configured via logback.xml)
	 * 
	 * @throws IOException
	 */
	private void fixLogging(BimServerConfig config) throws IOException {
		Path logFolder = config.getHomeDir().resolve("logs");
		if (!Files.isDirectory(logFolder)) {
			Files.createDirectories(logFolder);
		}
		Path file = logFolder.resolve("bimserver.log");

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		PatternLayoutEncoder ple = new PatternLayoutEncoder();

		ple.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
		ple.setContext(lc);
		ple.start();
		FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
		String filename = file.toAbsolutePath().toString();

		if (lc instanceof LoggerContext) {
		    if (!lc.isStarted()) {
		    	lc.start();
		    }
		}
		
		System.out.println("Logging to " + filename);
		
		fileAppender.setFile(filename);
		fileAppender.setEncoder(ple);
		fileAppender.setContext(lc);
		fileAppender.start();

		for (ch.qos.logback.classic.Logger log : lc.getLoggerList()) {
			if (log.getLevel() != null) {
				log.addAppender(fileAppender);
			}
		}
	}
}
