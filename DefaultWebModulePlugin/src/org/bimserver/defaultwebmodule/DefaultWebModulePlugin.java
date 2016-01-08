package org.bimserver.defaultwebmodule;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.web.AbstractWebModulePlugin;
import org.bimserver.shared.exceptions.PluginException;

public class DefaultWebModulePlugin extends AbstractWebModulePlugin {

	private boolean initialized;

	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "Default Web GUI (only shows server version/status)";
	}

	@Override
	public String getDefaultName() {
		return "Default Web GUI";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
	
	@Override
	public String getSubDir() {
		return "";
	}
	
	@Override
	public String getDefaultContextPath() {
		return "";
	}

	@Override
	public String getIdentifier() {
		return "default";
	}
}