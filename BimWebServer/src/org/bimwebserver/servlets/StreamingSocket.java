package org.bimwebserver.servlets;

import java.io.IOException;

import org.bimserver.interfaces.objects.SNewProjectNotification;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimwebserver.BimWebServer;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.jetty.websocket.WebSocket;

public class StreamingSocket implements WebSocket.OnTextMessage, NotificationInterface {

	private Connection connection;
	private BimWebServer bimWebServer;
	private long uoid;

	public StreamingSocket(BimWebServer bimWebServer, long uoid) {
		this.bimWebServer = bimWebServer;
		this.uoid = uoid;
	}
	
	@Override
	public void onClose(int arg0, String arg1) {
		bimWebServer.unregisterForNotification(uoid);
	}

	@Override
	public void onOpen(Connection connection) {
		this.connection = connection;
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("type", "Welcome");
			jsonObject.put("title", "Welcome");
			jsonObject.put("message", "Welcome to the BimWebServer!");
			send(jsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessage(String message) {
	}

	private void send(JSONObject object) {
		try {
			connection.sendMessage(object.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void serverHasStarted() throws ServiceException {
	}

	@Override
	public void serverWillBeShutdown() throws ServiceException {
	}

	@Override
	public void newProject(SNewProjectNotification newProjectNotification) throws ServiceException {
		JSONObject object = new JSONObject();
		try {
			object.put("type", "newProject");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		send(object);
	}

	@Override
	public void newRevision(SNewRevisionNotification newRevisionNotification, SToken token, String apiUrl) throws ServiceException {
		JSONObject object = new JSONObject();
		try {
			object.put("type", "newRevision");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		send(object);
	}
}