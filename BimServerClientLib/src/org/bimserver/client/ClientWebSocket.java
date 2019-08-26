package org.bimserver.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.plugins.services.ProgressHandler;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@org.eclipse.jetty.websocket.api.annotations.WebSocket(maxIdleTime=60 * 60 * 1000, maxBinaryMessageSize=1024*1024*5)
public class ClientWebSocket {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientWebSocket.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private Session session;
	private Long endPointId;
	private final Map<Long, ProgressHandler> progressHandlers = new HashMap<>();
	
	@OnWebSocketConnect
	public void onOpen(Session websocketSession) throws IOException {
		this.session = websocketSession;
	}

	@OnWebSocketClose
	public void onClose(Session session, int statusCode, String reason) {
		LOGGER.info("WebSocket closed: " + statusCode + ", " + reason);
		close();
	}
	
	public void close() {
		
	}

	public Session getSession() {
		return session;
	}
	
	@OnWebSocketMessage
	public void onMessage(Session session, String message) {
	}
	
	@OnWebSocketMessage
	public void onMessage(Session session, byte buf[], int offset, int length) {
		
	}

	public Long getEndPointId() {
		return endPointId;
	}

	public void registerProgressHandler(long topicId, ProgressHandler progressHandler) {
		this.progressHandlers.put(topicId, progressHandler);
	}

	public void unregisterProgressHandlers(long topicId) {
		this.progressHandlers.remove(topicId);
	}
}