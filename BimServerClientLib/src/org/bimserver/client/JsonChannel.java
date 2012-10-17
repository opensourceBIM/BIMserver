package org.bimserver.client;

import org.bimserver.client.channels.Channel;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ReflectorFactory;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.meta.ServicesMap;

public class JsonChannel extends Channel {

	private ServicesMap servicesMap;
	private ReflectorFactory reflectorFactory;

	public JsonChannel(ServicesMap servicesMap, ReflectorFactory reflectorFactory) {
		this.servicesMap = servicesMap;
		this.reflectorFactory = reflectorFactory;
	}

	@Override
	public void disconnect() {
	}

	public void connect(String address, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		finish(new JsonSocketReflector(servicesMap, address, useHttpSession, authenticationInfo), reflectorFactory);
	}
}