package org.bimserver.client;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import org.bimserver.pb.NotificationInterfaceReflectorImpl;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
import org.bimserver.shared.pb.ReflectiveRpcChannel;
import org.bimserver.shared.pb.Reflector;

import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Message;
import com.google.protobuf.ServiceException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HttpNotificationsClient extends NotificationsClient {
	private ReflectiveRpcChannel reflectiveRpcChannel;

	public HttpNotificationsClient() {
//		final ProtocolBuffersMetaData protocolBuffersMetaData = new ProtocolBuffersMetaData(new File("service.desc"));
//		reflectiveRpcChannel = new ReflectiveRpcChannel(new NotificationInterfaceReflectorImpl(new Reflector(rpcController, rpcChannel)), protocolBuffersMetaData);
//		try {
//			HttpServer server = HttpServer.create();
//			HttpHandler handler = new HttpHandler() {
//				public void handle(HttpExchange exchange) throws IOException {
//					InputStream inputStream = exchange.getRequestBody();
//					DataInputStream dis = new DataInputStream(inputStream);
//					String serviceName = dis.readUTF();
//					String methodName = dis.readUTF();
//					MethodDescriptorContainer methodDescriptorContainer = protocolBuffersMetaData.getMethod(serviceName, methodName);
//
//					DynamicMessage request = DynamicMessage.parseFrom(methodDescriptorContainer.getInputDescriptor(), dis);
//					try {
//						Message response = reflectiveRpcChannel.callBlockingMethod(methodDescriptorContainer.getMethodDescriptor(), null, request, DynamicMessage.getDefaultInstance(methodDescriptorContainer.getOutputDescriptor()));
//						exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getSerializedSize());
//						response.writeTo(exchange.getResponseBody());
//					} catch (ServiceException e) {
//						e.printStackTrace();
//					}
//					exchange.close();
//				}
//			};
//			server.createContext("/", handler);
//			server.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}