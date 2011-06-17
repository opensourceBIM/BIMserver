package org.bimserver.ifc.xml.serializer;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class IfcXmlSerializerPlugin implements SerializerPlugin {

	@Override
	public EmfSerializer createSerializer() {
		return new IfcXmlSerializer();
	}

	@Override
	public String getDescription() {
		return "IfcXmlSerializer";
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
	public String getDefaultSerializerName() {
		return "IfcXML";
	}

	@Override
	public String getDefaultContentType() {
		return "application/ifcxml";
	}

	@Override
	public String getDefaultExtension() {
		return "ifcxml";
	}

	@Override
	public boolean requiresIfcEngine() {
		return false;
	}

	@Override
	public boolean requiresIfcStepSerializer() {
		return false;
	}
}