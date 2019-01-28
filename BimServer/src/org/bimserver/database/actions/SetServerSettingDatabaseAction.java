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
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.PostCommitAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;

public class SetServerSettingDatabaseAction extends BimDatabaseAction<Void> {
	private ServerSettingsSetter serverSettingsSetter;
	private BimServer bimServer;

	public SetServerSettingDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, ServerSettingsSetter serverSettingsSetter) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.serverSettingsSetter = serverSettingsSetter;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ServerSettings serverSettings = getDatabaseSession().getSingle(StorePackage.eINSTANCE.getServerSettings(), OldQuery.getDefault());
		serverSettingsSetter.set(serverSettings);
		getDatabaseSession().store(serverSettings);
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getServerSettingsCache().updateCache();
			}
		});
		return null;
	}
}