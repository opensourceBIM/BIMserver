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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;

public class ProtocolBuffersReflector extends ProtocolBuffersConverter implements Reflector {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolBuffersReflector.class);
	private final ProtocolBuffersMetaData protocolBuffersMetaData;
	private final SocketProtocolBuffersChannel channel;
	private SServicesMap servicesMap;

	public ProtocolBuffersReflector(ProtocolBuffersMetaData protocolBuffersMetaData, SServicesMap servicesMap, SocketProtocolBuffersChannel channel) {
		super(protocolBuffersMetaData);
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		this.servicesMap = servicesMap;
		this.channel = channel;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) throws ServerException, UserException {
		try {
			MethodDescriptorContainer methodDescriptorContainer;
			try {
				methodDescriptorContainer = protocolBuffersMetaData.getMethod(interfaceName, methodName);
				SMethod sMethod = servicesMap.getBySimpleName(interfaceName).getSMethod(methodName);
				Descriptor inputDescriptor = methodDescriptorContainer.getInputDescriptor();
				Builder builder = DynamicMessage.newBuilder(methodDescriptorContainer.getInputDescriptor());
				int i = 0;
				for (FieldDescriptor field : inputDescriptor.getFields()) {
					Object arg = args[i].getValue();
					if (field.getJavaType() == JavaType.ENUM) {
						EnumDescriptor enumType = field.getEnumType();
						builder.setField(field, enumType.findValueByName(arg.toString()));
					} else {
						if (arg instanceof SBase) {
							builder.setField(field, convertSObjectToProtocolBuffersObject((SBase) arg, sMethod.getParameter(i).getType()));
						} else if (arg instanceof DataHandler) {
							DataHandler dataHandler = (DataHandler) arg;
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							try {
								IOUtils.copy(dataHandler.getInputStream(), baos);
							} catch (IOException e) {
								LOGGER.error("", e);
							}
							builder.setField(field, ByteString.copyFrom(baos.toByteArray()));
						} else {
							if (arg != null) {
								if (arg instanceof Collection) {
									Collection col = (Collection) arg;
									Iterator iterator = col.iterator();
									while (iterator.hasNext()) {
										Object o = iterator.next();
										builder.addRepeatedField(field, o);
									}
								} else {
									builder.setField(field, arg);
								}
							}
						}
					}
					i++;
				}
				DynamicMessage message = builder.build();
				Message result = channel.callBlockingMethod(methodDescriptorContainer, message);
				FieldDescriptor errorMessageField = methodDescriptorContainer.getOutputField("errorMessage");
				String errorMessage = (String) result.getField(errorMessageField);
				if (errorMessage.equals("OKE")) {
					if (result.getDescriptorForType().getName().equals("VoidResponse")) {
						return null;
					} else {
						FieldDescriptor outputField = methodDescriptorContainer.getOutputField("value");
						Object value = result.getField(outputField);
						if (outputField.isRepeated()) {
							if (value instanceof Collection) {
								Collection collection = (Collection) value;
								Collection x = null;
								if (definedReturnType == List.class) {
									x = new ArrayList();
								} else if (definedReturnType == Set.class) {
									x = new HashSet();
								}
								for (Object v : collection) {
									if (v instanceof DynamicMessage) {
										x.add(convertProtocolBuffersMessageToSObject((DynamicMessage) v, null, sMethod.getBestReturnType()));
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
							return convertProtocolBuffersMessageToSObject((DynamicMessage) value, null, sMethod.getBestReturnType());
						} else {
							if (definedReturnType == Date.class) {
								return new Date((Long) value);
							}
							return value;
						}
					}
				} else {
					throw new UserException(errorMessage);
				}
			} catch (ConvertException e) {
				throw new ServerException(e);
			} catch (ServiceException e) {
				throw new ServerException(e.getMessage());
			}
		} catch (ServiceNotFoundException e) {
			throw new ServerException(e);
		} catch (ServiceMethodNotFoundException e) {
			throw new ServerException(e);
		}
	}
}