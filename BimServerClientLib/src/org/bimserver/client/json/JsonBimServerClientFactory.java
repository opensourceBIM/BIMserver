package org.bimserver.client.json;

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

import org.bimserver.client.AbstractBimServerClientFactory;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.reflector.ReflectorBuilder;
import org.bimserver.shared.reflector.ReflectorFactory;

public class JsonBimServerClientFactory extends AbstractBimServerClientFactory {

	private String address;
	private JsonSocketReflectorFactory jsonSocketReflectorFactory;
	private ReflectorFactory reflectorFactory;

	public JsonBimServerClientFactory(String address, SServicesMap servicesMap, JsonSocketReflectorFactory jsonSocketReflectorFactory, ReflectorFactory reflectorFactory) {
		super(servicesMap);
		this.address = address;
		this.jsonSocketReflectorFactory = jsonSocketReflectorFactory;
		this.reflectorFactory = reflectorFactory;
	}

	public JsonBimServerClientFactory(String address) {
		super();
		this.address = address;
		this.jsonSocketReflectorFactory = new JsonSocketReflectorFactory(getServicesMap());
		ReflectorBuilder reflectorBuilder = new ReflectorBuilder(getServicesMap());
		reflectorFactory = reflectorBuilder.newReflectorFactory();
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException {
		JsonChannel jsonChannel = new JsonChannel(reflectorFactory, jsonSocketReflectorFactory, address + "/json", getServicesMap());
		BimServerClient bimServerClient = new BimServerClient(address, getServicesMap(), jsonChannel);
		jsonChannel.connect(bimServerClient);
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connect();
		return bimServerClient;
	}
}