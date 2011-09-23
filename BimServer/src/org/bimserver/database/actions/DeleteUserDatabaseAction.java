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

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;

public class DeleteUserDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long actingUoid;
	private final long uoid;

	public DeleteUserDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long uoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.uoid = uoid;
	}

	@Override
	public Boolean execute() throws UserException, BimDatabaseException, BimDeadlockException {
		User actingUser = getUserByUoid(actingUoid);
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only administrators can delete users accounts");
		}
		final User user = getUserByUoid(uoid);
		if (user.getUserType() == UserType.SYSTEM) {
			throw new UserException("System user cannot be deleted");
		}
		if (user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("Cannot delete this user");
		}
		user.setState(ObjectState.DELETED);
		getDatabaseSession().store(user);
		return true;
	}
}