package org.bimserver.client;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;

import org.bimserver.ProtocolBuffersBlockingService;
import org.bimserver.pb.server.ReflectiveRpcChannel;

import com.google.protobuf.BlockingService;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.DescriptorProto.Builder;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HttpNotificationsClient extends NotificationsClient {
	private FileDescriptor fileDescriptor;

	public HttpNotificationsClient() {
		try {
			FileDescriptorSet descriptorSet = FileDescriptorSet.parseFrom(new FileInputStream(new File("service.desc")));
			List<FileDescriptorProto> fileList = descriptorSet.getFileList();
			FileDescriptorProto fileDescriptorProto = fileList.get(0);
			fileDescriptor = FileDescriptor.buildFrom(fileDescriptorProto, new FileDescriptor[]{});
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			HttpServer server = HttpServer.create();
			HttpHandler handler = new HttpHandler() {
				public void handle(HttpExchange exchange) throws IOException {
					InputStream inputStream = exchange.getRequestBody();
					DataInputStream dis = new DataInputStream(inputStream);
					String messageName = dis.readUTF();
					
					Descriptor descriptor = null;
					for (Descriptor d : fileDescriptor.getMessageTypes()) {
						if (d.getName().equals(messageName)) {
							descriptor = d;
							break;
						}
					}
					Builder newBuilderForType = descriptor.toProto().newBuilderForType();
					DescriptorProto build = newBuilderForType.mergeFrom(inputStream).build();
					byte[] response = "<?xml version=\"1.0\"?>\n<resource id=\"1234\" name=\"test\" />\n".getBytes();
					exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length);
					exchange.getResponseBody().write(response);
					exchange.close();
				}
			};
			server.createContext("/", handler);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
