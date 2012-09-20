package org.bimwebserver.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.shared.exceptions.ServiceException;
import org.bimwebserver.BimWebServer;
import org.bimwebserver.jsp.LoginManager;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class StreamingServlet extends WebSocketServlet {

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request, String response) {
		BimWebServer bimWebServer = (BimWebServer)getServletContext().getAttribute("bimwebserver");
		LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
		try {
			StreamingSocket streamingSocket = new StreamingSocket(bimWebServer, loginManager.getUoid());
			bimWebServer.registerForNotifications(loginManager.getUoid(), streamingSocket);
			return streamingSocket;
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getNamedDispatcher("default").forward(request, response);
	}
}