package org.bimserver.pb.server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.utils.StringUtils;
import org.bimserver.webservices.ServiceFactory;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Message.Builder;

public class ReflectiveRpcChannel implements BlockingRpcChannel {

	private final ServiceFactory serviceFactory;
	private ServiceInterface service;
//	private final Map<Class<?>, Map<String, Set<Method>>> cachedMethods = new HashMap<Class<?>, Map<String, Set<Method>>>();

	public ReflectiveRpcChannel(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	private Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
		try {
			return clazz.getMethod(methodName, parameterClasses);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
//		if (cachedMethods.containsKey(clazz)) {
//			Map<String, Set<Method>> map = cachedMethods.get(clazz);
//			if (map.containsKey(methodName)) {
//				for (Method method : map.get(methodName)) {
//					if (ArrayUtils.isEquals(method.getParameterTypes(), parameterClasses)) {
//						return method;
//					}
//				}
//			} else {
//				map.put(methodName, new HashSet<Method>());
//			}
//			for (Method method : clazz.getMethods()) {
//				if (method.getName().equals(methodName) && ArrayUtils.isEquals(method.getParameterTypes(), parameterClasses)) {
//					map.get(methodName).add(method);
//					return method;
//				}
//			}
//			return null;
//		} else {
//			cachedMethods.put(clazz, new HashMap<String, Set<Method>>());
//			return getMethod(clazz, methodName);
//		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Message callBlockingMethod(MethodDescriptor methodDescriptor, RpcController controller, Message request, Message responsePrototype) throws ServiceException {
		if (service == null) {
			service = serviceFactory.newService(AccessMethod.INTERNAL);
		}
		Class<? extends ServiceInterface> clazz = service.getClass();
		Class<?>[] parameterClasses = new Class[methodDescriptor.getInputType().getFields().size()];
		int ci = 0;
		for (FieldDescriptor fieldDescriptor : methodDescriptor.getInputType().getFields()) {
			parameterClasses[ci++] = convert(fieldDescriptor);
		}
		try {
			Method method = getMethod(clazz, methodDescriptor.getName(), parameterClasses);
			// Method method = clazz.getMethod(methodDescriptor.getName(),
			// parameterClasses);
			Object[] arguments = new Object[methodDescriptor.getInputType().getFields().size()];
			int i = 0;
			for (FieldDescriptor fieldDescriptor : methodDescriptor.getInputType().getFields()) {
				arguments[i] = convertProtocolBuffersObjectToServiceObject(request.getField(fieldDescriptor));
				i++;
			}
			Object result = method.invoke(service, arguments);
			Builder builder = responsePrototype.newBuilderForType();
			FieldDescriptor valueField = methodDescriptor.getOutputType().getFields().get(0);
			if (result != null) {
				if (valueField.getType().getJavaType() != JavaType.MESSAGE) {
					builder.setField(valueField, result);
				} else if (result instanceof List) {
					Descriptor messageType = valueField.getMessageType();
					List list = new ArrayList();
					List originalList = (List) result;
					for (Object object : originalList) {
						list.add(convertObject(new HashMap(), messageType, object));
					}
					builder.setField(valueField, list);
				} else {
					Descriptor messageType = valueField.getMessageType();
					builder.setField(valueField, convertObject(new HashMap<Object, Object>(), messageType, result));
				}
			}
			builder.setField(responsePrototype.getDescriptorForType().getFields().get(1), "OKE");
			return builder.build();
		} catch (InvocationTargetException e) {
			Builder errorMessage = responsePrototype.newBuilderForType();
			errorMessage.setField(responsePrototype.getDescriptorForType().getFields().get(1), e.getTargetException().getMessage());
			return errorMessage.build();
		} catch (Exception e) {
			Builder errorMessage = responsePrototype.newBuilderForType();
			if (e.getMessage() != null) {
				errorMessage.setField(responsePrototype.getDescriptorForType().getFields().get(1), e.getMessage());
			} else {
				e.printStackTrace();
				errorMessage.setField(responsePrototype.getDescriptorForType().getFields().get(1), "Unknown error");
			}
			return errorMessage.build();
		}
	}

	private Object convertProtocolBuffersObjectToServiceObject(Object value) {
		if (value instanceof EnumValueDescriptor) {
			EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor) value;
			int ordinal = enumValueDescriptor.getNumber();
			return org.bimserver.shared.ResultType.values()[ordinal];
		} else {
			return value;
		}
	}

	@SuppressWarnings("unchecked")
	private Object convertObject(Map<Object, Object> convertedObjects, Descriptor descriptor, Object object) {
		if (convertedObjects.containsKey(object)) {
			return convertedObjects.get(object);
		}
		Class<? extends Object> clazz = object.getClass();
		Builder builder = null;
		try {
			Class builderClass = Class.forName("org.bimserver.pb.Service$" + descriptor.getName());
			Method method = getMethod(builderClass, "newBuilder");
			// Method method = builderClass.getMethod("newBuilder");
			builder = (Builder) method.invoke(null);
			convertedObjects.put(object, builder);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
			try {
				Method getMethod = getMethod(clazz, "get" + StringUtils.firstUpperCase(fieldDescriptor.getName()));
				// Method getMethod = clazz.getMethod("get" +
				// StringUtils.firstUpperCase(fieldDescriptor.getName()));
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
								newList.add(convertObject(convertedObjects, fieldDescriptor.getMessageType(), o));
							} else {
								newList.add(o);
							}
						}
						builder.setField(fieldDescriptor, newList);
					} else {
						System.out.println("Unimplemented: " + fieldDescriptor.getName() + ": " + value);
					}
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return builder.build();
	}

	private Class<?> convert(FieldDescriptor fieldDescriptor) {
		if (fieldDescriptor.getJavaType() == JavaType.BOOLEAN) {
			return boolean.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.BYTE_STRING) {
			return Byte[].class;
		} else if (fieldDescriptor.getJavaType() == JavaType.DOUBLE) {
			return Double.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.FLOAT) {
			return Float.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.INT) {
			return Integer.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.LONG) {
			return long.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.STRING) {
			return String.class;
		} else if (fieldDescriptor.getJavaType() == JavaType.ENUM) {
			try {
				return Class.forName("org.bimserver.shared." + fieldDescriptor.getEnumType().getName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}