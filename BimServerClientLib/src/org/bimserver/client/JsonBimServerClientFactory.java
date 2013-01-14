package org.bimserver.client;

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

import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.ServicesMap;

public class JsonBimServerClientFactory extends AbstractBimServerClientFactory {

	private String address;
	private JsonSocketReflectorFactory jsonSocketReflectorFactory;

	public JsonBimServerClientFactory(String address, ServicesMap servicesMap, JsonSocketReflectorFactory jsonSocketReflectorFactory) {
		super(servicesMap);
		this.address = address;
		this.jsonSocketReflectorFactory = jsonSocketReflectorFactory;
	}

	public JsonBimServerClientFactory(String address) {
		super();
		this.address = address;
		this.jsonSocketReflectorFactory = new JsonSocketReflectorFactory(getServicesMap());
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException {
		BimServerClient bimServerClient = new BimServerClient(address, getServicesMap(), null);
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.setJsonSocketReflectorFactory(jsonSocketReflectorFactory);
		bimServerClient.connectJson();
		return bimServerClient;
	}
}