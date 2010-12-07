package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.GeoTag;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class GetGeoTagDatabaseAction extends BimDatabaseAction<GeoTag> {

	private final long goid;
	private final long actingUoid;

	public GetGeoTagDatabaseAction(AccessMethod accessMethod, long actingUoid, long goid) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.goid = goid;
	}

	@Override
	public GeoTag execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		GeoTag geoTag = (GeoTag) bimDatabaseSession.get(bimDatabaseSession.getCid(StorePackage.eINSTANCE.getGeoTag()), goid);
		boolean hasRights = false;
		for (Project project : geoTag.getProjects()) {
			if (RightsManager.hasRightsOnProject(actingUser, project)) {
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