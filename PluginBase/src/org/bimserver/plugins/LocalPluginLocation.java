package org.bimserver.plugins;

import java.util.List;

public class LocalPluginLocation extends PluginLocation<LocalPluginVersion> {

	@Override
	public List<LocalPluginVersion> getAllVersions() {
		return null;
	}

	@Override
	public PluginBundleIdentifier getPluginIdentifier() {
		return null;
	}
}