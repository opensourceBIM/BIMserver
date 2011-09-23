package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.PasswordChanged;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Hashers;

public class ChangePasswordDatabaseAction extends BimDatabaseAction<Boolean> {

	private final String oldPassword;
	private final String newPassword;
	private final long uoid;
	private final long actingUoid;

	public ChangePasswordDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long uoid, String oldPassword, String newPassword, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.uoid = uoid;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.actingUoid = actingUoid;
	}

	@Override
	public Boolean execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		User user = getUserByUoid(uoid);
		if (user.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("Password of anonymous user cannot be changed");
		} else if (user.getUserType() == UserType.SYSTEM) {
			throw new UserException("Password of system user cannot be changed");
		}
		if (uoid == actingUoid) {
			return changePassword(getDatabaseSession(), actingUser, false);
		} else {
			if (actingUser.getUserType() == UserType.ADMIN || actingUser.getUserType() == UserType.SYSTEM) {
				return changePassword(getDatabaseSession(), actingUser, true);
			} else {
				throw new UserException("Insufficient rights to change the password of this user");
			}
		}
	}

	private boolean changePassword(BimDatabaseSession bimDatabaseSession, User actingUser, boolean skipCheck) throws BimDeadlockException, BimDatabaseException, UserException {
		User user = getUserByUoid(uoid);
		if (skipCheck || Hashers.getSha256Hash(oldPassword).equals(user.getPassword())) {
			user.setPassword(Hashers.getSha256Hash(newPassword));
			PasswordChanged passwordchanged = LogFactory.eINSTANCE.createPasswordChanged();
			passwordchanged.setAccessMethod(getAccessMethod());
			passwordchanged.setDate(new Date());
			passwordchanged.setExecutor(actingUser);
			passwordchanged.setUser(user);
			bimDatabaseSession.store(user);
			bimDatabaseSession.store(passwordchanged);
			return true;
		} else {
			throw new UserException("Old password does not match user's password");
		}
	}
}