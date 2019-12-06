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

import java.util.HashMap;
import java.util.Map;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.util.concurrent.TimeUnit;

import org.bimserver.BimServer;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.User;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.AnonymousAuthorization;
import org.bimserver.webservices.authorization.Authorization;

public class PublicInterfaceFactory implements ServiceFactory {
	private final BimServer bimServer;
	private final Map<ServiceKey, ServiceMap> cachedServiceMaps = new HashMap<>();

	public PublicInterfaceFactory(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	public ServiceMap get(Authorization authorization, AccessMethod accessMethod) {
		return get(authorization, accessMethod, null);
	}
	
	public ServiceMap get(Authorization authorization, AccessMethod accessMethod, User user) {
		ServiceKey serviceKey = new ServiceKey(authorization, accessMethod);
		if (cachedServiceMaps.containsKey(serviceKey)) {
			return cachedServiceMaps.get(serviceKey);
		} else {
			ServiceMap serviceMap = new ServiceMap(bimServer, authorization, accessMethod, user);
			cachedServiceMaps.put(serviceKey, serviceMap);
			return serviceMap;
		}
	}
	
	public synchronized ServiceMap get(AccessMethod accessMethod) throws UserException {
		Authorization authorization = null;
		if (bimServer.getServerInfo().getServerState() == ServerState.MIGRATION_REQUIRED) {
			// We don't want to access the server settings, because those are possibly also to be migrated
			authorization = new AnonymousAuthorization(60 * 10, TimeUnit.SECONDS);
		} else {
			authorization = new AnonymousAuthorization(bimServer.getServerSettingsCache().getServerSettings().getSessionTimeOutSeconds(), TimeUnit.SECONDS);
		}
		return get(authorization, accessMethod, null);
	}
	
	public synchronized ServiceMap get(String token, AccessMethod accessMethod) throws UserException {
		try {
			Authorization authorization = bimServer.getAuthCache().getAuthorization(token);
			User user = null;
			if (authorization == null) {
				authorization = Authorization.fromToken(bimServer.getEncryptionKey(), token);
				// We do this on login as well, so no need to do for cached auth
				// TODO When a user is being deleted, this auth cache should be updated accordingly
				// TODO A logout method should be added
				DatabaseSession session = bimServer.getDatabase().createSession(OperationType.READ_ONLY);
				try {
					user = session.get(authorization.getUoid(), OldQuery.getDefault());
					if (user == null) {
						throw new UserException("No user found with uoid " + authorization.getUoid());
					}
					if (user.getState() == ObjectState.DELETED) {
						throw new UserException("User has been deleted");
					}
				} finally {
					session.close();
				}
			}
			return get(authorization, accessMethod, user);
		} catch (Exception e) {
			if (e instanceof UserException) {
				throw (UserException)e;
			} else if (e instanceof org.bimserver.webservices.authorization.AuthenticationException) {
				throw new InvalidTokenException(e.getMessage());
			} else {
				throw new UserException(e);
			}
		}
	}
}