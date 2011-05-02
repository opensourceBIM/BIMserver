package org.bimserver;

import org.bimserver.ServerInfo.ServerState;

public interface StateChangeListener {

	void stateChanged(ServerState oldState, ServerState newState);
}
