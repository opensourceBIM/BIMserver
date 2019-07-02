package org.bimserver.webservices;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.log.AccessMethod;
import org.bimserver.webservices.authorization.Authorization;

public class ServiceKey {

	private Authorization authorization;
	private AccessMethod accessMethod;

	public ServiceKey(Authorization authorization, AccessMethod accessMethod) {
		this.authorization = authorization;
		this.accessMethod = accessMethod;
	}
	
	public AccessMethod getAccessMethod() {
		return accessMethod;
	}
	
	public Authorization getAuthorization() {
		return authorization;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessMethod == null) ? 0 : accessMethod.hashCode());
		result = prime * result + ((authorization == null) ? 0 : authorization.hashCode());
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
		ServiceKey other = (ServiceKey) obj;
		if (accessMethod != other.accessMethod)
			return false;
		if (authorization == null) {
			if (other.authorization != null)
				return false;
		} else if (!authorization.equals(other.authorization))
			return false;
		return true;
	}
}
