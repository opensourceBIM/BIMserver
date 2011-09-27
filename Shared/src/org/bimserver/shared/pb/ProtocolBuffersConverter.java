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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.io.IOUtils;
import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
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

	public SBase convertProtocolBuffersMessageToSObject(Message message, SClass targetType) {
		try {
			Descriptor descriptor = message.getDescriptorForType();
			SBase newInstance = targetType.newInstance();
			for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
				Object val = message.getField(fieldDescriptor);
				SField field = newInstance.getSClass().getField(fieldDescriptor.getName());
				if (field == null) {
					throw new RuntimeException("No field with name " + fieldDescriptor.getName());
				}
				if (fieldDescriptor.isRepeated()) {
					List list = new ArrayList();
					List oldList = (List)val;
					for (Object x : oldList) {
						list.add(convertFieldValue(field, x));
					}
					newInstance.sSet(field, list);
				} else {
					SField sField = targetType.getField(fieldDescriptor.getName());
					newInstance.sSet(sField, convertFieldValue(sField, val));
				}
			}
			return newInstance;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Object convertFieldValue(SField field, Object val) {
		if (val instanceof EnumValueDescriptor) {
			EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor)val;
			Class<?> enumClass;
			try {
				enumClass = Class.forName("org.bimserver.interfaces.objects." + enumValueDescriptor.getType().getName());
				for (Object v : enumClass.getEnumConstants()) {
					Enum<?> e = (Enum<?>)v;
					if (e.ordinal() == enumValueDescriptor.getNumber()) {
						val = e;
						break;
					}
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			return val;
		} else if (field.getType() == Date.class) {
			return new Date((Long)val);
		} else if (field.getType() == DataHandler.class) {
			ByteString byteString = (ByteString)val;
			return new DataHandler(new ByteArrayDataSource(byteString.toByteArray(), "data"));
		} else {
			return val;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Message convertSObjectToProtocolBuffersObject(Descriptor descriptor, SBase object) {
		Builder builder = null;
		try {
			builder = DynamicMessage.getDefaultInstance(descriptor).newBuilderForType();
		} catch (SecurityException e) {
			LOGGER.error("", e);
		} catch (IllegalArgumentException e) {
			LOGGER.error("", e);
		}
		for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
			try {
				SClass sClass = object.getSClass();
				SField sField = sClass.getField(fieldDescriptor.getName());
				Object value = object.sGet(sField);
				if (value != null) {
					if (value.getClass().isPrimitive() || value.getClass() == String.class || value.getClass() == Long.class || value.getClass() == Float.class
							|| value.getClass() == Integer.class) {
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
								newList.add(convertSObjectToProtocolBuffersObject(fieldDescriptor.getMessageType(), (SBase) o));
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