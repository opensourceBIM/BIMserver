package org.bimserver.webservices;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.concurrent.TimeUnit;

import org.bimserver.BimServer;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.AnonymousAuthorization;
import org.bimserver.webservices.authorization.Authorization;

public class PublicInterfaceFactory implements ServiceFactory {
	private final BimServer bimServer;

	public PublicInterfaceFactory(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	public ServiceMap get(Authorization authorization, AccessMethod accessMethod) {
		ServiceMap serviceMap = new ServiceMap(bimServer, authorization, accessMethod);
		return serviceMap;
	}
	
	public synchronized ServiceMap get(AccessMethod accessMethod) throws UserException {
		Authorization authorization = new AnonymousAuthorization(bimServer.getServerSettingsCache().getServerSettings().getSessionTimeOutSeconds(), TimeUnit.SECONDS);
		return get(authorization, accessMethod);
	}
	
	public synchronized ServiceMap get(String token, AccessMethod accessMethod) throws UserException {
		try {
			Authorization authorization = Authorization.fromToken(bimServer.getEncryptionKey(), token);
			DatabaseSession session = bimServer.getDatabase().createSession();
			try {
				User user = session.get(authorization.getUoid(), Query.getDefault());
				if (user == null) {
					throw new UserException("No user found with uoid " + authorization.getUoid());
				}
				if (user.getState() == ObjectState.DELETED) {
					throw new UserException("User has been deleted");
				}
			} finally {
				session.close();
			}
			return get(authorization, accessMethod);
		} catch (Exception e) {
			if (e instanceof UserException) {
				throw (UserException)e;
			} else {
				throw new UserException(e);
			}
		}
	}
}