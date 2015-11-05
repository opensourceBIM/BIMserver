package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class DeleteRenderEngineDatabaseAction extends DeleteDatabaseAction<RenderEnginePluginConfiguration> {

	public DeleteRenderEngineDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long iid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), iid);
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		RenderEnginePluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), Query.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getRenderEngines().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}