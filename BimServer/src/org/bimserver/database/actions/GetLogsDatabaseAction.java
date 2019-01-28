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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetLogsDatabaseAction extends BimDatabaseAction<List<LogAction>> {

	private Authorization authorization;

	public GetLogsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.authorization = authorization;
	}

	@Override
	public List<LogAction> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getUserByUoid(authorization.getUoid());
		if (user.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin users can retrieve log");
		}
		Map<Long, LogAction> query = getDatabaseSession().query(new IsOfTypeCondition(LogPackage.eINSTANCE.getLogAction()), LogAction.class, OldQuery.getDefault());
		ArrayList<LogAction> list = new ArrayList<LogAction>(query.values());
		return list;
	}
}