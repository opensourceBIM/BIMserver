package org.bimserver.settings;

public class ServerSettings {
	private static Settings settings;

	public static final void setSettings(Settings settings) {
		ServerSettings.settings = settings;
	}

	public static final Settings getSettings() {
		return settings;
	}
}