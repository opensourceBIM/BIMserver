package org.bimserver.servlets;

import java.io.IOException;

import org.bimserver.BimServer;
import org.bimserver.interfaces.NotificationInterfaceReflectorImpl;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.eclipse.jetty.websocket.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamingSocket implements WebSocket.OnTextMessage, EndPoint, StreamingSocketInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingSocket.class);
	private Connection connection;
	private BimServer bimServer;
	private long uoid;
	private long endpointid;
	private NotificationInterfaceReflectorImpl reflectorImpl;

	public StreamingSocket(BimServer bimServer) {
		this.bimServer = bimServer;
		this.endpointid = bimServer.getEndPointManager().register(this);
		reflectorImpl = new NotificationInterfaceReflectorImpl(new JsonWebsocketReflector(bimServer.getServiceInterfaces(), this));
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
		}
	}

	public void send(JSONObject object) {
		try {
//			LOGGER.info("sending " + object.toString(2));
			connection.sendMessage(object.toString());
		} catch (IOException e) {
		}
	}

	@Override
	public long getEndPointId() {
		return endpointid;
	}

	@Override
	public NotificationInterface getNotificationInterface() {
		return reflectorImpl;
	}

	@Override
	public void cleanup() {
		bimServer.getNotificationsManager().unregisterEndpoint(uoid, this);
	}
}