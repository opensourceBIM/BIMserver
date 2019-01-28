package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.List;

import org.bimserver.BimServer;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.shared.exceptions.UserException;

public class GetSerializerByContentTypeDatabaseAction extends BimDatabaseAction<SerializerPluginConfiguration> {

	private final String contentType;
	private BimServer bimServer;

	public GetSerializerByContentTypeDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, String contentType) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.contentType = contentType;
	}

	@Override
	public SerializerPluginConfiguration execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		List<SerializerPluginConfiguration> allOfType = getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), SerializerPluginConfiguration.class, OldQuery.getDefault());
		// One loop to try and find the streaming version
		for (SerializerPluginConfiguration serializerPluginConfiguration : allOfType) {
			PluginConfiguration pluginConfiguration = bimServer.getPluginSettingsCache().getPluginSettings(serializerPluginConfiguration.getOid());
			String string = pluginConfiguration.getString(SerializerPlugin.CONTENT_TYPE);
			if (string != null && string.equals(contentType) && serializerPluginConfiguration.getPluginDescriptor().getPluginInterfaceClassName().equals(StreamingSerializerPlugin.class.getName())) {
				return serializerPluginConfiguration;
			}
		}
		// None found, there try again and also allow non-streaming
		for (SerializerPluginConfiguration serializerPluginConfiguration : allOfType) {
			PluginConfiguration pluginConfiguration = bimServer.getPluginSettingsCache().getPluginSettings(serializerPluginConfiguration.getOid());
			String string = pluginConfiguration.getString(SerializerPlugin.CONTENT_TYPE);
			if (string != null && string.equals(contentType)) {
				return serializerPluginConfiguration;
			}
		}
		return null;
	}
}