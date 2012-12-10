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

import org.bimserver.client.channels.Channel;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.reflector.ReflectorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonChannel extends Channel {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonChannel.class);
	private final ReflectorFactory reflectorFactory;
	private final JsonSocketReflectorFactory jsonSocketReflectorFactory;
	private JsonSocketReflector reflector;

	public JsonChannel(ReflectorFactory reflectorFactory, JsonSocketReflectorFactory jsonSocketReflectorFactory) {
		this.reflectorFactory = reflectorFactory;
		this.jsonSocketReflectorFactory = jsonSocketReflectorFactory;
	}

	@Override
	public void disconnect() {
	}
	
	@Override
	public String getToken() {
		return reflector.getToken();
	}

	public void connect(String address, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		reflector = jsonSocketReflectorFactory.create(address, useHttpSession, authenticationInfo);
		finish(reflector, reflectorFactory);
		if (authenticationInfo instanceof UsernamePasswordAuthenticationInfo) {
			UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo)authenticationInfo;
			try {
				reflector.setToken(getServiceInterface().login(usernamePasswordAuthenticationInfo.getUsername(), usernamePasswordAuthenticationInfo.getPassword()));
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
	}
}