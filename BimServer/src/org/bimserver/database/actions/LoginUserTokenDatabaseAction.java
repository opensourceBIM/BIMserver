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
import java.util.concurrent.TimeUnit;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.DefaultErrorCode;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.authorization.AdminAuthorization;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.UserAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginUserTokenDatabaseAction extends BimDatabaseAction<String> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserTokenDatabaseAction.class);
	public static final Integer DEFAULT_LOGIN_ERROR_TIMEOUT = 2000;

	private BimServer bimServer;
	private ServiceMap serviceMap;
	private String userToken;

	public LoginUserTokenDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, ServiceMap serviceMap, AccessMethod accessMethod, String userToken) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.serviceMap = serviceMap;
		this.userToken = userToken;
	}

	@Override
	public String execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		BimDatabaseAction<User> action = new GetUserByUserTokenDatabaseAction(getDatabaseSession(), getAccessMethod(), userToken);
		User user = action.execute();
		if (user != null) {
			if (user.getState() == ObjectState.DELETED) {
				throw new UserException("User account has been deleted");
			} else if (user.getUserType() == UserType.SYSTEM) {
				throw new UserException("System user cannot login");
			}
			Authorization authorization = null;
			if (user.getUserType() == UserType.ADMIN) {
				authorization = new AdminAuthorization(bimServer.getServerSettingsCache().getServerSettings().getSessionTimeOutSeconds(), TimeUnit.SECONDS);
			} else {
				authorization = new UserAuthorization(bimServer.getServerSettingsCache().getServerSettings().getSessionTimeOutSeconds(), TimeUnit.SECONDS);
			}
			authorization.setUoid(user.getOid());
			authorization.setUsername(user.getUsername());
			String asHexToken = authorization.asHexToken(bimServer.getEncryptionKey());
			serviceMap.setAuthorization(authorization);
			if (bimServer.getServerSettingsCache().getServerSettings().isStoreLastLogin()) {
				user.setLastSeen(new Date());
				getDatabaseSession().store(user);
			}
			return asHexToken;					
		}
		try {
			// Adding a random sleep to prevent timing attacks
			Thread.sleep(DEFAULT_LOGIN_ERROR_TIMEOUT + new java.security.SecureRandom().nextInt(1000));
		} catch (InterruptedException e) {
			LOGGER.error("", e);
		}
		throw new UserException("Invalid token", DefaultErrorCode.INVALID_TOKEN);
	}
}