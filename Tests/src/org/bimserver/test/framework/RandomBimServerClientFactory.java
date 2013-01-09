package org.bimserver.test.framework;

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

import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.JsonBimServerClientFactory;
import org.bimserver.client.JsonSocketReflectorFactory;
import org.bimserver.client.ProtocolBuffersBimServerClientFactory;
import org.bimserver.client.SoapBimServerClientFactory;
import org.bimserver.interfaces.SServiceInterfaceService;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.ServicesMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Creates a randomly initialized connection to a local bimserver
 */
public class RandomBimServerClientFactory implements BimServerClientFactory {
	public static enum Type {
		PROTOCOL_BUFFERS,
		SOAP,
		JSON;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomBimServerClientFactory.class);
	private int current = 0;
	private final Type[] types;
	private JsonBimServerClientFactory jsonBimServerClientFactory;
	private ProtocolBuffersBimServerClientFactory protocolBuffersBimServerClientFactory;
	private SoapBimServerClientFactory soapBimServerClientFactory;
	
	public RandomBimServerClientFactory(TestFramework testFramework, Type... types) {
		if (types.length == 0) {
			this.types = Type.values();
		} else {
			this.types = types;
		}
		ServicesMap servicesMap = new ServicesMap();
		servicesMap.add(new SServiceInterfaceService(null, ServiceInterface.class));
		
		jsonBimServerClientFactory = new JsonBimServerClientFactory("http://localhost:8080", servicesMap, new JsonSocketReflectorFactory(servicesMap));
		protocolBuffersBimServerClientFactory = new ProtocolBuffersBimServerClientFactory("localhost", 8020, servicesMap);
		soapBimServerClientFactory = new SoapBimServerClientFactory("http://localhost:8080", servicesMap);
	}
	
	public synchronized BimServerClient create(AuthenticationInfo authenticationInfo) throws ServerException, UserException {
		try {
			Type type = types[current];
			BimServerClient bimServerClient = null;
			switch (type) {
			case PROTOCOL_BUFFERS:
				LOGGER.info("New BimServerClient: Protocol Buffers");
				bimServerClient = protocolBuffersBimServerClientFactory.create(authenticationInfo);
				break;
			case SOAP:
				LOGGER.info("New BimServerClient: SOAP/useSoapHeaderSessions");
				bimServerClient = soapBimServerClientFactory.create(authenticationInfo);
				break;
			case JSON:
				LOGGER.info("New BimServerClient: JSON");
				bimServerClient = jsonBimServerClientFactory.create(authenticationInfo);
				break;
			}
			current = (current + 1) % types.length;
			return bimServerClient;
		} catch (ChannelConnectionException | ServiceException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public BimServerClient create() throws ServiceException, ChannelConnectionException {
		return null;
	}
}