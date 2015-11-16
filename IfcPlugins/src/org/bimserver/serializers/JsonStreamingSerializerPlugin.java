package org.bimserver.serializers;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.StreamingSerializer;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;

public class JsonStreamingSerializerPlugin implements StreamingSerializerPlugin {

	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "JsonStreamingSerializer";
	}

	@Override
	public String getDefaultName() {
		return "JsonStreamingSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public StreamingSerializer createSerializer(PluginConfiguration plugin) {
		return new StreamingJsonSerializer();
	}

	@Override
	public boolean needsGeometry() {
		return true;
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		Set<Schema> schemas = new HashSet<>();
		schemas.add(Schema.IFC2X3TC1);
		schemas.add(Schema.IFC4);
		return schemas;
	}
}