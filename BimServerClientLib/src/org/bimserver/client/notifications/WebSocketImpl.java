package org.bimserver.client.notifications;

import java.io.IOException;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/*
 * TODO 
 * 
 * 100MB is sometimes exceeded, probably because of very large (single) objects. 
 * Would be really nice if we could guarantee an upper limit (preferably even smaller than 100MB)
 * Increased to 512MB for now to be sure this never results in errors
 */

// Max binary message size should match what's in EmbeddedWebServer (or tomcat generic websocket configuration)
@WebSocket(maxBinaryMessageSize = 1024 * 1024 * 512)
public class WebSocketImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketImpl.class);
    private Session session;
	private NotificationsManager socketNotificationsClient;
	private CountDownLatch countDownLatch = new CountDownLatch(1);
	private BinaryMessageListener binaryMessageListener;
    
	public WebSocketImpl(NotificationsManager socketNotificationsClient) {
		this.socketNotificationsClient = socketNotificationsClient;
    }
 
	public void close() {
		if (session != null) {
			session.close();
		}
	}
	
    public void waitForEndpointId() {
    	try {
			if (!countDownLatch.await(1, TimeUnit.MINUTES)) {
				LOGGER.warn("Did not get an EndpointId within 1 minute");
			}
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
 
    public void send(JsonNode jsonNode) {
    	LOGGER.info(jsonNode.toString());
    	try {
			this.session.getRemote().sendString(jsonNode.toString());
		} catch (IOException e) {
			LOGGER.error("", e);
		}
    }
    
    @OnWebSocketMessage
	public void onBinary(byte[] bytes, int start, int length) {
		binaryMessageListener.newData(bytes, start, length);
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
    public void onError(Session session, Throwable error) {
    	LOGGER.error("", error);
    }
    
	public void setBinaryMessageListener(BinaryMessageListener messageListener) {
		this.binaryMessageListener = messageListener;
	}
}