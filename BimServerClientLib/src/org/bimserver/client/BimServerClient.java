package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.HashSet;
import java.util.Set;

import org.bimserver.client.channels.Channel;
import org.bimserver.client.channels.DirectChannel;
import org.bimserver.client.channels.ProtocolBuffersChannel;
import org.bimserver.client.channels.SoapChannel;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class BimServerClient implements ConnectDisconnectListener {
	private final Set<ConnectDisconnectListener> connectDisconnectListeners = new HashSet<ConnectDisconnectListener>();
	private Channel channel;

	public BimServerClient() {
	}

	public void connectDirect(ServiceInterface serviceInterface) {
		DirectChannel directChannel = new DirectChannel();
		this.channel = directChannel;
		directChannel.registerConnectDisconnectListener(this);
		directChannel.connect(serviceInterface);
	}
	
	public void connectProtocolBuffers(String address, int port) {
		ProtocolBuffersChannel protocolBuffersChannel = new ProtocolBuffersChannel();
		this.channel = protocolBuffersChannel;
		protocolBuffersChannel.registerConnectDisconnectListener(this);
		protocolBuffersChannel.connect(address, port);
	}
	
	public void connectSoap(final String address) {
		SoapChannel soapChannel = new SoapChannel();
		this.channel = soapChannel;
		soapChannel.registerConnectDisconnectListener(this);
		soapChannel.connect(address);
	}

	public void login(String username, String password) throws ServiceException {
		channel.getServiceInterface().login(username, password);
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
	
	public ServiceInterface getServiceInterface() {
		return channel.getServiceInterface();
	}
	
	public Session createSession() {
		if (channel.getServiceInterface() == null) {
			throw new RuntimeException("Connect first");
		}
		Session session = new Session(channel.getServiceInterface());
		return session;
	}

	public void disconnect() {
		channel.disconnect();
	}

	@Override
	public void connected() {
		notifyOfConnect();
	}

	@Override
	public void disconnected() {
		notifyOfDisconnect();
	}
}