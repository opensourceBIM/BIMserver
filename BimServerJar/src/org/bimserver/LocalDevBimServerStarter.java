package org.bimserver;

import java.io.IOException;
import java.nio.file.Files;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerState;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.util.StatusPrinter;

public class LocalDevBimServerStarter {
	private BimServer bimServer;
	
	public static void main(String[] args) {
		new LocalDevBimServerStarter().start(-1, "localhost", "LocalDev BIMserver (8080)", 8080, 8085, new OptionsParser(args).getPluginDirectories());
	}

	public void start(int id, String address, String name, int port, int pbport, Path[] pluginDirectories) {
		BimServerConfig config = new BimServerConfig();
		config.setHomeDir(Paths.get("home" + (id == -1 ? "" : id)));
		config.setResourceFetcher(new LocalDevelopmentResourceFetcher(Paths.get("../")));
		config.setStartEmbeddedWebServer(true);
		config.setClassPath(System.getProperty("java.class.path"));
		config.setLocalDev(true);
		config.setEnvironment(Environment.LOCAL_DEV);
		config.setPort(port);
		config.setStartCommandLine(true);
		config.setDevelopmentBaseDir(Paths.get("../BimServer"));

		try {
			fixLogging(config);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		bimServer = new BimServer(config);
		bimServer.getVersionChecker().getLocalVersion().setDate(new Date());
		bimServer.setEmbeddedWebServer(new EmbeddedWebServer(bimServer, config.getDevelopmentBaseDir(), config.isLocalDev()));
		Logger LOGGER = LoggerFactory.getLogger(LocalDevBimServerStarter.class);
		try {
			bimServer.start();
			if (bimServer.getServerInfo().getServerState() != ServerState.MIGRATION_REQUIRED) {
				LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);
				try {
					AdminInterface adminInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(AdminInterface.class);
					adminInterface.setup("http://localhost:" + port, name, "My Description", "http://localhost:" + port + "/img/bimserver.png", "Administrator", "admin@bimserver.org", "admin");
					SettingsInterface settingsInterface = bimServer.getServiceFactory().get(new SystemAuthorization(1, TimeUnit.HOURS), AccessMethod.INTERNAL).get(SettingsInterface.class);
					settingsInterface.setCacheOutputFiles(false);
					settingsInterface.setPluginStrictVersionChecking(false);
				} catch (Exception e) {
					// Ignore
				}
				bimServer.activateServices();
			} else {
				bimServer.getServerInfoManager().registerStateChangeListener(new StateChangeListener() {
					@Override
					public void stateChanged(ServerState oldState, ServerState newState) {
						if (oldState == ServerState.MIGRATION_REQUIRED && newState == ServerState.RUNNING) {
							try {
								LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager(), pluginDirectories);
							} catch (PluginException e) {
								LOGGER.error("", e);
							}
						}
					}
				});
			}
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

	public BimServer getBimServer() {
		return bimServer;
	}
}