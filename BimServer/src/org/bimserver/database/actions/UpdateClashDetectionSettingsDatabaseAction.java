package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.StorePackage;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.ClashDetectionSettingsUpdated;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.shared.UserException;

public class UpdateClashDetectionSettingsDatabaseAction extends BimDatabaseAction<Void> {

	private final SClashDetectionSettings sClashDetectionSettings;
	private final long actingUoid;

	public UpdateClashDetectionSettingsDatabaseAction(AccessMethod accessMethod, long actingUoid, SClashDetectionSettings sClashDetectionSettings) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.sClashDetectionSettings = sClashDetectionSettings;
	}

	@Override
	public Void execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		ClashDetectionSettings clashDetectionSettings = (ClashDetectionSettings) bimDatabaseSession.get(StorePackage.eINSTANCE.getClashDetectionSettings(), sClashDetectionSettings.getOid());
		clashDetectionSettings.setEnabled(sClashDetectionSettings.isEnabled());
		clashDetectionSettings.setMargin(sClashDetectionSettings.getMargin());
		for (long subPoid : sClashDetectionSettings.getProjects()) {
			clashDetectionSettings.getProjects().add(bimDatabaseSession.getProjectByPoid(subPoid));
		}
		for (String ignoredClass : sClashDetectionSettings.getIgnoredClasses()) {
			clashDetectionSettings.getIgnoredClasses().add(ignoredClass);
		}
		ClashDetectionSettingsUpdated clashDetectionSettingsUpdated = LogFactory.eINSTANCE.createClashDetectionSettingsUpdated();
		clashDetectionSettingsUpdated.setClashDetectionSettings(clashDetectionSettings);
		clashDetectionSettingsUpdated.setAccessMethod(getAccessMethod());
		clashDetectionSettingsUpdated.setDate(new Date());
		clashDetectionSettingsUpdated.setExecutor(actingUser);
		CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
		bimDatabaseSession.store(clashDetectionSettings, commitSet);
		bimDatabaseSession.store(clashDetectionSettingsUpdated, commitSet);
		return null;
	}
}