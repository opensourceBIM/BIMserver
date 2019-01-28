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
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;

public class AddUserToExtendedDataSchemaDatabaseAction extends BimDatabaseAction<Void> {

	private final long uoid;
	private final long edsid;

	public AddUserToExtendedDataSchemaDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long uoid, long edsid) {
		super(databaseSession, accessMethod);
		this.uoid = uoid;
		this.edsid = edsid;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), uoid, OldQuery.getDefault());
		if (user == null) {
			throw new UserException("User with oid " + uoid + " not found");
		}
		ExtendedDataSchema extendedDataSchema = getDatabaseSession().get(StorePackage.eINSTANCE.getExtendedDataSchema(), edsid, OldQuery.getDefault());
		if (extendedDataSchema == null) {
			throw new UserException("ExtendedDataSchema with oid " + edsid + " not found");
		}
		user.getSchemas().add(extendedDataSchema);
		getDatabaseSession().store(user);
		getDatabaseSession().store(extendedDataSchema);
		return null;
	}
}