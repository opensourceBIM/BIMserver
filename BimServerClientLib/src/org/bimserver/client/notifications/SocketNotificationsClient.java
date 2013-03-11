package org.bimserver.client.notifications;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketNotificationsClient extends NotificationsClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(SocketNotificationsClient.class);
	private ProtocolBuffersMetaData protocolBuffersMetaData;
	private InetSocketAddress address;
	private SServicesMap servicesMap;
	private boolean running;
	private ServerSocket serverSocket;
	private final Set<Handler> handlers = new HashSet<Handler>();
	private Thread thread;

	public void start() {
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				running = true;
				try {
					while (running) {
						Socket socket = serverSocket.accept();
						notifyConnect();
						Handler handler = new Handler(SocketNotificationsClient.this, socket, null, protocolBuffersMetaData, servicesMap);
						handlers.add(handler);
						handler.start();
					}
				} catch (IOException e) {
					LOGGER.error("", e);
				}
				notifyDisconnect();
			}
		});
		thread.start();
	}

	public void connect(SServicesMap servicesMap, InetSocketAddress address) {
		this.servicesMap = servicesMap;
		this.address = address;
	}

	public void disconnect() {
		running = false;
		thread.interrupt();
		for (Handler handler : handlers) {
			handler.close();
		}
		try {
			serverSocket.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void startAndWaitForInit() {
		try {
			running = true;
			serverSocket = new ServerSocket();
			serverSocket.bind(address);
			start();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public void unregisterNotifictionListener(NotificationInterface notificationInterface) {
		
	}
}