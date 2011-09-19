package org.bimserver.pb.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ProtocolBuffersConverter;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.meta.SBase;
import org.bimserver.webservices.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.Message.Builder;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;

public class ReflectiveRpcChannel extends ProtocolBuffersConverter implements BlockingRpcChannel {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectiveRpcChannel.class);
	private final ServiceFactory serviceFactory;
	private ServiceInterface service;

	public ReflectiveRpcChannel(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Message callBlockingMethod(MethodDescriptor methodDescriptor, RpcController controller, Message request, Message responsePrototype) throws ServiceException {
		if (service == null) {
			service = serviceFactory.newService(AccessMethod.INTERNAL);
		}
		FieldDescriptor errorMessageField = getFieldDescriptor(responsePrototype.getDescriptorForType(), "errorMessage");
		Class<? extends ServiceInterface> clazz = service.getClass();
		Descriptor inputType = methodDescriptor.getInputType();
		Class<?>[] parameterClasses = new Class[inputType.getFields().size()];
		int ci = 0;
		for (FieldDescriptor fieldDescriptor : inputType.getFields()) {
			parameterClasses[ci++] = getJavaType(fieldDescriptor);
		}
		try {
			Method method = getMethod(clazz, methodDescriptor.getName(), parameterClasses);
			Object[] arguments = new Object[inputType.getFields().size()];
			int i = 0;
			for (FieldDescriptor fieldDescriptor : inputType.getFields()) {
				Object field = request.getField(fieldDescriptor);
				if (field instanceof EnumValueDescriptor) {
					EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor)field;
					Class en = getJavaType(fieldDescriptor);
					arguments[i] = en.getEnumConstants()[enumValueDescriptor.getIndex()];
				} else if (field instanceof ByteString) {
					ByteString byteString = (ByteString)field;
					DataSource dataSource = new ByteArrayDataSource(byteString.toByteArray(), "bytes");
					DataHandler dataHandler = new DataHandler(dataSource);
					arguments[i] = dataHandler;
				} else {
					arguments[i] = field;
				}
				i++;
			}
			Object result = method.invoke(service, arguments);
			Builder builder = responsePrototype.newBuilderForType();
			if (methodDescriptor.getOutputType().getName().equals("VoidResponse")) {
				builder.setField(errorMessageField, "OKE");
			} else {
				FieldDescriptor valueField = getFieldDescriptor(responsePrototype.getDescriptorForType(), "value");
				if (result != null) {
					if (valueField.getType().getJavaType() != JavaType.MESSAGE) {
						builder.setField(valueField, result);
					} else if (result instanceof List) {
						Descriptor messageType = valueField.getMessageType();
						List list = new ArrayList();
						List originalList = (List) result;
						for (Object object : originalList) {
							list.add(convertSObjectToProtocolBuffersObject(messageType, (SBase) object));
						}
						builder.setField(valueField, list);
					} else {
						Descriptor messageType = valueField.getMessageType();
						builder.setField(valueField, convertSObjectToProtocolBuffersObject(messageType, (SBase) result));
					}
				}
				builder.setField(errorMessageField, "OKE");
			}
			return builder.build();
		} catch (InvocationTargetException e) {
			Builder errorMessage = responsePrototype.newBuilderForType();
			errorMessage.setField(errorMessageField, e.getTargetException().getMessage());
			return errorMessage.build();
		} catch (Exception e) {
			LOGGER.error("", e);
			Builder errorMessage = responsePrototype.newBuilderForType();
			if (e.getMessage() != null) {
				errorMessage.setField(errorMessageField, e.getMessage());
			} else {
				LOGGER.error("", e);
				errorMessage.setField(responsePrototype.getDescriptorForType().getFields().get(0), "Unknown error");
			}
			return errorMessage.build();
		}
	}
}