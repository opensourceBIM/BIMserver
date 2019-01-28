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

import org.bimserver.Authenticator;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.interfaces.SConverter;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.PasswordChanged;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class ChangePasswordDatabaseAction extends BimDatabaseAction<Boolean> {

	private final String oldPassword;
	private final String newPassword;
	private final long uoid;
	private Authorization authorization;
	private BimServer bimServer;

	public ChangePasswordDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long uoid, String oldPassword, String newPassword, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.uoid = uoid;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.authorization = authorization;
	}

	@Override
	public Boolean execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User actingUser = getUserByUoid(authorization.getUoid());
		User user = getUserByUoid(uoid);
		if (user.getUserType() == UserType.SYSTEM) {
			throw new UserException("Password of system user cannot be changed");
		}
		if (uoid == authorization.getUoid()) {
			return changePassword(getDatabaseSession(), actingUser, false);
		} else {
			if (actingUser.getUserType() == UserType.ADMIN || actingUser.getUserType() == UserType.SYSTEM) {
				return changePassword(getDatabaseSession(), actingUser, true);
			} else {
				throw new UserException("Insufficient rights to change the password of this user");
			}
		}
	}

	private boolean changePassword(DatabaseSession databaseSession, User actingUser, boolean skipCheck) throws BimserverLockConflictException, BimserverDatabaseException, UserException {
		User user = getUserByUoid(uoid);
		Authenticator authenticator = new Authenticator();
		if (skipCheck || authenticator.validate(oldPassword, user.getPasswordHash(), user.getPasswordSalt())) {
			byte[] salt = new byte[32];
			new java.security.SecureRandom().nextBytes(salt);
			user.setPasswordHash(authenticator.createHash(newPassword, salt));
			user.setPasswordSalt(salt);
			
			final PasswordChanged passwordchanged = databaseSession.create(PasswordChanged.class);
			passwordchanged.setAccessMethod(getAccessMethod());
			passwordchanged.setDate(new Date());
			passwordchanged.setExecutor(actingUser);
			passwordchanged.setUser(user);
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(passwordchanged));
				}
			});
			databaseSession.store(user);
			return true;
		} else {
			throw new UserException("Old password does not match user's password");
		}
	}
}