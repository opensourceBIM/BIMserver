package org.bimserver;

public class ServerInfo {
	private static String errorMessage;
	
	public boolean isAvailable() {
		return errorMessage == null;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public static void setErrorMessage(String errorMessage) {
		ServerInfo.errorMessage = errorMessage;
	}

	public static void setOutOfMemory() {
		ServerInfo.errorMessage = "This server is out of memory, more info on how to fix this can be found on <a href=\"http://www.bimserver.org/faq\">www.bimserver.org/faq</a>";
	}
}