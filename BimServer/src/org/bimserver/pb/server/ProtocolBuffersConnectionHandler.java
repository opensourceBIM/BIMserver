package org.bimserver.pb.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
import org.bimserver.shared.pb.ReflectiveRpcChannel;

import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;

public class ProtocolBuffersConnectionHandler extends Thread {
	private final Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private DataInputStream dataInputStream;
	private final ProtocolBuffersServer protocolBuffersServer;
	private final Map<String, Object> services = new HashMap<String, Object>();

	public ProtocolBuffersConnectionHandler(Socket socket, ProtocolBuffersServer protocolBuffersServer) {
		this.socket = socket;
		this.protocolBuffersServer = protocolBuffersServer;
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String serviceName = dataInputStream.readUTF();
				String methodName = dataInputStream.readUTF();
				ProtocolBuffersMetaData protocolBuffersMetaData = protocolBuffersServer.getProtocolBuffersMetaData();
				if (!services.containsKey(serviceName)) {
					services.put(serviceName, protocolBuffersServer.getServiceFactoryRegistry().createServiceFactory(serviceName).newService(AccessMethod.PROTOCOL_BUFFERS));
				}
				ReflectiveRpcChannel reflectiveRpcChannel = new ReflectiveRpcChannel(services.get(serviceName), protocolBuffersMetaData);
				MethodDescriptorContainer method = protocolBuffersMetaData.getMethod(serviceName, methodName);
				Builder requestBuilder = DynamicMessage.getDefaultInstance(method.getInputDescriptor()).newBuilderForType();
				requestBuilder.mergeDelimitedFrom(dataInputStream);
				Message response = reflectiveRpcChannel.callBlockingMethod(method, requestBuilder.build());
				response.writeDelimitedTo(outputStream);
				outputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
	}
}
