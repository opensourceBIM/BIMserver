package org.bimserver.webservices;

import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.store.Token;

/* This class is here because Token is generated and does not have equals/hashCode which makes in impossible to use in a HashMap */

public class TokenWrapper {
	private final Token token;
	private final SToken sToken;

	public TokenWrapper(Token token) {
		this.token = token;
		this.sToken = null;
	}
	
	public TokenWrapper(SToken sToken) {
		this.sToken = sToken;
		this.token = null;
	}
	
	public String getTokenString() {
		if (token == null) {
			return sToken.getTokenString();
		} else {
			return token.getTokenString();
		}
	}
	
	public long getExpires() {
		if (token == null) {
			return sToken.getExpires();
		} else {
			return token.getExpires();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (getExpires() ^ (getExpires() >>> 32));
		result = prime * result + ((getTokenString() == null) ? 0 : getTokenString().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenWrapper other = (TokenWrapper) obj;
		if (getExpires() != other.getExpires())
			return false;
		if (getTokenString() == null) {
			if (other.getTokenString() != null)
				return false;
		} else if (!getTokenString().equals(other.getTokenString()))
			return false;
		return true;
	}

	public SToken getToken() {
		return sToken;
	}
}
