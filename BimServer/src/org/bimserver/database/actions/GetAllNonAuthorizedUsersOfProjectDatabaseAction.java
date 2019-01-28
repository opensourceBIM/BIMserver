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

import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.query.conditions.AndCondition;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.database.query.conditions.Not;
import org.bimserver.database.query.literals.EnumLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllNonAuthorizedUsersOfProjectDatabaseAction extends BimDatabaseAction<Set<User>>{

	private final long poid;

	public GetAllNonAuthorizedUsersOfProjectDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid) {
		super(databaseSession, accessMethod);
		this.poid = poid;
	}
	
	@Override
	public Set<User> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getProjectByPoid(poid);
		if (project == null) {
			throw new UserException("No Project with oid " + poid + " found");
		}
		Condition condition = 
			new AndCondition(
				new AndCondition(
						new Not(new HasReferenceToCondition(StorePackage.eINSTANCE.getUser_HasRightsOn(), project)), 
						new AttributeCondition(StorePackage.eINSTANCE.getUser_State(), new EnumLiteral(ObjectState.ACTIVE))), 
				new Not(new AttributeCondition(StorePackage.eINSTANCE.getUser_UserType(), new EnumLiteral(UserType.SYSTEM))));
		return CollectionUtils.mapToSet(getDatabaseSession().query(condition, User.class, OldQuery.getDefault()));
	}
}