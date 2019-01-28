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
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;
import org.eclipse.emf.ecore.EClass;

public class GetAllDatabaseAction<T extends IdEObject> extends BimDatabaseAction<List<T>> {

	private final Class<T> clazz;
	private final EClass eClass;

	public GetAllDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Class<T> clazz, EClass eClass) {
		super(databaseSession, accessMethod);
		this.clazz = clazz;
		this.eClass = eClass;
	}

	@Override
	public List<T> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Condition condition = new IsOfTypeCondition(eClass);
		Map<Long, T> result = getDatabaseSession().query(condition, clazz, OldQuery.getDefault());
		return CollectionUtils.mapToList(result);
	}
}