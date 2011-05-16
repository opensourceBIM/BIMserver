package org.bimserver.collada;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class ColladaSerializerPlugin implements SerializerPlugin {

	@Override
	public String getDescription() {
		return "ColladaSerializerPlugin";
	}

	@Override
	public String getName() {
		return "ColladaSerializerPlugin";
	}

	@Override
	public String getVersion() {
		return "ColladaSerializerPlugin";
	}

	@Override
	public void init() {
	}

	@Override
	public EmfSerializer createSerializer() {
		return new ColladaSerializer();
	}
}