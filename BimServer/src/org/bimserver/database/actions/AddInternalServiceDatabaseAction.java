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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.Plugin;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddInternalServiceDatabaseAction extends AddDatabaseAction<InternalServicePluginConfiguration> {

	private Authorization authorization;
	private BimServer bimServer;

	public AddInternalServiceDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, InternalServicePluginConfiguration eService) {
		super(databaseSession, accessMethod, eService);
		this.bimServer = bimServer;
		this.authorization = authorization;
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), OldQuery.getDefault());
		InternalServicePluginConfiguration idEObject = getIdEObject();
		idEObject.setUserSettings(user.getUserSettings());
		Plugin plugin = bimServer.getPluginManager().getPlugin(idEObject.getPluginDescriptor().getIdentifier(), true);
		ObjectType settings = bimServer.convertSettings(getDatabaseSession(), plugin.getUserSettingsDefinition());
		user.getUserSettings().getServices().add(idEObject);
		idEObject.setSettings(settings);
		getDatabaseSession().store(user.getUserSettings());
		return super.execute();
	}
}