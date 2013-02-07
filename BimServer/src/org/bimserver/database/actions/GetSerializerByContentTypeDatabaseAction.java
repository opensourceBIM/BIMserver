package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
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
		for (SerializerPluginConfiguration serializerPluginConfiguration : getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), SerializerPluginConfiguration.class, Query.getDefault())) {
			PluginConfiguration pluginConfiguration = new PluginConfiguration(serializerPluginConfiguration.getSettings());
			if (pluginConfiguration.getString(SerializerPlugin.CONTENT_TYPE).equals(contentType)) {
				return serializerPluginConfiguration;
			}
		}
		return null;
	}
}