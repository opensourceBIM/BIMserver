package org.bimserver.servlets;

import java.io.IOException;
import java.io.StringReader;

import org.apache.commons.io.output.NullWriter;
import org.bimserver.BimServer;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.codehaus.jettison.json.JSONException;
import org.eclipse.jetty.websocket.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;

public class StreamingSocket implements WebSocket.OnTextMessage, EndPoint, StreamingSocketInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingSocket.class);
	private Connection connection;
	private BimServer bimServer;
	private long uoid;
	private long endpointid;
	private NotificationInterface reflectorImpl;

	public StreamingSocket(BimServer bimServer) {
		this.bimServer = bimServer;
		this.endpointid = bimServer.getEndPointManager().register(this);
		reflectorImpl = bimServer.getReflectorFactory().createReflector(NotificationInterface.class, new JsonWebsocketReflector(bimServer.getServicesMap(), this));
	}

	@Override
	public void onClose(int arg0, String arg1) {
		bimServer.getEndPointManager().unregister(this);
	}

	@Override
	public void onOpen(Connection connection) {
		this.connection = connection;
		JsonObject welcome = new JsonObject();
		welcome.add("endpointid", new JsonPrimitive(endpointid));
		send(welcome);
	}

	@Override
	public void onMessage(String message) {
		try {
			JsonReader reader = new JsonReader(new StringReader(message));
			JsonParser parser = new JsonParser();
			JsonObject request = (JsonObject) parser.parse(reader);
			bimServer.getJsonHandler().execute(request, null, new NullWriter());
		} catch (JSONException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public void send(JsonObject object) {
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