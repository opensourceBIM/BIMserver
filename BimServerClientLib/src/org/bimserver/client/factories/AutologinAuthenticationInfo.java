package org.bimserver.client.factories;

public class AutologinAuthenticationInfo extends AuthenticationInfo {
	private final String username;
	private final String autologinCode;

	public AutologinAuthenticationInfo(String username, String autologinCode) {
		this.username = username;
		this.autologinCode = autologinCode;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getAutologinCode() {
		return autologinCode;
	}
}
