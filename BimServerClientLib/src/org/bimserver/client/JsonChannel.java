package org.bimserver.client;

import org.bimserver.client.channels.Channel;
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.interfaces.ServiceInterfaceReflectorImpl;
import org.bimserver.shared.meta.SService;

public class JsonChannel extends Channel {

	private SService sService;

	public JsonChannel(SService sService) {
		this.sService = sService;
	}

	@Override
	public void disconnect() {
	}

	public void connect(String address, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		setServiceInterface(new ServiceInterfaceReflectorImpl(new JsonReflector(sService, address, useHttpSession, authenticationInfo)));
	}
}