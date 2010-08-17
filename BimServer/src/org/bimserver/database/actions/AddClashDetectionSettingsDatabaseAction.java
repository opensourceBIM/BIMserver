package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.StoreFactory;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.shared.UserException;

public class AddClashDetectionSettingsDatabaseAction extends BimDatabaseAction<ClashDetectionSettings> {

	private final SClashDetectionSettings sClashDetectionSettings;
	private final int actingUid;

	public AddClashDetectionSettingsDatabaseAction(AccessMethod accessMethod, int actingUid, SClashDetectionSettings sClashDetectionSettings) {
		super(accessMethod);
		this.actingUid = actingUid;
		this.sClashDetectionSettings = sClashDetectionSettings;
	}

	@Override
	public ClashDetectionSettings execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		ClashDetectionSettings clashDetectionSettings = StoreFactory.eINSTANCE.createClashDetectionSettings();
		clashDetectionSettings.setMargin(sClashDetectionSettings.getMargin());
		clashDetectionSettings.setEnabled(sClashDetectionSettings.isEnabled());
		for (long subPoid : sClashDetectionSettings.getProjects()) {
			clashDetectionSettings.getProjects().add(bimDatabaseSession.getProjectByPoid(subPoid));
		}
		for (String ignoredClass : sClashDetectionSettings.getIgnoredClasses()) {
			clashDetectionSettings.getIgnoredClasses().add(ignoredClass);
		}
		bimDatabaseSession.store(clashDetectionSettings, new CommitSet(Database.STORE_PROJECT_ID, -1));
		bimDatabaseSession.saveGidCounter();
		return clashDetectionSettings;
	}
}