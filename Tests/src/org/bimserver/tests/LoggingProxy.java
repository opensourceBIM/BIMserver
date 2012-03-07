package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoggingProxy {
	public static void main(String[] args) {
		new LoggingProxy().start();
	}

	private void start() {
		int listenPort = 7777;
		final int remotePort = 8080;
		
		try {
			ServerSocket serverSocket = new ServerSocket(listenPort);
			while (true) {
				final Socket socket = serverSocket.accept();
				final Socket remoteSocket = new Socket("localhost", remotePort);
				Thread thread1 = new Thread(new Runnable(){
					@Override
					public void run() {
						try {
							OutputStream outputStream = remoteSocket.getOutputStream();
							InputStream inputStream = socket.getInputStream();
							byte[] buffer = new byte[1024];
							int red = inputStream.read(buffer, 0, buffer.length);
							while (red != -1) {
								outputStream.write(buffer, 0, red);
								System.out.print(new String(buffer, 0, red, "UTF-8"));
								red = inputStream.read(buffer, 0, buffer.length);
							}
						} catch (UnknownHostException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}});
				thread1.start();
				Thread thread2 = new Thread(new Runnable(){
					@Override
					public void run() {
						try {
							OutputStream outputStream = socket.getOutputStream();
							InputStream inputStream = remoteSocket.getInputStream();
							byte[] buffer = new byte[1024];
							int red = inputStream.read(buffer, 0, buffer.length);
							while (red != -1) {
								outputStream.write(buffer, 0, red);
								System.out.print(new String(buffer, 0, red, "UTF-8"));
								red = inputStream.read(buffer, 0, buffer.length);
							}
						} catch (UnknownHostException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}});
				thread2.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}