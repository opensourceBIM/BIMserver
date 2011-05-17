package org.bimserver.citygml;

import net.xeoh.plugins.base.annotations.PluginImplementation;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

@PluginImplementation
public class CityGmlSerializerPlugin implements SerializerPlugin {

	public CityGmlSerializerPlugin() {
		
	}
	
	@Override
	public String getDescription() {
		return "CityGmlSerializer";
	}

	@Override
	public String getName() {
		return "CityGmlSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init() {
		
	}
	
	public EmfSerializer createSerializer() {
		return new CityGmlSerializer();
	}

	@Override
	public String getDefaultSerializerName() {
		return "CityGML 1.0.0";
	}
}