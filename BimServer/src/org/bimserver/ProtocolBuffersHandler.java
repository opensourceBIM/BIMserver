package org.bimserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.bimserver.pb.Service.ServiceInterface;
import org.bimserver.utils.BinUtils;

import com.google.protobuf.Descriptors.MethodDescriptor;

public class ProtocolBuffersHandler extends Thread {

	private final Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private boolean running = true;

	public ProtocolBuffersHandler(Socket socket) {
		this.socket = socket;
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (running) {
				byte[] buffer = new byte[4];
				int red = 0;
				while (red < 4) {
					red += inputStream.read(buffer, red, 4 - red);
				}
				int methodIndex = BinUtils.byteArrayToInt(buffer);
				MethodDescriptor methodDescriptor = ServiceInterface.getDescriptor().getMethods().get(methodIndex);
				System.out.println(methodDescriptor.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}