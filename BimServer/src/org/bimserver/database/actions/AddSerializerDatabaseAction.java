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
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddSerializerDatabaseAction extends AddDatabaseAction<SerializerPluginConfiguration> {

	private Authorization authorization;

	public AddSerializerDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, SerializerPluginConfiguration serializer) {
		super(databaseSession, accessMethod, serializer);
		this.authorization = authorization;
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Long execute = super.execute();
		// Make sure the backreferences are stored as well, someday this should be automatic
		if (getIdEObject().getRenderEngine() != null) {
			getDatabaseSession().store(getIdEObject().getRenderEngine());
		}
		if (getIdEObject().getObjectIDM() != null) {
			getDatabaseSession().store(getIdEObject().getObjectIDM());
		}
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), OldQuery.getDefault());
		user.getUserSettings().getSerializers().add(getIdEObject());
		getDatabaseSession().store(user.getUserSettings());

		return execute;
	}
}