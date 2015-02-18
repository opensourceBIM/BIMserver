package org.bimserver.admin;


import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.web.AbstractWebModulePlugin;

public class AdminWebModulePlugin extends AbstractWebModulePlugin {

	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "Bootstrap based Admin WEB GUI";
	}

	@Override
	public String getDefaultName() {
		return "BootstrapBIMAdmin";
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
	public String getDefaultContextPath() {
		return "/admin";
	}

	@Override
	public String getIdentifier() {
		return "admin";
	}
}