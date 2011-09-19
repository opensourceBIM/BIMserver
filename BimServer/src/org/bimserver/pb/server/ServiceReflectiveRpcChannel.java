package org.bimserver.pb.server;

import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ReflectiveRpcChannel;
import org.bimserver.webservices.ServiceFactory;

public abstract class ServiceReflectiveRpcChannel extends ReflectiveRpcChannel {

	public ServiceReflectiveRpcChannel(ServiceFactory serviceFactory, ProtocolBuffersMetaData protocolBuffersMetaData) {
		super(serviceFactory.newService(AccessMethod.PROTOCOL_BUFFERS), protocolBuffersMetaData);
	}
}