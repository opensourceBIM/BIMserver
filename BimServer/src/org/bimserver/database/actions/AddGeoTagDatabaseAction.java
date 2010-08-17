package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.GeoTag;
import org.bimserver.database.store.StoreFactory;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;

public class AddGeoTagDatabaseAction extends BimDatabaseAction<GeoTag> {

	private final float x;
	private final float y;
	private final float z;
	private final float directionAngle;
	private final int epsg;
	private final int uid;

	public AddGeoTagDatabaseAction(AccessMethod accessMethod, float x1, float y1, float z1, float directionAngle, int epsg, int uid) {
		super(accessMethod);
		this.x = x1;
		this.y = y1;
		this.z = z1;
		this.directionAngle = directionAngle;
		this.epsg = epsg;
		this.uid = uid;
	}

	@Override
	public GeoTag execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		GeoTag geoTag = StoreFactory.eINSTANCE.createGeoTag();
		geoTag.setX(x);
		geoTag.setY(y);
		geoTag.setZ(z);
		geoTag.setDirectionAngle(directionAngle);
		geoTag.setEpsg(epsg);
		bimDatabaseSession.store(geoTag, new CommitSet(Database.STORE_PROJECT_ID, -1));
		bimDatabaseSession.saveGidCounter();
		return geoTag;
	}
}