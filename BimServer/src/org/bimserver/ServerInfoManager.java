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

import java.util.ArrayList;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.MigrationException;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.store.ServerInfo;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerInfoManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerInfoManager.class);
	private BimServer bimServer;
	private final ArrayList<StateChangeListener> stateChangeListeners = new ArrayList<StateChangeListener>();
	private final ServerInfo serverInfo = StoreFactory.eINSTANCE.createServerInfo();
	
	public void registerStateChangeListener(StateChangeListener stateChangeListener) {
		stateChangeListeners.add(0, stateChangeListener);
	}

	private void notifyStateChangeListeners(ServerState oldState, ServerState newState) {
		for (StateChangeListener stateChangeListener : stateChangeListeners) {
			stateChangeListener.stateChanged(oldState, newState);
		}
	}

	public void update() {
		try {
			((IdEObjectImpl)serverInfo).setUuid(bimServer.getUuid());
			if (bimServer.getVersionChecker() != null) {
				serverInfo.setVersion(bimServer.getSConverter().convertFromSObject(bimServer.getVersionChecker().getLocalVersion()));
			}
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
		if (bimServer.getDatabase().getMigrator().migrationRequired()) {
			setServerState(ServerState.MIGRATION_REQUIRED);
			if (bimServer.getConfig().isAutoMigrate()) {
				try {
					bimServer.getDatabase().getMigrator().migrate();
					setServerState(ServerState.SETUP);
				} catch (MigrationException | InconsistentModelsException e) {
					LOGGER.error("", e);
				}
			}
		} else if (bimServer.getDatabase().getMigrator().migrationImpossible()) {
			setServerState(ServerState.MIGRATION_IMPOSSIBLE);
		} else {
			DatabaseSession session = bimServer.getDatabase().createSession(OperationType.READ_ONLY);
			try {
				boolean adminFound = false;
				ServerSettings settings = bimServer.getServerSettingsCache().getServerSettings();
				IfcModelInterface users = session.getAllOfType(StorePackage.eINSTANCE.getUser(), OldQuery.getDefault());
				for (IdEObject idEObject : users.getValues()) {
					if (idEObject instanceof User) {
						User user = (User)idEObject;
						if (user.getUserType() == UserType.ADMIN) {
							adminFound = true;
							break;
						}
					}
				}
				if (settings.getSiteAddress().isEmpty() || !adminFound) {
					setServerState(ServerState.NOT_SETUP);
				} else {
					setServerState(ServerState.RUNNING);
				}
			} catch (BimserverDatabaseException e) {
				LOGGER.error("", e);
			} finally {
				session.close();
			}
		}
	}

	public boolean isAvailable() {
		return serverInfo.getErrorMessage() == null && serverInfo.getServerState() == ServerState.RUNNING;
	}

	public void setOutOfMemory() {
		serverInfo.setErrorMessage("This server is out of memory, more info on how to fix this can be found on <a href=\"http://support.opensourcebim.org/\">support.opensourcebim.org</a>. Or let us handle the hosting stuff and join our VIP hosting solutions at <a href=\"http://vip.bimserver.org/\">vip.bimserver.org</a>.  ");
	}

	public void setServerState(ServerState serverState) {
		ServerState oldState = serverInfo.getServerState();
		serverInfo.setServerState(serverState);
		LOGGER.info("Changing server state to " + serverState);
		notifyStateChangeListeners(oldState, serverState);
	}

	public void setErrorMessage(String message) {
		serverInfo.setErrorMessage(message);
	}

	public ServerState getServerState() {
		return serverInfo.getServerState();
	}

	public ServerInfo getServerInfo() {
		return serverInfo;
	}

	public void init(BimServer bimServer) {
		this.bimServer = bimServer;
	}
}