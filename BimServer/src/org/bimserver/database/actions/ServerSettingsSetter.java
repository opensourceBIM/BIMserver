package org.bimserver.database.actions;

import org.bimserver.models.store.ServerSettings;

public interface ServerSettingsSetter {
	void set(ServerSettings serverSettings);
}