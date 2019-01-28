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
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetGeoTagDatabaseAction extends BimDatabaseAction<GeoTag> {

	private final long goid;
	private Authorization authorization;

	public GetGeoTagDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long goid) {
		super(databaseSession, accessMethod);
		this.authorization = authorization;
		this.goid = goid;
	}

	@Override
	public GeoTag execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User actingUser = getUserByUoid(authorization.getUoid());
		GeoTag geoTag = (GeoTag) getDatabaseSession().get(StorePackage.eINSTANCE.getGeoTag(), goid, OldQuery.getDefault());
		boolean hasRights = false;
		for (Project project : geoTag.getProjects()) {
			if (authorization.hasRightsOnProject(actingUser, project)) {
				hasRights = true;
				continue;
			}
		}
		if (hasRights) {
			return geoTag;
		} else {
			throw new UserException("User has no rights on any projects associated with this geotag");
		}
	}
}