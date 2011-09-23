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