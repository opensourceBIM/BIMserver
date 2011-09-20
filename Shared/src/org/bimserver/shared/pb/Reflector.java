package org.bimserver.shared.pb;

import java.io.IOException;
import java.net.URL;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;
import com.googlecode.protobuf.socketrpc.SocketRpcController;

public class Reflector extends ProtocolBuffersConverter {

	private final BlockingRpcChannel rpcChannel;
	private final SocketRpcController rpcController;
	private ProtocolBuffersMetaData protocolBuffersMetaData;
	private String interfaceName;

	public Reflector(URL desc, SocketRpcController rpcController, BlockingRpcChannel rpcChannel) {
		this.rpcController = rpcController;
		this.rpcChannel = rpcChannel;
		try {
			protocolBuffersMetaData = new ProtocolBuffersMetaData();
			interfaceName = protocolBuffersMetaData.load(desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object callMethod(String methodName, Object... args) throws org.bimserver.shared.exceptions.ServiceException {
		MethodDescriptorContainer methodDescriptorContainer = protocolBuffersMetaData.getMethod(interfaceName, methodName);
		Descriptor inputDescriptor = methodDescriptorContainer.getInputDescriptor();
		Builder builder = DynamicMessage.newBuilder(methodDescriptorContainer.getInputDescriptor());
		int i = 0;
		for (FieldDescriptor field : inputDescriptor.getFields()) {
			builder.setField(field, args[i++]);
		}
		DynamicMessage message = builder.build();
		try {
			Message result = rpcChannel.callBlockingMethod(methodDescriptorContainer.getMethodDescriptor(), rpcController, message, DynamicMessage.getDefaultInstance(methodDescriptorContainer.getOutputDescriptor()));
			String errorMessage = (String) result.getField(methodDescriptorContainer.getOutputField("errorMessage"));
			if (errorMessage.equals("OKE")) {
				if (result.getDescriptorForType().getName().equals("VoidResponse")) {
					return null;
				} else {
					Object value = result.getField(methodDescriptorContainer.getOutputField("value"));
					if (value instanceof DynamicMessage) {
						return convertProtocolBuffersMessageToSObject((DynamicMessage) value);
					}
					return value;
				}
			} else {
				throw new UserException(errorMessage);
			}
		} catch (ServiceException e) {
			throw new ServerException(e.getMessage());
		}
	}
}