package org.bimserver.citygml;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.schema.SchemaException;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class CityGmlSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	public CityGmlSerializerPlugin() {
	}
	
	@Override
	public String getDescription() {
		return "CityGmlSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) throws SchemaException, PluginException, IfcEngineException {
		pluginManager.requireSchemaDefinition();
		pluginManager.requireIfcEngine();
		initialized = true;
	}
	
	public EmfSerializer createSerializer() {
		return new CityGmlSerializer();
	}

	@Override
	public String getDefaultSerializerName() {
		return "CityGML1.0.0";
	}

	@Override
	public String getDefaultContentType() {
		return "application/gml";
	}

	@Override
	public String getDefaultExtension() {
		return "gml";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}