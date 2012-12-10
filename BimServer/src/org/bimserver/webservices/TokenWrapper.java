package org.bimserver.webservices;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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
