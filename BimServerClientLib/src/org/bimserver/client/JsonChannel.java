package org.bimserver.client;

import org.bimserver.client.channels.Channel;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.json.JsonReflector;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.meta.ServicesMap;

public class JsonChannel extends Channel {

	private ServicesMap servicesMap;

	public JsonChannel(ServicesMap servicesMap) {
		this.servicesMap = servicesMap;
	}

	@Override
	public void disconnect() {
	}

	public void connect(String address, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		JsonReflector reflector = new JsonSocketReflector(servicesMap, address, useHttpSession, authenticationInfo);
		finish(reflector);
	}
}