package org.bimserver.web;

import org.bimserver.BimServer;

public class WebServerHelper {
	private static BimServer bimServer;

	public static void setBimServer(BimServer bimServer) {
		WebServerHelper.bimServer = bimServer;
	}
	
	public static BimServer getBimServer() {
		return bimServer;
	}
}
