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

import org.bimserver.client.AbstractBimServerClientFactory;
import org.bimserver.client.BimServerClient;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.reflector.RealtimeReflectorFactoryBuilder;
import org.bimserver.shared.reflector.ReflectorFactory;

public class ProtocolBuffersBimServerClientFactory extends AbstractBimServerClientFactory {

	private final String address;
	private final int port;
	private final int httpPort;
	private final ReflectorFactory reflectorFactory;
	private ProtocolBuffersMetaData protocolBuffersMetaData;

	public ProtocolBuffersBimServerClientFactory(String address, int port, int httpPort, ProtocolBuffersMetaData protocolBuffersMetaData, MetaDataManager metaDataManager, SServicesMap serviceMap) throws BimServerClientException {
		super(metaDataManager);
		this.httpPort = httpPort;
		this.address = address;
		this.port = port;
		this.protocolBuffersMetaData = protocolBuffersMetaData;
		RealtimeReflectorFactoryBuilder factoryBuilder = new RealtimeReflectorFactoryBuilder(serviceMap);
		this.reflectorFactory = factoryBuilder.newReflectorFactory();
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException {
		ProtocolBuffersChannel channel = new ProtocolBuffersChannel(getHttpClient(), getServicesMap(), protocolBuffersMetaData, reflectorFactory, address, port);
		// TODO people using https or a non-root context-path will get in trouble here
		BimServerClient bimServerClient = new BimServerClient(this.getMetaDataManager(), "http://" + address + ":" + httpPort, getServicesMap(), channel);
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connect();
		return bimServerClient;
	}
}