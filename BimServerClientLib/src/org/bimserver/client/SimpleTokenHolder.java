package org.bimserver.client;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.shared.TokenChangeListener;
import org.bimserver.shared.TokenHolder;

public class SimpleTokenHolder implements TokenHolder {

	private final Set<TokenChangeListener> tokenChangeListeners = new HashSet<TokenChangeListener>();
	private String token;

	public void setToken(String token) {
		this.token = token;
		for (TokenChangeListener tokenChangeListener : tokenChangeListeners) {
			tokenChangeListener.newToken(token);
		}
	}
	
	@Override
	public String getToken() {
		return token;
	}

	@Override
	public void registerTokenChangeListener(TokenChangeListener tokenChangeListener) {
		tokenChangeListeners.add(tokenChangeListener);
	}
}
