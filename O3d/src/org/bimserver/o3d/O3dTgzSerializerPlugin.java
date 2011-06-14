package org.bimserver.o3d;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class O3dTgzSerializerPlugin implements SerializerPlugin {

	@Override
	public EmfSerializer createSerializer() {
		return new O3dTgzSerializer();
	}

	@Override
	public String getDescription() {
		return "O3dTgzSerializer";
	}

	@Override
	public String getName() {
		return "O3dTgzSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init() {
	}

	@Override
	public String getDefaultSerializerName() {
		return "O3DTgz";
	}

	@Override
	public String getDefaultContentType() {
		return "appliction/o3d";
	}

	@Override
	public String getDefaultExtension() {
		return "o3dtgz";
	}
}