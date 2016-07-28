package org.bimserver.servlets.websockets.jsr356;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.concurrent.Future;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.bimserver.BimServer;
import org.bimserver.servlets.Streamer;
import org.bimserver.shared.StreamingSocketInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

@WebListener
@ServerEndpoint(value = "/stream")
public class Jsr356Impl implements StreamingSocketInterface, ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(Jsr356Impl.class);
	private Streamer streamer;
	private Session websocketSession;
	
	// This is a static reference unfortunately. This is because the only other
	// way of getting the ServletContext (and thus BimServer instance)
	// to the websocket methods would be via the httpsession, which we don't
	// have/use/want. This will probably be fixed in a later
	// version of JSR-356 and implementations
	private static ServletContext servletContext;
	
	@OnOpen
	public void onOpen(Session websocketSession, EndpointConfig config) {
		LOGGER.debug("WebSocket open");
		try {
			this.websocketSession = websocketSession;
			BimServer bimServer = (BimServer) servletContext.getAttribute("bimserver");
			streamer = new Streamer(this, bimServer);
			streamer.onOpen();
		} catch (Throwable t) {
			LOGGER.error("", t);
		}
	}

	public static void setServletContext(ServletContext servletContext) {
		Jsr356Impl.servletContext = servletContext;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		LOGGER.info("WebSocket context initialized");
        servletContext = servletContextEvent.getServletContext();
    }

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		LOGGER.info("WebSocket context destroyed");
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		streamer.onText(new StringReader(message));
	}
	
	@OnError
	public void onError(Throwable exception, Session session) {
		if (exception instanceof IOException) {
			// Let this one slide, usually indicates a disconnected client
		} else {
			LOGGER.error("", exception);
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		streamer.onClose();
	}

	@Override
	public void send(JsonObject request) {
		synchronized (this) {
			if (websocketSession.isOpen()) {
				websocketSession.getAsyncRemote().sendText(request.toString());
			} else {
				streamer.onClose();
			}
		}
	}

	@Override
	public Future<Void> send(byte[] data, int start, int length) throws IOException {
		synchronized (this) {
			return websocketSession.getAsyncRemote().sendBinary(ByteBuffer.wrap(data, start, length));
		}
	}

	@Override
	public void sendBlocking(byte[] data, int start, int length) {
		synchronized (this) {
			websocketSession.getAsyncRemote().sendBinary(ByteBuffer.wrap(data, start, length));
		}
	}
}