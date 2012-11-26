package org.bimserver.client;

import org.bimserver.client.channels.Channel;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.reflector.ReflectorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonChannel extends Channel {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonChannel.class);
	private ReflectorFactory reflectorFactory;
	private JsonSocketReflector reflector;
	private JsonSocketReflectorFactory jsonSocketReflectorFactory;

	public JsonChannel(ReflectorFactory reflectorFactory, JsonSocketReflectorFactory jsonSocketReflectorFactory) {
		this.reflectorFactory = reflectorFactory;
		this.jsonSocketReflectorFactory = jsonSocketReflectorFactory;
	}

	@Override
	public void disconnect() {
	}
	
	@Override
	public SToken getToken() {
		return reflector.getToken();
	}

	public void connect(String address, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		reflector = jsonSocketReflectorFactory.create(address, useHttpSession, authenticationInfo);
		finish(reflector, reflectorFactory);
		if (authenticationInfo instanceof UsernamePasswordAuthenticationInfo) {
			UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo)authenticationInfo;
			try {
				SToken sToken = getServiceInterface().login(usernamePasswordAuthenticationInfo.getUsername(), usernamePasswordAuthenticationInfo.getPassword());
				reflector.setToken(sToken);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
	}
}