package org.bimserver.pb.server;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ReflectiveRpcChannel;
import org.bimserver.webservices.PublicInterfaceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtocolBuffersServer extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolBuffersServer.class);
	private volatile boolean running;
	private final Set<ProtocolBuffersConnectionHandler> activeHandlers = new HashSet<ProtocolBuffersConnectionHandler>();
	private final ProtocolBuffersMetaData protocolBuffersMetaData;
	private final int port;
	private ServerSocket serverSocket;
	private final SServicesMap servicesMap;
	private final PublicInterfaceFactory publicInterfaceFactory;

	public ProtocolBuffersServer(ProtocolBuffersMetaData protocolBuffersMetaData, PublicInterfaceFactory publicInterfaceFactory, SServicesMap servicesMap, int port) {
		this.publicInterfaceFactory = publicInterfaceFactory;
		setName("ProtocolBuffersServer");
		this.servicesMap = servicesMap;
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		this.port = port;
	}

	@Override
	public void run() {
		running = true;
		try {
			serverSocket = new ServerSocket(port);
			while (running) {
				Socket socket = serverSocket.accept();
				ProtocolBuffersConnectionHandler protocolBuffersConnectionHandler = new ProtocolBuffersConnectionHandler(socket, this, publicInterfaceFactory, servicesMap);
				activeHandlers.add(protocolBuffersConnectionHandler);
				protocolBuffersConnectionHandler.start();
			}
		} catch (IOException e) {
			if (running) {
				LOGGER.error("", e);
			}
		}
	}

	public ProtocolBuffersMetaData getProtocolBuffersMetaData() {
		return protocolBuffersMetaData;
	}
	
	public void registerService(ReflectiveRpcChannel reflectiveRpcChannel) {
		
	}

	public void shutdown() {
		running = false;
		try {
			serverSocket.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		for (ProtocolBuffersConnectionHandler protocolBuffersConnectionHandler : activeHandlers) {
			protocolBuffersConnectionHandler.close();
		}
		this.interrupt();
	}

	public void unregister(ProtocolBuffersConnectionHandler protocolBuffersConnectionHandler) {
		activeHandlers.remove(protocolBuffersConnectionHandler);
	}
}