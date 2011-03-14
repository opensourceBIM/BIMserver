package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.GeoTagUpdated;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class UpdateGeoTagDatabaseAction extends BimDatabaseAction<Void> {

	private final SGeoTag sGeoTag;
	private final long actingUoid;

	public UpdateGeoTagDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, SGeoTag sGeoTag) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.sGeoTag = sGeoTag;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		GeoTag geoTag = (GeoTag) getDatabaseSession().get(StorePackage.eINSTANCE.getGeoTag(), sGeoTag.getOid(), false);
		boolean hasRights = false;
		for (Project project : geoTag.getProjects()) {
			if (RightsManager.hasRightsOnProject(actingUser, project)) {
				hasRights = true;
				continue;
			}
		}
		if (hasRights) {
			geoTag.setEnabled(sGeoTag.isEnabled());
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