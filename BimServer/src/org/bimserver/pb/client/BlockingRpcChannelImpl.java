package org.bimserver.pb.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

import org.bimserver.utils.BinUtils;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import com.google.protobuf.Descriptors.MethodDescriptor;

public class BlockingRpcChannelImpl implements BlockingRpcChannel {

	private Socket socket = new Socket();
	private InputStream inputStream;
	private OutputStream outputStream;
	
	public BlockingRpcChannelImpl(SocketAddress address) {
		try {
			socket.connect(address);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized Message callBlockingMethod(MethodDescriptor method, RpcController controller, Message request, Message responsePrototype) throws ServiceException {
		try {
			outputStream.write(BinUtils.intToByteArray(method.getIndex()));
			request.writeDelimitedTo(outputStream);
			outputStream.flush();
			responsePrototype.newBuilderForType().mergeDelimitedFrom(inputStream);
			return responsePrototype;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}