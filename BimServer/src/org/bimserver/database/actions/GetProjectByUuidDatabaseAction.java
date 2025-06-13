package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.database.query.conditions.Not;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.*;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

import java.util.Map;
import java.util.UUID;

public class GetProjectByUuidDatabaseAction extends BimDatabaseAction<Project> {

	private final String uuid;
	private Authorization authorization;

	public GetProjectByUuidDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, String uuid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.uuid = uuid;
		this.authorization = authorization;
	}

	@Override
	public Project execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {

		UUID comparisonUUID;
		try {
			comparisonUUID = UUID.fromString(uuid);
		}
		catch (IllegalArgumentException e) {
			throw new UserException("Invalid uuid format");
		}
		User user = getUserByUoid(authorization.getUoid());
		Not notStoreProject = new Not(new AttributeCondition(StorePackage.eINSTANCE.getProject_Name(), new StringLiteral(Database.STORE_PROJECT_NAME)));
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getProject()).and(notStoreProject);
		Map<UUID, Project> results = getDatabaseSession().queryUuid(condition, Project.class, OldQuery.getDefault());
		if (results.containsKey(comparisonUUID)) {
			if (!authorization.hasRightsOnProject(user, results.get(comparisonUUID))) {
				throw new UserException("You do not have rights on this project");
			}
			if (!results.get(comparisonUUID).getState().equals(ObjectState.ACTIVE) &&
					user.getUserType() != UserType.ADMIN && user.getUserType() != UserType.SYSTEM){
				throw new UserException("This project is not active");
			}
			return results.get(comparisonUUID);
		}
		else {
			throw new UserException("Project with uuid " + uuid + " does not exist");
		}
	}
}