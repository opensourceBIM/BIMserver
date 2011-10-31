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
import org.bimserver.models.log.UserUndeleted;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;

public class UndeleteUserDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long actingUoid;
	private final long uoid;

	public UndeleteUserDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long uoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.uoid = uoid;
	}

	@Override
	public Boolean execute() throws UserException, BimDatabaseException, BimDeadlockException {
		User actingUser = getUserByUoid(actingUoid);
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only administrators can undelete users");
		}
		final User user = getUserByUoid(uoid);
		UserUndeleted userUndeleted = LogFactory.eINSTANCE.createUserUndeleted();
		userUndeleted.setAccessMethod(getAccessMethod());
		userUndeleted.setDate(new Date());
		userUndeleted.setExecutor(actingUser);
		userUndeleted.setUser(user);
		user.setState(ObjectState.ACTIVE);
		getDatabaseSession().store(user);
		getDatabaseSession().store(userUndeleted);
		return true;
	}
}