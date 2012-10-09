package org.bimserver.servlets;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.bimserver.BimServer;

public class TomcatStreamingServlet extends WebSocketServlet {
	
	@Override
	protected StreamInbound createWebSocketInbound(String arg0, HttpServletRequest arg1) {
		final BimServer bimServer = (BimServer)getServletContext().getAttribute("bimserver");
		return new TomcatStreamInbound(bimServer);
	}
}
