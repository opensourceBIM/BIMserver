package org.bimserver.o3d;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class O3dTgzSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public EmfSerializer createSerializer() {
		return new O3dTgzSerializer();
	}

	@Override
	public String getDescription() {
		return "O3dTgzSerializer";
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
	public String getDefaultSerializerName() {
		return "O3DTgz";
	}

	@Override
	public String getDefaultContentType() {
		return "application/o3d";
	}

	@Override
	public String getDefaultExtension() {
		return "o3dtgz";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}