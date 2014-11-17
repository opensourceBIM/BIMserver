package org.bimserver.servlets.websockets.jsr356;

import java.io.IOException;
import java.io.StringReader;
import java.nio.ByteBuffer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.bimserver.BimServer;
import org.bimserver.servlets.Streamer;
import org.bimserver.servlets.StreamingSocketInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

@ServerEndpoint(value = "/stream", configurator = ServletAwareConfig.class)
public class Jsr356Impl implements StreamingSocketInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(Jsr356Impl.class);
	private Streamer streamer;
	private Session websocketSession;
	
	@OnOpen
	public void onOpen(Session websocketSession, EndpointConfig config) {
		LOGGER.info("WebSocket session opened");
		this.websocketSession = websocketSession;
		HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
		ServletContext servletContext = httpSession.getServletContext();
		streamer = new Streamer(this, (BimServer) servletContext.getAttribute("bimserver"));
		streamer.onOpen();
	}

	@OnMessage
	public String onMessage(String message, Session session) {
		LOGGER.info("Message received: " + message);
		streamer.onText(new StringReader(message));
		return null;
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		LOGGER.info("WebSocket closed");
		streamer.onClose();
	}

	@Override
	public void send(JsonObject request) {
		LOGGER.info("WebSocket sending: " + request);
		websocketSession.getAsyncRemote().sendText(request.toString());
	}

	@Override
	public void send(byte[] data, int start, int length) {
		LOGGER.info("WebSocket sending binary data");
		try {
			websocketSession.getAsyncRemote().sendBinary(ByteBuffer.wrap(data, start, length));
			websocketSession.getAsyncRemote().flushBatch();
		} catch (IOException e) {
		}
	}
}