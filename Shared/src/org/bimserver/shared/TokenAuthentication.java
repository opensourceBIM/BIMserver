package org.bimserver.shared;

import org.bimserver.interfaces.objects.SToken;

public class TokenAuthentication extends AuthenticationInfo {

	private SToken token;

	public TokenAuthentication(SToken token) {
		this.token = token;
	}

	public SToken getToken() {
		return token;
	}
}
