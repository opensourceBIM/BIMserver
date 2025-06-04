package org.bimserver.client.notifications;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.json.ConvertException;
import org.eclipse.jetty.io.EofException;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WriteCallback;
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
	private final Map<Long, BinaryMessageListener> binaryMessageListeners = Collections.synchronizedMap(new HashMap<>());
	private WebSocketHeartbeat heartbeat;
    
	public WebSocketImpl(NotificationsManager socketNotificationsClient) {
		this.socketNotificationsClient = socketNotificationsClient;
    }
 
	public void close() {
		this.socketNotificationsClient.socketIsClosed();
		if (this.heartbeat != null) {
			this.heartbeat.shutdown();
			this.heartbeat = null;
		}
		if (this.session != null) {
			this.session.close();
			this.session = null;
		}
	}
	
    public void waitForEndpointId() {
    	try {
			if (!countDownLatch.await(15, TimeUnit.SECONDS)) {
				LOGGER.error("Did not get an EndpointId within 1 minute");
			}
		} catch (InterruptedException e) {
			LOGGER.error("", e);
		}
    }
    
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
    	close();
    }
 
    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
		this.heartbeat = new WebSocketHeartbeat(this);
		this.heartbeat.start();
    }
 
    public void send(JsonNode jsonNode) {
    	if (this.session != null) {
    		this.session.getRemote().sendString(jsonNode.toString(), new WriteCallback() {
    			@Override
    			public void writeSuccess() {
    			}
    			
    			@Override
    			public void writeFailed(Throwable x) {
    			}
    		});
    	} else {
    		LOGGER.warn("Cannot send message, session is closed");
    	}
    }
    
    @OnWebSocketMessage
	public void onBinary(byte[] bytes, int start, int length) {
    	if (length == 0) {
    		return;
    	}
    	ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
    	long topicId = buffer.getLong();
		BinaryMessageListener binaryMessageListener = binaryMessageListeners.get(topicId);
		if (binaryMessageListener != null) {
			binaryMessageListener.newData(bytes, start, length);
		}
	}
    
    @OnWebSocketMessage
    public void onMessage(String msg) {
    	try {
			ObjectNode parse = new ObjectMapper().readValue(msg, ObjectNode.class);
//			LOGGER.info(parse.toString());
			if (parse instanceof ObjectNode) {
				ObjectNode object = (ObjectNode)parse;
				if (object.has("welcome")) {
					String token = socketNotificationsClient.getBimServerClient().getToken();
					session.getRemote().sendString("{\"token\":\"" + token + "\"}");
				} else if (object.has("endpointid")) {
					socketNotificationsClient.setEndpointId(object.get("endpointid").asLong());
					countDownLatch.countDown();
//					LOGGER.info("Counted down to " + countDownLatch.getCount());
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
    	if (error instanceof EofException) {
    		LOGGER.error("EofException for " + session.getRemoteAddress());
    	} else {
    		LOGGER.error("", error);
    	}
    }
    
	public void setBinaryMessageListener(long topicId, BinaryMessageListener messageListener) {
		this.binaryMessageListeners.put(topicId, messageListener);
	}
}