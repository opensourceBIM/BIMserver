package org.bimserver.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
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
		FileDescriptorSet descriptorSet;
		try {
			descriptorSet = FileDescriptorSet.parseFrom(getClass().getClassLoader().getResource("service.desc").openStream());
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

	public Object callMethod(String name, Object... args) {
		for (MethodDescriptor methodDescriptor : serviceDescriptor.getMethods()) {
			if (methodDescriptor.getName().equals(name)) {
				Message request = DynamicMessage.getDefaultInstance(methodDescriptor.getInputType());
				
				try {
					return rpcChannel.callBlockingMethod(methodDescriptor, rpcController, request, methodDescriptor.getOutputType().toProto().getDefaultInstanceForType());
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}