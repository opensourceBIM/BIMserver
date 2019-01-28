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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
import org.bimserver.shared.reflector.KeyValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Message;
import com.google.protobuf.Message.Builder;

public class ReflectiveRpcChannel extends ProtocolBuffersConverter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectiveRpcChannel.class);
	private final ProtocolBuffersMetaData protocolBuffersMetaData;
	private Class<? extends PublicInterface> publicInterface = null;
	private final PublicInterface service;
	private SServicesMap servicesMap;

	public ReflectiveRpcChannel(Class<? extends PublicInterface> publicInterface, PublicInterface service, ProtocolBuffersMetaData protocolBuffersMetaData, SServicesMap servicesMap) {
		super(protocolBuffersMetaData);
		this.service = service;
		this.publicInterface = publicInterface;
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		this.servicesMap = servicesMap;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Message callBlockingMethod(MethodDescriptorContainer methodDescriptor, Message request) {
		FieldDescriptor errorMessageField = methodDescriptor.getOutputField("errorMessage");
		DynamicMessage response = DynamicMessage.getDefaultInstance(methodDescriptor.getOutputDescriptor());
		Descriptor inputType = methodDescriptor.getInputDescriptor();
		SMethod sMethod = servicesMap.getBySimpleName(methodDescriptor.getServiceDescriptorContainer().getName()).getSMethod(methodDescriptor.getName());
		if (sMethod == null) {
			LOGGER.info("Method " + methodDescriptor.getName() + " not found");
			return null;
		} else {
			try {
				KeyValuePair[] arguments = new KeyValuePair[inputType.getFields().size()];
				int i = 0;
				for (FieldDescriptor fieldDescriptor : inputType.getFields()) {
					SParameter sParameter = sMethod.getParameter(i);
					Object value = request.getField(fieldDescriptor);
					if (value instanceof EnumValueDescriptor) {
						EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor)value;
						Class en = getJavaType(fieldDescriptor);
						arguments[i] = new KeyValuePair(fieldDescriptor.getName(), en.getEnumConstants()[enumValueDescriptor.getIndex()]);
					} else if (value instanceof ByteString) {
						ByteString byteString = (ByteString)value;
						DataSource dataSource = new org.bimserver.utils.ByteArrayDataSource("bytes", byteString.toByteArray());
						DataHandler dataHandler = new DataHandler(dataSource);
						arguments[i] = new KeyValuePair(fieldDescriptor.getName(), dataHandler);
					} else if (value instanceof DynamicMessage) {
						arguments[i] = new KeyValuePair(fieldDescriptor.getName(), convertProtocolBuffersMessageToSObject((DynamicMessage)value, null, sParameter.getType()));
					} else if (value instanceof Collection) {
						Collection col = (Collection)value;
						if (sParameter.getType().isList()) {
							List list = new ArrayList(col);
							arguments[i] = new KeyValuePair(fieldDescriptor.getName(), list);
						} else if (sParameter.getType().isSet()) {
							Set set = new HashSet(col);
							arguments[i] = new KeyValuePair(fieldDescriptor.getName(), set);
						}
					} else {
						arguments[i] = new KeyValuePair(fieldDescriptor.getName(), value);
					}
					i++;
				}
				Object result = sMethod.invoke(publicInterface, service, arguments);
				Builder builder = response.newBuilderForType();
				if (methodDescriptor.getOutputDescriptor().getName().equals("VoidResponse")) {
					builder.setField(errorMessageField, "OKE");
				} else {
					FieldDescriptor valueField = protocolBuffersMetaData.getMessageDescriptor(response.getDescriptorForType().getName()).getField("value");
					if (result != null) {
						if (valueField.getType().getJavaType() == JavaType.ENUM) {
							builder.setField(valueField, valueField.getEnumType().findValueByName(result.toString()));
						} else if (valueField.getType().getJavaType() != JavaType.MESSAGE) {
							if (result instanceof Date) {
								builder.setField(valueField, ((Date)result).getTime());
							} else {
								if (valueField.isRepeated()) {
									builder.setField(valueField, new ArrayList());
								} else {
									builder.setField(valueField, result);
								}
							}
						} else if (result instanceof List) {
							List list = new ArrayList();
							List originalList = (List) result;
							for (Object object : originalList) {
								list.add(convertSObjectToProtocolBuffersObject((SBase) object, sMethod.getBestReturnType()));
							}
							builder.setField(valueField, list);
						} else if (result instanceof Set) {
							List list = new ArrayList();
							Set originalSet = (Set) result;
							for (Object object : originalSet) {
								list.add(convertSObjectToProtocolBuffersObject((SBase) object, sMethod.getBestReturnType()));
							}
							builder.setField(valueField, list);
						} else {
							builder.setField(valueField, convertSObjectToProtocolBuffersObject((SBase) result, sMethod.getBestReturnType()));
						}
					}
					builder.setField(errorMessageField, "OKE");
				}
				return builder.build();
	//		} catch (InvocationTargetException e) {
	//			Builder errorMessage = response.newBuilderForType();
	//			if (e.getTargetException() != null && e.getTargetException().getMessage() != null) {
	//				errorMessage.setField(errorMessageField, e.getTargetException().getMessage());
	//			} else {
	//				if (e.getMessage() != null) {
	//					errorMessage.setField(errorMessageField, e.getMessage());
	//				} else {
	//					errorMessage.setField(errorMessageField, "Unknown error");
	//				}
	//			}
	//			return errorMessage.build();
			} catch (Exception e) {
				if (!(e instanceof org.bimserver.shared.exceptions.ServiceException)) {
					LOGGER.error("", e);
				}
				Builder errorMessage = response.newBuilderForType();
				if (e.getMessage() != null) {
					errorMessage.setField(errorMessageField, e.getMessage());
				} else {
					LOGGER.error("", e);
					errorMessage.setField(errorMessageField, "Unknown error");
				}
				return errorMessage.build();
			}
		}
	}
}