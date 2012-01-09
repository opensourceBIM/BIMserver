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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;

public class Reflector extends ProtocolBuffersConverter {

	private final ProtocolBuffersMetaData protocolBuffersMetaData;
	private final Channel channel;
	private final SService sService;

	public Reflector(ProtocolBuffersMetaData protocolBuffersMetaData, SService sService, Channel channel) {
		super(sService);
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		this.sService = sService;
		this.channel = channel;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, Object... args) throws ServerException, UserException {
		MethodDescriptorContainer methodDescriptorContainer = protocolBuffersMetaData.getMethod(interfaceName, methodName);
		Descriptor inputDescriptor = methodDescriptorContainer.getInputDescriptor();
		Builder builder = DynamicMessage.newBuilder(methodDescriptorContainer.getInputDescriptor());
		int i = 0;
		for (FieldDescriptor field : inputDescriptor.getFields()) {
			Object arg = args[i++];
			if (field.getJavaType() == JavaType.ENUM) {
				EnumDescriptor enumType = field.getEnumType();
				builder.setField(field, enumType.findValueByName(arg.toString()));
			} else {
				if (arg instanceof SBase) {
					builder.setField(field, convertSObjectToProtocolBuffersObject(field.getMessageType(), (SBase)arg));
				} else if (arg instanceof DataHandler) {
					DataHandler dataHandler = (DataHandler)arg;
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					try {
						IOUtils.copy(dataHandler.getInputStream(), baos);
					} catch (IOException e) {
						e.printStackTrace();
					}
					builder.setField(field, ByteString.copyFrom(baos.toByteArray()));
				} else {
					builder.setField(field, arg);
				}
			}
		}
		SMethod sMethod = sService.getSMethod(methodName);
		DynamicMessage message = builder.build();
		try {
			Message result = channel.callBlockingMethod(methodDescriptorContainer, message);
			String errorMessage = (String) result.getField(methodDescriptorContainer.getOutputField("errorMessage"));
			if (errorMessage.equals("OKE")) {
				if (result.getDescriptorForType().getName().equals("VoidResponse")) {
					return null;
				} else {
					FieldDescriptor outputField = methodDescriptorContainer.getOutputField("value");
					Object value = result.getField(outputField);
					if (outputField.isRepeated()) {
						if (value instanceof Collection) {
							Collection collection = (Collection)value;
							Collection x = null;
							if (definedReturnType == List.class) {
								x = new ArrayList();
							} else if (definedReturnType == Set.class) {
								x = new HashSet();
							}
							for (Object v : collection) {
								if (v instanceof DynamicMessage) {
									x.add(convertProtocolBuffersMessageToSObject((DynamicMessage) v, sMethod.getGenericReturnType()));
								} else {
									x.add(v);
								}
							}
							return x;
						} else {
							return new ArrayList();
						}
					} else if (outputField.getJavaType() == JavaType.ENUM) {
						EnumDescriptor enumType = outputField.getEnumType();
						return enumType.findValueByName(value.toString());
					} else if (value instanceof DynamicMessage) {
						return convertProtocolBuffersMessageToSObject((DynamicMessage) value, sMethod.getReturnType());
					} else {
						if  (definedReturnType == Date.class) {
							return new Date((Long)value);
						}
						return value;
					}
				}
			} else {
				throw new UserException(errorMessage);
			}
		} catch (ServiceException e) {
			throw new ServerException(e.getMessage());
		}
	}
}