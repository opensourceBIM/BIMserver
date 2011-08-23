package org.bimserver.ifc.xml.deserializer;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;

public class IfcXmlDeserializerPlugin implements DeserializerPlugin {

	private boolean initialized = false;

	@Override
	public EmfDeserializer createDeserializer() {
		return new IfcXmlDeserializer();
	}

	@Override
	public String getDescription() {
		return "IfcXmlDeserializer";
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
		initialized = true;
		pluginManager.requireSchemaDefinition();
	}

	@Override
	public boolean canHandleExtension(String extension) {
		return extension.equalsIgnoreCase("ifcxml");
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getDefaultDeserializerName() {
		return "IfcXmlDeserializer";
	}
}