package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.ReadSet;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;

public class GetClashDetectionSettingsDatabaseAction extends BimDatabaseAction<ClashDetectionSettings> {

	private final long cdsoid;
	private final long actingUoid;

	public GetClashDetectionSettingsDatabaseAction(AccessMethod accessMethod, long actingUoid, long cdsoid) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.cdsoid = cdsoid;
	}

	@Override
	public ClashDetectionSettings execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		return (ClashDetectionSettings) bimDatabaseSession.get(bimDatabaseSession.getCid(StorePackage.eINSTANCE.getClashDetectionSettings()), cdsoid, new ReadSet(Database.STORE_PROJECT_ID, -1));
	}
}