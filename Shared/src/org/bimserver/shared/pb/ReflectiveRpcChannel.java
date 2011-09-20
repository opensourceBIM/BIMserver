package org.bimserver.shared.pb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
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
import com.google.protobuf.ServiceException;

public class ReflectiveRpcChannel extends ProtocolBuffersConverter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReflectiveRpcChannel.class);
	private final ProtocolBuffersMetaData protocolBuffersMetaData;
	private final Object service;

	public ReflectiveRpcChannel(Object service, ProtocolBuffersMetaData protocolBuffersMetaData) {
		this.service = service;
		this.protocolBuffersMetaData = protocolBuffersMetaData;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Message callBlockingMethod(MethodDescriptorContainer methodDescriptor, Message request) throws ServiceException {
		FieldDescriptor errorMessageField = methodDescriptor.getOutputField("errorMessage");
		DynamicMessage response = DynamicMessage.getDefaultInstance(methodDescriptor.getOutputDescriptor());
		Class<?> clazz = service.getClass();
		Descriptor inputType = methodDescriptor.getInputDescriptor();
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
			Builder builder = response.newBuilderForType();
			if (methodDescriptor.getOutputDescriptor().getName().equals("VoidResponse")) {
				builder.setField(errorMessageField, "OKE");
			} else {
				FieldDescriptor valueField = protocolBuffersMetaData.getMessageDescriptor(response.getDescriptorForType().getName()).getField("value");
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
			Builder errorMessage = response.newBuilderForType();
			e.getTargetException().printStackTrace();
			errorMessage.setField(errorMessageField, e.getTargetException().getMessage());
			return errorMessage.build();
		} catch (Exception e) {
			LOGGER.error("", e);
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