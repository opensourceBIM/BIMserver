package org.bimserver.shared.pb;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;

public class Reflector extends ProtocolBuffersConverter {

	private final ProtocolBuffersMetaData protocolBuffersMetaData;
	private final Channel channel;

	public Reflector(ProtocolBuffersMetaData protocolBuffersMetaData, Channel channel) {
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		this.channel = channel;
	}

	public Object callMethod(String interfaceName, String methodName, Object... args) throws org.bimserver.shared.exceptions.ServiceException {
		MethodDescriptorContainer methodDescriptorContainer = protocolBuffersMetaData.getMethod(interfaceName, methodName);
		Descriptor inputDescriptor = methodDescriptorContainer.getInputDescriptor();
		Builder builder = DynamicMessage.newBuilder(methodDescriptorContainer.getInputDescriptor());
		int i = 0;
		for (FieldDescriptor field : inputDescriptor.getFields()) {
			builder.setField(field, args[i++]);
		}
		DynamicMessage message = builder.build();
		try {
			Message result = channel.callBlockingMethod(methodDescriptorContainer, message);
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