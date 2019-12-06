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

import org.bimserver.Authenticator;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.authorization.AdminAuthorization;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.MonitorAuthorization;
import org.bimserver.webservices.authorization.UserAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDatabaseAction extends BimDatabaseAction<String> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDatabaseAction.class);
	public static final Integer DEFAULT_LOGIN_ERROR_TIMEOUT = 2000;

	private final String username;
	private final String password;
	private BimServer bimServer;
	private ServiceMap serviceMap;

	public LoginDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, ServiceMap serviceMap, AccessMethod accessMethod, String username, String password) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.serviceMap = serviceMap;
		this.username = username;
		this.password = password;
	}

	@Override
	public String execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(getDatabaseSession(), getAccessMethod(), username);
		User user = action.execute();
		if (user != null) {
			if (user.getPasswordHash() == null || user.getPasswordHash().length == 0) {
				throw new UserException("Your email address has not been validated yet");
			}
			if (new Authenticator().validate(password, user.getPasswordHash(), user.getPasswordSalt())) {
				if (user.getState() == ObjectState.DELETED) {
					throw new UserException("User account has been deleted");
				} else if (user.getUserType() == UserType.SYSTEM) {
					throw new UserException("System user cannot login");
				}
				Authorization authorization = null;
				
				int sessionTimeOutSeconds = 60 * 10;
				boolean migrationRequired = bimServer.getDatabase().getMigrator().migrationRequired();
				if (!migrationRequired) {
					sessionTimeOutSeconds = bimServer.getServerSettingsCache().getServerSettings().getSessionTimeOutSeconds();
				}
				if (user.getUserType() == UserType.ADMIN) {
					authorization = new AdminAuthorization(sessionTimeOutSeconds, TimeUnit.SECONDS);
				} else if (user.getUserType() == UserType.MONITOR) {
					authorization = new MonitorAuthorization(sessionTimeOutSeconds, TimeUnit.SECONDS);
				} else {
					authorization = new UserAuthorization(sessionTimeOutSeconds, TimeUnit.SECONDS);
				}
				authorization.setUoid(user.getOid());
				authorization.setUsername(user.getUsername());
				String asHexToken = authorization.asHexToken(bimServer.getEncryptionKey());
				serviceMap.setAuthorization(authorization);
				bimServer.getAuthCache().store(asHexToken, authorization);
				if (!migrationRequired && bimServer.getServerSettingsCache().getServerSettings().isStoreLastLogin()) {
					user.setLastSeen(new Date());
					getDatabaseSession().store(user);
				}
				return asHexToken;					
			}
		}
		try {
			// Adding a random sleep to prevent timing attacks
			Thread.sleep(DEFAULT_LOGIN_ERROR_TIMEOUT + new java.security.SecureRandom().nextInt(1000));
		} catch (InterruptedException e) {
			LOGGER.error("", e);
		}
		throw new UserException("Invalid username/password combination");
	}
}