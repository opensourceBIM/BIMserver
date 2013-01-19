package org.bimserver.client.channels;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.io.IOException;
import java.net.InetSocketAddress;

import org.bimserver.client.ChannelConnectionException;
import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.meta.ServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ProtocolBuffersReflector;
import org.bimserver.shared.pb.SocketProtocolBuffersChannel;
import org.bimserver.shared.reflector.ReflectorFactory;
import org.slf4j.LoggerFactory;

public class ProtocolBuffersChannel extends Channel implements ConnectDisconnectListener {

	private SocketProtocolBuffersChannel protocolBuffersChannel;
	private final static ProtocolBuffersMetaData protocolBuffersMetaData;
	private ServicesMap servicesMap;
	private ReflectorFactory reflectorFactory;
	private String address;
	private int port;

	static {
		protocolBuffersMetaData = new ProtocolBuffersMetaData();
		try {
			protocolBuffersMetaData.load(ProtocolBuffersChannel.class.getClassLoader().getResource("service.desc"));
			protocolBuffersMetaData.load(ProtocolBuffersChannel.class.getClassLoader().getResource("notification.desc"));
		} catch (IOException e) {
			LoggerFactory.getLogger(ProtocolBuffersChannel.class).error("", e);
		}
	}
	
	public ProtocolBuffersChannel(ServicesMap servicesMap, ReflectorFactory reflectorFactory, String address, int port) {
		this.servicesMap = servicesMap;
		this.reflectorFactory = reflectorFactory;
		this.address = address;
		this.port = port;
	}
	
	public void connect(TokenHolder tokenHolder) throws ChannelConnectionException {
		protocolBuffersChannel = new SocketProtocolBuffersChannel(tokenHolder);
		protocolBuffersChannel.registerConnectDisconnectListener(this);
		finish(new ProtocolBuffersReflector(protocolBuffersMetaData, servicesMap, protocolBuffersChannel), reflectorFactory);
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