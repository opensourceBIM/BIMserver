package org.bimserver.database;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseSessionMonitor extends Thread {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSessionMonitor.class);
	private volatile boolean running = true;
	private Database database;
	private Set<DatabaseSession> reported = new HashSet<>();

	public DatabaseSessionMonitor(Database database) {
		this.database = database;
	}
	
	@Override
	public void run() {
		while (running) {
			for (DatabaseSession databaseSession : database.sessions) {
				if (System.currentTimeMillis() - databaseSession.getCreatedAt() > 60000) {
					if (!reported.contains(databaseSession)) {
						reported.add(databaseSession);
						LOGGER.info("Database session open > 60s");
						LOGGER.info("Owner: " + databaseSession);
						StackTraceElement[] stackTraceElements = databaseSession.getStackTrace();
						for (StackTraceElement stackTraceElement : stackTraceElements) {
							LOGGER.info("\tat " + stackTraceElement);
						}
					}
				}
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
