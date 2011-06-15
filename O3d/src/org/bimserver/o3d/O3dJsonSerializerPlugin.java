package org.bimserver.o3d;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class O3dJsonSerializerPlugin implements SerializerPlugin {

	@Override
	public EmfSerializer createSerializer() {
		return new O3dJsonSerializer();
	}

	@Override
	public String getDescription() {
		return "O3dJsonSerializer";
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
		return "O3DJSON";
	}

	@Override
	public String getDefaultContentType() {
		return "appliction/json";
	}

	@Override
	public String getDefaultExtension() {
		return "o3djson";
	}
}