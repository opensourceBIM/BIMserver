package org.bimserver;

import org.bimserver.pb.server.ReflectiveRpcChannel;

import com.google.protobuf.BlockingService;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;

public class ProtocolBuffersBlockingService implements BlockingService {
	private final FileDescriptor fileDescriptor;
	private final ReflectiveRpcChannel reflectiveRpcChannel;

	public ProtocolBuffersBlockingService(FileDescriptor fileDescriptor, ReflectiveRpcChannel reflectiveRpcChannel) {
		this.fileDescriptor = fileDescriptor;
		this.reflectiveRpcChannel = reflectiveRpcChannel;
	}

	@Override
	public ServiceDescriptor getDescriptorForType() {
		return fileDescriptor.getServices().get(0);
	}

	@Override
	public Message callBlockingMethod(MethodDescriptor method, RpcController controller, Message request) throws ServiceException {
		if (method.getService() != getDescriptorForType()) {
			throw new java.lang.IllegalArgumentException("Service.callBlockingMethod() given method descriptor for " + "wrong service type.");
		}
		return reflectiveRpcChannel.callBlockingMethod(method, controller, request, getResponsePrototype(method));
	}

	@Override
	public Message getRequestPrototype(MethodDescriptor method) {
		if (method.getService() != getDescriptorForType()) {
			throw new java.lang.IllegalArgumentException("Service.getRequestPrototype() given method " + "descriptor for wrong service type.");
		}
		MethodDescriptor methodDescriptor = getDescriptorForType().getMethods().get(method.getIndex());
		return DynamicMessage.getDefaultInstance(methodDescriptor.getInputType());
	}

	@Override
	public Message getResponsePrototype(MethodDescriptor method) {
		if (method.getService() != getDescriptorForType()) {
			throw new java.lang.IllegalArgumentException("Service.getRequestPrototype() given method " + "descriptor for wrong service type.");
		}
		MethodDescriptor methodDescriptor = getDescriptorForType().getMethods().get(method.getIndex());
		return DynamicMessage.getDefaultInstance(methodDescriptor.getOutputType());
	}
}