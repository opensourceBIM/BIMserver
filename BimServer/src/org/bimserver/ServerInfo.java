package org.bimserver;

public class ServerInfo {
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
	}

	public static ServerState getServerState() {
		return serverState;
	}
}