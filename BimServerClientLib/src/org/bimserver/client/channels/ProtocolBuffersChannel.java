package org.bimserver.client.channels;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.bimserver.pb.ServiceInterfaceReflectorImpl;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.Reflector;
import org.bimserver.shared.pb.SocketChannel;

public class ProtocolBuffersChannel extends Channel implements ConnectDisconnectListener {

	private SocketChannel channel;
	private final ProtocolBuffersMetaData protocolBuffersMetaData;

	public ProtocolBuffersChannel(ProtocolBuffersMetaData protocolBuffersMetaData) {
		this.protocolBuffersMetaData = protocolBuffersMetaData;
	}
	
	public void connect(String address, int port) {
		try {
			channel = new SocketChannel();
			channel.registerConnectDisconnectListener(this);
			Reflector reflector = new Reflector(protocolBuffersMetaData, new SService(ServiceInterface.class), channel);
			setServiceInterface(new ServiceInterfaceReflectorImpl(reflector));
			channel.connect(new InetSocketAddress(address, port));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connected() {
		notifyOfConnect();
	}

	@Override
	public void disconnected() {
		notifyOfDisconnect();
	}

	@Override
	public void disconnect() {
		channel.disconnect();
	}
}