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
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.database.IfcDatabase;
import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcSlab;
import org.bimserver.models.ifc2x3.IfcWall;
import org.bimserver.models.ifc2x3.IfcWindow;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandLine extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommandLine.class);
	private final Server server;

	public CommandLine(Server server) {
		setName("CommandLine");
		setDaemon(true);
		this.server = server;
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
					server.stop();
					return;
				} else if (line.equalsIgnoreCase("test")) {
					BimDatabaseSession bimDatabaseSession = ServerInitializer.getDatabase().createReadOnlySession();	
					try {
						DownloadDatabaseAction downloadDatabaseAction = new DownloadDatabaseAction(bimDatabaseSession, AccessMethod.INTERNAL_LITERAL, ServerInitializer.getSettingsManager(), 16, ServerInitializer.getSystemService().getCurrentUser().getOid());
						IfcModel model = downloadDatabaseAction.execute();
						System.out.println("Model size: " + model.size());
						
						IfcDatabase ifcDatabase = new IfcDatabase(model, null);
						
						List<IfcWall> walls = ifcDatabase.getAll(IfcWall.class);
						List<IfcProject> projects = ifcDatabase.getAll(IfcProject.class);
						List<IfcSlab> slabs = ifcDatabase.getAll(IfcSlab.class);
						List<IfcWindow> windows = ifcDatabase.getAll(IfcWindow.class);
						
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
					ColumnDatabase columnDatabase = ((Database) ServerInitializer.getDatabase()).getColumnDatabase();
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