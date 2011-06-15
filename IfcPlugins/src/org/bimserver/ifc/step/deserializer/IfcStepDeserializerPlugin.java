package org.bimserver.ifc.step.deserializer;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;

public class IfcStepDeserializerPlugin implements DeserializerPlugin {

	@Override
	public EmfDeserializer createDeserializer() {
		return new IfcStepDeserializer();
	}

	@Override
	public String getDescription() {
		return "IfcStepDeserializer";
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
	public void init(PluginManager pluginManager) {
	}

	@Override
	public boolean canHandleExtension(String extension) {
		return extension.equalsIgnoreCase("ifc");
	}
}