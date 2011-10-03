package org.bimserver.client.channels;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.ServiceInterface;

public abstract class Channel {
	private ServiceInterface serviceInterface;
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();

	protected void setServiceInterface(ServiceInterface serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	public ServiceInterface getServiceInterface() {
		return serviceInterface;
	}
	
	public void registerConnectDisconnectListener(ConnectDisconnectListener connectDisconnectListener) {
		connectDisconnectListeners.add(connectDisconnectListener);
	}
	
	public void notifyOfConnect() {
		for (ConnectDisconnectListener connectDisconnectListener : connectDisconnectListeners) {
			connectDisconnectListener.connected();
		}
	}
	
	public void notifyOfDisconnect() {
		for (ConnectDisconnectListener connectDisconnectListener : connectDisconnectListeners) {
			connectDisconnectListener.disconnected();
		}
	}

	public abstract void disconnect();
}