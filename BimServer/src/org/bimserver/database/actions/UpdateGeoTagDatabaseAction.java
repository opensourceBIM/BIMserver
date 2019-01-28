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

import java.util.Date;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.PostCommitAction;
import org.bimserver.interfaces.SConverter;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.GeoTagUpdated;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class UpdateGeoTagDatabaseAction extends BimDatabaseAction<Void> {

	private final SGeoTag sGeoTag;
	private Authorization authorization;
	private BimServer bimServer;

	public UpdateGeoTagDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, SGeoTag sGeoTag) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.sGeoTag = sGeoTag;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User actingUser = getUserByUoid(authorization.getUoid());
		GeoTag geoTag = (GeoTag) getDatabaseSession().get(StorePackage.eINSTANCE.getGeoTag(), sGeoTag.getOid(), OldQuery.getDefault());
		boolean hasRights = false;
		for (Project project : geoTag.getProjects()) {
			if (authorization.hasRightsOnProject(actingUser, project)) {
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
			final GeoTagUpdated geoTagUpdated = getDatabaseSession().create(GeoTagUpdated.class);
			geoTagUpdated.setGeoTag(geoTag);
			geoTagUpdated.setAccessMethod(getAccessMethod());
			geoTagUpdated.setDate(new Date());
			geoTagUpdated.setExecutor(actingUser);
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(geoTagUpdated));
				}
			});
			getDatabaseSession().store(geoTag);
		} else {
			throw new UserException("User has no rights on any projects associated with this geotag");
		}
		return null;
	}
}