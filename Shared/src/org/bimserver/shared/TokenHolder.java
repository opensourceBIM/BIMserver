package org.bimserver.shared;

public interface TokenHolder {
	String getToken();
	void setToken(String token);
	void registerTokenChangeListener(TokenChangeListener tokenChangeListener);
}