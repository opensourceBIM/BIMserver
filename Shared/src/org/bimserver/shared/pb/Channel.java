package org.bimserver.shared.pb;

import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;

import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;

public interface Channel {
	public Message callBlockingMethod(MethodDescriptorContainer methodDescriptor, Message request) throws ServiceException;
}
