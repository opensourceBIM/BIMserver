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

import java.util.Date;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.BimserverDeadlockException;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.GeoTagUpdated;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class UpdateGeoTagDatabaseAction extends BimDatabaseAction<Void> {

	private final SGeoTag sGeoTag;
	private final long actingUoid;

	public UpdateGeoTagDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long actingUoid, SGeoTag sGeoTag) {
		super(databaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.sGeoTag = sGeoTag;
	}

	@Override
	public Void execute() throws UserException, BimserverDeadlockException, BimserverDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		GeoTag geoTag = (GeoTag) getDatabaseSession().get(StorePackage.eINSTANCE.getGeoTag(), sGeoTag.getOid(), false, null);
		boolean hasRights = false;
		for (Project project : geoTag.getProjects()) {
			if (RightsManager.hasRightsOnProject(actingUser, project)) {
				hasRights = true;
				continue;
			}
		}
		if (hasRights) {
			geoTag.setEnabled(sGeoTag.getEnabled());
			geoTag.setX(sGeoTag.getX());
			geoTag.setY(sGeoTag.getY());
			geoTag.setZ(sGeoTag.getZ());
			geoTag.setDirectionAngle(sGeoTag.getDirectionAngle());
			geoTag.setEpsg(sGeoTag.getEpsg());
			GeoTagUpdated geoTagUpdated = LogFactory.eINSTANCE.createGeoTagUpdated();
			geoTagUpdated.setGeoTag(geoTag);
			geoTagUpdated.setAccessMethod(getAccessMethod());
			geoTagUpdated.setDate(new Date());
			geoTagUpdated.setExecutor(actingUser);
			getDatabaseSession().store(geoTagUpdated);
			getDatabaseSession().store(geoTag);
		} else {
			throw new UserException("User has no rights on any projects associated with this geotag");
		}
		return null;
	}
}