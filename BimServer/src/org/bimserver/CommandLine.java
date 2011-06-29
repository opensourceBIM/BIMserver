package org.bimserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ColumnDatabase;
import org.bimserver.database.Database;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcSlab;
import org.bimserver.models.ifc2x3.IfcWall;
import org.bimserver.models.ifc2x3.IfcWindow;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandLine extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommandLine.class);
	private final BimServer bimServer;

	public CommandLine(BimServer bimServer) {
		this.bimServer = bimServer;
		setName("CommandLine");
		setDaemon(true);
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
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
						BimDatabaseSession bimDatabaseSession = bimServer.getDatabase().createReadOnlySession();	
						try {
							DownloadDatabaseAction downloadDatabaseAction = new DownloadDatabaseAction(bimServer, bimDatabaseSession, AccessMethod.INTERNAL, roid, bimServer.getSystemService().getCurrentUser().getOid());
							IfcModelInterface model = downloadDatabaseAction.execute();
							System.out.println("Model size: " + model.size());
							
							List<IfcWall> walls = model.getAll(IfcWall.class);
							List<IfcProject> projects = model.getAll(IfcProject.class);
							List<IfcSlab> slabs = model.getAll(IfcSlab.class);
							List<IfcWindow> windows = model.getAll(IfcWindow.class);
							
							System.out.println("Walls: " + walls.size());
							System.out.println("Windows: " + windows.size());
							System.out.println("Projects: " + projects.size());
							System.out.println("Slabs: " + slabs.size());
						} catch (UserException e1) {
							e1.printStackTrace();
						} catch (ServerException e1) {
							e1.printStackTrace();
						} catch (BimDeadlockException e) {
							e.printStackTrace();
						} catch (BimDatabaseException e) {
							e.printStackTrace();
						} finally {
							bimDatabaseSession.close();
						}
					} catch (Exception e) {
						LOGGER.error("", e);
					}
				} else if (line.equalsIgnoreCase("dump")) {
					System.out.println("Dumping all thread's track traces...");
					System.out.println();
					Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
					for (Thread t : allStackTraces.keySet()) {
						System.out.println(t.getName());
						StackTraceElement[] stackTraceElements = allStackTraces.get(t);
						for (StackTraceElement stackTraceElement : stackTraceElements) {
							System.out.println("\t" + stackTraceElement.getClassName() + ":" + stackTraceElement.getLineNumber() + "."
									+ stackTraceElement.getMethodName());
						}
						System.out.println();
					}
					System.out.println("Done printing stack traces");
					System.out.println();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						LOGGER.error("", e);
					}
				} else if (line.startsWith("showall")) {
					ColumnDatabase columnDatabase = ((Database) bimServer.getDatabase()).getColumnDatabase();
					Set<String> allTableNames = columnDatabase.getAllTableNames();
					long total = 0;
					for (String tableName : allTableNames) {
						long size = columnDatabase.count(tableName);
						total += size;
						if (size != 0) {
							System.out.println(tableName + " " + size);
						}
					}
					System.out.println("total: " + total);
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
	}
}