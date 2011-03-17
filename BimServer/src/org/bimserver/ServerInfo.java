package org.bimserver;

import org.bimserver.database.BimDatabase;
import org.bimserver.models.store.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerInfo {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerInfo.class);
	public static enum ServerState {
		UNKNOWN,
		NOT_SETUP,
		MIGRATION_REQUIRED,
		MIGRATION_IMPOSSIBLE,
		FATAL_ERROR,
		RUNNING
	}
	
	private static String errorMessage;
	private static ServerState serverState = ServerState.UNKNOWN;
	private static BimDatabase bimDatabase;
	private static SettingsManager settingsManager;
	
	public static void update() {
		if (bimDatabase.getMigrator().migrationRequired()) {
			ServerInfo.setServerState(ServerState.MIGRATION_REQUIRED);
		} else if (bimDatabase.getMigrator().migrationImpossible()) {
			ServerInfo.setServerState(ServerState.MIGRATION_IMPOSSIBLE);
		} else {
			Settings settings = settingsManager.getSettings();
			if (settings.getSiteAddress().isEmpty() || settings.getSmtpServer().isEmpty()) {
				ServerInfo.setServerState(ServerState.NOT_SETUP);
			} else {
				ServerInfo.setServerState(ServerState.RUNNING);
			}
		}
	}
	
	public static boolean isAvailable() {
		return errorMessage == null && serverState == ServerState.RUNNING;
	}
	
	public static String getErrorMessage() {
		return errorMessage;
	}
	
	public static void setErrorMessage(String errorMessage) {
		ServerInfo.errorMessage = errorMessage;
	}

	public static void setOutOfMemory() {
		ServerInfo.errorMessage = "This server is out of memory, more info on how to fix this can be found on <a href=\"http://www.bimserver.org/faq\">www.bimserver.org/faq</a>";
	}

	public static void setServerState(ServerState serverState) {
		ServerInfo.serverState = serverState;
		LOGGER.info("Changing server state to " + serverState);
	}

	public static ServerState getServerState() {
		return serverState;
	}

	public static void init(BimDatabase bimDatabase, SettingsManager settingsManager) {
		ServerInfo.bimDatabase = bimDatabase;
		ServerInfo.settingsManager = settingsManager;
	}
}