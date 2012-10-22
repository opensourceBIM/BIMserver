package org.bimserver.client;

import org.bimserver.client.channels.Channel;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ReflectorFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.meta.ServicesMap;

public class JsonChannel extends Channel {

	private ServicesMap servicesMap;
	private ReflectorFactory reflectorFactory;
	private JsonSocketReflector reflector;

	public JsonChannel(ServicesMap servicesMap, ReflectorFactory reflectorFactory) {
		this.servicesMap = servicesMap;
		this.reflectorFactory = reflectorFactory;
	}

	@Override
	public void disconnect() {
	}
	
	@Override
	public SToken getToken() {
		return reflector.getToken();
	}

	public void connect(String address, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		reflector = new JsonSocketReflector(servicesMap, address, useHttpSession, authenticationInfo);
		finish(reflector, reflectorFactory);
		if (authenticationInfo instanceof UsernamePasswordAuthenticationInfo) {
			UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo)authenticationInfo;
			try {
				SToken sToken = getServiceInterface().login(usernamePasswordAuthenticationInfo.getUsername(), usernamePasswordAuthenticationInfo.getPassword());
				reflector.setToken(sToken);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			}
		}
	}
}