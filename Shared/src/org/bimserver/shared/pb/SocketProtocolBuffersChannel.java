package org.bimserver.shared.pb;

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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;

public class SocketProtocolBuffersChannel {

	private static final Logger LOGGER = LoggerFactory.getLogger(SocketProtocolBuffersChannel.class);
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private DataOutputStream dataOutputStream;
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();
	private TokenHolder tokenHolder;

	public SocketProtocolBuffersChannel(TokenHolder tokenHolder) {
		this.tokenHolder = tokenHolder;
	}
	
	public void connect(InetSocketAddress address) throws IOException {
		socket = new Socket(address.getAddress(), address.getPort());
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
		dataOutputStream = new DataOutputStream(outputStream);
		notifyOfConnect();
	}

	public Message callBlockingMethod(MethodDescriptorContainer methodDescriptor, Message request) throws ServiceException {
		try {
			dataOutputStream.writeUTF(methodDescriptor.getServiceDescriptorContainer().getName());
			dataOutputStream.writeUTF(methodDescriptor.getName());
			dataOutputStream.writeUTF(tokenHolder.getToken() == null ? "" : tokenHolder.getToken());
			request.writeDelimitedTo(dataOutputStream);
			dataOutputStream.flush();
			DynamicMessage response = DynamicMessage.getDefaultInstance(methodDescriptor.getOutputDescriptor());
			Builder responseBuilder = response.newBuilderForType();
			responseBuilder.mergeDelimitedFrom(inputStream);
			return responseBuilder.build();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public void notifyOfConnect() {
		for (ConnectDisconnectListener connectDisconnectListener : connectDisconnectListeners) {
			connectDisconnectListener.connected();
		}
	}
	
	public void notifyOfDisconnect() {
		for (ConnectDisconnectListener connectDisconnectListener : connectDisconnectListeners) {
			connectDisconnectListener.disconnected();
		}
	}

	public void registerConnectDisconnectListener(ConnectDisconnectListener connectDisconnectListener) {
		connectDisconnectListeners.add(connectDisconnectListener);
	}

	public void disconnect() {
		try {
			socket.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		notifyOfDisconnect();
	}
}