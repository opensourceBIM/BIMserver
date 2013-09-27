package org.bimserver.serializers;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class BinaryGeometrySerializerPlugin extends AbstractSerializerPlugin {

	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "BinaryGeometrySerializer";
	}

	@Override
	public String getDefaultName() {
		return "BinaryGeometrySerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		return new BinaryGeometrySerializer();
	}

	@Override
	public boolean needsGeometry() {
		return true;
	}

	@Override
	public String getDefaultExtension() {
		return "dat";
	}

	@Override
	public String getDefaultContentType() {
		return "binarygeometry";
	}
}