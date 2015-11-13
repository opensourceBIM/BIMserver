package org.bimserver.serializers.binarygeometry;

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.MessagingStreamingSerializer;
import org.bimserver.plugins.serializers.MessagingStreamingSerializerPlugin;

public class BinaryGeometryMessagingStreamingSerializerPlugin implements MessagingStreamingSerializerPlugin {
	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "BinaryGeometryMessagingStreamingSerializer";
	}

	@Override
	public String getDefaultName() {
		return "BinaryGeometryMessagingStreamingSerializer";
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
	public boolean needsGeometry() {
		return true;
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.asSet(Schema.IFC2X3TC1, Schema.IFC4);
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public MessagingStreamingSerializer createSerializer(PluginConfiguration plugin) {
		return new BinaryGeometryMessagingStreamingSerializer();
	}
}