package org.bimserver;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.HashSet;
import java.util.Set;

import org.bimserver.models.store.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerInfo {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerInfo.class);
	public static enum ServerState {
		UNKNOWN,
		NOT_SETUP,
		MIGRATION_REQUIRED,
		MIGRATION_IMPOSSIBLE,
		FATAL_ERROR,
		RUNNING
	}
	
	private String errorMessage;
	private ServerState serverState = ServerState.UNKNOWN;
	private Set<StateChangeListener> stateChangeListeners = new HashSet<StateChangeListener>();
	private BimServer bimServer;

	public void registerStateChangeListener(StateChangeListener stateChangeListener) {
		stateChangeListeners.add(stateChangeListener);
	}
	
	private void notifyStateChangeListeners(ServerState oldState, ServerState newState) {
		for (StateChangeListener stateChangeListener : stateChangeListeners) {
			stateChangeListener.stateChanged(oldState, newState);
		}
	}
	
	public void update() {
		if (bimServer.getDatabase().getMigrator().migrationRequired()) {
			setServerState(ServerState.MIGRATION_REQUIRED);
		} else if (bimServer.getDatabase().getMigrator().migrationImpossible()) {
			setServerState(ServerState.MIGRATION_IMPOSSIBLE);
		} else {
			Settings settings = bimServer.getSettingsManager().getSettings();
			if (settings.getSiteAddress().isEmpty() || settings.getSmtpServer().isEmpty()) {
				setServerState(ServerState.NOT_SETUP);
			} else {
				setServerState(ServerState.RUNNING);
			}
		}
	}
	
	public boolean isAvailable() {
		return errorMessage == null && serverState == ServerState.RUNNING;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setOutOfMemory() {
		this.errorMessage = "This server is out of memory, more info on how to fix this can be found on <a href=\"http://support.bimserver.org/\">support.bimserver.org</a>. Or let us handle the hosting stuff and join our VIP hosting solutions at <a href=\"http://vip.bimserver.org/\">vip.bimserver.org</a>.  ";
	}

	public void setServerState(ServerState serverState) {
		ServerState oldState = this.serverState;
		this.serverState = serverState;
		LOGGER.info("Changing server state to " + serverState);
		notifyStateChangeListeners(oldState, serverState);
	}

	public ServerState getServerState() {
		return serverState;
	}

	public void init(BimServer bimServer) {
		this.bimServer = bimServer;
	}
}