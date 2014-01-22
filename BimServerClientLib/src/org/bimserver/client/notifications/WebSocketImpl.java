package org.bimserver.client.notifications;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

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
		try {
			session.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
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
						LOGGER.error("", e);
					} catch (JSONException e) {
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
}