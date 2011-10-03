package org.bimserver.client.channels;

import org.bimserver.shared.ServiceInterface;

public class DirectChannel extends Channel {
	public DirectChannel() {
	}
	
	public void connect(ServiceInterface serviceInterface) {
		setServiceInterface(serviceInterface);
		notifyOfConnect();
	}

	@Override
	public void disconnect() {
		notifyOfDisconnect();
	}
}