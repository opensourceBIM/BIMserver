package org.bimserver.database.actions;

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

import java.util.Date;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.authorization.AuthenticationException;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutologinDatabaseAction extends BimDatabaseAction<String>{
	private static final Logger LOGGER = LoggerFactory.getLogger(AutologinDatabaseAction.class);
	private final String token;
	private BimServer bimServer;
	private ServiceMap serviceMap;

	public AutologinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, ServiceMap serviceMap, AccessMethod accessMethod, String token) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.serviceMap = serviceMap;
		this.token = token;
	}

	@Override
	public String execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		try {
			Authorization authorization = Authorization.fromToken(bimServer.getEncryptionKey(), token);
			User user = getDatabaseSession().get(authorization.getUoid(), OldQuery.getDefault());
			if (user.getState() == ObjectState.DELETED) {
				throw new UserException("User account has been deleted");
			} else if (user.getUserType() == UserType.SYSTEM) {
				throw new UserException("System user cannot login");
			}
			if (bimServer.getServerSettingsCache().getServerSettings().isStoreLastLogin()) {
				user.setLastSeen(new Date());
				getDatabaseSession().store(user);
			}
			authorization.setUoid(user.getOid());
			authorization.setUsername(user.getUsername());
			String asHexToken = authorization.asHexToken(bimServer.getEncryptionKey());
			
			serviceMap.setAuthorization(authorization);
			return asHexToken;
		} catch (AuthenticationException e) {
			LOGGER.error("", e);
		}
		try {
			// Adding a random sleep to prevent timing attacks
			Thread.sleep(LoginDatabaseAction.DEFAULT_LOGIN_ERROR_TIMEOUT + new java.security.SecureRandom().nextInt(1000));
		} catch (InterruptedException e) {
			LOGGER.error("", e);
		}
		throw new UserException("User not found or inccorrect autologin token");
	}
}