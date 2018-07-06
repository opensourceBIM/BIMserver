package org.bimserver;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.webservices.authorization.Authorization;

public class AuthCache {
	private BimServer bimServer;
	private final Map<String, Authorization> authorizations = new HashMap<>();

	public AuthCache(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public void store(String token, Authorization authorization) {
		authorizations.put(token, authorization);
	}

	public Authorization getAuthorization(String token) {
		return authorizations.get(token);
	}
}
