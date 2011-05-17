package org.bimserver.serializers;

import net.xeoh.plugins.base.annotations.PluginImplementation;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

@PluginImplementation
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

	@Override
	public String getDefaultSerializerName() {
		return "ObjectInfo";
	}
}