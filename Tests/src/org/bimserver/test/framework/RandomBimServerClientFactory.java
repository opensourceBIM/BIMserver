package org.bimserver.test.framework;

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

import java.util.HashMap;
import java.util.Map;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Creates a randomly initialized connection to a local bimserver
 */
public class RandomBimServerClientFactory implements BimServerClientFactory {
	public static enum Type {
		PROTOCOL_BUFFERS,
		SOAP_HEADER,
		SOAP_NO_HEADERS,
		JSON_SESSION_BASED,
		JSON_TOKEN_BASED
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomBimServerClientFactory.class);
	private int current = 0;
	private final Type[] types;
	private Map<String, SService> map;
	private PluginManager pluginManager;
	
	public RandomBimServerClientFactory(TestFramework testFramework, Type... types) {
		if (types.length == 0) {
			this.types = Type.values();
		} else {
			this.types = types;
		}
		map = new HashMap<String, SService>();
		map.put(ServiceInterface.class.getSimpleName(), new SService(null, ServiceInterface.class));
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(testFramework.getTestConfiguration().getHomeDir());
		} catch (PluginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized BimServerClient create(AuthenticationInfo authenticationInfo, String remoteAddress) {
		try {
			BimServerClient bimServerClient = new BimServerClient(pluginManager, map);
			bimServerClient.setAuthentication(authenticationInfo);
			Type type = types[current];
			switch (type) {
			case PROTOCOL_BUFFERS:
				LOGGER.info("New BimServerClient: Protocol Buffers");
				bimServerClient.connectProtocolBuffers("localhost", 8020);
				break;
			case SOAP_HEADER:
				LOGGER.info("New BimServerClient: SOAP/useSoapHeaderSessions");
				bimServerClient.connectSoap("http://localhost:8080/soap", true);
				break;
			case SOAP_NO_HEADERS:
				LOGGER.info("New BimServerClient: SOAP");
				bimServerClient.connectSoap("http://localhost:8080/soap", false);
				break;
			case JSON_SESSION_BASED:
				LOGGER.info("New BimServerClient: JSON");
				bimServerClient.connectJson("http://localhost:8080/jsonapi", true);
				break;
			case JSON_TOKEN_BASED:
				LOGGER.info("New BimServerClient: JSON");
				bimServerClient.connectJson("http://localhost:8080/jsonapi", false);
				break;
			}
			current = (current + 1) % types.length;
			return bimServerClient;
		} catch (ConnectionException e) {
			LOGGER.error("", e);
		}
		return null;
	}
}