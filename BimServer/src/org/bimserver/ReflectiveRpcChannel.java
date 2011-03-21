package org.bimserver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.webservices.ServiceFactory;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Message.Builder;

public class ReflectiveRpcChannel implements BlockingRpcChannel {

	private final ServiceFactory serviceFactory;
	private ServiceInterface service;

	public ReflectiveRpcChannel(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	
	@Override
	public Message callBlockingMethod(MethodDescriptor methodDescriptor, RpcController controller, Message request, Message responsePrototype) throws ServiceException {
		if (service == null) {
			service = serviceFactory.newService(AccessMethod.INTERNAL);
		}
		Class<? extends ServiceInterface> clazz = service.getClass();
		Class[] parameterClasses = new Class[methodDescriptor.getInputType().getFields().size()];
		int ci=0;
		for (FieldDescriptor fieldDescriptor : methodDescriptor.getInputType().getFields()) {
			parameterClasses[ci++] = convert(fieldDescriptor.getJavaType());
		}
		try {
			Method method = clazz.getMethod(methodDescriptor.getName(), parameterClasses);
			Object[] arguments = new Object[methodDescriptor.getInputType().getFields().size()];
			int i=0;
			for (FieldDescriptor fieldDescriptor : methodDescriptor.getInputType().getFields()) {
				arguments[i] = request.getField(fieldDescriptor);
				i++;
			}
			Object result = method.invoke(service, arguments);
			Class<? extends Object> resultClass = result.getClass();
			Builder builder = responsePrototype.newBuilderForType();
			FieldDescriptor valueField = methodDescriptor.getOutputType().getFields().get(0);
			if (valueField.getType().getJavaType() != JavaType.MESSAGE) {
				builder.setField(valueField, result);
			} else if (result instanceof List) {
				Descriptor messageType = valueField.getMessageType();
				List list = (List) builder.getField(valueField);
			} else {
				Descriptor messageType = valueField.getMessageType();
				Object field = builder.getField(valueField);
//			for (FieldDescriptor fieldDescriptor : methodDescriptor.getOutputType().getFields()) {
//				Method method2 = resultClass.getMethod("get" + StringUtils.firstUpperCase(fieldDescriptor.getName()));
//				builder.setField(fieldDescriptor, method2.invoke(result));
//			}
			}
			return builder.build();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Class convert(JavaType javaType) {
		if (javaType == JavaType.BOOLEAN) {
			return Boolean.class;
		} else if (javaType == JavaType.BYTE_STRING) {
			return Byte[].class;
		} else if (javaType == JavaType.DOUBLE) {
			return Double.class;
		} else if (javaType == JavaType.FLOAT) {
			return Float.class;
		} else if (javaType == JavaType.INT) {
			return Integer.class;
		} else if (javaType == JavaType.LONG) {
			return Long.class;
		} else if (javaType == JavaType.STRING) {
			return String.class;
		}
		return null;
	}
}