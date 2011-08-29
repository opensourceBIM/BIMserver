package org.bimserver.scenejs;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class SceneJSSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public String getDescription() {
		return "SceneJSSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginManager.requireSchemaDefinition();
		pluginManager.requireIfcEngine();
		initialized = true;
	}

	@Override
	public EmfSerializer createSerializer() {
		return new SceneJSSerializer();
	}

	@Override
	public String getDefaultSerializerName() {
		return "SceneJS";
	}

	@Override
	public String getDefaultContentType() {
		return "application/javascript";
	}

	@Override
	public String getDefaultExtension() {
		return "js";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}
