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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.OperationType;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.MigrationException;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.SystemAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandLine extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommandLine.class);
	private final BimServer bimServer;
	private volatile boolean running;
	private BufferedReader reader;

	public CommandLine(BimServer bimServer) {
		this.bimServer = bimServer;
		setName("CommandLine");
		setDaemon(true);
	}

	@Override
	public void run() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		running = true;
		try {
			while (running) {
				try {
					String line = reader.readLine();
					if (line == null) {
						Thread.sleep(50);
						continue;
					}
					if (line.equalsIgnoreCase("exit")) {
						bimServer.stop();
						return;
					} else if (line.startsWith("dumpmodel")) {
						try {
							long roid = Long.parseLong(line.substring(9).trim());
							DatabaseSession databaseSession = bimServer.getDatabase().createSession(OperationType.READ_ONLY);	
							try {
								DownloadDatabaseAction downloadDatabaseAction = new DownloadDatabaseAction(bimServer, databaseSession, AccessMethod.INTERNAL, roid, -1, -1, new SystemAuthorization(1, TimeUnit.HOURS));
								IfcModelInterface model = downloadDatabaseAction.execute();
								LOGGER.info("Model size: " + model.size());
								
								List<IfcWall> walls = model.getAll(IfcWall.class);
								List<IfcProject> projects = model.getAll(IfcProject.class);
								List<IfcSlab> slabs = model.getAll(IfcSlab.class);
								List<IfcWindow> windows = model.getAll(IfcWindow.class);
								
								LOGGER.info("Walls: " + walls.size());
								LOGGER.info("Windows: " + windows.size());
								LOGGER.info("Projects: " + projects.size());
								LOGGER.info("Slabs: " + slabs.size());
							} catch (UserException e) {
								LOGGER.error("", e);
							} catch (BimserverLockConflictException e) {
								LOGGER.error("", e);
							} catch (BimserverDatabaseException e) {
								LOGGER.error("", e);
							} finally {
								databaseSession.close();
							}
						} catch (Exception e) {
							LOGGER.error("", e);
						}
					} else if (line.equalsIgnoreCase("dump")) {
						LOGGER.info("Dumping all thread's track traces...");
						LOGGER.info("");
						Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
						for (Thread t : allStackTraces.keySet()) {
							LOGGER.info(t.getName());
							StackTraceElement[] stackTraceElements = allStackTraces.get(t);
							for (StackTraceElement stackTraceElement : stackTraceElements) {
								LOGGER.info("\t" + stackTraceElement.getClassName() + ":" + stackTraceElement.getLineNumber() + "."
										+ stackTraceElement.getMethodName());
							}
							LOGGER.info("");
						}
						LOGGER.info("Done printing stack traces");
						LOGGER.info("");
						Thread.sleep(10000);
					} else if (line.equals("migrate")) {
						LOGGER.info("Starting migration...");
						try {
							bimServer.getDatabase().getMigrator().migrate();
							bimServer.getServerInfoManager().update();
						} catch (MigrationException e) {
							LOGGER.error("", e);
						} catch (InconsistentModelsException e) {
							LOGGER.error("", e);
						} catch (Exception e) {
							LOGGER.error("", e);
						}
					} else if (line.equals("clearendpoints")) {
						bimServer.getEndPointManager().clear();
					} else if (line.startsWith("showall")) {
						KeyValueStore keyValueStore = ((Database) bimServer.getDatabase()).getKeyValueStore();
						Set<String> allTableNames = keyValueStore.getAllTableNames();
						long total = 0;
						for (String tableName : allTableNames) {
							long size = keyValueStore.count(tableName);
							total += size;
							if (size != 0) {
								LOGGER.info(tableName + " " + size);
							}
						}
						LOGGER.info("total: " + total);
					} else {
						LOGGER.info("Unknown command");
					}
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}
		} catch (InterruptedException e) {
		}
	}

	public void shutdown() {
		running = false;
		interrupt();
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}