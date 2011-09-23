package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
