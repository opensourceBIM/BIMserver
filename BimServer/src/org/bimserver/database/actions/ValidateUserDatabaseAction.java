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

import java.util.Arrays;
import java.util.Date;

import org.bimserver.Authenticator;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Hashers;

public class ValidateUserDatabaseAction extends BimDatabaseAction<User> {

	private static final long VALIDATION_TOKEN_EXPIRE_MILLIS = 1000 * 60 * 60 * 24 * 7; // 7 days
	private final long uoid;
	private final String token;
	private final String password;

	public ValidateUserDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long uoid, String token, String password) {
		super(databaseSession, accessMethod);
		this.uoid = uoid;
		this.token = token;
		this.password = password;
	}

	@Override
	public User execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getUserByUoid(uoid);
		if (user.getValidationToken() == null || user.getValidationTokenCreated() == null) {
			throw new UserException("This account is already validated and no password reset has been requested");
		}
		if (user.getValidationTokenCreated().getTime() + VALIDATION_TOKEN_EXPIRE_MILLIS < new Date().getTime()) {
			throw new UserException("The validation period of this validation token has expired, please contact your administrator or request the password reset again");
		}
		if (!Arrays.equals(user.getValidationToken(), Hashers.getSha256Hash(token))) {
			throw new UserException("The given token is not correct");
		}
		if (password == null || password.trim().equals("")) {
			throw new UserException("Invalid new password");
		}
		byte[] salt = new byte[32];
		new java.security.SecureRandom().nextBytes(salt);
		user.setPasswordHash(new Authenticator().createHash(password, salt));
		user.setPasswordSalt(salt);
		user.setValidationToken(null);
		user.setValidationTokenCreated(null);
		getDatabaseSession().store(user);
		return user;
	}
}