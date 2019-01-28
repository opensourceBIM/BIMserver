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

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class AddExtendedDataSchemaDatabaseAction extends AddDatabaseAction<ExtendedDataSchema> {

	public AddExtendedDataSchemaDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, ExtendedDataSchema extendedDataSchema) {
		super(databaseSession, accessMethod, extendedDataSchema);
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		if (getIdEObject().getName() == null || getIdEObject().getName().trim().equals("")) {
			throw new UserException("Name cannot be empty");
		}
		if (getIdEObject().getContentType() == null || getIdEObject().getContentType().trim().equals("")) {
			throw new UserException("ContentType cannot be empty");
		}
		if (getDatabaseSession().querySingle(new AttributeCondition(StorePackage.eINSTANCE.getExtendedDataSchema_Name(), new StringLiteral(getIdEObject().getName())), ExtendedDataSchema.class, OldQuery.getDefault()) != null) {
			throw new UserException("ExtendedDataSchema name must be unique");
		}
		return super.execute();
	}
}