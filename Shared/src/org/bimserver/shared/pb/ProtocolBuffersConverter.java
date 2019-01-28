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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MessageDescriptorContainer;
import org.bimserver.utils.ByteArrayDataSource;
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

public class ProtocolBuffersConverter {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolBuffersConverter.class);
	private final ProtocolBuffersMetaData protocolBuffersMetaData;

	public ProtocolBuffersConverter(ProtocolBuffersMetaData protocolBuffersMetaData) {
		this.protocolBuffersMetaData = protocolBuffersMetaData;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SBase convertProtocolBuffersMessageToSObject(Message message, SBase newInstance, SClass sClass) throws ConvertException {
		try {
			Descriptor descriptor = message.getDescriptorForType();
			if (newInstance == null) {
				newInstance = sClass.newInstance();
			}
			Message subTypeMessage = null;
			for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
				if (fieldDescriptor.getName().equals("__actual_type")) {
					sClass = sClass.getServicesMap().getSType((String)message.getField(fieldDescriptor));
					newInstance = sClass.newInstance();
				} else if (fieldDescriptor.getName().startsWith("__")) {
					if (fieldDescriptor.getName().substring(2).equals(sClass.getSimpleName())) {
						subTypeMessage = (Message) message.getField(fieldDescriptor);
					}
				} else {
					Object val = message.getField(fieldDescriptor);
					SField field = newInstance.getSClass().getField(fieldDescriptor.getName());
					if (field == null) {
						throw new ConvertException("No field on " + sClass.getName() + " with name " + fieldDescriptor.getName());
					}
					if (fieldDescriptor.isRepeated()) {
						List list = new ArrayList();
						if (val instanceof List) {
							List oldList = (List) val;
							for (Object x : oldList) {
								list.add(convertFieldValue(field, x));
							}
						} else if (val instanceof DynamicMessage) {
							int size = message.getRepeatedFieldCount(fieldDescriptor);
							for (int index=0; index<size; index++) {
								Object repeatedField = message.getRepeatedField(fieldDescriptor, index);
								list.add(convertFieldValue(field, repeatedField));
							}
						} else {
							throw new ConvertException("Field " + sClass.getName() + "." + fieldDescriptor.getName() + " should have list value");
						}
						newInstance.sSet(field, list);
					} else {
						SField sField = sClass.getField(fieldDescriptor.getName());
						newInstance.sSet(sField, convertFieldValue(sField, val));
					}
				}
			}
			if (subTypeMessage != null) {
				convertProtocolBuffersMessageToSObject(subTypeMessage, newInstance, sClass);
			}
			return newInstance;
		} catch (IllegalArgumentException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	private Object convertFieldValue(SField field, Object val) throws ConvertException {
		if (val instanceof EnumValueDescriptor) {
			EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor) val;
			Class<?> enumClass;
			try {
				enumClass = Class.forName("org.bimserver.interfaces.objects." + enumValueDescriptor.getType().getName());
				for (Object v : enumClass.getEnumConstants()) {
					Enum<?> e = (Enum<?>) v;
					if (e.ordinal() == enumValueDescriptor.getNumber()) {
						val = e;
						break;
					}
				}
			} catch (ClassNotFoundException e) {
				LOGGER.error("", e);
			}
			return val;
		} else if (field.getType().getInstanceClass() == Date.class) {
			return new Date((Long) val);
		} else if (field.getType().getInstanceClass() == DataHandler.class) {
			ByteString byteString = (ByteString) val;
			ByteArrayDataSource byteArrayDataSource = new ByteArrayDataSource("test", byteString.toByteArray());
			return new DataHandler(byteArrayDataSource);
		} else if (val instanceof DynamicMessage) {
			return convertProtocolBuffersMessageToSObject((DynamicMessage) val, null, field.isAggregate() ? field.getGenericType() : field.getType());
		} else {
			return val;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Message convertSObjectToProtocolBuffersObject(SBase object, SClass definedType) throws ConvertException {
		Builder builder = null;
		MessageDescriptorContainer messageDescriptor = protocolBuffersMetaData.getMessageDescriptor(definedType.getSimpleName());
		if (messageDescriptor == null) {
			throw new ConvertException("No message descriptor found with name " + definedType.getSimpleName());
		}
		Descriptor definedDescriptor = messageDescriptor.getDescriptor();
		try {
			builder = DynamicMessage.getDefaultInstance(definedDescriptor).newBuilderForType();
		} catch (SecurityException e) {
			throw new ConvertException(e);
		} catch (IllegalArgumentException e) {
			throw new ConvertException(e);
		}
		SClass sClass = object.getSClass();
		SClass superClass = sClass;
		while (superClass.getSuperClass() != null && superClass.getSuperClass().getInstanceClass() != Object.class) {
			superClass = superClass.getSuperClass();
		}
		if (sClass != superClass && messageDescriptor.getField("__actual_type") != null) {
			builder.setField(messageDescriptor.getField("__actual_type"), sClass.getSimpleName());
			builder.setField(messageDescriptor.getField("__" + sClass.getSimpleName()), convertSObjectToProtocolBuffersObject(object, sClass));
		}
		for (SField field : definedType.getAllFields()) {
			try {
				Object value = object.sGet(field);
				FieldDescriptor fieldDescriptor = messageDescriptor.getField(field.getName());
				if (value != null) {
					if (value.getClass().isPrimitive() || value.getClass() == String.class || value.getClass() == Long.class || value.getClass() == Double.class
							|| value.getClass() == Integer.class || value.getClass() == Boolean.class) {
						builder.setField(fieldDescriptor, value);
					} else if (value.getClass().isEnum()) {
						Enum eNum = (Enum) value;
						int ordinal = eNum.ordinal();
						EnumValueDescriptor findValueByNumber = fieldDescriptor.getEnumType().findValueByNumber(ordinal);
						builder.setField(fieldDescriptor, findValueByNumber);
					} else if (value.getClass() == Date.class) {
						builder.setField(fieldDescriptor, ((Date) value).getTime());
					} else if (value.getClass() == DataHandler.class) {
						DataHandler dataHandler = (DataHandler) value;
						InputStream inputStream = dataHandler.getInputStream();
						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						IOUtils.copy(inputStream, byteArrayOutputStream);
						ByteString byteString = ByteString.copyFrom(byteArrayOutputStream.toByteArray());
						builder.setField(fieldDescriptor, byteString);
					} else if (List.class.isAssignableFrom(value.getClass())) {
						List list = (List) value;
						List newList = new ArrayList();
						for (Object o : list) {
							if (fieldDescriptor.getJavaType() == JavaType.MESSAGE) {
								newList.add(convertSObjectToProtocolBuffersObject((SBase) o, field.getGenericType()));
							} else {
								newList.add(o);
							}
						}
						builder.setField(fieldDescriptor, newList);
					} else {
						LOGGER.error("Unimplemented: " + fieldDescriptor.getName() + ": " + value);
					}
				}
			} catch (SecurityException e) {
				LOGGER.error("", e);
			} catch (IllegalArgumentException e) {
				LOGGER.error("", e);
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return builder.build();
	}

	protected Class<?> getJavaType(FieldDescriptor fieldDescriptor) {
		if (fieldDescriptor.getJavaType() == JavaType.BOOLEAN) {
			return Boolean.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.BYTE_STRING) {
			return DataHandler.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.DOUBLE) {
			return Double.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.FLOAT) {
			return Float.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.INT) {
			return Integer.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.LONG) {
			return Long.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.STRING) {
			return String.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.ENUM) {
			try {
				return Class.forName("org.bimserver.interfaces.objects." + fieldDescriptor.getEnumType().getName());
			} catch (ClassNotFoundException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	protected Class<?> getJavaPrimitiveType(FieldDescriptor fieldDescriptor) {
		if (fieldDescriptor.getJavaType() == JavaType.BOOLEAN) {
			return boolean.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.BYTE_STRING) {
			return DataHandler.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.DOUBLE) {
			return double.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.FLOAT) {
			return float.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.INT) {
			return int.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.LONG) {
			return long.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.STRING) {
			return String.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.ENUM) {
			try {
				return Class.forName("org.bimserver.interfaces.objects." + fieldDescriptor.getEnumType().getName());
			} catch (ClassNotFoundException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}
}