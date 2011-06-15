package org.bimserver.ifc.xml.deserializer;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;

public class IfcXmlDeserializerPlugin implements DeserializerPlugin {

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
	public void init(PluginManager pluginManager) {
	}

	@Override
	public boolean canHandleExtension(String extension) {
		return extension.equalsIgnoreCase("ifcxml");
	}
}