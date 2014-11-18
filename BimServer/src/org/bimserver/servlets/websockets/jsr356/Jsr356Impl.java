package org.bimserver.servlets.websockets.jsr356;

import java.io.IOException;
import java.io.StringReader;
import java.nio.ByteBuffer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
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

@WebListener
@ServerEndpoint(value = "/stream")
public class Jsr356Impl implements StreamingSocketInterface, ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(Jsr356Impl.class);
	private Streamer streamer;
	private Session websocketSession;
	private static ServletContext servletContext;
	
	public Jsr356Impl() {
		LOGGER.info("WebSocket object created");
	}

	@OnOpen
	public void onOpen(Session websocketSession, EndpointConfig config) {
		LOGGER.info("WebSocket session opened");
		try {
			this.websocketSession = websocketSession;
			LOGGER.info("Servlet Context: " + servletContext);
			BimServer bimServer = (BimServer) servletContext.getAttribute("bimserver");
			LOGGER.info("bimserver: " + bimServer);
			streamer = new Streamer(this, bimServer);
			streamer.onOpen();
		} catch (Throwable t) {
			LOGGER.error("", t);
		}
	}
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		LOGGER.info("WebSocket context initialized");
        servletContext = servletContextEvent.getServletContext();
    }

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
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