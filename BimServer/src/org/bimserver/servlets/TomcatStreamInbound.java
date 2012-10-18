package org.bimserver.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WsOutbound;
import org.bimserver.BimServer;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.json.JsonReflector;
import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;

public class TomcatStreamInbound extends StreamInbound implements EndPoint, StreamingSocketInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(TomcatStreamInbound.class);
	private BimServer bimServer;
	private long uoid;
	private long endpointid;
	private NotificationInterface reflectorImpl;
	private WsOutbound outbound;

	public TomcatStreamInbound(BimServer bimServer) {
		this.bimServer = bimServer;
		this.endpointid = bimServer.getEndPointManager().register(this);
		JsonReflector jsonReflector = new JsonWebsocketReflector(bimServer.getServicesMap(), this);
		reflectorImpl = bimServer.getReflectorFactory().createReflector(NotificationInterface.class, jsonReflector);
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		this.outbound = outbound;
		JsonObject welcome = new JsonObject();
		welcome.add("endpointid", new JsonPrimitive(endpointid));
		send(welcome);
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

	@Override
	public void send(JsonObject request) {
		String toString = request.toString();
		CharBuffer charBuffer = CharBuffer.wrap(toString.toCharArray());
		try {
			outbound.writeTextMessage(charBuffer);
			outbound.flush();
			LOGGER.info("WS_OUT: " + toString);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	@Override
	protected void onTextData(Reader reader) throws IOException {
		try {
			JsonReader jsonreader = new JsonReader(reader);
			JsonParser parser = new JsonParser();
			JsonObject request = (JsonObject) parser.parse(jsonreader);
			bimServer.getJsonHandler().execute(request, null, null);
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
	}
	
	@Override
	protected void onClose(int status) {
		bimServer.getEndPointManager().unregister(this);
		super.onClose(status);
	}
	
	@Override
	protected void onBinaryData(InputStream arg0) throws IOException {
	}
}