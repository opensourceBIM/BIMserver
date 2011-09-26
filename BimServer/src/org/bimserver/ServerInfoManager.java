package org.bimserver;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.models.store.ServerInfo;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StoreFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerInfoManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerInfoManager.class);
	private BimServer bimServer;
	private Set<StateChangeListener> stateChangeListeners = new HashSet<StateChangeListener>();
	private ServerInfo serverInfo = StoreFactory.eINSTANCE.createServerInfo();

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
		return serverInfo.getErrorMessage() == null && serverInfo.getServerState() == ServerState.RUNNING;
	}

	public void setOutOfMemory() {
		serverInfo.setErrorMessage("This server is out of memory, more info on how to fix this can be found on <a href=\"http://support.bimserver.org/\">support.bimserver.org</a>. Or let us handle the hosting stuff and join our VIP hosting solutions at <a href=\"http://vip.bimserver.org/\">vip.bimserver.org</a>.  ");
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
