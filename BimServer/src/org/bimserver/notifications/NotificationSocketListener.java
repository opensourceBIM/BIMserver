package org.bimserver.notifications;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class NotificationSocketListener extends Thread {
	private final Set<NotificationSocketHandler> handlers = new HashSet<NotificationSocketHandler>();
	
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(8050);
			while (true) {
				Socket socket = serverSocket.accept();
//				NotificationSocketHandler handler = new NotificationSocketHandler(socket);
//				handlers.add(handler);
//				handler.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
