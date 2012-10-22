package org.bimserver.client.channels;

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

import java.io.IOException;
import java.net.InetSocketAddress;

import org.bimserver.shared.ConnectDisconnectListener;
import org.bimserver.shared.ReflectorFactory;
import org.bimserver.shared.meta.ServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.pb.ProtocolBuffersReflector;
import org.bimserver.shared.pb.SocketChannel;
import org.slf4j.LoggerFactory;

public class ProtocolBuffersChannel extends Channel implements ConnectDisconnectListener {

	private SocketChannel channel;
	private final static ProtocolBuffersMetaData protocolBuffersMetaData;
	private ServicesMap servicesMap;
	private ReflectorFactory reflectorFactory;

	static {
		protocolBuffersMetaData = new ProtocolBuffersMetaData();
		try {
			protocolBuffersMetaData.load(ProtocolBuffersChannel.class.getClassLoader().getResource("service.desc"));
			protocolBuffersMetaData.load(ProtocolBuffersChannel.class.getClassLoader().getResource("notification.desc"));
		} catch (IOException e) {
			LoggerFactory.getLogger(ProtocolBuffersChannel.class).error("", e);
		}
	}
	
	public ProtocolBuffersChannel(ServicesMap servicesMap, ReflectorFactory reflectorFactory) {
		this.servicesMap = servicesMap;
		this.reflectorFactory = reflectorFactory;
	}
	
	public void connect(String address, int port) throws IOException {
		channel = new SocketChannel();
		channel.registerConnectDisconnectListener(this);
		finish(new ProtocolBuffersReflector(protocolBuffersMetaData, servicesMap, channel), reflectorFactory);
		channel.connect(new InetSocketAddress(address, port));
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