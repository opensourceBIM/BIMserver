package org.bimserver.shared.pb;

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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;

import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;

public class SocketChannel implements Channel {

	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private DataOutputStream dataOutputStream;

	public SocketChannel(InetSocketAddress address) {
		try {
			socket = new Socket(address.getAddress(), address.getPort());
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Message callBlockingMethod(MethodDescriptorContainer methodDescriptor, Message request) throws ServiceException {
		try {
			dataOutputStream.writeUTF(methodDescriptor.getServiceDescriptorContainer().getName());
			dataOutputStream.writeUTF(methodDescriptor.getName());
			request.writeDelimitedTo(dataOutputStream);
			dataOutputStream.flush();
			DynamicMessage response = DynamicMessage.getDefaultInstance(methodDescriptor.getOutputDescriptor());
			Builder responseBuilder = response.newBuilderForType();
			responseBuilder.mergeDelimitedFrom(inputStream);
			return responseBuilder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}