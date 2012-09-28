package org.bimserver.servlets;

import java.io.IOException;

import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.json.JsonConverter;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.eclipse.jetty.websocket.WebSocket;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class StreamingSocket implements WebSocket.OnTextMessage, NotificationInterface, EndPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingSocket.class);
	private Connection connection;
	private BimServer bimServer;
	private long uoid;
	private long endpointid;
	private ServiceInterface service;

	public StreamingSocket(BimServer bimServer) {
		this.bimServer = bimServer;
		this.endpointid = bimServer.getEndPointManager().register(this);
	}

	@Override
	public void onClose(int arg0, String arg1) {
		bimServer.getEndPointManager().unregister(this);
	}

	@Override
	public void onOpen(Connection connection) {
		this.connection = connection;
		try {
			JSONObject welcome = new JSONObject();
			welcome.put("endpointid", endpointid);
			send(welcome);
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public void onMessage(String message) {
		try {
			JSONObject request = new JSONObject(new JSONTokener(message));
			bimServer.getJsonHandler().execute(request, null);
		} catch (JSONException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
	}

	private void send(JSONObject object) {
		try {
			connection.sendMessage(object.toString());
		} catch (IOException e) {
		}
	}

	@Override
	public void newLogAction(SLogAction logAction, SToken token, String apiUrl) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("logAction", bimServer.getJsonHandler().getJsonConverter().toJson(logAction));
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
		send(jsonObject);
	}

	@Override
	public long getEndPointId() {
		return endpointid;
	}

	@Override
	public NotificationInterface getNotificationInterface() {
		return this;
	}

	@Override
	public void cleanup() {
		bimServer.getNotificationsManager().unregisterEndpoint(uoid, this);
	}
}