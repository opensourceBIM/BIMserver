package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class DeletePluginConfigurationDatabaseAction extends BimDatabaseAction<Void>{

	private long oid;

	public DeletePluginConfigurationDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long oid) {
		super(databaseSession, accessMethod);
		this.oid = oid;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		PluginConfiguration pluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), oid, OldQuery.getDefault());
		UserSettings settings = (UserSettings) pluginConfiguration.eGet(pluginConfiguration.eClass().getEStructuralFeature("userSettings"));
		settings.getSerializers().remove(pluginConfiguration);
		getDatabaseSession().store(settings);
		pluginConfiguration.remove();
		return null;
	} 
}