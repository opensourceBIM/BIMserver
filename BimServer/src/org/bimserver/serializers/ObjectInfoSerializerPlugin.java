package org.bimserver.serializers;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.mangosdk.spi.ProviderFor;

@ProviderFor(value=SerializerPlugin.class)
public class ObjectInfoSerializerPlugin implements SerializerPlugin {

	@Override
	public String getDescription() {
		return "ObjectInfoSerializerPlugin";
	}

	@Override
	public String getName() {
		return "ObjectInfoSerializerPlugin";
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
		return new ObjectInfoSerializer();
	}
}