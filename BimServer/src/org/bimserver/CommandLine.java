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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.Reporter;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandLine extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommandLine.class);
	private final BimServer bimServer;
	private volatile boolean running;

	public CommandLine(BimServer bimServer) {
		this.bimServer = bimServer;
		setName("CommandLine");
		setDaemon(true);
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		running = true;
		while (running) {
			try {
				String line = reader.readLine();
				if (line == null) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						LOGGER.error("", e);
					}
					continue;
				}
				if (line.equalsIgnoreCase("exit")) {
					bimServer.stop();
					return;
				} else if (line.startsWith("dumpmodel")) {
					try {
						long roid = Long.parseLong(line.substring(9).trim());
						DatabaseSession databaseSession = bimServer.getDatabase().createSession();	
						try {
							DownloadDatabaseAction downloadDatabaseAction = new DownloadDatabaseAction(bimServer, databaseSession, AccessMethod.INTERNAL, roid, -1, -1, ((Service)bimServer.getSystemService()).getAuthorization(), null, new Reporter(){
								@Override
								public void error(String error) {
								}

								@Override
								public void info(String info) {
								}
								
								@Override
								public void warning(String warning) {
								}});
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
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						LOGGER.error("", e);
					}
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
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
	}

	public void shutdown() {
		running = false;
		interrupt();
	}
}