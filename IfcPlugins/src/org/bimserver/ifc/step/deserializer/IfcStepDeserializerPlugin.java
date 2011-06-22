package org.bimserver.ifc.step.deserializer;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.SchemaException;
import org.bimserver.plugins.schema.SchemaPlugin;

public class IfcStepDeserializerPlugin implements DeserializerPlugin {

	boolean initialized = false;
	
	@Override
	public EmfDeserializer createDeserializer() {
		return new IfcStepDeserializer();
	}

	@Override
	public String getDescription() {
		return "IfcStepDeserializer";
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
	public void init(PluginManager pluginManager) throws SchemaException, PluginException {
		pluginManager.requireSchemaDefinition();
		initialized = true;
	}

	@Override
	public boolean canHandleExtension(String extension) {
		return extension.equalsIgnoreCase("ifc");
	}

	@Override
	public Set<Class<? extends Plugin>> getRequiredPlugins() {
		Set<Class<? extends Plugin>> set = new HashSet<Class<? extends Plugin>>();
		set.add(SchemaPlugin.class);
		return set;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}