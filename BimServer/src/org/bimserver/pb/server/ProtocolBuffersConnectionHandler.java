package org.bimserver.pb.server;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
import org.bimserver.shared.pb.ReflectiveRpcChannel;
import org.bimserver.webservices.PublicInterfaceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;

public class ProtocolBuffersConnectionHandler extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolBuffersConnectionHandler.class);
	private OutputStream outputStream;
	private DataInputStream dataInputStream;
	private final ProtocolBuffersServer protocolBuffersServer;
	private final SServicesMap servicesMap;
	private PublicInterfaceFactory serviceFactory;
	private volatile boolean running;
	private Socket socket;

	public ProtocolBuffersConnectionHandler(Socket socket, ProtocolBuffersServer protocolBuffersServer, PublicInterfaceFactory serviceFactory, SServicesMap servicesMap) {
		this.socket = socket;
		this.protocolBuffersServer = protocolBuffersServer;
		this.serviceFactory = serviceFactory;
		this.servicesMap = servicesMap;
		setName("ProtocolBuffersConnectionHandler");
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			outputStream = socket.getOutputStream();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public void run() {
		try {
			running = true;
			while (running) {
				String serviceName = dataInputStream.readUTF();
				String methodName = dataInputStream.readUTF();
				String token = dataInputStream.readUTF();
				ProtocolBuffersMetaData protocolBuffersMetaData = protocolBuffersServer.getProtocolBuffersMetaData();
				
				SService sService = servicesMap.getBySimpleName(serviceName);
				if (sService == null) {
					throw new UserException("No service found with name " + serviceName);
				}
				SMethod method = sService.getSMethod(methodName);
				if (method == null) {
					throw new UserException("Method " + methodName + " not found on " + serviceName);
				}
				
				Class<? extends PublicInterface> clazz = sService.getInterfaceClass();
				PublicInterface service = null;
				if (token.equals("")) {
					service = serviceFactory.get(AccessMethod.PROTOCOL_BUFFERS).get(clazz);
				} else {
					service = serviceFactory.get(token, AccessMethod.PROTOCOL_BUFFERS).get(clazz);
				}

				ReflectiveRpcChannel reflectiveRpcChannel = new ReflectiveRpcChannel(clazz, service, protocolBuffersMetaData, servicesMap);
				MethodDescriptorContainer pbMethod = protocolBuffersMetaData.getMethod(serviceName, methodName);
				Builder requestBuilder = DynamicMessage.getDefaultInstance(pbMethod.getInputDescriptor()).newBuilderForType();
				requestBuilder.mergeDelimitedFrom(dataInputStream);
				Message response = reflectiveRpcChannel.callBlockingMethod(pbMethod, requestBuilder.build());
				response.writeDelimitedTo(outputStream);
				outputStream.flush();
			}
		} catch (SocketException e) {
		} catch (EOFException e) {
		} catch (Exception e) {
			if (running) {
				LOGGER.error("", e);
			}
		}
		protocolBuffersServer.unregister(this);
	}

	public void close() {
		running = false;
		try {
			socket.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		interrupt();
	}
}