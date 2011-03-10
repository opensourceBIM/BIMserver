package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.log.AccessMethod;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class GetClashDetectionSettingsDatabaseAction extends BimDatabaseAction<ClashDetectionSettings> {

	private final long cdsoid;
	private final long actingUoid;

	public GetClashDetectionSettingsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, long cdsoid) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.cdsoid = cdsoid;
	}

	@Override
	public ClashDetectionSettings execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		ClashDetectionSettings clashDetectionSettings = (ClashDetectionSettings) getDatabaseSession().get(StorePackage.eINSTANCE.getClashDetectionSettings(), cdsoid, false);
		boolean hasRights = false;
		for (Project project : clashDetectionSettings.getProjects()) {
			if (RightsManager.hasRightsOnProject(actingUser, project)) {
				hasRights = true;
				continue;
			}
		}
		if (hasRights) {
			return clashDetectionSettings;
		} else {
			throw new UserException("User has no rights on any projects associated with these clash detection settings");
		}
	}
}