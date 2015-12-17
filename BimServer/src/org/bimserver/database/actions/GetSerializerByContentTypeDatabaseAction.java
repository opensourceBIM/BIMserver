package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.UserException;

public class GetSerializerByContentTypeDatabaseAction extends BimDatabaseAction<SerializerPluginConfiguration> {

	private final String contentType;

	public GetSerializerByContentTypeDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, String contentType) {
		super(databaseSession, accessMethod);
		this.contentType = contentType;
	}

	@Override
	public SerializerPluginConfiguration execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		for (SerializerPluginConfiguration serializerPluginConfiguration : getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), SerializerPluginConfiguration.class, OldQuery.getDefault())) {
			PluginConfiguration pluginConfiguration = new PluginConfiguration(serializerPluginConfiguration.getSettings());
			String string = pluginConfiguration.getString(SerializerPlugin.CONTENT_TYPE);
			if (string != null && string.equals(contentType)) {
				return serializerPluginConfiguration;
			}
		}
		return null;
	}
}