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

import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.HasReferenceToCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.*;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.webservices.authorization.Authorization;

public class GetAllCheckoutsOfRevisionDatabaseAction extends BimDatabaseAction<List<Checkout>> {

	private final long roid;
	private Authorization authorization;

	public GetAllCheckoutsOfRevisionDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long roid, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.roid = roid;
		this.authorization = authorization;
	}

	@Override
	public List<Checkout> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User actingUser = getUserByUoid(authorization.getUoid());
		Revision revision = getRevisionByRoid(roid);
		Project project = revision.getProject();
		if (!authorization.hasRightsOnProject(actingUser, project)) {
			throw new UserException("User does not have rights on project");
		}
		Condition condition = new HasReferenceToCondition(StorePackage.eINSTANCE.getCheckout_Revision(), revision);
		return CollectionUtils.mapToList(getDatabaseSession().query(condition, Checkout.class, OldQuery.getDefault()));
	}
}