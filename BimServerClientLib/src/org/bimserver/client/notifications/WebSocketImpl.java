package org.bimserver.client.notifications;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.json.ConvertException;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@WebSocket
public class WebSocketImpl {
	 
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketImpl.class);
    private Session session;
	private NotificationsManager socketNotificationsClient;
	private CountDownLatch countDownLatch = new CountDownLatch(1);
    
	public WebSocketImpl(NotificationsManager socketNotificationsClient) {
		this.socketNotificationsClient = socketNotificationsClient;
    }
 
	public void close() {
		session.close();
	}
	
    public void waitForEndpointId() {
    	try {
			countDownLatch.await(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			LOGGER.error("", e);
		}
    }
    
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        this.session = null;
    }
 
    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
    }
 
    @OnWebSocketMessage
    public void onMessage(String msg) {
    	try {
			ObjectNode parse = new ObjectMapper().readValue(msg, ObjectNode.class);
			if (parse instanceof ObjectNode) {
				ObjectNode object = (ObjectNode)parse;
				if (object.has("welcome")) {
					String token = socketNotificationsClient.getBimServerClient().getToken();
					session.getRemote().sendString("{\"token\":\"" + token + "\"}");
				} else if (object.has("endpointid")) {
					socketNotificationsClient.setEndpointId(object.get("endpointid").asLong());
					countDownLatch.countDown();
				} else {
					try {
						socketNotificationsClient.handleIncoming((ObjectNode) object.get("request"));
					} catch (UserException e) {
						LOGGER.error("", e);
					} catch (ConvertException e) {
						LOGGER.error("", e);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
    }
    
    @OnWebSocketError
    public void methodName(Session session, Throwable error) {
    	LOGGER.error("", error);
    }
}