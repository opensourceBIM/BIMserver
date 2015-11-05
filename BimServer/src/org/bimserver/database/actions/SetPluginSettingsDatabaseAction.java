package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class SetPluginSettingsDatabaseAction extends BimDatabaseAction<Void> {

	private ObjectType convertedSettings;
	private long poid;

	public SetPluginSettingsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid, ObjectType convertedSettings) {
		super(databaseSession, accessMethod);
		this.poid = poid;
		this.convertedSettings = convertedSettings;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		PluginConfiguration pluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), poid, Query.getDefault());
		pluginConfiguration.setSettings(convertedSettings);
		getDatabaseSession().store(convertedSettings, true);
		getDatabaseSession().store(pluginConfiguration);
		return null;
	}
}