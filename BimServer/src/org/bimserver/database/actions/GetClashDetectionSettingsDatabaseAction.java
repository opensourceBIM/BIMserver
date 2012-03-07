package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class GetClashDetectionSettingsDatabaseAction extends BimDatabaseAction<ClashDetectionSettings> {

	private final long cdsoid;
	private final long actingUoid;

	public GetClashDetectionSettingsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long cdsoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.cdsoid = cdsoid;
	}

	@Override
	public ClashDetectionSettings execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		ClashDetectionSettings clashDetectionSettings = (ClashDetectionSettings) getDatabaseSession().get(StorePackage.eINSTANCE.getClashDetectionSettings(), cdsoid, false, null);
		boolean hasRights = false;
		for (Project project : clashDetectionSettings.getProjects()) {
			if (RightsManager.hasRightsOnProject(actingUser, project)) {
				hasRights = true;
				continue;
			}
		}
		if (hasRights) {
			return clashDetectionSettings;
		} else {
			throw new UserException("User has no rights on any projects associated with these clash detection settings");
		}
	}
}