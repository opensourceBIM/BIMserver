//package org.bimserver.client.notifications;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

//import java.io.DataInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.InetSocketAddress;
//
//import org.bimserver.models.log.AccessMethod;
//import org.bimserver.shared.ServiceFactory;
//import org.bimserver.shared.ServiceInterface;
//import org.bimserver.shared.meta.SService;
//import org.bimserver.shared.pb.ProtocolBuffersMetaData;
//import org.bimserver.shared.pb.ProtocolBuffersMetaData.MethodDescriptorContainer;
//import org.bimserver.shared.pb.ReflectiveRpcChannel;
//
//import com.google.protobuf.DynamicMessage;
//import com.google.protobuf.Message;
//import com.google.protobuf.ServiceException;
//import com.sun.net.httpserver.HttpExchange;
//import com.sun.net.httpserver.HttpHandler;
//import com.sun.net.httpserver.HttpServer;
//
//public class HttpNotificationsClient extends NotificationsClient {
//	private ReflectiveRpcChannel reflectiveRpcChannel;
//
//	public HttpNotificationsClient() {
//		try {
//			final ProtocolBuffersMetaData protocolBuffersMetaData = new ProtocolBuffersMetaData();
//			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("service.desc"));
//			protocolBuffersMetaData.load(getClass().getClassLoader().getResource("notification.desc"));
//			HttpServer server = HttpServer.create();
//			HttpHandler handler = new HttpHandler() {
//				public void handle(HttpExchange exchange) throws IOException {
//					ServiceFactory service = new ServiceFactory() {
//						
//						@Override
//						public Object newService(AccessMethod accessMethod) {
//							return new NotificationLogger();
//						}
//
//						@Override
//						public String getName() {
//							return "NotifierInterface";
//						}
//					};
//					ReflectiveRpcChannel reflectiveRpcChannel = new ReflectiveRpcChannel(service.newService(AccessMethod.PROTOCOL_BUFFERS), protocolBuffersMetaData, new SService(ServiceInterface.class));
//
//					InputStream inputStream = exchange.getRequestBody();
//					DataInputStream dis = new DataInputStream(inputStream);
//					String serviceName = dis.readUTF();
//					String methodName = dis.readUTF();
//					MethodDescriptorContainer methodDescriptorContainer = protocolBuffersMetaData.getMethod(serviceName, methodName);
//
//					DynamicMessage request = DynamicMessage.parseFrom(methodDescriptorContainer.getInputDescriptor(), dis);
//					try {
//						Message response = reflectiveRpcChannel.callBlockingMethod(methodDescriptorContainer, request);
//						exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getSerializedSize());
//						response.writeTo(exchange.getResponseBody());
//					} catch (ServiceException e) {
//						e.printStackTrace();
//					}
//					exchange.close();
//				}
//			};
//			server.createContext("/", handler);
//			server.bind(new InetSocketAddress(80), 1000);
//			server.start();
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}