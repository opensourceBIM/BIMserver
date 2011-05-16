package org.bimserver.collada;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class KmzSerializerPlugin implements SerializerPlugin {

	@Override
	public EmfSerializer createSerializer() {
		return new KmzSerializer();
	}

	@Override
	public String getDescription() {
		return "KmzSerializerPlugin";
	}

	@Override
	public String getName() {
		return "KmzSerializerPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init() {
	}
}
