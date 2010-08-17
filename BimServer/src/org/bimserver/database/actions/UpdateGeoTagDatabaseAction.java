package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.GeoTag;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.shared.UserException;

public class UpdateGeoTagDatabaseAction extends BimDatabaseAction<Void> {

	private final SGeoTag sGeoTag;
	private final long actionUoid;

	public UpdateGeoTagDatabaseAction(AccessMethod accessMethod, long actionUoid, SGeoTag sGeoTag) {
		super(accessMethod);
		this.actionUoid = actionUoid;
		this.sGeoTag = sGeoTag;
	}

	@Override
	public Void execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		GeoTag geoTag = (GeoTag) bimDatabaseSession.get(StorePackage.eINSTANCE.getGeoTag(), sGeoTag.getOid());
		geoTag.setEnabled(sGeoTag.isEnabled());
		geoTag.setX(sGeoTag.getX());
		geoTag.setY(sGeoTag.getY());
		geoTag.setZ(sGeoTag.getZ());
		geoTag.setDirectionAngle(sGeoTag.getDirectionAngle());
		geoTag.setEpsg(sGeoTag.getEpsg());
		bimDatabaseSession.store(geoTag, new CommitSet(Database.STORE_PROJECT_ID, -1));
		return null;
	}
}