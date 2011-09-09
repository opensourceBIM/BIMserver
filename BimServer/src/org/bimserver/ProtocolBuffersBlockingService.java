package org.bimserver;

import org.bimserver.pb.server.ReflectiveRpcChannel;

import com.google.protobuf.BlockingService;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;

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
		return reflectiveRpcChannel.callBlockingMethod(method, controller, request, getResponsePrototype(method));
	}

	@Override
	public Message getRequestPrototype(MethodDescriptor method) {
		return method.getInputType().toProto().getDefaultInstanceForType();
	}

	@Override
	public Message getResponsePrototype(MethodDescriptor method) {
		return method.getOutputType().toProto().getDefaultInstanceForType();
	}
}