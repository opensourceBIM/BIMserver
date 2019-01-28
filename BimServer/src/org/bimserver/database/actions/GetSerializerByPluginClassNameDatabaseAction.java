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
		throw new UserException("No plugin found for this user with classname " + pluginClassName);
	}
}