package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.GeoTag;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.GeoTagUpdated;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.shared.UserException;

public class UpdateGeoTagDatabaseAction extends BimDatabaseAction<Void> {

	private final SGeoTag sGeoTag;
	private final long actingUoid;

	public UpdateGeoTagDatabaseAction(AccessMethod accessMethod, long actingUoid, SGeoTag sGeoTag) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.sGeoTag = sGeoTag;
	}

	@Override
	public Void execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		GeoTag geoTag = (GeoTag) bimDatabaseSession.get(StorePackage.eINSTANCE.getGeoTag(), sGeoTag.getOid());
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
		CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
		bimDatabaseSession.store(geoTagUpdated, commitSet);
		bimDatabaseSession.store(geoTag, commitSet);
		return null;
	}
}