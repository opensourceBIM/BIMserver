package org.bimserver.collada;

import net.xeoh.plugins.base.annotations.PluginImplementation;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

@PluginImplementation
public class ColladaSerializerPlugin implements SerializerPlugin {

	@Override
	public String getDescription() {
		return "ColladaSerializer";
	}

	@Override
	public String getName() {
		return "ColladaSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init() {
	}

	@Override
	public EmfSerializer createSerializer() {
		return new ColladaSerializer();
	}

	@Override
	public String getDefaultSerializerName() {
		return "Collada";
	}
}