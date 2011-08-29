package org.bimserver.collada;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class KmzSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public EmfSerializer createSerializer() {
		return new KmzSerializer();
	}

	@Override
	public String getDescription() {
		return "KmzSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}
	
	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginManager.requireSchemaDefinition();
		pluginManager.requireIfcEngine();
		initialized = true;
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

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}