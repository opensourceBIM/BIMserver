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
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.database.query.conditions.Not;
import org.bimserver.database.query.literals.EnumLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.webservices.authorization.Authorization;

public class GetAllUsersDatabaseAction extends BimDatabaseAction<Set<User>> {

	private Authorization authorization;

	public GetAllUsersDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.authorization = authorization;
	}

	@Override
	public Set<User> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User actingUser = getUserByUoid(authorization.getUoid());
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getUser());
		condition = condition.and(new Not(new AttributeCondition(StorePackage.eINSTANCE.getUser_UserType(), new EnumLiteral(UserType.SYSTEM))));
		if (actingUser.getUserType() != UserType.ADMIN) {
			condition = condition.and(new AttributeCondition(StorePackage.eINSTANCE.getUser_State(), new EnumLiteral(ObjectState.ACTIVE)));
		}
		return CollectionUtils.mapToSet(getDatabaseSession().query(condition, User.class, OldQuery.getDefault()));
	}
}