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
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.UserException;

public class SetPluginSystemSettingsDatabaseAction extends BimDatabaseAction<Void> {

	private ObjectType convertedSettings;
	private long poid;
	private BimServer bimServer;

	public SetPluginSystemSettingsDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, ObjectType convertedSettings) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.poid = poid;
		this.convertedSettings = convertedSettings;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		org.bimserver.models.store.PluginDescriptor pluginDescriptor = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginDescriptor(), poid, OldQuery.getDefault());
		pluginDescriptor.setSettings(convertedSettings);
		getDatabaseSession().store(convertedSettings, true);
		getDatabaseSession().store(pluginDescriptor);
		bimServer.getPluginSettingsCache().reset(pluginDescriptor.getOid());
		
		RenderEnginePlugin plugin = bimServer.getPluginManager().getRenderEnginePlugin(pluginDescriptor.getPluginClassName(), true);
		PluginContext context = bimServer.getPluginManager().getPluginContext(plugin);
		try {
			plugin.init(context, new PluginConfiguration(convertedSettings));
		} catch (PluginException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}