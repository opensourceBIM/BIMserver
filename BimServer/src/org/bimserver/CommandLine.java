package org.bimserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.ColumnDatabase;
import org.bimserver.database.Database;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.ServiceException;
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
					long startTime = System.nanoTime();
					try {
						ServerInitializer.getSystemService().download(1051442, ResultType.IFC, true);
					} catch (ServiceException e) {
						LOGGER.error("", e);
					}
					long endTime = System.nanoTime();
					System.out.println(((endTime - startTime) / 1000000) + " ms");
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