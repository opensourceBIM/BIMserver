package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.ClashDetectionSettingsUpdated;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class UpdateClashDetectionSettingsDatabaseAction extends BimDatabaseAction<Void> {

	private final SClashDetectionSettings sClashDetectionSettings;
	private final long actingUoid;

	public UpdateClashDetectionSettingsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, SClashDetectionSettings sClashDetectionSettings) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.sClashDetectionSettings = sClashDetectionSettings;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		ClashDetectionSettings clashDetectionSettings = (ClashDetectionSettings) getDatabaseSession().get(StorePackage.eINSTANCE.getClashDetectionSettings(), sClashDetectionSettings.getOid(), false);
		
		boolean hasRights = false;
		for (Project project : clashDetectionSettings.getProjects()) {
			if (RightsManager.hasRightsOnProject(actingUser, project)) {
				hasRights = true;
				continue;
			}
		}
		if (hasRights) {
			clashDetectionSettings.setEnabled(sClashDetectionSettings.isEnabled());
			clashDetectionSettings.setMargin(sClashDetectionSettings.getMargin());
			for (long subPoid : sClashDetectionSettings.getProjects()) {
				clashDetectionSettings.getProjects().add(getProjectByPoid(subPoid));
			}
			for (String ignoredClass : sClashDetectionSettings.getIgnoredClasses()) {
				clashDetectionSettings.getIgnoredClasses().add(ignoredClass);
			}
			ClashDetectionSettingsUpdated clashDetectionSettingsUpdated = LogFactory.eINSTANCE.createClashDetectionSettingsUpdated();
			clashDetectionSettingsUpdated.setClashDetectionSettings(clashDetectionSettings);
			clashDetectionSettingsUpdated.setAccessMethod(getAccessMethod());
			clashDetectionSettingsUpdated.setDate(new Date());
			clashDetectionSettingsUpdated.setExecutor(actingUser);
			getDatabaseSession().store(clashDetectionSettings);
			getDatabaseSession().store(clashDetectionSettingsUpdated);
		} else {
			throw new UserException("User has no rights on any projects associated with these clash detection settings");
		}
		return null;
	}
}