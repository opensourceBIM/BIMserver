package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class UpdateRenderEngineDatabaseAction extends UpdateDatabaseAction<RenderEnginePluginConfiguration> {

	private final RenderEnginePluginConfiguration renderEngine;

	public UpdateRenderEngineDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, RenderEnginePluginConfiguration renderEngine) {
		super(databaseSession, accessMethod, renderEngine);
		this.renderEngine = renderEngine;
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		RenderEnginePluginConfiguration oldRenderEngine = getDatabaseSession().get(StorePackage.eINSTANCE.getRenderEnginePluginConfiguration(), renderEngine.getOid(), OldQuery.getDefault());
		if (oldRenderEngine.getEnabled() && !renderEngine.getEnabled() && !renderEngine.getSerializers().isEmpty()) {
			throw new UserException("Cannot disable render engine with serializers");
		}
		return super.execute();
	}
}