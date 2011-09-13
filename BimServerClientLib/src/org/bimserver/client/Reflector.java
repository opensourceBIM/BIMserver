package org.bimserver.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.bimserver.shared.ServerException;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;
import com.googlecode.protobuf.socketrpc.SocketRpcController;

public class Reflector {

	private final BlockingRpcChannel rpcChannel;
	private FileDescriptor fileDescriptor;
	private ServiceDescriptor serviceDescriptor;
	private final SocketRpcController rpcController;

	public Reflector(SocketRpcController rpcController, BlockingRpcChannel rpcChannel) {
		this.rpcController = rpcController;
		this.rpcChannel = rpcChannel;
		try {
			FileDescriptorSet descriptorSet = FileDescriptorSet.parseFrom(getClass().getClassLoader().getResource("service.desc").openStream());
			List<FileDescriptorProto> fileList = descriptorSet.getFileList();
			FileDescriptorProto fileDescriptorProto = fileList.get(0);
			fileDescriptor = FileDescriptor.buildFrom(fileDescriptorProto, new FileDescriptor[]{});
			serviceDescriptor = fileDescriptor.getServices().get(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DescriptorValidationException e) {
			e.printStackTrace();
		}
	}

	private FieldDescriptor getFieldDescriptor(Descriptor descriptor, String fieldName) {
		for (FieldDescriptor fieldDescriptor : descriptor.getFields()) {
			if (fieldDescriptor.getName().equals(fieldName)) {
				return fieldDescriptor;
			}
		}
		return null;
	}
	
	public Object callMethod(String name, Object... args) throws ServerException {
		for (MethodDescriptor methodDescriptor : serviceDescriptor.getMethods()) {
			if (methodDescriptor.getName().equals(name)) {
				Descriptor descriptor = methodDescriptor.getInputType();
				Builder builder = DynamicMessage.newBuilder(descriptor);
				int i=0;
				for (FieldDescriptor field : descriptor.getFields()) {
					builder.setField(field, args[i++]);
				}
				DynamicMessage message = builder.build();
				try {
					Message result = rpcChannel.callBlockingMethod(methodDescriptor, rpcController, message, DynamicMessage.getDefaultInstance(methodDescriptor.getOutputType()));
					String errorMessage = (String) result.getField(getFieldDescriptor(result.getDescriptorForType(), "errorMessage"));
					System.out.println(errorMessage);
					Object value = result.getField(getFieldDescriptor(result.getDescriptorForType(), "value"));
					if (value instanceof DynamicMessage) {
						
					}
					return value;
				} catch (ServiceException e) {
					throw new ServerException(e.getMessage());
				}
			}
		}
		return null;
	}
}