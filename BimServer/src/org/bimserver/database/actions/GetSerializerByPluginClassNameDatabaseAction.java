package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class GetSerializerByPluginClassNameDatabaseAction extends BimDatabaseAction<SerializerPluginConfiguration> {

	private String pluginClassName;
	private Authorization authorization;

	public GetSerializerByPluginClassNameDatabaseAction(DatabaseSession databaseSession, Authorization authorization, AccessMethod accessMethod, String pluginClassName) {
		super(databaseSession, accessMethod);
		this.authorization = authorization;
		this.pluginClassName = pluginClassName;
	}

	@Override
	public SerializerPluginConfiguration execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		PluginDescriptor pluginDescriptor = getDatabaseSession().querySingle(StorePackage.eINSTANCE.getPluginDescriptor_PluginClassName(), pluginClassName);
		if (pluginDescriptor == null) {
			throw new UserException("No plugin found with classname " + pluginClassName);
		}
		User user = getUserByUoid(authorization.getUoid());
		UserSettings userSettings = user.getUserSettings();
		for (SerializerPluginConfiguration serializerPluginConfiguration : userSettings.getSerializers()) {
			if (serializerPluginConfiguration.getPluginDescriptor() == pluginDescriptor) {
				return serializerPluginConfiguration;
			}
		}
		return null;
	}
}