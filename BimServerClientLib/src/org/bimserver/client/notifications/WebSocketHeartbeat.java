package org.bimserver.client.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class WebSocketHeartbeat extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketHeartbeat.class);
	private WebSocketImpl webSocketImpl;
	private volatile boolean running = true;

	public WebSocketHeartbeat(WebSocketImpl webSocketImpl) {
		this.webSocketImpl = webSocketImpl;
		setName("WebSocket Heartbeat");
	}

	public void shutdown() {
		this.running = false;
		this.interrupt();
	}
	
	@Override
	public void run() {
		ObjectNode message = new ObjectMapper().createObjectNode();
		message.put("hb", true);
		while (running) {
			try {
				Thread.sleep(1000 * 30);
			} catch (InterruptedException e) {
				if (running) {
					LOGGER.error("", e);
				}
				return;
			}
			if (running) {
				webSocketImpl.send(message);
			}
		}
	}
}