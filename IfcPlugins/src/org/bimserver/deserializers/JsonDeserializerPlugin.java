package org.bimserver.deserializers;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;

public class JsonDeserializerPlugin implements DeserializerPlugin {

	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "JsonDeserializerPlugin";
	}

	@Override
	public String getDefaultName() {
		return "JsonDeserializerPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public Deserializer createDeserializer(PluginConfiguration pluginConfiguration) {
		return new JsonDeserializer();
	}

	@Override
	public boolean canHandleExtension(String extension) {
		return extension.equals("json");
	}
}