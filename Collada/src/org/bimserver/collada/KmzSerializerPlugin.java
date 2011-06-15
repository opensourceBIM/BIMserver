package org.bimserver.collada;

import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class KmzSerializerPlugin implements SerializerPlugin {

	@Override
	public EmfSerializer createSerializer() {
		return new KmzSerializer();
	}

	@Override
	public String getDescription() {
		return "KmzSerializer";
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
		return "KMZ";
	}

	@Override
	public String getDefaultContentType() {
		return "application/vnd.google-earth.kmz";
	}

	@Override
	public String getDefaultExtension() {
		return "kmz";
	}
}