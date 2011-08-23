package org.bimserver.serializers.objectinfo;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class ObjectInfoSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public String getDescription() {
		return "ObjectInfoSerializer";
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
	public void init(PluginManager pluginManager) throws PluginException {
		pluginManager.requireSchemaDefinition();
		initialized = true;
	}

	@Override
	public EmfSerializer createSerializer() {
		return new ObjectInfoSerializer();
	}

	@Override
	public String getDefaultSerializerName() {
		return "ObjectInfo";
	}

	@Override
	public String getDefaultContentType() {
		return "text/html";
	}

	@Override
	public String getDefaultExtension() {
		return "html";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}