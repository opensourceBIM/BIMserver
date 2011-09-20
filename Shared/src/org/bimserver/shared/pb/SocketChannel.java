package org.bimserver.shared.pb;

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