package org.bimserver.pb.server;

import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ReflectiveRpcChannel;
import org.bimserver.webservices.ServiceInterfaceFactory;

public abstract class ServiceReflectiveRpcChannel extends ReflectiveRpcChannel {

	public ServiceReflectiveRpcChannel(ServiceInterfaceFactory serviceFactory, ProtocolBuffersMetaData protocolBuffersMetaData) {
		super(serviceFactory, protocolBuffersMetaData);
	}
}