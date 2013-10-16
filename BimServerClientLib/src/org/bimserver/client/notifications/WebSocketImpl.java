package org.bimserver.client.notifications;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.json.ConvertException;
import org.codehaus.jettison.json.JSONException;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

@WebSocket
public class WebSocketImpl {
	 
    private Session session;
	private NotificationsManager socketNotificationsClient;
	private CountDownLatch countDownLatch = new CountDownLatch(1);
    
	public WebSocketImpl(NotificationsManager socketNotificationsClient) {
		this.socketNotificationsClient = socketNotificationsClient;
    }
 
	public void close() {
		try {
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public void waitForEndpointId() {
    	try {
			countDownLatch.await(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        this.session = null;
    }
 
    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        System.out.println("Connect");
    }
 
    @OnWebSocketMessage
    public void onMessage(String msg) {
    	try {
    		System.out.println(msg);
			JsonReader jsonReader = new JsonReader(new StringReader(msg));
			JsonParser parser = new JsonParser();
			JsonElement parse = parser.parse(jsonReader);
			if (parse instanceof JsonObject) {
				JsonObject object = (JsonObject)parse;
				if (object.has("welcome")) {
					String token = socketNotificationsClient.getBimServerClient().getToken();
					session.getRemote().sendString("{\"token\":\"" + token + "\"}");
				} else if (object.has("endpointid")) {
					socketNotificationsClient.setEndpointId(object.get("endpointid").getAsLong());
					countDownLatch.countDown();
				} else {
					try {
						socketNotificationsClient.handleIncoming(object.get("request").getAsJsonObject());
					} catch (UserException e) {
						e.printStackTrace();
					} catch (JSONException e) {
						e.printStackTrace();
					} catch (ConvertException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}