package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.shared.UserException;

public class UpdateClashDetectionSettingsDatabaseAction extends BimDatabaseAction<Void> {

	private final SClashDetectionSettings sClashDetectionSettings;
	private final long actionUoid;

	public UpdateClashDetectionSettingsDatabaseAction(AccessMethod accessMethod, long actionUoid, SClashDetectionSettings sClashDetectionSettings) {
		super(accessMethod);
		this.actionUoid = actionUoid;
		this.sClashDetectionSettings = sClashDetectionSettings;
	}

	@Override
	public Void execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		ClashDetectionSettings clashDetectionSettings = (ClashDetectionSettings) bimDatabaseSession.get(StorePackage.eINSTANCE.getClashDetectionSettings(), sClashDetectionSettings.getOid());
		clashDetectionSettings.setEnabled(sClashDetectionSettings.isEnabled());
		clashDetectionSettings.setMargin(sClashDetectionSettings.getMargin());
		for (long subPoid : sClashDetectionSettings.getProjects()) {
			clashDetectionSettings.getProjects().add(bimDatabaseSession.getProjectByPoid(subPoid));
		}
		for (String ignoredClass : sClashDetectionSettings.getIgnoredClasses()) {
			clashDetectionSettings.getIgnoredClasses().add(ignoredClass);
		}
		bimDatabaseSession.store(clashDetectionSettings, new CommitSet(Database.STORE_PROJECT_ID, -1));
		return null;
	}
}