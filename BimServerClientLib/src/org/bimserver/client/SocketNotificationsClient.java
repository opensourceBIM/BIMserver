package org.bimserver.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
import org.bimserver.shared.pb.ReflectiveRpcChannel;

import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;

public class SocketNotificationsClient extends NotificationsClient {
	
	private final ProtocolBuffersMetaData protocolBuffersMetaData;
	private final InetSocketAddress address;
	private final NotificationInterface notificationInterface;
	private final SService sService;

	private class Handler extends Thread {
		private final Socket socket;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			ServiceFactory service = new ServiceFactory() {
				
				@Override
				public Object newService(AccessMethod accessMethod) {
					return notificationInterface;
				}

				@Override
				public String getName() {
					return "NotifierInterface";
				}
			};
			ReflectiveRpcChannel reflectiveRpcChannel = new ReflectiveRpcChannel(service.newService(AccessMethod.PROTOCOL_BUFFERS), protocolBuffersMetaData, sService);

			try {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				String serviceName = dis.readUTF();
				String methodName = dis.readUTF();
				MethodDescriptorContainer methodDescriptorContainer = protocolBuffersMetaData.getMethod(serviceName, methodName);
				
				Builder newBuilder = DynamicMessage.newBuilder(methodDescriptorContainer.getInputDescriptor());
				newBuilder.mergeDelimitedFrom(dis);
				DynamicMessage request = newBuilder.build();
				try {
					Message response = reflectiveRpcChannel.callBlockingMethod(methodDescriptorContainer, request);
					response.writeDelimitedTo(socket.getOutputStream());
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(address);
			while (true) {
				Socket socket = serverSocket.accept();
				new Handler(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public SocketNotificationsClient(ProtocolBuffersMetaData protocolBuffersMetaData, SService sService, InetSocketAddress address, NotificationInterface notificationInterface) {
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		this.sService = sService;
		this.address = address;
		this.notificationInterface = notificationInterface;
	}
}
