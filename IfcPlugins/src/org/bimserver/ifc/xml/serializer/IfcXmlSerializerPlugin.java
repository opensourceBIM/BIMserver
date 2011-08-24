package org.bimserver.ifc.xml.serializer;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class IfcXmlSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public EmfSerializer createSerializer() {
		return new IfcXmlSerializer();
	}

	@Override
	public String getDescription() {
		return "IfcXmlSerializer";
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
	public boolean isInitialized() {
		return initialized;
	}
}