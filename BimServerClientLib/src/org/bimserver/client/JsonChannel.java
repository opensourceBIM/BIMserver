package org.bimserver.client;

import java.util.Map;

import org.bimserver.client.channels.Channel;
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.shared.meta.SService;

public class JsonChannel extends Channel {

	private Map<String, SService> sServices;

	public JsonChannel(Map<String, SService> sServices) {
		this.sServices = sServices;
	}

	@Override
	public void disconnect() {
	}

	public void connect(String address, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		JsonReflector reflector = new JsonReflector(sServices, address, useHttpSession, authenticationInfo);
		finish(reflector);
	}
}