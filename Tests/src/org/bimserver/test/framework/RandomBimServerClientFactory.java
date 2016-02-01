package org.bimserver.test.framework;

import java.nio.file.Path;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.client.json.JsonSocketReflectorFactory;
import org.bimserver.client.protocolbuffers.ProtocolBuffersBimServerClientFactory;
import org.bimserver.client.soap.SoapBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.InterfaceList;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.pb.ProtocolBuffersMetaData;
import org.bimserver.shared.reflector.FileBasedReflectorFactoryBuilder;
import org.bimserver.shared.reflector.ReflectorFactory;
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
		
		SServicesMap servicesMap = InterfaceList.createSServicesMap();
		
		FileBasedReflectorFactoryBuilder factoryBuilder = new FileBasedReflectorFactoryBuilder();
		ReflectorFactory reflectorFactory = factoryBuilder.newReflectorFactory();
		
		try {
			Path home = Paths.get("home");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(home);
			MetaDataManager metaDataManager = new MetaDataManager(home.resolve("tmp"));
			pluginManager.setMetaDataManager(metaDataManager);

			jsonBimServerClientFactory = new JsonBimServerClientFactory("http://localhost:8080", servicesMap, new JsonSocketReflectorFactory(servicesMap), reflectorFactory, metaDataManager);
			ProtocolBuffersMetaData protocolBuffersMetaData = new ProtocolBuffersMetaData();
			protocolBuffersMetaData.load(servicesMap, ProtocolBuffersBimServerClientFactory.class);
			protocolBuffersBimServerClientFactory = new ProtocolBuffersBimServerClientFactory("localhost", 8020, 8080, protocolBuffersMetaData, metaDataManager);
			soapBimServerClientFactory = new SoapBimServerClientFactory("http://localhost:8080", servicesMap, metaDataManager);
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized BimServerClientInterface create(AuthenticationInfo authenticationInfo) throws ServerException, UserException {
		try {
			Type type = types[current];
			BimServerClientInterface bimServerClient = null;
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
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ChannelConnectionException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public BimServerClient create() throws ServiceException, ChannelConnectionException {
		return null;
	}
}