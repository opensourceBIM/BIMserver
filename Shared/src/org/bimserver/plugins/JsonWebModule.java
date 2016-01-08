package org.bimserver.plugins;

import org.bimserver.plugins.web.AbstractWebModulePlugin;
import org.bimserver.shared.exceptions.PluginException;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonWebModule extends AbstractWebModulePlugin {

	private ObjectNode settings;
	private boolean initialized;

	public JsonWebModule(ObjectNode settings) {
		this.settings = settings;
	}

	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}

	@Override
	public String getDescription() {
		return settings.get("description").asText();
	}

	@Override
	public String getDefaultName() {
		return settings.get("defaultName").asText();
	}

	@Override
	public String getVersion() {
		return settings.get("version").asText();
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getIdentifier() {
		return settings.get("identifier").asText();
	}

	@Override
	public String getDefaultContextPath() {
		return settings.get("defaultContextPath").asText();
	}
}