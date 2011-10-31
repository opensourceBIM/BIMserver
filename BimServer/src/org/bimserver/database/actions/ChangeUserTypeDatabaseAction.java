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
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.UserChanged;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;

public class ChangeUserTypeDatabaseAction extends BimDatabaseAction<Void> {

	private final long actingUoid;
	private final long uoid;
	private final SUserType userType;

	public ChangeUserTypeDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long uoid, SUserType userType) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.uoid = uoid;
		this.userType = userType;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin users can change other user's types");
		}
		User user = getUserByUoid(uoid);
		if (user.getUserType() == UserType.SYSTEM) {
			throw new UserException("Type of system user cannot be changed");
		}
		user.setUserType(UserType.get(userType.getOrdinal()));
		UserChanged userChanged = LogFactory.eINSTANCE.createUserChanged();
		userChanged.setAccessMethod(getAccessMethod());
		userChanged.setDate(new Date());
		userChanged.setExecutor(actingUser);
		userChanged.setUser(user);
		getDatabaseSession().store(userChanged);
		getDatabaseSession().store(user);
		return null;
	}
}
