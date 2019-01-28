package org.bimserver.client.protocolbuffers;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.http.impl.client.CloseableHttpClient;
import org.bimserver.client.Channel;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ProtocolBuffersReflector;
import org.bimserver.shared.pb.SocketProtocolBuffersChannel;
import org.bimserver.shared.reflector.ReflectorFactory;

public class ProtocolBuffersChannel extends Channel implements ConnectDisconnectListener {

	private SocketProtocolBuffersChannel protocolBuffersChannel;
	private SServicesMap servicesMap;
	private ReflectorFactory reflectorFactory;
	private String address;
	private int port;
	private ProtocolBuffersMetaData protocolBuffersMetaData;

	public ProtocolBuffersChannel(CloseableHttpClient httpClient, SServicesMap servicesMap, ProtocolBuffersMetaData protocolBuffersMetaData, ReflectorFactory reflectorFactory, String address, int port) {
		super(httpClient);
		this.servicesMap = servicesMap;
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		this.reflectorFactory = reflectorFactory;
		this.address = address;
		this.port = port;
	}
	
	public void connect(TokenHolder tokenHolder) throws ChannelConnectionException {
		protocolBuffersChannel = new SocketProtocolBuffersChannel(tokenHolder);
		protocolBuffersChannel.registerConnectDisconnectListener(this);
		
		ProtocolBuffersReflector reflector = new ProtocolBuffersReflector(protocolBuffersMetaData, servicesMap, protocolBuffersChannel);
		for (Class<? extends PublicInterface> interface1 : servicesMap.getInterfaceClasses()) {
			PublicInterface createReflector = reflectorFactory.createReflector(interface1, reflector);
			add(interface1.getName(), createReflector);
		}
		
		finish(reflector, reflectorFactory);
		try {
			protocolBuffersChannel.connect(new InetSocketAddress(address, port));
		} catch (IOException e) {
			throw new ChannelConnectionException(e);
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
		if (protocolBuffersChannel != null) {
			protocolBuffersChannel.disconnect();
		}
	}
}