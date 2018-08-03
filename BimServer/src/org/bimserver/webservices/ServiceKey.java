package org.bimserver.webservices;

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
