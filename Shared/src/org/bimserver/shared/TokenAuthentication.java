package org.bimserver.shared;

public class TokenAuthentication extends AuthenticationInfo {

	private String token;

	public TokenAuthentication(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
