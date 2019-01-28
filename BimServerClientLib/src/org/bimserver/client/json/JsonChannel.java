package org.bimserver.client.json;

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

import org.apache.http.impl.client.CloseableHttpClient;
import org.bimserver.client.Channel;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.json.JsonReflector;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.reflector.ReflectorFactory;

public class JsonChannel extends Channel {

	private final ReflectorFactory reflectorFactory;
	private final JsonReflectorFactory jsonReflectorFactory;
	private JsonReflector reflector;
	private String address;
	private SServicesMap sServicesMap;

	public JsonChannel(CloseableHttpClient closeableHttpClient, ReflectorFactory reflectorFactory, JsonReflectorFactory jsonReflectorFactory, String address, SServicesMap sServicesMap) {
		super(closeableHttpClient);
		this.reflectorFactory = reflectorFactory;
		this.jsonReflectorFactory = jsonReflectorFactory;
		this.address = address;
		this.sServicesMap = sServicesMap;
	}

	@Override
	public void disconnect() {
		reflector.close();
	}

	public void connect(TokenHolder tokenHolder) throws ChannelConnectionException {
		reflector = jsonReflectorFactory.create(address, tokenHolder);
		for (Class<? extends PublicInterface> interface1 : sServicesMap.getInterfaceClasses()) {
			PublicInterface createReflector = reflectorFactory.createReflector(interface1, reflector);
			add(interface1.getName(), createReflector);
		}
		finish(reflector, reflectorFactory);
	}

	@Override
	protected JsonConverter getJsonConverter() {
		return reflector.getConverter();
	}
	
	@Override
		protected SServicesMap getSServicesMap() {
			return sServicesMap;
		}
}