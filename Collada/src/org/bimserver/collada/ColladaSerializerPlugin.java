package org.bimserver.collada;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class ColladaSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public String getDescription() {
		return "ColladaSerializer";
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
		pluginManager.requireIfcEngine();
		initialized = true;
	}

	@Override
	public EmfSerializer createSerializer() {
		return new ColladaSerializer();
	}

	@Override
	public Set<Class<? extends Plugin>> getRequiredPlugins() {
		Set<Class<? extends Plugin>> set = new HashSet<Class<? extends Plugin>>();
		set.add(SchemaPlugin.class);
		set.add(IfcEnginePlugin.class);
		return set;
	}

	@Override
	public String getDefaultSerializerName() {
		return "Collada";
	}

	@Override
	public String getDefaultContentType() {
		return "application/collada";
	}

	@Override
	public String getDefaultExtension() {
		return "dae";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}