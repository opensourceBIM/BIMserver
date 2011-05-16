package org.bimserver.ifc;

import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.mangosdk.spi.ProviderFor;

@ProviderFor(value=SerializerPlugin.class)
public class XsltSerializerPlugin implements SerializerPlugin {

	@Override
	public EmfSerializer createSerializer() {
		return new XsltSerializer();
	}

	@Override
	public String getDescription() {
		return "XsltSerializerPlugin";
	}

	@Override
	public String getName() {
		return "XsltSerializerPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init() {
	}
}