package org.bimserver.scenejs;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class SceneJSSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public String getDescription() {
		return "SceneJSSerializer";
	}

	@Override
	public String getName() {
		return getClass().getName();
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
