package org.bimserver;

import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ReflectiveRpcChannel;

import com.google.protobuf.BlockingService;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;

public class ProtocolBuffersBlockingService implements BlockingService {
	private final ReflectiveRpcChannel reflectiveRpcChannel;
	private final ProtocolBuffersMetaData protocolBuffersMetaData;

	public ProtocolBuffersBlockingService(ProtocolBuffersMetaData protocolBuffersMetaData, ReflectiveRpcChannel reflectiveRpcChannel) {
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		this.reflectiveRpcChannel = reflectiveRpcChannel;
	}

	@Override
	public ServiceDescriptor getDescriptorForType() {
		return protocolBuffersMetaData.getServices().iterator().next().getServiceDescriptor();
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