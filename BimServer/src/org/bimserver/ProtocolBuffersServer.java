package org.bimserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolBuffersServer extends Thread {
	private ServerSocket serverSocket;

	public ProtocolBuffersServer(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		Socket socket;
		try {
			socket = serverSocket.accept();
			while (socket != null && !serverSocket.isClosed()) {
				ProtocolBuffersHandler protocolBuffersHandler = new ProtocolBuffersHandler(socket);
				protocolBuffersHandler.start();
				socket = serverSocket.accept();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
