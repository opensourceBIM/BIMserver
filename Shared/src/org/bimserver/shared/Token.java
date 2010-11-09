package org.bimserver.shared;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

@XmlRootElement
public class Token {
	private String tokenString;
	private long expires;

	public Token() {
	}

	public Token(String tokenString, Long expires) {
		this.tokenString = tokenString;
		this.expires = expires;
	}

	public Token(String tokenString, Date expires) {
		this.tokenString = tokenString;
		this.expires = expires.getTime();
	}

	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	public String getTokenString() {
		return tokenString;
	}

	public long getExpires() {
		return expires;
	}

	public Date getExpiresAsDate() {
		return new Date(expires);
	}

	@Override
	public String toString() {
		return tokenString + ", " + expires;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (expires ^ (expires >>> 32));
		result = prime * result + ((tokenString == null) ? 0 : tokenString.hashCode());
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
		Token other = (Token) obj;
		if (expires != other.expires)
			return false;
		if (tokenString == null) {
			if (other.tokenString != null)
				return false;
		} else if (!tokenString.equals(other.tokenString))
			return false;
		return true;
	}
}