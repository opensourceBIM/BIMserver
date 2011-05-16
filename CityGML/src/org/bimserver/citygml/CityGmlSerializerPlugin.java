package org.bimserver.citygml;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class CityGmlSerializerPlugin implements SerializerPlugin {

	public CityGmlSerializerPlugin() {
		
	}
	
	@Override
	public String getDescription() {
		return "CityGmlSerializerPlugin";
	}

	@Override
	public String getName() {
		return "CityGmlSerializerPlugin";
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
}