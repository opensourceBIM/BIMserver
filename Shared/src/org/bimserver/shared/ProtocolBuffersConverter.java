package org.bimserver.shared;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SField;
import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Message.Builder;

public class ProtocolBuffersConverter {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolBuffersConverter.class);

	protected Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
		try {
			return clazz.getMethod(methodName, parameterClasses);
		} catch (SecurityException e) {
			LOGGER.error("", e);
		} catch (NoSuchMethodException e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	protected Object convertProtocolBuffersMessageToSObject(DynamicMessage message) {
		try {
			Descriptor descriptor = message.getDescriptorForType();
			SBase newInstance = (SBase) Class.forName("org.bimserver.interfaces.objects." + descriptor.getName()).newInstance();
			for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
				Object val = message.getField(fieldDescriptor);
				SField field = newInstance.getSClass().getField(fieldDescriptor.getName());
				if (field == null) {
					throw new RuntimeException("No field with name " + fieldDescriptor.getName());
				}
				if (fieldDescriptor.isRepeated()) {
//					Method setMethod = getMethod(newInstance.getClass(), "set" + StringUtils.firstUpperCase(fieldDescriptor.getName()), new Class[]{List.class});
//					System.out.println(val);
				} else {
					Method setMethod = getMethod(newInstance.getClass(), "set" + StringUtils.firstUpperCase(fieldDescriptor.getName()), new Class[]{field.getType()});
					if (val instanceof EnumValueDescriptor) {
						EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor)val;
						Class<?> enumClass = Class.forName("org.bimserver.interfaces.objects." + enumValueDescriptor.getType().getName());
						for (Object v : enumClass.getEnumConstants()) {
							Enum<?> e = (Enum<?>)v;
							if (e.ordinal() == enumValueDescriptor.getNumber()) {
								val = e;
								break;
							}
						}
						setMethod.invoke(newInstance, val);
					} else if (field.getType() == Date.class) {
						setMethod.invoke(newInstance, new Date((Long)val));
					} else {
						System.out.println(setMethod);
						System.out.println(val);
						setMethod.invoke(newInstance, val);
					}
				}
			}
			return newInstance;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Object convertSObjectToProtocolBuffersObject(Map<Object, Object> convertedObjects, Descriptor descriptor, Object object) {
		if (convertedObjects.containsKey(object)) {
			return convertedObjects.get(object);
		}
		Class<? extends Object> clazz = object.getClass();
		Builder builder = null;
		try {
			builder = DynamicMessage.getDefaultInstance(descriptor).newBuilderForType();
			convertedObjects.put(object, builder);
		} catch (SecurityException e) {
			LOGGER.error("", e);
		} catch (IllegalArgumentException e) {
			LOGGER.error("", e);
		}
		for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
			try {
				Method getMethod = getMethod(clazz, "get" + StringUtils.firstUpperCase(fieldDescriptor.getName()));
				Object value = getMethod.invoke(object);
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
								newList.add(convertSObjectToProtocolBuffersObject(convertedObjects, fieldDescriptor.getMessageType(), o));
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
			} catch (IllegalAccessException e) {
				LOGGER.error("", e);
			} catch (InvocationTargetException e) {
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

	protected FieldDescriptor getFieldDescriptor(Descriptor descriptor, String fieldName) {
		for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
			if (fieldDescriptor.getName().equals(fieldName)) {
				return fieldDescriptor;
			}
		}
		throw new RuntimeException("Field " + fieldName + " not found in " + descriptor.getName());
	}
}