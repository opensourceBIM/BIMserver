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
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.UserUndeleted;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class UndeleteUserDatabaseAction extends BimDatabaseAction<Boolean> {

	private final long uoid;
	private Authorization authorization;
	private BimServer bimServer;

	public UndeleteUserDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long uoid) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.uoid = uoid;
	}

	@Override
	public Boolean execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		User actingUser = getUserByUoid(authorization.getUoid());
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only administrators can undelete users");
		}
		final User user = getUserByUoid(uoid);
		if (user == null) {
			throw new UserException("No User with oid " + uoid + " found");
		}
		final UserUndeleted userUndeleted = getDatabaseSession().create(UserUndeleted.class);
		userUndeleted.setAccessMethod(getAccessMethod());
		userUndeleted.setDate(new Date());
		userUndeleted.setExecutor(actingUser);
		userUndeleted.setUser(user);
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(userUndeleted));
			}
		});
		user.setState(ObjectState.ACTIVE);
		getDatabaseSession().store(user);
		return true;
	}
}