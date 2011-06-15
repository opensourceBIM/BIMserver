package org.bimserver.citygml;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class CityGmlSerializerPlugin implements SerializerPlugin {

	public CityGmlSerializerPlugin() {
	}
	
	@Override
	public String getDescription() {
		return "CityGmlSerializer";
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
}