package org.bimserver.database.actions;

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