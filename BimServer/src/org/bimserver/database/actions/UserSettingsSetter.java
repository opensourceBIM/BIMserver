package org.bimserver.database.actions;

import org.bimserver.models.store.UserSettings;

public interface UserSettingsSetter {
	void set(UserSettings userSettings);
}