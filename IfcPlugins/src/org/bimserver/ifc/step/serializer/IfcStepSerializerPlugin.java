package org.bimserver.ifc.step.serializer;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class IfcStepSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public EmfSerializer createSerializer() {
		return new IfcStepSerializer();
	}

	@Override
	public String getDescription() {
		return "IfcStepSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginManager.requireSchemaDefinition();
		initialized = true;
	}

	@Override
	public String getDefaultSerializerName() {
		return "Ifc2x3";
	}

	@Override
	public String getDefaultContentType() {
		return "application/ifc";
	}

	@Override
	public String getDefaultExtension() {
		return "ifc";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}