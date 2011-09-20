package org.bimserver.pb.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ReflectiveRpcChannel;

public class ProtocolBuffersServer extends Thread {
	private boolean running;
	private final Set<ProtocolBuffersConnectionHandler> activeHandlers = new HashSet<ProtocolBuffersConnectionHandler>();
	private final ServiceFactoryRegistry serviceFactoryRegistry;
	private final ProtocolBuffersMetaData protocolBuffersMetaData;

	public ProtocolBuffersServer(ProtocolBuffersMetaData protocolBuffersMetaData, ServiceFactoryRegistry serviceFactoryRegistry) {
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		this.serviceFactoryRegistry = serviceFactoryRegistry;
	}
	
	@Override
	public void run() {
		running = true;
		try {
			ServerSocket serverSocket = new ServerSocket(8020);
			while (running) {
				Socket socket = serverSocket.accept();
				ProtocolBuffersConnectionHandler protocolBuffersConnectionHandler = new ProtocolBuffersConnectionHandler(socket, this);
				activeHandlers.add(protocolBuffersConnectionHandler);
				protocolBuffersConnectionHandler.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ServiceFactoryRegistry getServiceFactoryRegistry() {
		return serviceFactoryRegistry;
	}
	
	public ProtocolBuffersMetaData getProtocolBuffersMetaData() {
		return protocolBuffersMetaData;
	}
	
	public void registerService(ReflectiveRpcChannel reflectiveRpcChannel) {
		
	}
}