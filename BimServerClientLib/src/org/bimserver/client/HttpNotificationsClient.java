package org.bimserver.client;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;

import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
import org.bimserver.shared.pb.ReflectiveRpcChannel;

import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HttpNotificationsClient extends NotificationsClient {
	private ReflectiveRpcChannel reflectiveRpcChannel;

	public HttpNotificationsClient() {
		try {
			final ProtocolBuffersMetaData protocolBuffersMetaData = new ProtocolBuffersMetaData();
			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("service.desc"));
			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("notification.desc"));
			HttpServer server = HttpServer.create();
			HttpHandler handler = new HttpHandler() {
				public void handle(HttpExchange exchange) throws IOException {
					ReflectiveRpcChannel reflectiveRpcChannel = new ReflectiveRpcChannel(new ServiceFactory() {
						
						@Override
						public Object newService(AccessMethod accessMethod) {
							return new NotifierImpl();
						}
					}, protocolBuffersMetaData);

					InputStream inputStream = exchange.getRequestBody();
					DataInputStream dis = new DataInputStream(inputStream);
					String serviceName = dis.readUTF();
					String methodName = dis.readUTF();
					MethodDescriptorContainer methodDescriptorContainer = protocolBuffersMetaData.getMethod(serviceName, methodName);

					DynamicMessage request = DynamicMessage.parseFrom(methodDescriptorContainer.getInputDescriptor(), dis);
					try {
						Message response = reflectiveRpcChannel.callBlockingMethod(methodDescriptorContainer.getMethodDescriptor(), null, request,
								DynamicMessage.getDefaultInstance(methodDescriptorContainer.getOutputDescriptor()));
						exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getSerializedSize());
						response.writeTo(exchange.getResponseBody());
					} catch (ServiceException e) {
						e.printStackTrace();
					}
					exchange.close();
				}
			};
			server.createContext("/", handler);
			server.bind(new InetSocketAddress(80), 1000);
			server.start();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}