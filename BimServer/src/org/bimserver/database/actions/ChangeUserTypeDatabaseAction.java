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
import org.bimserver.database.PostCommitAction;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.UserChanged;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class ChangeUserTypeDatabaseAction extends BimDatabaseAction<Void> {

	private final long uoid;
	private final SUserType userType;
	private Authorization authorization;
	private BimServer bimServer;

	public ChangeUserTypeDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long uoid, SUserType userType) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.uoid = uoid;
		this.userType = userType;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User actingUser = getUserByUoid(authorization.getUoid());
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin users can change other user's types");
		}
		User user = getUserByUoid(uoid);
		if (user.getUserType() == UserType.SYSTEM) {
			throw new UserException("Type of system user cannot be changed");
		}
		user.setUserType(UserType.get(userType.getOrdinal()));
		final UserChanged userChanged = getDatabaseSession().create(UserChanged.class);
		userChanged.setAccessMethod(getAccessMethod());
		userChanged.setDate(new Date());
		userChanged.setExecutor(actingUser);
		userChanged.setUser(user);
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(userChanged));
			}
		});
		getDatabaseSession().store(user);
		return null;
	}
}
