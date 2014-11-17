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
import org.eclipse.jetty.websocket.api.WebSocketException;

import com.google.gson.JsonObject;

@ServerEndpoint(value = "/stream", configurator = ServletAwareConfig.class)
public class Jsr356Impl implements StreamingSocketInterface {

	private Streamer streamer;
	private Session websocketSession;

	@OnOpen
	public void onOpen(Session websocketSession, EndpointConfig config) {
		this.websocketSession = websocketSession;
		HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
		ServletContext servletContext = httpSession.getServletContext();
		streamer = new Streamer(this, (BimServer) servletContext.getAttribute("bimserver"));
	}

	@OnMessage
	public String onMessage(String message, Session session) {
		streamer.onText(new StringReader(message));
		return null;
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		streamer.onClose();
	}

	@Override
	public void send(JsonObject request) {
		try {
			websocketSession.getAsyncRemote().sendText(request.toString());
		} catch (WebSocketException e) {
		}
	}

	@Override
	public void send(byte[] data, int start, int length) {
		try {
			websocketSession.getAsyncRemote().sendBinary(ByteBuffer.wrap(data, start, length));
			websocketSession.getAsyncRemote().flushBatch();
		} catch (IOException e) {
		}
	}
}