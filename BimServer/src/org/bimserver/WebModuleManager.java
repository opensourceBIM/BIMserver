package org.bimserver;

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

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.actions.ServerSettingsSetter;
import org.bimserver.database.actions.SetServerSettingDatabaseAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.WebModulePluginConfiguration;
import org.bimserver.plugins.web.WebModulePlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class WebModuleManager {

	private BimServer bimServer;

	public WebModuleManager(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public void setDefault(Long oid) throws BimserverDatabaseException, UserException, ServerException {
		DatabaseSession session = bimServer.getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			final WebModulePluginConfiguration defaultWebModule = session.get(StorePackage.eINSTANCE.getWebModulePluginConfiguration(), oid, OldQuery.getDefault());
			bimServer.setDefaultWebModule((WebModulePlugin) bimServer.getPluginManager().getPlugin(defaultWebModule.getPluginDescriptor().getPluginClassName(), true));
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, AccessMethod.INTERNAL, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setWebModule(defaultWebModule);
				}});
			session.executeAndCommitAction(action);
		} finally {
			session.close();
		}

	}
}
