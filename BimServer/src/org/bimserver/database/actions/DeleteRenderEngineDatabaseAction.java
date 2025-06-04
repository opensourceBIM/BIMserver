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
import org.bimserver.models.store.*;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class DeleteRenderEngineDatabaseAction extends DeleteDatabaseAction<RenderEnginePluginConfiguration> {
	private Authorization authorization;

	public DeleteRenderEngineDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long iid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), iid);
		this.authorization = authorization;
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), OldQuery.getDefault());
		if (user.getUserType() == UserType.READ_ONLY) {
			throw new UserException("User has no rights for this call");
		}
		RenderEnginePluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), OldQuery.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getRenderEngines().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}