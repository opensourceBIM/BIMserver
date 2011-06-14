package org.bimserver.collada;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class ColladaSerializerPlugin implements SerializerPlugin {

	@Override
	public String getDescription() {
		return "ColladaSerializer";
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

	@Override
	public String getDefaultContentType() {
		return "appliction/collada";
	}

	@Override
	public String getDefaultExtension() {
		return "dae";
	}
}