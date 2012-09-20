package org.bimwebserver.servlets;

import org.eclipse.jetty.websocket.WebSocket;

public class StreamingSocket implements WebSocket.OnTextMessage {

	private Connection connection;

	public StreamingSocket() {
		System.out.println("new streaming socket");
	}
	
	@Override
	public void onClose(int arg0, String arg1) {
		System.out.println("close");
	}

	@Override
	public void onOpen(Connection connection) {
		System.out.println("open");
		this.connection = connection;
	}

	@Override
	public void onMessage(String message) {
		System.out.println(message);
	}
}