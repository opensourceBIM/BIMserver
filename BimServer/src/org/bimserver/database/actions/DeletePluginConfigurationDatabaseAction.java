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
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.*;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EReference;

public class DeletePluginConfigurationDatabaseAction extends BimDatabaseAction<Void>{

	private long oid;
	private Authorization authorization;

	public DeletePluginConfigurationDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long oid) {
		super(databaseSession, accessMethod);
		this.oid = oid;
		this.authorization = authorization;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), authorization.getUoid(), OldQuery.getDefault());
		if (user.getUserType() == UserType.READ_ONLY) {
			throw new UserException("User has no rights for this call");
		}
		PluginConfiguration pluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), oid, OldQuery.getDefault());
		UserSettings settings = (UserSettings) pluginConfiguration.eGet(pluginConfiguration.eClass().getEStructuralFeature("userSettings"));
		if (settings == null) {
			throw new UserException("No user settings found...");
		}
		for (EReference eReference : settings.eClass().getEAllReferences()) {
			if (eReference.getEType() == pluginConfiguration.eClass() && eReference.isMany()) {
				List list = (List) settings.eGet(eReference);
				list.remove(pluginConfiguration);
			}
		}
		getDatabaseSession().store(settings);
		pluginConfiguration.remove();
		return null;
	} 
}