package org.bimserver.client.factories;

public class UsernamePasswordAuthenticationInfo extends AuthenticationInfo {
	private final String username;
	private final String password;

	public UsernamePasswordAuthenticationInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
